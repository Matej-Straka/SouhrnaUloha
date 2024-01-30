public class Deskovka {
    private String nazev;
    private boolean koupena;
    private int oblibenost;

    public Deskovka(String nazev, boolean koupena, int oblibenost) {
        this.nazev = nazev;
        this.koupena = koupena;
        this.oblibenost = oblibenost;
    }
    //kostruktor s jedním parametrem názvem
    public Deskovka(String nazev){
        this.nazev = nazev;
        this.koupena = false;
        this.oblibenost = 0;
    }
    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public boolean isKoupena() {
        return koupena;
    }

    public void setKoupena(boolean koupena) {
        this.koupena = koupena;
    }

    public int getOblibenost() {
        return oblibenost;
    }

    public void setOblibenost(int oblibenost) {
        this.oblibenost = oblibenost;
    }
}
