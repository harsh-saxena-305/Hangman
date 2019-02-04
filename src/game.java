import java.util.Random;
import java.util.Scanner;
import java.lang.*;
public class game {

    static int k = 0,e=0;
    static int alp[] = new int[26];

    public void xyz(char a,String s,char s1[]) {
        int c = 0;

        if(a>=65 && a<=90)
            a = (char)(a + 32);

        if (alp[(int) a - 97] == 1) {
            e++;
            System.out.println("This character has been used" + " , " + "chances left: " + ((s.length() / 2) + 1 - e));
            k++;
        }
        else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == a) {
                    s1[i] = a;
                    c++;
                    alp[(int) a - 97] = 1;
                }
            }
            if (c > 0) {
                System.out.println("Good,you are close");
                for (int i = 0; i < s1.length; i++) {
                    System.out.print(s1[i]);

                }
                System.out.println();
            } else {
                e++;
                System.out.println("You are wrong" + " , " + "chances left: " + ((s.length() / 2) + 1 - e));
                k++;
            }

        }
    }
    enum season {FRUIT,ANIMAL,VEHICLE,ROAD,COLOUR}
    public static void main(String[] args) {

        char a;
        int p;
        String list[] = {"mango","lion","truck","mumbai","blue"};
        Random r = new Random();
        int ri = r.nextInt(5);
        String s = list[ri];
        char s1[]= new char[s.length()];

        System.out.println("It's a "+ season.values()[ri]);
        System.out.println("You have total "+ ((s.length() / 2) + 1) +" chances to attempt wrong or repeat the same characterl");
        for (int i = 0; i < s.length() ; i++) {
            s1[i] = '-';
            System.out.print(s1[i]);
        }
        System.out.println();

        Scanner x = new Scanner(System.in);
        game obj = new game();

        for (int i = 0; true ; i++) {
            a = x.next().charAt(0);

            obj.xyz(a,s,s1);

            String str = String.valueOf(s1);

            if(s.equalsIgnoreCase(str))
                break;
            if(k == (s.length()/2)+1)
                break;
        }
        if (k == (s.length()/2)+1)
            System.out.println("OH NO! YOU LOSE");
        else
            System.out.println("HURRY! YOU WIN");
    }
}