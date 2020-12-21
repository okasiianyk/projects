import java.lang.reflect.Field;
import java.util.Scanner;

public class Game {

    //FIELD
    private static int[][] field = new int[3][3];
    private static boolean Computer_win = false;
    private static boolean Player_win = false;
    private Game game ;
    private Player player;
    private Computer computer;
    private Symbol symbol;
    private int backgroundColor;
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static int[][] getField() {
        return field;
    }
    public static void setField(int row, int column, int n) {
        field[row][column] = n;
    }
    public int pickColorOfField()
    {
        System.out.println("What background color would you like for your game: 1-yellow, 2-blue, 3-red");
        Scanner in=new Scanner(System.in);
        backgroundColor=in.nextInt();
        switch (backgroundColor)
        {
            case 1:
                System.out.println(ANSI_YELLOW);
                break;
            case 2:
                System.out.println(ANSI_BLUE);
                break;
            case 3:
                System.out.println(ANSI_RED);
                break;
        }
        return backgroundColor;
    }
    public void generalPlayer()
    {
        symbol=new Symbol();
        System.out.println("What symbol will represent you in the game: 1(☺), 2(☻), 3(♥), 4(♦), 5(♣), 6(♠), 7(♪), 8(☼)");
        symbol.makeChoice(symbol.choose());
        symbol.getColor(symbol.colorSet());
    }
    private int choose()
    {
        int choice;
        choice=(int)(Math.random()*8+1);
        return choice;
    }
    private int color()
    {
        int choice;
        choice=(int)(Math.random()*3+1);
        return choice;
    }
    public void generalComp()
    {
        System.out.println("Computer choice ");
        symbol.makeChoice(choose());
        symbol.getColor(color());
    }
    public void display() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < 3; j++) {
                if(field[j][i] == 1) {
                    System.out.print("O ");
                } else if(field[j][i] == 0){
                    System.out.print("_ ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public void play() {
        game = new Game();
        player = new Player();
        computer = new Computer();
        while (true) {
            player.move();

            if (win_check()) {
                break;
            };
            computer.move();
            if (win_check()) {
                break;
            };
            game.display();
        }
        if (Player_win)
        {
            System.out.println("Player won the game");
        }
        else if(Computer_win)
        {
            System.out.println("Computer won the game");
        } else {
            System.out.println("Draw. No one won the game");
        }
    }

    public boolean win_check() {
        int sum_hor, sum_ver, sum_dia1 = 0, sum_dia2 = 0, sum_all;
        for (int i = 0; i < 3; i++) {
            sum_hor = 0;
            sum_ver = 0;

            for (int j = 0; j < 3; j++) {
                sum_hor += field[j][i];
                sum_ver += field[i][j];
            }
            if (sum_hor == 3 || sum_ver == 3) {
                Player_win = true;
                return true;
            }
            if (sum_hor == -3 || sum_ver == -3) {
                Computer_win = true;
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            sum_dia1 += field[i][i];
            sum_dia2 += field[2-i][i];
        }
        if (sum_dia1 == 3 || sum_dia2 == 3) {
            Player_win = true;
            return true;
        }
        if (sum_dia1 == -3 || sum_dia2 == -3) {
            Computer_win = true;
            return true;
        }

        sum_all = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] != 0) {
                    sum_all += 1;
                }
            }
        }
        if (sum_all == 9) {
            return true;
        }
        return false;
    }
}
