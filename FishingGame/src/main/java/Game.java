import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Game {
    private Stack<Fish>[]fishArr = new Stack[6];

    public Game() {
        for(int i=0;i<6;i++){
            fishArr[i]=new Stack<Fish>();
        }
        addFish();
    }

    public Stack<Fish>[] getFish() {
            return fishArr;
    }

    private void addFish(){
        for(int j=0;j<3;j++) {
            for (int i = 0; i < 6; i++) {
                Random random = new Random();
                int temp = random.nextInt(4);
                if (temp == 0) {
                    fishArr[i].add(new SmallFish());
                } else if (temp == 1) {
                    fishArr[i].add(new MidFish());
                } else if(temp==2) {
                    fishArr[i].add(new BigFish());
                }
            }
        }
    }

    private void addFishTest(){
        fishArr[0].add(new SmallFish());
        fishArr[0].add(new MidFish());

        fishArr[1].add(new SmallFish());
        fishArr[1].add(new MidFish());
        fishArr[1].add(new BigFish());

        fishArr[2].add(new BigFish());
        fishArr[2].add(new BigFish());
        fishArr[2].add(new BigFish());

        fishArr[3].add(new SmallFish());

        fishArr[4].add(new MidFish());

        fishArr[5].add(new BigFish());



    }
    public void moveFish(int take, int put) {
        Fish temp = fishArr[take - 1].pop();
        fishArr[put - 1].add(temp);
        System.out.println(temp.display());
    }

    public void startGame(){
        Field field=new Field(this);
        field.getDisplay();

        do{
            eat(field.playerChoice(),field.playerChoice());
        field.getDisplay();
        }while(true);
        //}while(field.continuePlay());

    }
    public void eat(int take,int put){
        if (fishArr[take-1].empty()) {
            return;
        }

        moveFish(take,put);
        take--;
        put--;

        Fish f1=fishArr[put].pop();//s
        if (fishArr[put].empty()) {
            fishArr[put].add(f1);
            return;
        }
        Fish f2=fishArr[put].peek();//m
        if(f1 instanceof SmallFish && f2 instanceof MidFish){
            fishArr[put].peek().changeSign();
            explosion(f2.count(f1,f2),put);
        }else if(f2 instanceof BigFish && f1 instanceof MidFish){
            fishArr[put].peek().changeSign();
            explosion(f2.count(f1,f2),put);
        }else {
            fishArr[put].add(f1);
        }

    }
    public void explosion(boolean answer,int put){
        if(answer==true){
            fishArr[put].pop();
        }

    }
}
