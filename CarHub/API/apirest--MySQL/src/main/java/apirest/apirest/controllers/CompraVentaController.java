package apirest.apirest.controllers;
import apirest.apirest.models.CompraVentaModel;
import apirest.apirest.services.interfaces.ICompraVentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import apirest.apirest.utils.ResponseMessage2;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/compraventa")
public class CompraVentaController {
    @Autowired
    private ICompraVentaServices compraVentaServices;

    @GetMapping
    public ArrayList<CompraVentaModel> getAllCV(){
        return this.compraVentaServices.obtenerTodasLasTransacciones();
    }

    @GetMapping("/{id}")
    public Optional<CompraVentaModel> getCVID(@PathVariable Long id){
        return this.compraVentaServices.obtenerTransaccionPorId(id);
    }

    @PostMapping
    public CompraVentaModel insertCV(@RequestBody CompraVentaModel transa){
        return this.compraVentaServices.saveTransaccion(transa);
    }

    @PutMapping("/{id}")
    public CompraVentaModel updateCV (@RequestBody CompraVentaModel transa, @PathVariable Long id){
        return this.compraVentaServices.editTransaccion(transa,id);
    }

    @DeleteMapping("/{id}")
    public CompraVentaModel deleteCV(@PathVariable Long id){
        boolean elimadoCV = this.compraVentaServices.deleteTransaccion(id);
        if (elimadoCV){
            return new ResponseMessage2("Transaccion " + id + " elimada con exito");
        }else {
            return new ResponseMessage2("Error al eliminar la transaccion: " + id);
        }
    }
}
