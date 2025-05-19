package apirest.apirest.repositories;


import apirest.apirest.models.VehiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculoRepository extends JpaRepository <VehiculoModel, Long> {
}
