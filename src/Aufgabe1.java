import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
            double global = Double.parseDouble(values[6].replace("\"", ""));

            all.add(new Marvel(id, held,antagonist,Konfrontationstyp.valueOf(typ), ort,time ,  global));

        }

        reader.close();
        return all;


    }

    public void filterByGlobal(double global, List<Marvel> list) {
        list.stream().filter(entry -> entry.getGlobalerEinfluss() > global).map(Marvel::getHeld).distinct().forEach(System.out::println);

    }

    public void sortGalaktish(List<Marvel> list) {
        list.stream().filter(entry -> entry.getTyp() == Konfrontationstyp.Galaktisch).sorted((p1, p2) -> p2.getDatum().compareTo(p1.getDatum())).forEach(entry -> System.out.println(entry.getDatum() + " : " + entry.getHeld() + " vs. " + entry.getAntagonist() + " - " + entry.getOrt()));

    }

    public void groupTotalKonfuntationen(List<Marvel> list) {

        Map<Konfrontationstyp, Long> countMap = list.stream()
                .collect(Collectors.groupingBy(Marvel::getTyp, Collectors.counting()));

        List<Map.Entry<Konfrontationstyp, Long>> sorted = new ArrayList<>(countMap.entrySet());

        sorted.sort((entry1, entry2) -> {
            int countCompare = entry2.getValue().compareTo(entry1.getValue()); // Absteigende Reihenfolge der Fallanzahl
            if (countCompare != 0) {
                return countCompare;
            } else {
                return entry1.getKey().compareTo(entry2.getKey());
            }
        });


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("bericht_konfrontationen.txt"))) {
            for (Map.Entry<Konfrontationstyp, Long> entry : sorted) {
                writer.write(entry.getKey() + "&" + entry.getValue() +"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
