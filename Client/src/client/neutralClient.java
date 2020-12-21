package client;

public class neutralClient extends Client
{
    public neutralClient(Client c,String name)
    {
        super.setName(name);
    }
    @Override
    public double getCost() {
        System.out.println("Neutral Client");
        return 0;
    }

    @Override
    protected int getMood() {
        System.out.println("Neutral Client");
        return 1;
    }

    @Override
    protected void setMood(int mood) {
        super.setMood(mood);
    }
}
