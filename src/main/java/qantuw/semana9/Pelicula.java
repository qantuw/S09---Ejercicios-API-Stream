/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qantuw.semana9;
import java.util.*;
import java.util.List;

public class Pelicula {
     private int idPelicula;
    private String tituloPelicula;
    private int year;
    private String ranking;
    private List<Genero> generos;
    private List<Director> directores;
    
     public Pelicula(int idPelicula, String tituloPelicula, int year, String ranking, List<Genero> generos, List<Director> directores) {
        this.idPelicula = idPelicula;
        this.tituloPelicula = tituloPelicula;
        this.year = year;
        this.ranking = ranking;
        this.generos = generos;
        this.directores = directores;
    }

    

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Director> getDirectores() {
        return directores;
    }

    public void setDirectores(List<Director> directores) {
        this.directores = directores;
    }

    
    
}
