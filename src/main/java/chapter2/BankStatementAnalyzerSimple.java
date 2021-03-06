package main.java.chapter2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Example 2.1
 * Answers the query: What is the total profit and loss from a list of bank statements? Is it
 * positive or negative?
 */
public class BankStatementAnalyzerSimple {

    private static final String RESOURCES = "src/main/resources/";

    public static void main(final String[] args) throws Exception {
        final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
        final List<String> lines = Files.readAllLines(path);
        double total = 0;
        for (final String line: lines) {
            String[] columns = line.split(",");
            double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);
    }

    /*
    * This approach starts with the KISS principle.
    * Considerations:
    * What if the file is empty?
    * What if parsing the amount fails because the data was corrupted?
    * What if a statement line has missing data?
    */
}
