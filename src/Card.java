public class Card {

    private Simbolis simbolis;
    private Skaicius skaicius;

    public Card(Simbolis simbolis, Skaicius skaicius)
    {
        this.simbolis = simbolis;
        this.skaicius = skaicius;
    }

    public String toString()
    {
        return this.simbolis.toString() + "_" + this.skaicius.toString();
    }

    public Skaicius getskaicius()
    {
        return this.skaicius;
    }
}
