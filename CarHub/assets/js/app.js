function cargarVehiculos() {
    fetch("http://localhost:4050/vehiculos")
    .then(function(respuestaTextoPlano) {
        return respuestaTextoPlano.json()
    })
    .then(function(data) {
        console.log(data)
        const divContenedor = document.getElementById("contenedor-vehiculos")
        divContenedor.innerHTML = ""

        const divLista = document.createElement("div")
        divLista.classList.add("vehicle-list")

        for (let vehiculo of data) {
            const div = document.createElement("div")
            div.classList.add("vehicle")

            const img = document.createElement("img")
            img.src = vehiculo.imagen_url
            img.alt = `${vehiculo.marca} ${vehiculo.modelo}`

            const h3 = document.createElement("h3")
            h3.textContent = `${vehiculo.marca} ${vehiculo.modelo}`

            const p = document.createElement("p")
            p.textContent = `Precio: ${vehiculo.precio} €`

            div.appendChild(img)
            div.appendChild(h3)
            div.appendChild(p)

            divLista.appendChild(div)
        }

        divContenedor.appendChild(divLista)
    })
    .catch(function(error) {
        console.error("Error al cargar vehículos:", error)
    })
}

// Añadir evento para cargar los vehículos cuando se carga la página
document.addEventListener('DOMContentLoaded', function() {
    // Verificar si estamos en la página del catálogo
    if (document.querySelector('.catalog-page')) {
        cargarVehiculos()
    }
    
    // Descomentar si necesitas cargar componentes
    /*
    cargarComponente('navbar.html', 'nav')
    cargarComponente('footer.html', 'footer')
    */
})

/*
function cargarComponente(ruta, elementoId) {
    fetch(`../componentes/${ruta}`)
    .then(function(response) {
        if (!response.ok) {
            throw new Error(`Error al cargar ${ruta}: ${response.status}`)
        }
        return response.text()
    })
    .then(function(data) {
        document.getElementById(elementoId).innerHTML = data
    })
    .catch(function(error) {
        console.error(`Error cargando el componente: ${error}`)
    })
}
*/
