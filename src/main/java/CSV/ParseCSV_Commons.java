package CSV;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParseCSV_Commons {
    public static void main(String[] args) {
        String csvFile = "insecte_commons.csv";

        try (
                Reader reader = Files.newBufferedReader(Paths.get(csvFile));
                CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())
        ) {
            for (CSVRecord record : parser) {
                System.out.println(
                        record.get("Habitat") + " | " +
                                record.get("Insectă 1") + " | " +
                                record.get("Insectă 2") + " | " +
                                record.get("Insectă 3")
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
