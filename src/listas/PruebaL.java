package listas;

import fes.aragon.excepciones.IndiceFueraRango;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PruebaL {
    public static void main(String[] args) {
        InsertarLista leerA = new InsertarLista();
        leerA.procesarArchivo("/home/kayaba/Descargas/Datos.csv");
        leerA.print();
        try {
            double promedio = leerA.calcularPromedio();
            int minimo = leerA.minValue();
            int maximo = leerA.maxValue();

            System.out.println("Promedio: " + promedio);
            System.out.println("Mínimo: " + minimo);
            System.out.println("Máximo: " + maximo);
        } catch (Exception e) {
            System.out.println("Error al calcular estadísticas: " + e.getMessage());
        }

    }
}
