package placeholder;

import java.io.IOException;
import java.util.Scanner;

public abstract class Card {
    public static Scanner input;
    public double myAmount;
    public boolean within6months;
    protected double points;


    public Card() {
        myAmount = 10000;
        within6months = true;
        this.points = 0;

    }


    //EFFECTS: deduct the money and return the amount of money spending
    protected abstract double spentMoney(String moneySpent)throws NegativeAmountException, ImpossibleSituationException;



    //EFFECTS: calculate the points we have made according to the spending money and "function"
    public abstract void moneyToPoints();


//    public abstract double getPoints();


    //REQUIRES: the value of initialAmount
    //EFFECTS: return the movies we have earned according to the amount
    public abstract int moviesEarned();



    //EFFECTS: return true if the card is used within 6 months,
    //false otherVise

    public abstract boolean cardIsValid();


}


