package logic;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*2.1. Los datos de cada préstamo incluyen el monto (M), tasa de interés (I) y plazo (P) del préstamo.
2.2. El cálculo de la cuota (C) se debe hacer por medio de la siguiente fórmula financiera: 𝐶 =
𝑀∗𝐼
1−(1+𝐼)−𝑝
.
2.3. Cada mes el cliente deberá pagar dicha cuota, de la cual una parte corresponde al monto de interés sobre el
saldo vigente y la otra a amortización. Dicha fórmula tiene la virtud de que al final del plazo el saldo quedará en
cero y el préstamo estará completamente pagado.
*/
public class Prestamo {
    private double monto;
    private double tasaInteres;
    private double plazo;

    public Prestamo(double monto, double tasaInteres, double plazo) {
        this.monto = monto;
        this.tasaInteres = tasaInteres;
        this.plazo = plazo;
    }

    public List<Pago> listaPagos() {
        double saldo = monto;

        List<Pago> lista = new ArrayList<>();
        for(int i = 1; i <= getPlazo(); i++) {
            Pago pago = new Pago(new Date(),saldo,i, getTasaInteres(), calculoCuota());
            lista.add(pago);
            saldo = pago.saldoActualizado();
        }
        return lista;
    }

    public Prestamo() {
        this.monto = 0;
        this.tasaInteres = 0;
        this.plazo = 0;
    }

    public List<Pago> listaPagos(double extra){
        double saldo=getMonto();
        double x=0;
        List<Pago> lista=new ArrayList<>();
        for(int i=0;i<getPlazo();i++){
            if(extra>calculoCuota()){
                x=extra-calculoCuota();
                saldo=monto-x;
                Pago pago=new Pago(new Date(),saldo,i,getTasaInteres(),calculoCuota());
                lista.add(pago);
                saldo=pago.saldoActualizado();
            }
        }
        return lista;
    }

    public double calculoCuota(){
        return (monto*tasaInteres)/(1-(Math.pow(1+tasaInteres, -plazo)));
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public double getPlazo() {
        return plazo;
    }

    public void setPlazo(double plazo) {
        this.plazo = plazo;
    }
}
