import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.dto.LoginDTO;
import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.dto.UtilisateurDTO;
import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.jwt.JwtUtils;
import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.mapper.UtilisateurMapper;
import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.modele.Utilisateur;
import com.uasz.sn.Gestion_Utilisateur.Gestion.Utilisateur.Microservice.service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class UtilisateurController {

    private final UtilisateurService utilisateurService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final UtilisateurMapper utilisateurMapper;

    @PostMapping(path = "/inscrire")
    public ResponseEntity<?> ajouter(@RequestBody UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurMapper.dtoToUtilisateur(utilisateurDTO);
        String password = passwordEncoder.encode("Passer123");
        utilisateur.setPassword(password);
        utilisateurService.ajouter(utilisateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurDTO);
    }

    @PostMapping(path = "/connecter")
    public ResponseEntity<?> authenticator(@RequestBody LoginDTO loginDTO) {
        Utilisateur utilisateur = utilisateurMapper.loginToUtilisateur(loginDTO);
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(utilisateur.getUsername(), utilisateur.getPassword()));
            if (authentication.isAuthenticated()) {
                System.out.println(authentication);
                Utilisateur user = utilisateurService.rechercher(utilisateur.getUsername());
                Map<String, Object> authData = new HashMap<>();
                authData.put("token", jwtUtils.generateToken(utilisateur.getUsername()));
                authData.put("type", "Bearer");
                return ResponseEntity.ok(authData);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erreur sur username ou password");
        } catch (AuthenticationException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erreur sur username ou password");
        }
    }
}