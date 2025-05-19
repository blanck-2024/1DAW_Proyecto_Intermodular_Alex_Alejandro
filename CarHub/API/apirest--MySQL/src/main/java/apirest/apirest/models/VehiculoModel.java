package apirest.apirest.models;


import jakarta.persistence.*;

/*
Primero, definimos la clase Vehiculo, que representará los elementos en nuestro
archivo JSON:
* */
@Entity
@Table(name = "Vehiculos")
public class VehiculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vehiculo;

    @Column
    private String marca;

    @Column
    private String modelo;

    @Column
    private int anyo;

    @Column
    private String tipo;

    @Column
    private double kilometraje;

    @Column
    private double precio;

    @Column
    private String imagen_url;


    public Long getId_vehiculo() {
        return this.id_vehiculo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnyo() {
        return this.anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen_url() {
        return this.imagen_url;
    }

    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }
}
