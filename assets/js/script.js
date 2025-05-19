
const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');

registerBtn.addEventListener('click', () => {
    container.classList.add("active");
});

loginBtn.addEventListener('click', () => {
    container.classList.remove("active");
});

/*
 * Función para alternar la visibilidad de la contraseña
 * @param {Event} event - El evento del click
 * @returns {void}
*/
function togglePasswordVisibility(event) {
    const container = event.currentTarget.closest('.password-container');
    const passwordInput = container.querySelector('input[type="password"], input[type="text"]');
    const passwordToggle = container.querySelector(".password-toggle i");
    const isPasswordVisible = passwordInput.type === "text";
    passwordInput.type = isPasswordVisible ? "password" : "text";
    passwordToggle.classList.toggle("fa-eye");
    passwordToggle.classList.toggle("fa-eye-slash");
}
// Agregar el evento click a todos los botones de toggle cuando el DOM esté cargado
document.addEventListener('DOMContentLoaded', () => {
    const toggleButtons = document.querySelectorAll('.password-toggle');
    toggleButtons.forEach(button => {
        button.addEventListener('click', togglePasswordVisibility);
    });

    const passwordInputs = document.querySelectorAll('.password-container input');
    passwordInputs.forEach(input => {
        let strengthIndicator = input.parentElement.querySelector('.password-strength');
        if (!strengthIndicator) {
            strengthIndicator = document.createElement('div');
            strengthIndicator.className = 'password-strength';
            strengthIndicator.style.display = 'none';
            strengthIndicator.style.marginTop = '5px';
            strengthIndicator.style.fontSize = '12px';
            input.parentElement.appendChild(strengthIndicator);
        }
        /*
        input.addEventListener('input', () => {
            updatePasswordStrength(input, strengthIndicator);
        });
        */

        input.placeholder = "Contraseña";
    });

    const forms = document.querySelectorAll('form');
    forms.forEach(form => {
        form.addEventListener('submit', function(event) {
            const passwordInput = this.querySelector('.password-container input');
            if (passwordInput) {
                const validation = validatePassword(passwordInput.value);
                if (!validation.isValid) {
                    event.preventDefault();
                    alert('Por favor, corrige los errores en la contraseña antes de continuar.');
                }
            }
        });
    });

    fetch("../components/footer.html")
        .then(response => response.text())
        .then(data => {
            const footerElement = document.getElementById("footer");
            if (footerElement) {
                footerElement.innerHTML = data;
            }
        })
        .catch(error => console.error('Error cargando el footer:', error));
});

