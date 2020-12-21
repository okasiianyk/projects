abstract class Fish implements Color{
    protected char sign;
    abstract String display();
    abstract void changeSign();
    public boolean count(Fish f1,Fish f2){
        int count2=f1.count+f2.count;
        if(count2>=2){
            return true;
        }else return false;
    }
    int count=0;
}
class SmallFish extends Fish {
    public SmallFish() {
        sign = 's';
    }

    public String display() {
        return Color.ANSI_TEXT_BLUE + sign + Color.ANSI_RESET_GRAY;
    }

    public void changeSign() {
        sign = 's';
    }
}
class MidFish extends Fish{
    public MidFish(){
        sign='m';
        count=0;
    }
    public String display(){
        return (Color.ANSI_TEXT_DARK_GREEN+sign+Color.ANSI_RESET_GRAY);
    }
    public void changeSign(){
        sign='M';count++;
    }

}
class BigFish extends Fish {
    public BigFish() {
        sign = 'b';
        count=1;
    }

    public String display() {
        return Color.ANSI_TEXT_DARK_RED + sign + Color.ANSI_RESET_GRAY;

    }
    public void changeSign(){
        sign='B';
        count++;
    }
}
class EmptyFish extends Fish{
    public EmptyFish() {
        sign = ' ';
    }

    public String display() {
        return Color.ANSI_TEXT_DARK_YELLOW + sign + Color.ANSI_RESET_GRAY;

    }
    public void changeSign(){
        sign='E';
    }
}
