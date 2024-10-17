/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qantuw.semana9;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class Director {
    private int idDirector;
    private String nombreDirector;
    private List<String> premios;
    
public Director(int idDirector, String nombreDirector, List<String> premios) {
        this.idDirector = idDirector;
        this.nombreDirector = nombreDirector;
        this.premios = premios;

}
public static List<Director> fromTxt(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
            .map(line -> {
                String[] data = line.split(",");
                List<String> premios = Arrays.asList(data[2].split(";"));
                return new Director(
                    Integer.parseInt(data[0]),
                    data[1],
                    premios
                );
            }).collect(Collectors.toList());
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

}
