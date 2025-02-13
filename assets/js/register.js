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