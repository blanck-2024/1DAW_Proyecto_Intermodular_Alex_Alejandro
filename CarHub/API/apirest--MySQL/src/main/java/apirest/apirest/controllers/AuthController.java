package apirest.apirest.controllers;

import apirest.apirest.models.AuthResponse;
import apirest.apirest.services.UserService;
import apirest.apirest.utils.ReponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        try {
            String token = userService.login(username, password);
            String rol = userService.getRolByUsername(username); // Obtener el rol
            // Obtener el nombre de usuario
            String userName = userService.getUsernameByUsername(username); // Asegúrate de que esta función exista
            Long idUser = userService.getIDByUsername(username);

            // Devuelve el token, el rol y el username
            return ResponseEntity.ok(new AuthResponse(token, rol, userName, idUser.toString())); // Asegúrate de que AuthResponse tenga un constructor adecuado
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ReponseMessage("Credenciales inválidas"));
        }
    }
}