package CSV;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class GenerateCSV_OpenCSV {
    public static void main(String[] args) {
        String csvFile = "insecte_opencsv.csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            String[] header = {"Habitat", "Insectă 1", "Insectă 2", "Insectă 3"};
            writer.writeNext(header);

            writer.writeNext(new String[]{"Tropical", "Cicada tropicală", "Gândacul frunzelor", "Lăcustă uriașă"});
            writer.writeNext(new String[]{"Temperat", "Furnica roșie", "Albina europeană", "Țânțar comun"});
            writer.writeNext(new String[]{"Desertic", "Scarabeu sacru", "Gândac zburător", "Furnica argintie"});
            writer.writeNext(new String[]{"Tundră", "Țânțar arctic", "Muscă polara", "Păduche polar"});
            writer.writeNext(new String[]{"Acvatic", "Gândac scafandru", "Țânțar de apă", "Corixă"});

            System.out.println("Fișierul CSV a fost creat cu OpenCSV.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

