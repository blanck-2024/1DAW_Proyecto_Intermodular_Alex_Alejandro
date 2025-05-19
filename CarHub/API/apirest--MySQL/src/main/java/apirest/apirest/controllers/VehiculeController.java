package apirest.apirest.controllers;

import apirest.apirest.models.VehiculoModel;
import apirest.apirest.services.interfaces.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import apirest.apirest.utils.ReponseMessage;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/vehiculos")
public class VehiculeController {
    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping
    public ArrayList<VehiculoModel> getAllVehiculos(){
        return this.vehiculoService.getVehiculos();
    }

    @GetMapping("/{id}")
    public Optional<VehiculoModel> getVehiculoById(@PathVariable Long id){
        return this.vehiculoService.getVehiculoById(id);
    }

    @PostMapping
    public VehiculoModel newVehiculo (@RequestBody VehiculoModel newVehiculo){
        return this.vehiculoService.newVehiculo(newVehiculo);
    }

    @PutMapping("/{id}")
    public VehiculoModel updateVehiculo (@RequestBody VehiculoModel vehiculo, @PathVariable Long id){
        return this.vehiculoService.updateVehiculo(vehiculo,id);
    }

    @DeleteMapping("/{id}")
    public ReponseMessage deleteVehiculo (@PathVariable Long id){
        boolean eliminado = this.vehiculoService.deleteVehiculo(id);
        if (eliminado) {
            return new ReponseMessage("Vehiculo con id'"+id+"' ha sido eliminado correctamente");
        } else {
            return new ReponseMessage("Error al eliminar vehiculo con id '"+id+"'");
        }
    }
}