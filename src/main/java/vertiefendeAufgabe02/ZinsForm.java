package vertiefendeAufgabe02;

import jakarta.validation.constraints.Min;

public class ZinsForm {
    @Min(value = 0, message = "Anfangskapital muss positiv sein")
    private double anfangskapital = 0;

    @Min(value = 0, message = "Laufzeit muss positiv sein")
    private int laufzeit = 0;

    @Min(value = 0, message = "Zinssatz kann nicht negativ sein")
    private double zinssatz = 0;

    public boolean tabelleAnzeigen = true;

    public double getAnfangskapital() {
        return anfangskapital;
    }

    public int getLaufzeit() {
        return laufzeit;
    }

    public double getZinssatz() {
        return zinssatz;
    }

    public boolean isTabelleAnzeigen() {
        return tabelleAnzeigen;
    }

    public void setAnfangskapital(double anfangskapital) {
        this.anfangskapital = anfangskapital;
    }

    public void setLaufzeit(int laufzeit) {
        this.laufzeit = laufzeit;
    }

    public void setZinssatz(double zinssatz) {
        this.zinssatz = zinssatz;
    }

    public void setTabelleAnzeigen(boolean tabelleAnzeigen) {
        this.tabelleAnzeigen = tabelleAnzeigen;
    }

}
