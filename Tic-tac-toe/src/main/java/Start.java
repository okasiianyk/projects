public class Start {
    public static void main(String[] args) {
        System.out.println("Welcome to the game");
        Game gm = new Game();
        gm.pickColorOfField();
        gm.display();
        gm.generalPlayer();
        gm.generalComp();
        gm.play();
        gm.win_check();
    }
}
