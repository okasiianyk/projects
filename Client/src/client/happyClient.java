package client;

public class happyClient extends Client
{
    public happyClient(Client c,String name)
    {
        super.setName(name);
    }
    @Override
    public double getCost() {
        System.out.println("Happy Client");
        return 10;
    }

    @Override
    protected int getMood() {
        System.out.println("Happy Client");
        return 2;
    }

    @Override
    protected void setMood(int mood) {
        super.setMood(mood);
    }

}
