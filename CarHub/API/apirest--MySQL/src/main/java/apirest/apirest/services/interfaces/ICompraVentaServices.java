package apirest.apirest.services.interfaces;

import apirest.apirest.models.CompraVentaModel;

import java.util.ArrayList;
import java.util.Optional;

public interface ICompraVentaServices {
    ArrayList<CompraVentaModel> obtenerTodasLasTransacciones();
    Optional<CompraVentaModel> obtenerTransaccionPorId(Long transa);
    CompraVentaModel saveTransaccion(CompraVentaModel transa);
    CompraVentaModel editTransaccion (CompraVentaModel transa, Long id);
    Boolean deleteTransaccion (Long id);
}
