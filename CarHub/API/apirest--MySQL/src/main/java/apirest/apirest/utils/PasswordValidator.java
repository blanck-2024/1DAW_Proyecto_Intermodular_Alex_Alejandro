package apirest.apirest.utils;

import java.util.regex.Pattern;

//Clase para validar la Password
public class PasswordValidator {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static ReponseMessage isValidPassword(String password) {
        if (password == null) {
            return new ReponseMessage("La contraseña no puede estar vacia");
        }

        // Verificar que la contraseña cuente minimo con 1 numero
        else if (!Pattern.compile(".*\\d.*").matcher(password).find()) {
            return new ReponseMessage("La contraseña debe contener al menos un número.");
        }

        // Verificar longitud mínima
        else if (password.length() < 8) {
            return new ReponseMessage("La contraseña debe tener al menos 8 caracteres. ");
        }

        // Verificar que tenga al menos una letra minúscula
        else if (!Pattern.compile("[a-z]").matcher(password).find()) {
            return new ReponseMessage("Debe incluir al menos una letra minúscula. ");
        }

        // Verificar que tenga al menos una letra mayúscula
        else if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return new ReponseMessage("Debe incluir al menos una letra mayúscula. ");
        }

        // Verificar que tenga al menos un carácter especial
        else if (!Pattern.compile("\\W").matcher(password).find()) {
            return new ReponseMessage("Debe incluir al menos un carácter especial. ");
        }

        else{
            /* Si no hay errores, la contraseña es válida
            return new ReponseMessage(pattern.matcher(password).matches());
            */
            // Si no hay errores, la contraseña es válida
            return new ReponseMessage("Contraseña válida");
        }
    }
}

