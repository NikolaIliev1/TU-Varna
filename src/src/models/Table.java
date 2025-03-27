package models;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<List<Cell>> data;

    public Table (){
        data = new ArrayList<>();
    }

    public void addRow() {
        List<Cell> newRow = new ArrayList<>();
        int cols = getMaxColumns();
        for (int i = 0; i < cols; i++) {
            newRow.add(new Cell("")); // Празни клетки
        }
        data.add(newRow);
        System.out.println("New row added");
    }

    public void addColumn() {
        for (List<Cell> row : data) {
            row.add(new Cell(""));
        }
        System.out.println("New column added");
    }

    public void editCell(int row, int col, String value) {
        if (row >= 0 && row < data.size() && col >= 0 && col < data.get(row).size()) {
            data.get(row).get(col).setValue(value);
        } else {
            System.out.println("Invalid index");
        }
    }

    public void printTable(){
        if (data.isEmpty()) {
            System.out.println("Table is empty");
            return;
        }

        int[] columnWidths = getColumnWidths();

        for (List<Cell> row : data) {
            for (int col = 0; col < row.size(); col++) {
                String value = row.get(col).getValue();
                System.out.print(String.format("%-" + columnWidths[col] + "s | ", value));
            }
            System.out.println();
        }
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < data.size() && col >= 0 && col < data.get(row).size();
    }

    private int[] getColumnWidths() {
        int maxCols = getMaxColumns();
        int[] widths = new int[maxCols];

        for (List<Cell> row : data) {
            for (int col = 0; col < row.size(); col++) {
                widths[col] = Math.max(widths[col], row.get(col).getValue().length());
            }
        }
        return widths;
    }

    private int getMaxColumns() {
        int maxCols = 0;
        for (List<Cell> row : data) {
            maxCols = Math.max(maxCols, row.size());
        }
        return maxCols;
    }
}
