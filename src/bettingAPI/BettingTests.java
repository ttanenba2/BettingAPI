package bettingAPI;
import static org.junit.Assert.*;
import org.junit.*;


public class BettingTests {
	private randomMock random;
	private Betting betting;
	
@Before
public void instantiation(){
 random=new randomMock();
betting=new Betting(-10, random);
}

@After
public void TakeDownTests(){
	random=null;
	betting=null;
}
@Test(expected=InvalidMinBalanceException.class)
//Cannot set minBalance to greater than zero
public void setMinBalanceToPositiveNumber(){
	betting.setMinBalance(45);
}

@Test
//test that canBet returns false when losing the bet will cause balance to fall below minimum value
public void Add30Bet50canBetFalse(){
	betting.addMoney(30);
	assertFalse(betting.canBet(50));
}
@Test
//test that canBet returns true when losing the bet will not cause balance to fall below minimum value
public void Add30Bet20canBetTrue(){
	betting.addMoney(30);
	assertTrue(betting.canBet(20));
}
@Test
//test that canBet returns true if bet will bring balance exactly to minBalance (but not below)
public void betToExactlyMinBalance(){
	betting.addMoney(30);
	assertTrue(betting.canBet(40));
}
@Test
//test that getCurrentBalance returns current Balance
public void getCurrentBalanceReturnsBalance(){
betting.addMoney(50);
betting.addMoney(4);
assertEquals(54, betting.getCurrentBalance());
}

@Test(expected=InvalidAddAmountException.class)
//test that addMoney rejects negative numbers
public void addMoneyCannotAddNegatives(){
	betting.addMoney(-3);
}
@Test
//test that BetOnANumber adjusts balance properly when bet wins.
public void betOnANumberWins(){
	betting.addMoney(50);
	random.setRandom(22);
	betting.betOnANumber(30,  10,  45,  22);
	
	assertEquals(1100, betting.getCurrentBalance());
}
@Test
//test that BetOnANumber adjusts balance properly when bet loses.
public void betOnANumberLoses(){
	betting.addMoney(50);
	random.setRandom(32);
	betting.betOnANumber(30,  10,  45,  22);
	assertEquals(20, betting.getCurrentBalance());
}
@Test
//test that BetOnProbability adjusts balance properly when bet wins
public void  BetOnProbabilityWins(){
	betting.addMoney(400);
	double balance=betting.betOnProbability(100,  .3);
	System.out.println(balance);
	//add 233 to original 50
	assertEquals(633, betting.getCurrentBalance());
}
@Test
//test that BetOnProbability adjusts balance properly when bet loses
public void  BetOnProbabilityLoses(){
	betting.addMoney(50);
	betting.probHappened=false;
	betting.betOnProbability(20,  .3);
	//check that method subtracted 20 (bet amt) from current balance.
	assertEquals(30, betting.getCurrentBalance());
}
@Test (expected=IllegalProbabilityException.class)
//throw illegal probability for negative probability
public void  BetOnNegativeProbability(){
	betting.addMoney(50);
	betting.probHappened=false;
	betting.betOnProbability(20,  -0.3);
	
}

@Test (expected=IllegalProbabilityException.class)
//throw illegal probability for greaterThanOne probability
public void  BetOnGreaterThanOneProbability(){
	betting.addMoney(50);
	betting.probHappened=false;
	betting.betOnProbability(20,  1.3);
}
}
