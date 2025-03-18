import models.Table;
import models.Cell;

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
        }
    }