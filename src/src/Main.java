import models.Table;
import models.Cell;
import parser.CSVParser;

public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        table.printTable();
        table.editCell(0, 0, "New value");
        table.printTable();

        Cell cell = new Cell("Hello");
        System.out.println(cell.getValue());
        cell.setValue("World");
        System.out.println(cell.getValue());

        String content = "1,2,3\n4,5,6\n7,8,9";
        var parsedTable = CSVParser.parse(content);
        for (var row : parsedTable) {
            for (var cellValue : row) {
                System.out.print(cellValue + " | ");
            }
            System.out.println();
        }
    }
}