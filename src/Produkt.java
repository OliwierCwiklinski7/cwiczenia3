package src;

public class Produkt {
    private int id;
    private String nazwa;
    private String kategoria;
    private double cena;
    public int iloscWMagazynie;
    public Produkt() {
        this.id = id;
        this.nazwa = nazwa;
        this.kategoria = kategoria;
        this.cena = cena;
        this.iloscWMagazynie = iloscWMagazynie;
    }

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getKategoria() {
        return kategoria;
    }

    public double getCena() {
        return cena;
    }

    public int getIloscWMagazynie() {
        return iloscWMagazynie;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setIloscWMagazynie(int iloscWMagazynie) {
        this.iloscWMagazynie = iloscWMagazynie;
    }


    public void wyswietlInformacje() {
        System.out.println("ID: " + id);
        System.out.println("Nazwa: " + nazwa);
        System.out.println("Kategoria: " + kategoria);
        System.out.println("Cena: " + cena + " PLN");
        System.out.println("Ilość w magazynie: " + iloscWMagazynie);
    }

    public static void main(String[] args) {
        Produkt laptop = new Produkt();
        laptop.wyswietlInformacje();
    }
}


