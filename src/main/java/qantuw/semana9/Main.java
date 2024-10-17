
package qantuw.semana9;

import java.util.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Collectors;


public class Main {
    private static final int LIMITE_POBLACION = 20_000_000; // Constante para el límite de población

    public static void main(String[] args) {
        try {
            
            List<Ciudad> todasCiudades = Ciudad.fromTxt("ciudades.txt");
            List<Genero> todosGeneros = Genero.fromTxt("generos.txt");
            List<Director> todosDirectores = Director.fromTxt("directores.txt");
            List<Pais> todosPaises = Pais.fromTxt("paises.txt", todasCiudades);
            List<Pelicula> todasPeliculas = Pelicula.fromTxt("peliculas.txt", todosGeneros, todosDirectores);

            
            mostrarCiudades(todasCiudades);
            mostrarGeneros(todosGeneros);
            mostrarDirectores(todosDirectores);

            
            List<Ciudad> ciudadesConMasDe20Millones = filtrarCiudadesPorPoblacion(todasCiudades, LIMITE_POBLACION);
            mostrarCiudadesConMasDe20Millones(ciudadesConMasDe20Millones);

    
            List<Pelicula> peliculasConDramaYComedia = filtrarPeliculasPorGeneros(todasPeliculas);
            mostrarPeliculasConDramaYComedia(peliculasConDramaYComedia);

        } catch (IOException e) {
            System.err.println("Error al leer archivos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    private static void mostrarCiudades(List<Ciudad> ciudades) {
        System.out.println("Lista de ciudades:");
        ciudades.forEach(System.out::println);
        System.out.println();
    }

   
    private static void mostrarGeneros(List<Genero> generos) {
        System.out.println("Lista de géneros:");
        generos.forEach(System.out::println);
        System.out.println();
    }

   
    private static void mostrarDirectores(List<Director> directores) {
        System.out.println("Lista de directores:");
        directores.forEach(System.out::println);
        System.out.println();
    }

   
    private static List<Ciudad> filtrarCiudadesPorPoblacion(List<Ciudad> ciudades, int limitePoblacion) {
        return ciudades.stream()
                .filter(ciudad -> ciudad.getNroPoblacion() > limitePoblacion)
                .collect(Collectors.toList());
    }

    
    private static void mostrarCiudadesConMasDe20Millones(List<Ciudad> ciudades) {
        System.out.println("Ciudades con más de 20 millones de habitantes:");
        ciudades.forEach(System.out::println);
        System.out.println();
    }

    
    private static List<Pelicula> filtrarPeliculasPorGeneros(List<Pelicula> peliculas) {
        return peliculas.stream()
            .filter(pelicula -> {
                List<String> nombresGeneros = pelicula.getGeneros().stream()
                    .map(Genero::getNombreGenero)
                    .collect(Collectors.toList());
                return nombresGeneros.size() == 2 && 
                       nombresGeneros.containsAll(Arrays.asList("Drama", "Comedia"));
            })
            .collect(Collectors.toList());
    }

  
    private static void mostrarPeliculasConDramaYComedia(List<Pelicula> peliculas) {
        System.out.println("Películas con géneros 'Drama' y 'Comedia':");
        peliculas.forEach(System.out::println);
        System.out.println();
    }
}
