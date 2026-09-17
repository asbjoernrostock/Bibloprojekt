public class Member {

    final String navn;
    final int medlemsNummer;

    public Member(String navn, int medlemsNummer) {
        this.navn = navn;
        this.medlemsNummer = medlemsNummer;
    }

    public String toString() {
        return navn + " " + "(Lånenummer: " + medlemsNummer + ")";
    }

    public int getMedlemsNummer() {
        return medlemsNummer;
    }

}
