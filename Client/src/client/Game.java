package client;

import java.util.Scanner;

public class Game {
    private int choice;
    private Client client;

    public Game() {
        this.choice = 1;
        this.client = new Client();
    }

    public void startGame() {
        System.out.println("Enter your drink choice: 1-tea, 2-coffee, 3-juice");
        Scanner in = new Scanner(System.in);
        this.choice = in.nextInt();
        compareDrink();
    }
    public void compareDrink()
    {
        if(client.getCurrentDrink()==choice)
        {
            System.out.println("Ok "+client.getCurrentDrink());
            client.wantDrink(true);
            System.out.println("Sum: "+client.getCost());
        }else
        {
            System.out.println("Wrong "+client.getCurrentDrink());
            client.wantDrink(false);
            System.out.println("Sum: "+client.getCost());
        }
    }
}
