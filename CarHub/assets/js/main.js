// Función para cargar componentes HTML dinámicamente
function cargarComponente(url, elementoId) {
    const elemento = document.getElementById(elementoId); // Obtener el elemento

    if (!elemento) {
        console.error(`El elemento con ID '${elementoId}' no existe.`);
        return; // Salir de la función si el elemento no existe
    }

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Error al cargar ${url}: ${response.status}`);
            }
            return response.text();
        })
        .then(data => {
            elemento.innerHTML = data; // Insertar el contenido solo si el elemento existe
        })
        .catch(error => {
            console.error(`Error cargando el componente: ${error}`);
        });
}

// Función para enviar los datos del formulario de registro
function manejarRegistroUsuario(event) {
    event.preventDefault();

    const usuario = {
        username: document.getElementById("username").value,
        nombre: document.getElementById("nombre").value,
        apellidos: document.getElementById("apellidos").value,
        correo_electronico: document.getElementById("correo_electronico").value,
        password: document.getElementById("password").value,
        telefono: document.getElementById("telefono").value,
        direccion: document.getElementById("direccion").value,
        rol: "user"
    };

    fetch("http://localhost:4050/usuarios", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(usuario)
    })
    .then(function(respuestaTextoPlano){
        return respuestaTextoPlano.json()
    })
    .then(function(data){
        console.log(data)
        if(data.password == null){
            Swal.fire({
                title: "¡Error!",
                text: data.message,
                icon: "error"
            })
        } else {
            Swal.fire({
                icon: "success",
                title: "¡Usuario registrado!",
                text: "El usuario ha sido registrado correctamente."
            })
            .then(function(){
                localStorage.setItem('rol', data.rol);
                localStorage.setItem('username', data.username);
                window.location.href="../index.html"
            })
        }
    })
    .catch(error => {
        console.error("Error al registrar:", error);
        Swal.fire({
            icon: "error",
            title: "Error de conexión",
            text: "No se pudo conectar con el servidor."
        });
    });
}

// Función para verificar el usuario
function verificarUsuario(e) {
    e.preventDefault(); // Evitar el envío del formulario

    // Obtener los valores del formulario
    const username = document.getElementById('login-username').value;
    const password = document.getElementById('login-password').value;

    // Realizar la solicitud de inicio de sesión
    fetch("http://localhost:4050/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username, password }) // Convertir a JSON
    })
    .then(response => {
        // Verificar si la respuesta es correcta
        if (!response.ok) {
            throw new Error("Credenciales inválidas");
        }
        return response.json(); // Convertir la respuesta a JSON
    })
    .then(data => {
        // Mostrar un mensaje de éxito con SweetAlert
        console.log(data)
        Swal.fire({
            title: "Inicio de Sesión",
            text: "¡Se ha iniciado sesión con éxito!",
            icon: "success"
        }).then(() => {
            // Guardar información del usuario en localStorage
            console.log(data.username)
            localStorage.setItem('rol', data.rol);
            localStorage.setItem('username', data.username);
            // Redirigir a la página principal
            window.location.href = "../index.html";
        });
    })    
    .catch(error => {
        // Manejo de errores
        Swal.fire({
            title: "¡Error!",
            text: error.message,
            icon: "error"
        });
    });
}

// Función para cerrar sesión
function cerrarSesion() {
    // Eliminar el rol y el nombre de usuario del localStorage
    localStorage.removeItem('rol');
    localStorage.removeItem('username');

    // Redirigir a la página de inicio
    window.location.href = "../index.html";
}

// Función para cargar el navbar
function cargarNavbar() {
    const nav = document.getElementById('nav');
    if (!nav) return;

    // Obtener el rol y el username desde localStorage
    const rol = localStorage.getItem('rol');
    const username = localStorage.getItem('username');

    let navbarHTML = `
        <ul>
            <li><a href="../index.html" class="nav-link">Inicio</a></li>
            <li><a href="../views/catalog.html" class="nav-link">Catálogo</a></li>
    `;

    // Agregar elementos según el rol del usuario
    if (rol === 'admin') {
        navbarHTML += `
            <li><a href="../views/dashboard.html" class="nav-link">Mi Cuenta</a></li>
            <li><a href="../views/admin.html" class="nav-link">Admin</a></li>
            <li><a href="../components/vehiculo/newVehiculo.html" class="nav-link">Nuevo Coche</a></li>
            <li><a href="#" class="nav-link" onclick="cerrarSesion()">Cerrar Sesión</a></li>
        `;
    } else if (rol === 'user') {
        navbarHTML += `
            <li><a href="../views/dashboard.html" class="nav-link">Mi Cuenta</a></li>
            <li><a href="../components/vehiculo/newVehiculo.html" class="nav-link">Nuevo Coche</a></li>
            <li><a href="#" class="nav-link" onclick="cerrarSesion()">Cerrar Sesión</a></li>
        `;
    }

    // Mostrar el nombre de usuario si está autenticado
    if (username) {
        navbarHTML += `<li class="nav-welcome">Bienvenido, ${username}</li>`;
    } else {
        navbarHTML += `
            <li><a href="../views/login.html" class="nav-link">Iniciar Sesión</a></li>
        `;
    }

    navbarHTML += `</ul>`;
    nav.innerHTML = navbarHTML; // Insertar el HTML generado
}




// Ejecutar cuando el DOM esté listo
document.addEventListener('DOMContentLoaded', function () {
    cargarNavbar(); // Asegúrate de que esta línea esté presente
    cargarComponente('/components/footer.html', 'footer'); // Si estás cargando el footer
});
