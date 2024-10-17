/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qantuw.semana9;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Collectors;

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

    // Método para leer desde un archivo txt
    public static List<Pelicula> fromTxt(String filePath, List<Genero> todosGeneros, List<Director> todosDirectores) throws IOException {
        return Files.lines(Paths.get(filePath))
            .map(line -> {
                String[] data = line.split(",");
                List<Genero> generosDePelicula = todosGeneros.stream()
                    .filter(g -> Arrays.asList(data[4].split(";")).contains(g.getNombreGenero()))
                    .collect(Collectors.toList());
                List<Director> directoresDePelicula = todosDirectores.stream()
                    .filter(d -> Arrays.asList(data[5].split(";")).contains(d.getNombreDirector()))
                    .collect(Collectors.toList());
                return new Pelicula(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2]),
                    data[3],
                    generosDePelicula,
                    directoresDePelicula
                );
            }).collect(Collectors.toList());
    }

    public List<Genero> getGeneros() {
        return generos;
    }
    
}
