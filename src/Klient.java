package src;

public class Klient {
    private int id;
    private String imie;
    private String nazwisko;
    private String email;
    private boolean czyStaly;

    public Klient(int id, String imie, String nazwisko, String email, boolean czyStaly) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.czyStaly = czyStaly;
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

    public String getEmail() {
        return email;
    }

    public boolean isCzyStaly() {
        return czyStaly;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCzyStaly(boolean czyStaly) {
        this.czyStaly = czyStaly;
    }

    public void wyswietlInformacje() {
        System.out.println("ID Klienta: " + id);
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Email: " + email);
        System.out.println("Czy stały klient: " + (czyStaly ? "Tak" : "Nie"));
    }

    public boolean isStaly() {
    }

    public class Main {
        public static void main(String[] args) {
            Klient klient = new Klient(1, "Jan", "Kowalski", "jan.kowalski@example.com", true);
            klient.wyswietlInformacje();
        }
    }
}