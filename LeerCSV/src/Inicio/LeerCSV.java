package Inicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeerCSV {

    public static void main(String[] args) {

        String rutaArchivo = "vial.csv";

        List<Vial> viales = new ArrayList<>();

        try (
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        ) {
            String linea = br.readLine();

            // Leer las líneas restantes del archivo
            while ((linea = br.readLine()) != null) {

                String[] valores = linea.split(",");

                Vial vial = new Vial(
                    Integer.parseInt(valores[0]),
                    valores[1],
                    Integer.parseInt(valores[2]),
                    valores[3],
                    Integer.parseInt(valores[4])
                );

                viales.add(vial);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar la información de los objetos Vial
        for (Vial vial : viales) {
            System.out.println(vial.toString());
        }
    }
}

class Vial {

    private int id;
    private String nombre;
    private int longitud;
    private String tipo;
    private int estado;

    public Vial(int id, String nombre, int longitud, String tipo, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.longitud = longitud;
        this.tipo = tipo;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Vial{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", longitud=" + longitud +
                ", tipo='" + tipo + '\'' +
                ", estado=" + estado +
                '}';
    }
}
