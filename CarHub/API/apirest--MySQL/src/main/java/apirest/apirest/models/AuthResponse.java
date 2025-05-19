package apirest.apirest.models;

public class AuthResponse {
    private String token;
    private String rol;
    private String username; // Agregar el campo username
    private String id;

    public AuthResponse(String token, String rol, String username, String id) {
        this.token = token;
        this.rol = rol;
        this.username = username;
        this.id = id;
    }

    // Getters y Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}