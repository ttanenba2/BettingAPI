package bettingAPI;

public class Betting {
	int minBalance=0;
	random random;
	boolean probHappened=true;
	int currentBalance=0;
	
	//constructor
	public Betting (int minBalance, random random){
		this.minBalance=minBalance;
		this.random=random;
	}
	public void setMinBalance(int minBalance){
		if (minBalance<=0)
		this.minBalance=minBalance;
		else throw new InvalidMinBalanceException("Minimum balance must be less than or equal to zero.");
	}
	public void setRandom(random random)
	{this.random=random;}
	
	public int getCurrentBalance()
	{return this.currentBalance;}
	
	public boolean canBet (int amount){
		if (amount<=currentBalance-minBalance)
		return true;
		else return false;}
	
	
	public void addMoney(int amount){
		if (amount>=0)
		currentBalance+=amount;
		else throw new InvalidAddAmountException("Add amounts must be greater than or equal to zero.");
	}
	public int betOnANumber(int amnt, int min, int max, int selectedNumber){
		if (selectedNumber>max||selectedNumber<min){throw new IllegalArgumentException("invalid amount.");}
		if (!canBet(amnt)){throw new IllegalArgumentException("cannot bet this amount.");}
		
		int rand=random.getRandom(max, min);
		if (rand!=selectedNumber){
			this.currentBalance-=amnt;
			return (0-amnt);}
		else {
			this.currentBalance+=(amnt*(max-min));
			return amnt*(max-min);
		}
	}
	public double betOnProbability(int amnt, double p){
if (!canBet(amnt)){throw new IllegalArgumentException("Cannot bet this amount.");}
if (p<0||p>1){throw new IllegalProbabilityException("Probability must be between 0 and 1.");}
if (probHappened){
	this.currentBalance+=((Math.pow(p,  -1)-1)*amnt);
	return (Math.pow(p, -1)-1)*amnt;
}
else{
	this.currentBalance-=amnt;
	return (0-amnt);
}
}
	
public void changeProbHappened(){
	probHappened=!probHappened;
}

}
