function cargarVehiculos(){
    fetch("http://localhost:4001/vehiculos")
    .then(function(respuestaTextoPlano){
        return respuestaTextoPlano.json()
    })
    .then(function(data){
        const divContenedor = document.getElementById("contenedor-vehiculos") // Referencia al div en el HTML
        divContenedor.innerHTML = "" // Limpia el contenido anterior

        const divLista = document.createElement("div")
        divLista.classList.add("vehicle-list")

        // Agregar vehículos al contenedor
        for (let vehiculo of data) {
            const div = document.createElement("div")
            div.classList.add("vehicle")

            const img = document.createElement("img")
            img.src = vehiculo.imagenes
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
    .catch(error => console.error("Error al cargar vehículos:", error))
}

// Llamar a la función cuando la página cargue
document.addEventListener("DOMContentLoaded", cargarVehiculos)




document.addEventListener("DOMContentLoaded", function() {
    // Cargar el Navbar
    fetch("../../components/navbar.html")
        .then(response => response.text())
        .then(data => {
            document.getElementById("nav").innerHTML = data

            // Ocultar la opción de "Catálogo" si estamos en la página de catálogo
            const catalogLink = document.querySelector('a[data-page="catalog"]')
            if (catalogLink) {
                catalogLink.parentElement.style.display = 'none'
            }
        })
        .catch(error => console.error('Error cargando el navbar:', error))
    })
    /*
    // Cargar el Footer
    fetch("../components/footer.html")
        .then(response => response.text())
        .then(data => document.getElementById("footer").innerHTML = data)
        .catch(error => console.error('Error cargando el footer:', error))
})
*/