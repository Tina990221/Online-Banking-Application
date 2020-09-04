package ui;

import placeholder.BankCard;
import placeholder.ImpossibleSituationException;
import placeholder.NegativeAmountException;
import placeholder.SpendingList;

public interface CreditCard {
    public double initialAmount = 1000;



    //EFFECTS: deduct the money and return the amount of money spending
    public double spentMoney(String s) throws NegativeAmountException, ImpossibleSituationException;

    //REQUIRES: the value of the initialAmount in the card
    //MODIFIES: this
    //EFFECTS: return the balance amount in the card account
    //according to the money spending(amount)
    public double balance();



    //EFFECTS: return the value of the points we get from moneytopoints
    public double getPoints();


}
