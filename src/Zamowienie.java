package src;

public class Zamowienie {
    private int id;
    private Klient klient;
    private Produkt[] produkty;
    private int[] ilosci;
    private String dataZamowienia;
    private String status;
    private double wartosc;


    public Zamowienie() {
        this.id = id;
        this.klient = klient;
        this.produkty = produkty;
        this.ilosci = ilosci;
        this.dataZamowienia = dataZamowienia;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public Produkt[] getProdukty() {
        return produkty;
    }

    public void setProdukty(Produkt[] produkty) {
        this.produkty = produkty;
    }

    public int[] getIlosci() {
        return ilosci;
    }

    public void setIlosci(int[] ilosci) {
        this.ilosci = ilosci;
    }

    public String getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(String dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getWartosc() {
        return wartosc;
    }

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }

    public void obliczWartoscZamowienia() {
        for (int x = 0; x < produkty.length; x++) {
            if (produkty[x] != null) {
                wartosc += produkty[x].getCena() * ilosci[x];
            }
        }
    }

    public void zastosujZnizke() {
        if (klient.isCzyStaly()) {
            wartosc *= 0.9;
        }
    }

    public void wyswietlSzczegoly() {
        int ile = 0;
        for (int x = 0; x < ilosci.length; x++) {
            ile += ilosci[x];
        }
        System.out.println("Szczegóły zamówienia:");
        System.out.println("ID zamówienia: " + id);
        System.out.println("Klient: " + klient.getImie() + " " + klient.getNazwisko());
        System.out.println("Data zamówienia: " + dataZamowienia);
        System.out.println("Status: " + status);
        System.out.println("Produkty:" + produkty.length);
        System.out.println("Ilość: " + ile);
        System.out.println("Wartość: " + wartosc);
    }
}

