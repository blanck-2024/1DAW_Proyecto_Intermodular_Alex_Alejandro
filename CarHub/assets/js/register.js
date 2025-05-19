/**
 * Función para alternar la visibilidad de la contraseña
 * @returns {void}
 */
function togglePasswordVisibility() {
    // Obtener los elementos del DOM
    const passwordInput = document.getElementById("password-input");
    const passwordToggle = document.querySelector(".password-toggle i");
    
    // Comprobar el tipo actual del input y cambiarlo
    const isPasswordVisible = passwordInput.type === "text";
    
    // Cambiar el tipo de input
    passwordInput.type = isPasswordVisible ? "password" : "text";
    
    // Actualizar el ícono
    passwordToggle.classList.toggle("fa-eye");
    passwordToggle.classList.toggle("fa-eye-slash");
}

// Agregar el evento click al botón de toggle cuando el DOM esté cargado
document.addEventListener('DOMContentLoaded', () => {
    const toggleButton = document.querySelector('.password-toggle');
    if (toggleButton) {
        toggleButton.addEventListener('click', togglePasswordVisibility);
    }
})

document.addEventListener("DOMContentLoaded", function() {
    // Cargar el Footer
    fetch("../components/footer.html")
    .then(response => response.text())
            .then(data => document.getElementById("footer").innerHTML = data)
            .catch(error => console.error('Error cargando el footer:', error));
});

async function createUser() {
    const username = document.getElementById("username").value;
    const firstName = document.getElementById("firstName").value;
    const lastName = document.getElementById("lastName").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("register-password").value;
    const telefono = document.getElementById("phone").value;
    const direccion = document.getElementById("address").value;

    // Verificar si el correo ya existe
    try {
        const checkEmail = await fetch(`http://localhost:4050/usuarios?email=${email}`);
        const existingUser = await checkEmail.json();

        if (existingUser.length > 0) {
            alert("Este correo ya está registrado. Usa otro.");
            return;
        }
    } catch (error) {
        console.error("Error al verificar el correo:", error);
        alert("Error al verificar el correo.");
        return;
    }

    // Datos para registrar el nuevo usuario
    const data = {
        username,
        firstName,
        lastName,
        email,
        password,
        phone: telefono,
        address: direccion,
        role: "user" // Asigna siempre este perfil
    };

    try {
        const response = await fetch("http://localhost:4050/usuarios", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            alert("Usuario registrado con éxito!");
            window.location.href = "login.html";
        } else {
            const errorData = await response.json();
            alert("Error al registrar: " + errorData.message);
        }
    } catch (error) {
        console.error("Error de conexión:", error);
        alert("Hubo un error al registrar el usuario.");
    }
}

