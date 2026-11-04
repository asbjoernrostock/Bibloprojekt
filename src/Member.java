public record Member (String navn, int medlemsNummer) implements Comparable<Member> {

    @Override
    public int compareTo(Member other) {
        return Integer.compare(this.medlemsNummer, other.medlemsNummer);
    }

    @Override
    public String toString() {
        return navn + " (Lånenummer: " + medlemsNummer + ")";
    }

}
