package apirest.apirest.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Transacciones")
public class CompraVentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private int id_transaccion;

    @Column
    private int id_vendedor;

    @Column
    private int id_vehiculo;

    @Column
    private int id_financiacion;

    @Column
    private Date fecha_transaccion;

    public CompraVentaModel(int id_transaccion, int id_vendedor, int id_vehiculo, int id_financiacion, Date fecha_transaccion) {
        this.id_transaccion = id_transaccion;
        this.id_vendedor = id_vendedor;
        this.id_vehiculo = id_vehiculo;
        this.id_financiacion = id_financiacion;
        this.fecha_transaccion = fecha_transaccion;
    }

    public CompraVentaModel() {

    }

    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getId_financiacion() {
        return id_financiacion;
    }

    public void setId_financiacion(int id_financiacion) {
        this.id_financiacion = id_financiacion;
    }

    public Date getFecha_transaccion() {
        return fecha_transaccion;
    }

    public void setFecha_transaccion(Date fecha_transaccion) {
        this.fecha_transaccion = fecha_transaccion;
    }
}