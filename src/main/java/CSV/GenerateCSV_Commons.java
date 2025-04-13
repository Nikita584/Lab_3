package CSV;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GenerateCSV_Commons {
    public static void main(String[] args) {
        String csvFile = "insecte_commons.csv";

        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(csvFile));
                CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("Habitat", "Insectă 1", "Insectă 2", "Insectă 3"))
        ) {
            printer.printRecord("Tropical", "Fluture Morpho", "Gândac rinocer", "Țânțar tigru");
            printer.printRecord("Temperat", "Greiere de câmp", "Libelulă comună", "Gândac de scoarță");
            printer.printRecord("Desertic", "Furnica de foc", "Călugăriță de nisip", "Lăcustă de deșert");
            printer.printRecord("Tundră", "Păduche de mușchi", "Țânțar rezistent", "Moliă de tundră");
            printer.printRecord("Acvatic", "Nimfă de libelulă", "Gândac acvatic mic", "Țânțar subacvatic");

            System.out.println("Fișierul nou CSV a fost creat cu Apache Commons CSV.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

