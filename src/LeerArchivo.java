import fes.aragon.estaticos.Array;
import fes.aragon.excepciones.IndiceFueraRango;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivo {

    private Array<Integer> arr;

    public static void main(String[] args) {
       LeerArchivo leerA = new LeerArchivo();
        leerA.procesarArchivo("/home/kayaba/Descargas/Datos.csv");
        leerA.imprimir();
    }

    /**
     * Método que regresa el arreglo
     * @return retorna en un arreglo los elementos de un archivo csv
     */
    public Array<Integer> getArr() {
        return arr;
    }

    /**
     * Método que lee un archivo .csv e introduce un n número de elementos dependiendo de las filas y columnas dadas
     * @param path ruta del archivo csv
     * @param filas numero de filas a considerar
     * @param columnas numero de columnas a considerar
     */
   /* public void procesarArchivoo(String path, int filas, int columnas) {
        try {
            int total = filas * columnas;
            arr = new Array<>(total);
            BufferedReader archivo = new BufferedReader(new FileReader(path));
            String line = null;
            while((line = archivo.readLine()) != null) {
                String[] elements = line.split(",");
                int nElements = elements.length;
                for(int i = 0; i < nElements; i++) {
                    arr.insertar(elements[i]);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        } catch (IndiceFueraRango e) {
            System.out.println(e);
        }
    }*/
    /**
     * Método que lee un archivo .csv e introduce un n número de elementos dependiendo de las filas y columnas dadas
     * @param path ruta del archivo csv
     */
    public void procesarArchivo(String path){
        try {
            BufferedReader archivo = new BufferedReader(new FileReader(path));
            String line = archivo.readLine();
            arr = new Array<>(300);
            while(line != null) {
                String[] elements = line.split(",");
                for(int i = 0; i < elements.length; i++) {
                    arr.insertar(Integer.parseInt(elements[i]));
                }
            }
            archivo.close();
        } catch (IOException e ) {
            e.printStackTrace();
        } catch (IndiceFueraRango e) {
            System.out.println(e);
        }
    }

    /**
     * Método que imprime la matriz donde se almacenan los datos del archivo csv
     */
    public void imprimir() {
        try {
            arr.imprime();

        }catch (IndiceFueraRango e){
            System.out.println(e);
        }
    }

}
