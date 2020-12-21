package client;

public class Client {
    private int mood;
    private String name;
    private Drink drink;
    private int currentDrink;
    protected double cost;
    public Client()
    {
        this.name="John";
        this.mood=1;
        this.drink=new Drink();
        this.currentDrink=this.drink.getDrink();
        this.cost=0;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getCurrentDrink() {
        return currentDrink;
    }

    public double getCost() {
        setSum();
        return cost;
    }

    private void setSum()
    {
       this.cost=finalCost()+this.cost;
    }

    private double finalCost()
    {

        if(mood>=2)
        {
            happyClient h=createHappyClient();
            mood=h.getMood();
            return h.getCost();
        }else if(mood==1)
        {
            neutralClient h=createNeutralClient();
            mood=h.getMood();
            return h.getCost();
        }else
        {
            sadClient h=createSadClient();
            mood=h.getMood();
            return h.getCost();
        }
    }

    private happyClient createHappyClient()
    {
        return new happyClient(this,"John");
    }
    private neutralClient createNeutralClient() {
        return new neutralClient(this, "John");
    }
    private sadClient createSadClient()
    {
        return new sadClient(this,"John");
    }

    protected int getMood() {
        return mood;
    }

    protected void setMood(int mood) {
        this.mood = mood;
    }

    public void wantDrink(boolean flag)
    {
        if(flag)
        {
            nextDrink();
            mood++;
        }else
        {
            mood--;
        }
    }
    private void nextDrink()
    {
        this.currentDrink=this.drink.getDrink();
    }
}
