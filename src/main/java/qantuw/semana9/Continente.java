
package qantuw.semana9;

import java.util.List;

public class Continente {
    private int idContinente;
    private String nombreContinente;
    private List<Pais> paises;

    public Continente(int idContinente, String nombreContinente, List<Pais> paises) {
        this.idContinente = idContinente;
        this.nombreContinente = nombreContinente;
        this.paises = paises;
    }

    public int getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(int idContinente) {
        this.idContinente = idContinente;
    }

    public String getNombreContinente() {
        return nombreContinente;
    }

    public void setNombreContinente(String nombreContinente) {
        this.nombreContinente = nombreContinente;
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }
    
    
}
