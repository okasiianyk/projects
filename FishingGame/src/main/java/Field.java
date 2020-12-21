import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Field {
    Game game;
    private Stack<Fish>fish[];
    ArrayList<Fish> listOfFish;

    public Field(Game game) {
        this.game = game;
            }

    private void initializeFish() {
        this.fish = game.getFish();
        Stack<Fish>[] temp = new Stack[6];
        for (int i = 0; i < 6; i++) {
            temp[i] = (Stack<Fish>) fish[i].clone();
        }
        reverseFish(temp);
    }
    private void reverseFish(Stack<Fish>[]temp) {
        listOfFish = new ArrayList<>();
        int max = maxSizeStack();


        for (int j = 0; j < 6; j++) {
            while (temp[j].size() != max) {
                temp[j].add(temp[j].size(), new EmptyFish());
            }
            Collections.reverse(temp[j]);
        }

        for(int i=max;i>0;i--){
            for (int j = 0; j < 6; j++) {
                listOfFish.add(temp[j].pop());
            }
        }
    }


    private int maxSizeStack(){
        int max=fish[0].size();
        for(int i=0;i<6;i++){
            if(max<fish[i].size()){
                max=fish[i].size();
            }
        }
        return max;
    }



    public void getDisplay() {
        initializeFish();
        int number =0;
        for (int i = 0; i < 6; i++) {
            System.out.print("|");
            for (int j = 1; j <=6; j++) {
                if(i==0) {
                    System.out.print(j + "|");
                }else {
                    number++;
                    System.out.print(this.getFish(number) + "|");
                }

            }
            System.out.print('\n');
        }
    }

    public String getFish(int num){

        if(listOfFish.size()<num){
            return " ";
        }else{
            if(listOfFish.get(num-1)==null){
                return "n";
            }else {
                return listOfFish.get(num - 1).display();
            }
        }
    }



    public int playerChoice(){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the column: ");
        int column=in.nextInt();
        return column;
    }
    public boolean continuePlay(){
        Scanner in=new Scanner(System.in);
        System.out.println("If you would like to stop push 0");
        int choice=in.nextInt();
        if(choice!=0){
           // playerChoice();
            return true;
        }else{
            return false;
        }

    }
    public boolean check(){
        int temp=playerChoice();
        if(temp>1 &&temp<6){
            return true;
        }else{
            return false;
        }
    }
    /*public void move(){
        for(int i=0;i<6;i++){
            for(int j=1;j<=6;j++){
                if(j==2 && )
            }
        }
    }*/



}
