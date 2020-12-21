import java.util.Scanner;

public class Player {

    private int column, row;

    public void move() {
        System.out.println("Player's move");
        while(true) {
            try {
                System.out.println("Enter cell (row and column) with space. Example: '1 3'");

                Scanner keyboard = new Scanner(System.in);
                column = keyboard.nextInt();
                row = keyboard.nextInt();

                if(Game.getField()[row-1][column-1] == 0) {
                    Game.setField(row-1, column-1, 1);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error in input");
            }
        }
    }
}
