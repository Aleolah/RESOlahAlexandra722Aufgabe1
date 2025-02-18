import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Aufgabe1 aufgabe1 = new Aufgabe1();
        List<Marvel> list = new ArrayList<Marvel>();
        list =  aufgabe1.readFileTsv();

        System.out.println("Pick a value: ");
        Scanner scanner = new Scanner(System.in);
        double value = scanner.nextDouble();
        aufgabe1.filterByGlobal(value,list);

        System.out.println("Galaktischen:");
        aufgabe1.sortGalaktish(list);

        aufgabe1.groupTotalKonfuntationen(list);



    }
}