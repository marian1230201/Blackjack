import java.util.ArrayList;
import java.util.Random;

public class Koloda {
    ArrayList<Card> koloda = new ArrayList<>();

    public Koloda(int kiekis)
    {
        for (int i = 0; i < kiekis; i++) {
            for (Simbolis cardSimbolis : Simbolis.values()) {
                for (Skaicius cardSkaicius : Skaicius.values()) {
                    koloda.add(new Card(cardSimbolis, cardSkaicius));
                }
            }
        }
    }
    public void KortuMaisymas()
    {
        ArrayList<Card> tempKoloda = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = koloda.size();
        for (int i = 0; i < originalSize; i++)
        {
            randomCardIndex = random.nextInt((koloda.size() - 1 - 0) + 1) + 0;
            tempKoloda.add(koloda.get(randomCardIndex));
            koloda.remove(randomCardIndex);
        }
        this.koloda = tempKoloda;
    }
    public void IstrauktiKorta(Koloda KolodaIsMain)
    {
        this.koloda.add(KolodaIsMain.GautiKorta(0));
        KolodaIsMain.IstrintiKorta(0);
    }
    private Card GautiKorta(int kielintas){
        return this.koloda.get(kielintas);
    }
    private void IstrintiKorta(int kielintas){
        this.koloda.remove(kielintas);
    }

    public int size(){
        return this.koloda.size();
    }

    public String toString(){
        String list = "";
        int i = 0;
        for(Card aCard : this.koloda){
            list += "\n" + aCard.toString();
            i++;
        }
        return list;
    }

    public int KortuSuma()
    {
        int Suma = 0;
        int Tuzas = 0;
        for (Card a : koloda)
        {
            switch (a.getskaicius())
            {
                case DU:
                    Suma += 2;
                    break;
                case TRIS:
                    Suma += 3;
                    break;
                case KETURI:
                    Suma += 4;
                    break;
                case PENKI:
                    Suma += 5;
                    break;
                case SESI:
                    Suma += 6;
                    break;
                case SEPTYNI:
                    Suma += 7;
                    break;
                case ASTUONI:
                    Suma += 8;
                    break;
                case DEVYNI:
                    Suma += 9;
                    break;
                case DESIMT:
                    Suma += 10;
                    break;
                case VALIETAS:
                    Suma += 10;
                    break;
                case DAMA:
                    Suma += 10;
                    break;
                case KARALIUS:
                    Suma += 10;
                    break;
                case TUZAS:
                    Suma += 1;
                    break;
            }
        }
        for (int i = 0; i < Tuzas; i++)
        {
            if (Suma > 10)
            {
                Suma += 1;
            }
            else
            {
                Suma += 11;
            }
        }
        return Suma;
    }
}

