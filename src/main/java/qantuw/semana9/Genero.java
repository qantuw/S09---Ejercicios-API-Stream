/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qantuw.semana9;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class Genero {
     private int idGenero;
    private String nombreGenero;

    public Genero(int idGenero, String nombreGenero) {
        this.idGenero = idGenero;
        this.nombreGenero = nombreGenero;
    }
    public static List<Genero> fromTxt(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
            .map(line -> {
                String[] data = line.split(",");
                return new Genero(Integer.parseInt(data[0]), data[1]);
            }).collect(Collectors.toList());
    }

    public String getNombreGenero() {
        return nombreGenero;
    }
    


}
