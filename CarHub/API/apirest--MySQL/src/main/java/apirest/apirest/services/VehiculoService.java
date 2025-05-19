package apirest.apirest.services;

import apirest.apirest.models.VehiculoModel;
import apirest.apirest.repositories.IVehiculoRepository;
import apirest.apirest.services.interfaces.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VehiculoService implements IVehiculoService {

    @Autowired
    IVehiculoRepository vehiculoRepository; // JPA - Hibernate

    @Override
    public ArrayList<VehiculoModel> getVehiculos() {
        //select * from vehiculos
        return (ArrayList<VehiculoModel>) this.vehiculoRepository.findAll();
    }

    @Override
    public Optional<VehiculoModel> getVehiculoById(Long id) {
        //select * from vehiculos where id = id
        return this.vehiculoRepository.findById(id);
    }

    @Override
    public VehiculoModel newVehiculo(VehiculoModel newVehiculo) {
        // insert into vehiculos values (...)
        return this.vehiculoRepository.save(newVehiculo);
    }

    @Override
    public VehiculoModel updateVehiculo(VehiculoModel vehiculoParam, Long id) {
        //Guardamos el vehiculo con id igual pasado por parametro en un objeto de tipo vehiculo
        VehiculoModel vehiculo = this.vehiculoRepository.findById(id).get();
        //Luego actualizamos este objeto con los datos del objeto pasado por paremtro
        vehiculo.setMarca(vehiculoParam.getMarca());
        vehiculo.setModelo(vehiculoParam.getModelo());
        vehiculo.setAnyo(vehiculoParam.getAnyo());
        vehiculo.setTipo(vehiculoParam.getTipo());
        vehiculo.setKilometraje(vehiculoParam.getKilometraje());
        vehiculo.setPrecio(vehiculoParam.getPrecio());
        vehiculo.setImagen_url(vehiculoParam.getImagen_url());
        //Por ultimo se guarda este nuevo vehiculo con los datos del vehiculo pasado por parametro - en la Base de Datos
        this.vehiculoRepository.save(vehiculo);
        return vehiculo;
    }

    @Override
    public Boolean deleteVehiculo(Long id) {
        try{
            this.vehiculoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
