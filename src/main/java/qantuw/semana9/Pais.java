/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qantuw.semana9;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class Pais {
    
     private String codigo;
    private String nombrePais;
    private String nombreContinente;
    private double areaPoblacion;
    private int capital;
    private int nroPoblacion;
    private List<Ciudad> ciudades;

    public Pais(String codigo, String nombrePais, String nombreContinente, double areaPoblacion, int capital, int nroPoblacion, List<Ciudad> ciudades) {
        this.codigo = codigo;
        this.nombrePais = nombrePais;
        this.nombreContinente = nombreContinente;
        this.areaPoblacion = areaPoblacion;
        this.capital = capital;
        this.nroPoblacion = nroPoblacion;
        this.ciudades = ciudades;
    }
    
     public static List<Pais> fromTxt(String filePath, List<Ciudad> todasCiudades) throws IOException {
        return Files.lines(Paths.get(filePath))
            .map(line -> {
                String[] data = line.split(",");
                List<Ciudad> ciudadesDelPais = todasCiudades.stream()
                    .filter(c -> c.getCodCiudad().startsWith(data[0]))
                    .collect(Collectors.toList());
                return new Pais(
                    data[0], data[1], data[2],
                    Double.parseDouble(data[3]),
                    Integer.parseInt(data[4]),
                    Integer.parseInt(data[5]),
                    ciudadesDelPais
                );
            }).collect(Collectors.toList());
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }
     

}
