/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package qantuw.semana9;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class Ciudad {

   private int idCiudad;
    private String nombreCiudad;
    private int nroPoblacion;
    private String codCiudad;
    
    public Ciudad(int idCiudad, String nombreCiudad, int nroPoblacion, String codCiudad) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.nroPoblacion = nroPoblacion;
        this.codCiudad = codCiudad;
    }
    public static List<Ciudad> fromTxt(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
            .map(line -> {
                String[] data = line.split(",");
                return new Ciudad(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2]),
                    data[3]
                );
            }).collect(Collectors.toList());
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public int getNroPoblacion() {
        return nroPoblacion;
    }

    public String getCodCiudad() {
        return codCiudad;
    }
    
 
}
