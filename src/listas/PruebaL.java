package listas;

import fes.aragon.excepciones.IndiceFueraRango;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PruebaL {
    public static void main(String[] args) {
        InsertarLista leerA = new InsertarLista();
        InsertarListaDoble leerB = new InsertarListaDoble();
        leerA.procesarArchivo("/home/kayaba/Descargas/Datos.csv");
        leerB.procesarArchivo("/home/kayaba/Descargas/Datos.csv");
        System.out.println("Lista simple");
        leerA.print();
        System.out.println("Lista doble");
        leerB.print();
        try {
            double promedio = leerA.calcularPromedio();
            int minimo = leerA.minValue();
            int maximo = leerA.maxValue();
            double promedioB= leerB.promedio();
            int minimoB = leerB.minValue();
            int maximoB = leerB.maxValue();
            System.out.println("Lista simple");
            System.out.println("Promedio: " + promedio);
            System.out.println("Mínimo: " + minimo);
            System.out.println("Máximo: " + maximo);
            System.out.println("Lista doble");
            System.out.println("Promedio: " + promedioB);
            System.out.println("Mínimo: " + minimoB);
            System.out.println("Máximo: " + maximoB);
        } catch (Exception e) {
            System.out.println("Error al calcular estadísticas: " + e.getMessage());
        }

    }
}
