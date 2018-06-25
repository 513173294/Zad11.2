import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        List<WeatherInfo> infoPogodowe = new ArrayList<>();
        File file = new File("cities.txt");
        Scanner scanner = new Scanner(file);
        String[] tablicaMiast = new String[5];

        int i = 0;
        int j = 0;
        while (scanner.hasNextLine()) {                     //wczytywanie miast z pliku do tablicy
            String infoDlaMiasta = scanner.nextLine();
            tablicaMiast[i] = infoDlaMiasta;
            i++;
        }

        while (j<tablicaMiast.length) {                                          //wyswietla info pogodowe o miastach z pliku
            String city = null;
            try {
                city = tablicaMiast[j];
                WeatherApi api = new WeatherApi();
                int temperature = api.getTemperature(city);
                String description = api.getDescription(city);
                System.out.printf("Pogoda w mieście %s: %s\n", city, description);
                System.out.printf("Aktualna temperatura: %d stopni\n", temperature);
                System.out.println();
                j++;
            } catch (IOException e) {
                System.err.println("Nie udało się pobrać informacji dla miasta " + city);


            }
        }
    }
}
