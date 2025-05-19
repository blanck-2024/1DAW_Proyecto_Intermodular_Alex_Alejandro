const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');

registerBtn.addEventListener('click', () => {
    container.classList.add("active");
});

loginBtn.addEventListener('click', () => {
    container.classList.remove("active");
});

/**
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

/**
 * Función para validar la contraseña
 * @param {string} password - La contraseña a validar
 * @returns {Object} - Objeto con el resultado de la validación y mensajes
 */
function validatePassword(password) {
    const result = {
        isValid: true,
        messages: []
    };

    if (password.length < 8) {
        result.isValid = false;
        result.messages.push("La contraseña debe tener al menos 8 caracteres");
    }

    if (!/[A-Z]/.test(password)) {
        result.isValid = false;
        result.messages.push("Debe incluir al menos una letra mayúscula");
    }

    if (!/[a-z]/.test(password)) {
        result.isValid = false;
        result.messages.push("Debe incluir al menos una letra minúscula");
    }

    if (!/[0-9]/.test(password)) {
        result.isValid = false;
        result.messages.push("Debe incluir al menos un número");
    }

    if (!/[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/.test(password)) {
        result.isValid = false;
        result.messages.push("Debe incluir al menos un caracter especial (!@#$%^&*()_+-=[]{};':\"\\|,.<>/?)");
    }

    return result;
}

/**
 * Actualiza el indicador de fortaleza de la contraseña
 * @param {HTMLElement} passwordInput - El campo de contraseña
 * @param {HTMLElement} strengthIndicator - El indicador de fortaleza
 */
function updatePasswordStrength(passwordInput, strengthIndicator) {
    const password = passwordInput.value;
    const validation = validatePassword(password);
    strengthIndicator.innerHTML = '';

    if (password.length === 0) {
        strengthIndicator.style.display = 'none';
        return;
    }

    strengthIndicator.style.display = 'block';

    let strength = 'débil';
    let color = '#ff4d4d';
    const criteriaCount = 5 - validation.messages.length;

    if (criteriaCount >= 4) {
        strength = 'fuerte';
        color = '#4CAF50';
    } else if (criteriaCount >= 2) {
        strength = 'media';
        color = '#FFC107';
    }

    const strengthMessage = document.createElement('div');
    strengthMessage.textContent = `Contraseña ${strength}`;
    strengthMessage.style.color = color;
    strengthMessage.style.marginBottom = '5px';
    strengthIndicator.appendChild(strengthMessage);

    validation.messages.forEach(message => {
        const messageElement = document.createElement('div');
        messageElement.textContent = message;
        messageElement.style.fontSize = '12px';
        messageElement.style.color = '#666';
        strengthIndicator.appendChild(messageElement);
    });
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

        input.addEventListener('input', () => {
            updatePasswordStrength(input, strengthIndicator);
        });

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
