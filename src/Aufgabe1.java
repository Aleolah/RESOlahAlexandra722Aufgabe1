import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Aufgabe1 {
    public List<Marvel> readFileTsv() throws IOException {

        String filePath = "evenimente.tsv";

        List<Marvel> all = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        boolean isFirstLine = true;

        while ((line = reader.readLine()) != null) {
            if (isFirstLine) {
                // Sarim peste prima linie (header)
                isFirstLine = false;
                continue;
            }

            String[] values = line.split("\t");


            int id = Integer.parseInt(values[0].replace("\"", "")); //"\t"
            String held = values[1].replace("\"", "");
            String antagonist = values[2].replace("\"", "");
            String typ = values[3].replace("\"", "");
            String ort =values[4].replace("\"", "");
            LocalDate time = LocalDate.parse(values[5].replace("\"", ""));
            double global = Double.parseDouble(values[5].replace("\"", ""));

            all.add(new Marvel(id, held,antagonist,Konfrontationstyp.valueOf(typ), ort,time ,  global));

        }

        reader.close();
        return all;


    }

}
