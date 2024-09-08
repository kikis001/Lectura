package listas;

import fes.aragon.dinamicos.ListaDoble;
import fes.aragon.dinamicos.Nodo;
import fes.aragon.dinamicos.NodoD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InsertarListaDoble {
    private ListaDoble<Integer> listaDoble;

    public InsertarListaDoble() {
        listaDoble = new ListaDoble<>();
    }

    public void procesarArchivo(String path) {
        try (BufferedReader archivo = new BufferedReader(new FileReader(path))) {
            String line;
            // Leer línea por línea
            while ((line = archivo.readLine()) != null) {
                // Dividir la línea en elementos usando coma como separador
                String[] elements = line.split(",");
                for (String element : elements) { // for each
                    // Convertir el elemento a Integer y agregarlo a la lista
                    try {
                        listaDoble.agregar(Integer.parseInt(element.trim()));
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
        listaDoble.print();
    }

    public int maxValue() {
        if(listaDoble.esVacia()) {
            throw new ArithmeticException("No se puede calcular el promedio de una lista vacía.");
        }
        NodoD<Integer> current = listaDoble.head;
        int maxValue = current.value;
        while(current != null) {
            if(current.value > maxValue) {
                maxValue = current.value;
            }
            current = current.next;
        }
        return maxValue;
    }

    public int minValue() {
        if(listaDoble.esVacia()) {
            throw new ArithmeticException("No se puede calcular el promedio de una lista vacía.");
        }
        NodoD<Integer> current = listaDoble.head;
        int minValue = current.value;
        while(current != null) {
            if(current.value < minValue) {
                minValue = current.value;
            }
            current = current.next;
        }
        return minValue;
    }

    public double promedio() {
        if(listaDoble.esVacia()) {
            throw new ArithmeticException("No se puede calcular el promedio de una lista vacía.");
        }
        double sum = 0;
        NodoD<Integer> current = listaDoble.head;

        while(current != null) {
            sum += current.value;
            current = current.next;
        }
        return sum/ listaDoble.getLongitud();
    }
}