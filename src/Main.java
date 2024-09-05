import fes.aragon.estaticos.Array;
import fes.aragon.excepciones.IndiceFueraRango;

import java.io.*;
public class Main {
    public static Array<String> arr = new Array<>(50);
    public static void main(String[] args)  {
        try {
            BufferedReader archivo = new BufferedReader(new FileReader("src/employees.csv"));
            String line = null;
            while((line = archivo.readLine()) != null) {
                String[] elements = line.split(",");
                int elementsT = elements.length;
              for(int i = 0; i < elementsT; i++) {
                  arr.insertar(elements[i]);
                    System.out.println(elements[i]+ " ");
                }
            }
          arr.imprime();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (IndiceFueraRango e) {
            System.out.println(e);
        }
    }
}