/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qantuw.semana9;

import java.util.*;


public class Pais {
    
     private String codigo;
    private String nombrePais;
    private String nombreContinente;
    private double areaPoblacion;
    private int capital;
    private int nroPoblacion;
    private int nroCiudades;
    private List<Ciudad> ciudades;

    public Pais(String codigo, String nombrePais, String nombreContinente, double areaPoblacion, int capital, int nroPoblacion, int nroCiudades, List<Ciudad> ciudades) {
        this.codigo = codigo;
        this.nombrePais = nombrePais;
        this.nombreContinente = nombreContinente;
        this.areaPoblacion = areaPoblacion;
        this.capital = capital;
        this.nroPoblacion = nroPoblacion;
        this.nroCiudades = nroCiudades;
        this.ciudades = ciudades;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getNombreContinente() {
        return nombreContinente;
    }

    public void setNombreContinente(String nombreContinente) {
        this.nombreContinente = nombreContinente;
    }

    public double getAreaPoblacion() {
        return areaPoblacion;
    }

    public void setAreaPoblacion(double areaPoblacion) {
        this.areaPoblacion = areaPoblacion;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public int getNroPoblacion() {
        return nroPoblacion;
    }

    public void setNroPoblacion(int nroPoblacion) {
        this.nroPoblacion = nroPoblacion;
    }

    public int getNroCiudades() {
        return nroCiudades;
    }

    public void setNroCiudades(int nroCiudades) {
        this.nroCiudades = nroCiudades;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    
   
     

}
