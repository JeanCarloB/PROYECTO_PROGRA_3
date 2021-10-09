package presentation.lending;

import logic.Prestamo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModel extends AbstractTableModel {
    private List<Prestamo> filas;
    private String[] nombCol = {"MONTO","TAZA DE INTERES","PLAZO"};


    public TableModel(List<Prestamo> filas) {
        this.filas =filas;
    }

    @Override
    public int getRowCount() {
        return filas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prestamo prestamo = filas.get(rowIndex);
        switch (columnIndex){
            case 0: return prestamo.getMonto();
            case 1: return prestamo.getTasaInteres();
            case 2: return prestamo.getPlazo();
            default: return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return nombCol[column];
    }

    public Prestamo getRowAT(int n){
        return filas.get(n);
    }
}
