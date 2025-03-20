package src;

public class SklepKomputerowy {
    private Produkt[] produkty;
    private Klient[] klienci;
    private Zamowienie[] zamowienia;
    private int liczbaProduktow;
    private int liczbaKlientow;
    private int liczbaZamowien;

    public SklepKomputerowy() {
        produkty = new Produkt[100];
        klienci = new Klient[100];
        zamowienia = new Zamowienie[100];
        liczbaProduktow = 0;
        liczbaKlientow = 0;
        liczbaZamowien = 0;
    }

    // Metoda dodająca nowy produkt do sklepu
    public void dodajProdukt(Produkt produkt) {
        if (liczbaProduktow < produkty.length) {
            produkty[liczbaProduktow] = produkt;
            liczbaProduktow++;
        } else {
            System.out.println("Brak miejsca na nowe produkty.");
        }
    }

    // Metoda dodająca nowego klienta do sklepu
    public void dodajKlienta(Klient klient) {
        if (liczbaKlientow < klienci.length) {
            klienci[liczbaKlientow] = klient;
            liczbaKlientow++;
        } else {
            System.out.println("Brak miejsca na nowych klientów.");
        }
    }

    // Metoda tworząca nowe zamówienie
    public void utworzZamowienie(Klient klient, Produkt[] produkty, int[] ilosci) {
        if (liczbaZamowien < zamowienia.length) {
            Zamowienie noweZamowienie = new Zamowienie(liczbaZamowien + 1, klient, produkty, ilosci, "2025-03-20", "Nowe");
            zamowienia[liczbaZamowien] = noweZamowienie;
            liczbaZamowien++;
            aktualizujStanMagazynowy(noweZamowienie);
        } else {
            System.out.println("Brak miejsca na nowe zamówienia.");
        }
    }

    // Metoda aktualizująca stan magazynowy po złożeniu zamówienia
    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
        Produkt[] zamowioneProdukty = zamowienie.getProdukty();
        int[] ilosci = zamowienie.getIlosci();

        for (int i = 0; i < zamowioneProdukty.length; i++) {
            for (int j = 0; j < produkty.length; j++) {
                if (produkty[j] != null && produkty[j].equals(zamowioneProdukty[i])) {
                    produkty[j].zmniejszIlosc(ilosci[i]);
                    break;
                }
            }
        }
    }

    // Metoda zmieniająca status zamówienia
    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        for (int i = 0; i < liczbaZamowien; i++) {
            if (zamowienia[i].getId() == idZamowienia) {
                zamowienia[i].setStatus(nowyStatus);
                break;
            }
        }
    }

    // Metoda wyświetlająca produkty w określonej kategorii
    public void wyswietlProduktyWKategorii(String kategoria) {
        System.out.println("Produkty w kategorii " + kategoria + ":");
        for (int i = 0; i < liczbaProduktow; i++) {
            if (produkty[i] != null && produkty[i].getKategoria().equals(kategoria)) {
                System.out.println(produkty[i].getNazwa() + " - Cena: " + produkty[i].getCena());
            }
        }
    }

    // Metoda wyświetlająca wszystkie zamówienia danego klienta
    public void wyswietlZamowieniaKlienta(int idKlienta) {
        System.out.println("Zamówienia klienta o ID " + idKlienta + ":");
        for (int i = 0; i < liczbaZamowien; i++) {
            if (zamowienia[i].getKlient().getId() == idKlienta) {
                zamowienia[i].wyswietlSzczegoly();
            }
        }
    }

    // Klasa Klient
    class Klient {
        private int id;
        private String imie;
        private String nazwisko;
        private boolean staly;

        public Klient(int id, String imie, String nazwisko, boolean staly) {
            this.id = id;
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.staly = staly;
        }

        public int getId() {
            return id;
        }

        public String getImie() {
            return imie;
        }

        public String getNazwisko() {
            return nazwisko;
        }

        public boolean isStaly() {
            return staly;
        }
    }

    // Klasa Produkt
    class Produkt {
        private String nazwa;
        private double cena;
        private String kategoria;
        private int ilosc;

        public Produkt(String nazwa, double cena, String kategoria, int ilosc) {
            this.nazwa = nazwa;
            this.cena = cena;
            this.kategoria = kategoria;
            this.ilosc = ilosc;
        }

        public String getNazwa() {
            return nazwa;
        }

        public double getCena() {
            return cena;
        }

        public String getKategoria() {
            return kategoria;
        }

        public int getIlosc() {
            return ilosc;
        }

        public void zmniejszIlosc(int iloscSprzedana) {
            if (ilosc - iloscSprzedana >= 0) {
                ilosc -= iloscSprzedana;
            } else {
                System.out.println("Brak wystarczającej ilości produktu.");
            }
        }
    }

