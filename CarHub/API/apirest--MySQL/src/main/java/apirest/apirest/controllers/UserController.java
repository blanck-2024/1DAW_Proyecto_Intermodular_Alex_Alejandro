package apirest.apirest.controllers;

import apirest.apirest.models.UserModel;
import apirest.apirest.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import apirest.apirest.utils.ReponseMessage;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public ArrayList<UserModel> getAllUsers(){
        return this.userService.getUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id){
        return this.userService.getUsuarioById(id);
    }

    @PostMapping
    public UserModel newUsuario (@RequestBody UserModel newUsuario){
        return this.userService.newUsuario(newUsuario);
    }

    @PutMapping("/{id}")
    public UserModel updateUsuario (@RequestBody UserModel usuario, @PathVariable Long id){
        return this.userService.updateUsuario(usuario,id);
    }

    @DeleteMapping("/{id}")
    public UserModel deleteUsuario (@PathVariable Long id){
        boolean eliminado = this.userService.deleteUser(id);
        if(eliminado){
            return new ReponseMessage("Usuario con id '"+ id +"' , eliminado con exito");
        } else {
            return new ReponseMessage("Error al eliminar usuario con id '"+ id + "'");
        }
    }
}
