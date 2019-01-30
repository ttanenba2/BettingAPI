package bettingAPI;

public class InvalidMinBalanceException extends RuntimeException{
public InvalidMinBalanceException(String e){
	super(e);
}
}
