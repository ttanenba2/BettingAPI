package bettingAPI;
import java.util.Random;
public class randomGenerator implements random{
	private Random random;
public randomGenerator(){
	this.random=new Random();
}
public int getRandom(){
	return random.nextInt();
}
public int getRandom(int max, int min){
	return random.nextInt(max-min+1)+min;
}
}
