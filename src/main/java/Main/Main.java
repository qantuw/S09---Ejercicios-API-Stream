
package Main;

import java.util.*;
import java.util.List;
import java.io.IOException;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import qantuw.semana9.Ciudad;
import qantuw.semana9.Director;
import qantuw.semana9.Genero;
import qantuw.semana9.Pais;
import qantuw.semana9.Pelicula;
import qantuw.semana9.Continente;

public class Main {

    public static void main(String[] args) {
        
        Ciudad ciudad1 = new Ciudad(1, "Ciudad de México", 21000000, "MX001"),
               ciudad2 = new Ciudad(2, "Tokio", 37000000, "JP001"),
               ciudad3 = new Ciudad(3, "Londres", 14000000, "GB001"),
               ciudad4 = new Ciudad(4, "Lagos", 21000000, "NG001"),
               ciudad5 = new Ciudad(5, "Sydney", 5000000, "AU001");
        

        List<Ciudad> ciudades1 = List.of(ciudad1 );
        List<Ciudad> ciudades2 = List.of(ciudad2);
        List<Ciudad> ciudades3 = List.of(ciudad3);
        List<Ciudad> ciudades4 = List.of(ciudad4);
        List<Ciudad> ciudades5 = List.of(ciudad5);

        
        Pais pais1 = new Pais("MX", "México", "América", 1964375.0, 0, 128932753,120,  ciudades1),
             pais2 = new Pais("JP", "Japón", "Asia", 377975.0, 0, 125960000, 791, ciudades2),
             pais3 = new Pais("GB", "Inglaterra", "Europa", 242495.0, 0, 67886011,51,  ciudades3),
             pais4 = new Pais("NG", "Nigeria", "Africa", 923769.0, 0, 206139587, 100, ciudades4),
             pais5 = new Pais("AU", "Australia", "Oceania", 7692024.0, 0, 25687041,51,  ciudades5);

        List<Pais> paises1 = List.of(pais1);
        List<Pais> paises2 = List.of(pais2);
        List<Pais> paises3 = List.of(pais3);
        List<Pais> paises4 = List.of(pais4);
        List<Pais> paises5 = List.of(pais5);
        

        Continente continente1 = new Continente(1, "América", paises1),
                   continente2 = new Continente(2, "Asia", paises2),
                   continente3 = new Continente(2, "Europa", paises3),
                   continente4 = new Continente(2, "Africa", paises4),
                   continente5 = new Continente(2, "Oceania", paises5);

        List<Continente> continentes = List.of(continente1, continente2, continente3,continente4,continente5 );

       
        System.out.println("La Ciudad mas poblada de cada continente:");
        continentes.stream()
                .collect(Collectors.toMap(Continente::getNombreContinente, continente -> continente.getPaises().stream()
                    .flatMap(pais -> pais.getCiudades().stream())
                    .max((a, b) -> Integer.compare(a.getNroPoblacion(), b.getNroPoblacion()))
                ))
                .forEach((continente, ciudades) -> ciudades.ifPresent(ciudad ->
                    System.out.println("La ciudad mas poblada en " + continente + " es: " +
                            ciudad.getNombreCiudad() + " y tiene una poblacion de " + ciudad.getNroPoblacion())
                ));

        
        System.out.println("\nLa Ciudad mas poblada de todos los continentes es:");
        continentes.stream()
                .flatMap(pais -> pais.getPaises().stream())
                .flatMap(ciudad -> ciudad.getCiudades().stream())
                .max((a, b) -> Integer.compare(a.getNroPoblacion(), b.getNroPoblacion()))
                .map(Ciudad::getNombreCiudad)
                .ifPresent(ciudad -> System.out.println("La ciudad mas poblada es: " + ciudad + ", con una población de 37 millones"));

       Director director1 = new Director(1, "Damien Chazelle", List.of("Oscar", "Golden Globe"));
       Director director2 = new Director(2, "Christopher Nolan", List.of("Oscar", "BAFTA"));
       Director director3 = new Director(3, "Luca Guadagnino", List.of("Cannes Award"));
       Director director4 = new Director(4, "Mark Waters", List.of("Teen Choice Award"));
       
        Genero drama = new Genero(1, "Drama");
        Genero comedia = new Genero(2, "Comedia");
        
        

        Pelicula pelicula1 = new Pelicula(1, "La La Land", 2016, "10", List.of(drama), List.of(director1));
        Pelicula pelicula2 = new Pelicula(2,  "Dunquerque", 2017, "7", List.of(drama), List.of(director2));
        Pelicula pelicula3 = new Pelicula(3,  "Call Me By Your Name", 2017, "6", List.of(drama), List.of(director3));
        Pelicula pelicula4 = new Pelicula(4,  "Chicas Pesadas", 2004, "70", List.of(comedia), List.of(director4));

         List<Pelicula> peliculas = List.of(pelicula1, pelicula2, pelicula3, pelicula4);


        System.out.println("\nPelículas que son dramáticas o de comedia:");
peliculas.stream()
        .filter(pelicula -> pelicula.getGeneros().stream().anyMatch(g -> g.getNombreGenero().equals("Drama")) ||
                pelicula.getGeneros().stream().anyMatch(g -> g.getNombreGenero().equals("Comedia")))
        .forEach(pelicula -> {
            System.out.println("Película: " + pelicula.getTituloPelicula());
            pelicula.getDirectores().forEach(director ->
                    System.out.println("Director: " + director.getNombreDirector()));
        });

        // Ciudades en orden descendente
        System.out.println("\nPaises ordenados por número de ciudades (descendente):");
        continentes.stream()
                .flatMap(c -> c.getPaises().stream())
                .sorted((p1, p2) -> Integer.compare(p2.getNroCiudades(), p1.getNroCiudades()))
                .forEach(pais -> System.out.println(pais.getNombrePais() + " tiene " + pais.getNroCiudades() + " ciudades"));

        // Países por población en orden ascendente
        System.out.println("\nPaises ordenados por número de población (ascendente):");
        continentes.stream()
                .flatMap(c -> c.getPaises().stream())
                .sorted(Comparator.comparingInt(Pais::getNroPoblacion))
                .forEach(pais -> System.out.println(pais.getNombrePais() + " tiene una poblacion de " + pais.getNroPoblacion() + " millones"));
    }
}
