import java.time.LocalDate;

public class Marvel {
    private int id;
    private String held;
    private String antagonist;
    private Konfrontationstyp typ;
    private String ort;
    private LocalDate datum;
    private double globalerEinfluss;

    public Marvel(int id, String held, String antagonist, Konfrontationstyp typ, String ort, LocalDate datum, double globalerEinfluss) {
        this.id = id;
        this.held = held;
        this.antagonist = antagonist;
        this.typ = typ;
        this.ort = ort;
        this.datum = datum;
        this.globalerEinfluss = globalerEinfluss;
    }

    @Override
    public String toString() {
        return "Marvel{" +
                "id=" + id +
                ", held='" + held + '\'' +
                ", antagonist='" + antagonist + '\'' +
                ", typ=" + typ +
                ", ort='" + ort + '\'' +
                ", datum=" + datum +
                ", globalerEinfluss=" + globalerEinfluss +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getHeld() {
        return held;
    }

    public String getAntagonist() {
        return antagonist;
    }

    public Konfrontationstyp getTyp() {
        return typ;
    }

    public String getOrt() {
        return ort;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public double getGlobalerEinfluss() {
        return globalerEinfluss;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeld(String held) {
        this.held = held;
    }

    public void setAntagonist(String antagonist) {
        this.antagonist = antagonist;
    }

    public void setTyp(Konfrontationstyp typ) {
        this.typ = typ;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setGlobalerEinfluss(double globalerEinfluss) {
        this.globalerEinfluss = globalerEinfluss;
    }
}
