package apirest.apirest.services;

import apirest.apirest.models.UserModel;
import apirest.apirest.repositories.IUserRepository;
import apirest.apirest.services.interfaces.IUserService;
import apirest.apirest.utils.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import apirest.apirest.utils.ReponseMessage;


import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository; //JPA - Hibernate

    @Override
    public ArrayList<UserModel> getUsuarios() {
        // select * from users
        return (ArrayList<UserModel>) this.userRepository.findAll();
    }

    @Override
    public Optional<UserModel> getUsuarioById(Long id) {
        //select * from users where id = id
        return this.userRepository.findById(id);
    }

    @Override
    public UserModel newUsuario(UserModel newUsuario) {
        if (PasswordValidator.isValidPassword(newUsuario.getPassword()).getMessage().contains("Contraseña válida")) {
            newUsuario.setRol("user");
            // Almacenar la contraseña tal cual (no recomendado)
            return this.userRepository.save(newUsuario);
        } else {
            throw new IllegalArgumentException("Contraseña no válida");
        }
    }
    
    @Override
    public UserModel updateUsuario(UserModel usuarioParam, Long id) {
        UserModel usuario = this.userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Actualizar campos
        usuario.setUsername(usuarioParam.getUsername());
        usuario.setNombre(usuarioParam.getNombre());
        usuario.setApellidos(usuarioParam.getApellidos());
        usuario.setCorreo_electronico(usuarioParam.getCorreo_electronico());
        usuario.setTelefono(usuarioParam.getTelefono());
        usuario.setDireccion(usuarioParam.getDireccion());

        if (usuarioParam.getPassword() != null && PasswordValidator.isValidPassword(usuarioParam.getPassword()).getMessage().contains("Contraseña válida")) {
            // Almacenar la contraseña tal cual
            usuario.setPassword(usuarioParam.getPassword());
        }

        return this.userRepository.save(usuario);
    }

    @Override
    public Boolean deleteUser(Long id) {
        try{
            this.userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String login(String username, String password) {
        UserModel user = userRepository.findByUsername(username); // Utiliza el nuevo método
        if (user != null && user.getPassword().equals(password)) {
            // Generar un token (puedes usar JWT o cualquier otra forma de autenticación)
            return "TokenGenerado"; // Reemplaza esto con tu lógica de generación de tokens
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }

    public String getRolByUsername(String username) {
        UserModel user = userRepository.findByUsername(username);
        return user != null ? user.getRol() : null;
    }

    public String getUsernameByUsername(String username) {
        // Implementa la lógica para obtener el nombre de usuario basado en el username
        // Por ejemplo, buscar en la base de datos
        UserModel user = userRepository.findByUsername(username);
        return user != null ? user.getUsername() : null; // Devuelve el nombre de usuario o null si no existe
    }

    public Long getIDByUsername(String username) {
        // Implementa la lógica para obtener el nombre de usuario basado en el username
        // Por ejemplo, buscar en la base de datos
        UserModel user = userRepository.findByUsername(username);
        return user != null ? user.getIdUser() : null; // Devuelve el ID de usuario o null si no existe
    }
}
