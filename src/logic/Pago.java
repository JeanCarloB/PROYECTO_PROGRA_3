package logic;

import java.util.Date;

public class Pago {

    private Date fecha;
    private double saldo;
    private int numeroCuota;
    private double interes;
    private double amortizacion;

    public Pago(Date fecha, double saldo, int numeroCuota, double interes, double amortizacion) {
        this.fecha = fecha;
        this.saldo = saldo;
        this.numeroCuota = numeroCuota;
        this.interes = interes;
        this.amortizacion = amortizacion;
    }

    public Pago() {
        this.fecha=new Date();
        this.saldo=0;
        this.numeroCuota = 0;
        this.interes=0;
        this.amortizacion=0;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = (saldo-interes);
    }

    public double getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(double amortizacion) {
        this.amortizacion = (amortizacion-this.interes);
    }

    public double saldoActualizado()
    {
        return (saldo - amortizacion);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "fecha=" + fecha.toString() +
                ", saldo=" + saldo +
                ", numeroCuota=" + numeroCuota +
                ", interes=" + interes +
                ", amortizacion=" + amortizacion +
                '}';
    }
}
