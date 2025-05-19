package apirest.apirest.services;


import apirest.apirest.models.CompraVentaModel;
import apirest.apirest.repositories.ICompraVentaRepository;
import apirest.apirest.services.interfaces.ICompraVentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CompraVentaServices implements ICompraVentaServices {

    @Autowired
    ICompraVentaRepository compraVentaRepository;

    @Override
    public ArrayList<CompraVentaModel> obtenerTodasLasTransacciones() {
        return (ArrayList<CompraVentaModel>)compraVentaRepository.findAll();
    }
    
    @Override
    public Optional<CompraVentaModel> obtenerTransaccionPorId(Long transa) {
        return compraVentaRepository.findById(transa);
    }

    @Override
    public CompraVentaModel saveTransaccion(CompraVentaModel transa) {
        return compraVentaRepository.save(transa);
    }

    @Override
    public CompraVentaModel editTransaccion(CompraVentaModel transa, Long id) {
        CompraVentaModel transaModel = compraVentaRepository.findById(id).get();
        transaModel.setId_vehiculo(transa.getId_vehiculo());
        transaModel.setId_financiacion(transa.getId_financiacion());
        transaModel.setId_vendedor(transa.getId_vendedor());
        transaModel.setFecha_transaccion(transa.getFecha_transaccion());
        return compraVentaRepository.save(transaModel);
    }

    @Override
    public Boolean deleteTransaccion(Long id) {
        try{
            compraVentaRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
