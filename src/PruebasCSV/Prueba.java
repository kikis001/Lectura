package PruebasCSV;

import Fes.Aragon.Estaticos.Array;
import Fes.Aragon.Excepciones.IndiceFueraRango;

public class Prueba {
    private int sup = 0;
    private static Array<Integer> arr = new Array<>(10);

    public static void main(String[] args) {
        try {
            arr.insertar(1);
        } catch (IndiceFueraRango e) {
            System.out.println(e);
        }
    }

    public Integer supremo() throws IndiceFueraRango {
        try {
            Integer s = arr.recupera(0);
            for (int i = 1; i < arr.longitud(); i++) {
                Integer current = arr.recupera(i);
                if (s.compareTo(current) < 0) {
                    s = current;
                }

            }
            return s;
        } catch (IndiceFueraRango e) {
            System.out.println(e);
        }
        return null;
    }
}
