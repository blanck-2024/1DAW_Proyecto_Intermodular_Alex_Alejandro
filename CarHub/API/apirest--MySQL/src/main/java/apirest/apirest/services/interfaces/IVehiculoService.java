package apirest.apirest.services.interfaces;

import apirest.apirest.models.VehiculoModel;

import java.util.ArrayList;
import java.util.Optional;

public interface IVehiculoService {
    ArrayList<VehiculoModel> getVehiculos();
    Optional<VehiculoModel> getVehiculoById(Long id);
    VehiculoModel newVehiculo(VehiculoModel newVehiculo);
    VehiculoModel updateVehiculo(VehiculoModel vehiculo, Long id);
    Boolean deleteVehiculo(Long id);
}
