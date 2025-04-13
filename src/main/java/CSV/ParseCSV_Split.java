package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParseCSV_Split {
    public static void main(String[] args) {
        String csvFile = "insecte_opencsv.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String val : values) {
                    System.out.print(val.trim() + " | ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

