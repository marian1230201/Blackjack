import java.util.Scanner;

public class Blackjack {

    public static void main(String[] args)
    {
        int Zaidejo_pinigai = 1000;

        Scanner sc = new Scanner(System.in);
        while (Zaidejo_pinigai > 0)
        {
            System.out.println("Jus turite " + Zaidejo_pinigai + " Eur, kiek norite duoti pradiniai normai?");
            Boolean ArUztenkaPiniguStavka = true;
            int Stavka = 0;
            while(ArUztenkaPiniguStavka)
            {
                Stavka = sc.nextInt();
                if (Stavka > Zaidejo_pinigai)
                {
                    System.out.println("Neuztenka pinigu.");
                }
                else
                {
                    ArUztenkaPiniguStavka = false;
                }
            }
            Koloda koloda = new Koloda(2);
            koloda.KortuMaisymas();
            Koloda Zaidejo_kortos = new Koloda(0);
            Koloda Dilerio_kortos = new Koloda(0);

            Zaidejo_kortos.IstrauktiKorta(koloda);
            Zaidejo_kortos.IstrauktiKorta(koloda);

            Dilerio_kortos.IstrauktiKorta(koloda);
            Dilerio_kortos.IstrauktiKorta(koloda);

            Boolean roundas = false;
            while (true)
            {
                System.out.println("Spauskite 1 jeigu norite gauti dar viena korta ar 2 jeigu norite baigti.");
                int a = sc.nextInt();
                if (a == 1)
                {
                    Zaidejo_kortos.IstrauktiKorta(koloda);
                    System.out.println("Jus gavote korta.");
                    System.out.println("Jusu kortos yra " + Zaidejo_kortos.toString());
                    System.out.println("Jusu kortu suma yra - " + Zaidejo_kortos.KortuSuma());
                    if(Zaidejo_kortos.KortuSuma() > 21)
                    {
                        System.out.println("Jusu kortu suma daugiau uz 21 - " + Zaidejo_kortos.KortuSuma());
                        Zaidejo_pinigai -= Stavka;
                        roundas = true;
                        break;
                    }
                }
                if (a == 2)
                {
                    break;
                }
            }
            if(roundas == false)
            {
                System.out.println("Jusu kortos yra " + Zaidejo_kortos.toString());
                System.out.println("Dilerio kortos yra " + Dilerio_kortos.toString());
            }
            if((Dilerio_kortos.KortuSuma() > Zaidejo_kortos.KortuSuma()) && roundas == false)
            {
                System.out.println("Dilerio kortu suma - " + Dilerio_kortos.KortuSuma() + ", daugiau uz jusu - " + Zaidejo_kortos.KortuSuma());
                Zaidejo_pinigai -= Stavka;
                roundas = true;
            }
            if(Dilerio_kortos.KortuSuma() == 21 && Zaidejo_kortos.KortuSuma() != 21 && roundas == false)
            {
                System.out.println("Dileris laimejo. :(");
                Zaidejo_pinigai -= Stavka;
            }
            while ((Dilerio_kortos.KortuSuma() < 17) && roundas == false)
            {
                Dilerio_kortos.IstrauktiKorta(koloda);
                System.out.println("Dileris gavo korta - " + Dilerio_kortos.GautiKorta(Dilerio_kortos.size() - 1).toString());
                System.out.println("Dilerio kortos yra " + Dilerio_kortos.toString());
            }
            if((Dilerio_kortos.KortuSuma()>21)&& roundas == false)
            {
                System.out.println("Dileris pralaimejo!");
                Zaidejo_pinigai += Stavka;
                roundas = true;
            }
            if((Dilerio_kortos.KortuSuma() == Zaidejo_kortos.KortuSuma()) && roundas == false)
            {
                System.out.println("Jusu ir dilierio kortu suma vienoda!");
                roundas = true;
            }
            if((Zaidejo_kortos.KortuSuma() > Dilerio_kortos.KortuSuma()) && roundas == false)
            {
                System.out.println("Jus laimejote!!!");
                Zaidejo_pinigai += Stavka;
                roundas = true;
            }
            else if(roundas == false)
            {
                System.out.println("Dileris laimejo! :(");
                Zaidejo_pinigai -= Stavka;
            }
            System.out.println("Roundas prasideta is naujo!");
        }
        System.out.println("Jus pralaimejote visus savo pinigus. :(");
        sc.close();
    }
}
