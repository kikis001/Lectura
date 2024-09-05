package PruebasCSV;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SImulador {
    public static List<int[]> leerCSV() {
        List<int[]> datos = new ArrayList<>();
        Random random = new Random();

        for(int i = 0; i < 300; i++) {
            int[] file = new int[3];
            file[0] = i + 1;
            file[1] = random.nextInt(100) + 1;
            file[2] = random.nextInt(10) +1;
            datos.add(file);
        }
        return datos;
    }
}
