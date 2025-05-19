package apirest.apirest.services.interfaces;

import apirest.apirest.models.UserModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IUserService {
    ArrayList<UserModel> getUsuarios();
    Optional<UserModel> getUsuarioById(Long id);
    UserModel newUsuario (UserModel newUsuario);
    UserModel updateUsuario (UserModel usuario, Long id);
    Boolean deleteUser(Long id);
    String login(String username, String password);
}
