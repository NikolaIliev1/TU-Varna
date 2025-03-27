package parser;

import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static List<List<String>> parse(String content) {
        List<List<String>> table = new ArrayList<>();
        String[] rows = content.split("\n");

        for (String row : rows) {
            List<String> cells = List.of(row.split(","));
            table.add(cells);
        }

        return table;
    }
}
