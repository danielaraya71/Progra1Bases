package Objetos;

import java.io.FileInputStream;

public class cliente {
    
    String primerNombre;
    String segundoNombre;
    String primerApellido;
    String segundoApellido;
    int cedulaCliente;
    int idProvinciaCliente;
    int idCantonCliente;
    int idDistritoCliente;
    String correoCliente;
    int telefonoCliente;
    private FileInputStream fotoLicencia;
    
    public cliente(){}

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public int getIdProvinciaCliente() {
        return idProvinciaCliente;
    }

    public void setIdProvinciaCliente(int idProvinciaCliente) {
        this.idProvinciaCliente = idProvinciaCliente;
    }

    public int getIdCantonCliente() {
        return idCantonCliente;
    }

    public void setIdCantonCliente(int idCantonCliente) {
        this.idCantonCliente = idCantonCliente;
    }

    public int getIdDistritoCliente() {
        return idDistritoCliente;
    }

    public void setIdDistritoCliente(int idDistritoCliente) {
        this.idDistritoCliente = idDistritoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public FileInputStream getFotoLicencia() {
        return fotoLicencia;
    }

    public void setFotoLicencia(FileInputStream fotoLicencia) {
        this.fotoLicencia = fotoLicencia;
    }
}
