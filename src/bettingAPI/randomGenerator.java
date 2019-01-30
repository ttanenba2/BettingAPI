package bettingAPI;
import java.util.Random;
public class randomGenerator implements random{
	private Random random;
public randomGenerator(){
	this.random=new Random();
}
public int getRandom(int i){
	return random.nextInt();
}
}
