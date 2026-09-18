public record Member (String navn, int medlemsNummer) {

    @Override
    public String toString() {
        return navn + " (Lånenummer: " + medlemsNummer + ")";
    }

}
