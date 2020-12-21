package client;

public class sadClient extends Client
{
    public sadClient(Client c,String name)
{
    super.setName(name);
}
    @Override
    public double getCost() {
        System.out.println("Sad Client");
        return -10;
    }

    @Override
    protected int getMood() {
        System.out.println("Sad Client");
        return 0;
    }

    @Override
    protected void setMood(int mood) {
        super.setMood(mood);
    }
}
