package listas;

import fes.aragon.dinamicos.ListaSimple;
import fes.aragon.dinamicos.Nodo;
import fes.aragon.estaticos.Array;
import fes.aragon.excepciones.IndiceFueraRango;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InsertarLista {
    private ListaSimple<Integer> lista;

    public InsertarLista() {
        lista = new ListaSimple<>();
    }

    public void procesarArchivo(String path){
        try (BufferedReader archivo = new BufferedReader(new FileReader(path))) {
            String line;
            // Leer línea por línea
            while ((line = archivo.readLine()) != null) {
                // Dividir la línea en elementos usando coma como separador
                String[] elements = line.split(",");
                for (String element : elements) { // for each
                    // Convertir el elemento a Integer y agregarlo a la lista
                    try {
                        lista.append(Integer.parseInt(element.trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir el elemento: " + element);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        Nodo<Integer> current = lista.head;
        while(current != null ) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.println("null");
        //lista.print();
    }

    public int maxValue() {
        if (lista.esVacia()) {
            throw new ArithmeticException("No se puede calcular el promedio de una lista vacía.");
        }
        Nodo<Integer> current = lista.head;
        int max = current.value;

       while(current != null) {
           if(current.value > max) {
               max = current.value;
           }
           current = current.next;
       }
        return max;
    }

    public int minValue() {
        if(lista.esVacia()) {
            throw new ArithmeticException("No se puede calcular el promedio de una lista vacía.");
        }
        Nodo<Integer> current = lista.head;
        int min = current.value;
        while(current != null) {
            if(current.value < min) {
                min = current.value;
            }
            current = current.next;
        }
        return min;
    }

    public double calcularPromedio() {
        if (lista.esVacia()) {
            throw new ArithmeticException("No se puede calcular el promedio de una lista vacía.");
        }

        double suma = 0;
        Nodo<Integer> current = lista.head;
        while (current != null) {
            suma += current.value;
            current = current.next;
        }
        return suma / lista.getLongitud();
    }
}
