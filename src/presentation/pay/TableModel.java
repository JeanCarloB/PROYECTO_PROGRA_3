package presentation.pay;

import logic.Pago;

import javax.swing.table.AbstractTableModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TableModel extends AbstractTableModel {
    private List<Pago> filas;
    String[] nombCols ={"MENSUALIDAD","SALDO","INTERES","AMORTIZACION" };

    public TableModel(List<Pago> filas) {
        this.filas =new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return filas.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pago pago = filas.get(rowIndex);
        DecimalFormat decimalFormat=new DecimalFormat("####");
        switch (columnIndex){
            case 0: return decimalFormat.format(pago.getNumeroCuota());
            case 1: return decimalFormat.format(pago.getSaldo());
            case 2: return decimalFormat.format(pago.getInteres());
            case 3: return decimalFormat.format(pago.getAmortizacion());
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return nombCols[column];
    }

    public Pago getRowAT(int n){
        return filas.get(n);
    }
}
