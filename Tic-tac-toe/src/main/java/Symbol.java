import java.util.Scanner;

public class Symbol {
    private int choice;
    private int color;
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public int makeChoice(int ch)
    {
        switch (ch)
        {
            case 1:
                System.out.println((char)1);
                break;
            case 2:
                System.out.println((char)2);
                break;
            case 3:
                System.out.println((char)3);
                break;
            case 4:
                System.out.println((char)4);
                break;
            case 5:
                System.out.println((char)5);
                break;
            case 6:
                System.out.println((char)6);
                break;
            case 7:
                System.out.println((char)13);
                break;
            case 8:
                System.out.println((char)15);
                break;
        }
        return (char)ch;
    }
    public int choose()
    {
        Scanner in=new Scanner(System.in);
        choice=in.nextInt();
        return choice;
    }
    public int getColor(int col)
    {
        int ch=(char)(makeChoice(choice));
        switch (col)
        {
            case 1:
                System.out.println(ch+ANSI_BLUE);
                break;
            case 2:
                System.out.println(ch+ANSI_YELLOW);
                break;
            case 3:
                System.out.println(ch+ANSI_GREEN);

        }
        return col;
    }
    public int colorSet()
    {
        System.out.println("What color would you like for your game: 1-blue, 2-yellow,3-green");
        Scanner in=new Scanner(System.in);
        color=in.nextInt();
        return color;
    }

    public int getChoice() {
        return choice;
    }

    public int getColor() {
        return color;
    }
}
