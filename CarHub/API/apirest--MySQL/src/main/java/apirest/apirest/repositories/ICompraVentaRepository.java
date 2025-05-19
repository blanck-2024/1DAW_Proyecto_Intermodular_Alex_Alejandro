package apirest.apirest.repositories;
import apirest.apirest.models.CompraVentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraVentaRepository extends JpaRepository<CompraVentaModel,Long> {
}
