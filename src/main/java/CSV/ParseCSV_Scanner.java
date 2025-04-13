package CSV;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ParseCSV_Scanner {
    public static void main(String[] args) {
        String csvFile = "insecte_opencsv.csv";

        try (Scanner scanner = new Scanner(new File(csvFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");
                while (lineScanner.hasNext()) {
                    System.out.print(lineScanner.next().trim() + " | ");
                }
                System.out.println();
                lineScanner.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
