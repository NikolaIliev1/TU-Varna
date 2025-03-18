package models;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<List<Cell>> data;

    public Table (){
        data = new ArrayList<>();
    }

    public void printTable(){
        for (List<Cell> row : data) {
            for (Cell cell : row) {
                System.out.print(cell.getValue() + " | ");
            }
            System.out.println();
        }
    }

    public void editCell(int row, int col, String value) {
        if (row >= 0 && row < data.size() && col >= 0 && col < data.get(row).size()) {
            data.get(row).get(col).setValue(value);
        } else {
            System.out.println("Invalid index");
        }
    }
}
