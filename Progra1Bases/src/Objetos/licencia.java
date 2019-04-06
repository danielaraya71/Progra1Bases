package Objetos;

import java.io.FileInputStream;

public class licencia {
    private int numeroLicencia;
    private int cedula;
    private int idTipoLicencia;
    private String fEmision;
    private String fExpiracion;
    private FileInputStream fotoLicencia;

    public int getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(int numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getIdTipoLicencia() {
        return idTipoLicencia;
    }

    public void setIdTipoLicencia(int idTipoLicencia) {
        this.idTipoLicencia = idTipoLicencia;
    }

    public String getfEmision() {
        return fEmision;
    }

    public void setfEmision(String fEmision) {
        this.fEmision = fEmision;
    }

    public String getfExpiracion() {
        return fExpiracion;
    }

    public void setfExpiracion(String fExpiracion) {
        this.fExpiracion = fExpiracion;
    }

    public FileInputStream getFotoLicencia() {
        return fotoLicencia;
    }

    public void setFotoLicencia(FileInputStream fotoLicencia) {
        this.fotoLicencia = fotoLicencia;
    }
    
    
}
