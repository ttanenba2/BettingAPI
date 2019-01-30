package bettingAPI;

public class Betting {
	int minBalance=0;
	random random;
	boolean probHappened=true;
	//constructor
	public Betting (int minBalance, random random){}
	public void setMinBalance(int minBalance){}
	public void setRandom(random random){}
	public int getCurrentBalance(){return 3;}
	public boolean canBet (int amount){return false;}
	public void addMoney(int amount){}
	public void betOnANumber(int amnt, int min, int max, int selectedNumber){}
	public int betOnProbability(int amnt, double p){return 0;}
	

}
