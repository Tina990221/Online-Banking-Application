package placeholder;

//import placeholder.Home;

import java.util.List;

import static java.lang.Integer.valueOf;

public class MovieCard extends Card {

    public List<BankCard> bankCardList;

    public ShareMethod shareMethod = new ShareMethod();

    public MovieCard() {
        super();
    }

    //REQUIRES: the bankCardlist does not contain bankcard
    //EFFECTS: add the bankcard to bankCardlist and add moviecard to movieCardList
    public void addGoCard(BankCard bankCard) {
        if (!bankCardList.contains(bankCard)) {
            bankCardList.add(bankCard);
            bankCard.addMovieCard(this);
        }
    }

    //REQUIRES: moneySpent >= 0
    //MODIFIES: myAmount
    //EFFECTS: deduct the moneySpent from the myAmount and return the value of moneySpent
    @Override
    public double spentMoney(String moneySpent) {
        myAmount = myAmount - valueOf(moneySpent);
        return valueOf(moneySpent);
    }

    //EFFECTS: return the points we get so far
    public double getPoints() {
        return points;
    }


    //REQUIRES: the value of spendingmoney(amount)
    //MODIFIES: this
    //EFFECTS: calculate the points we have made according to the spending money and "function"
    @Override
    public void moneyToPoints() {
        double amount1 = myAmount;
        this.points += amount1 * 0.15;
    }


    //EFFECTS: calculate how many movies we can get so far according to the points we get
    //         and then return it
    @Override
    public int moviesEarned() {
        int y = freeMoviesCalculator();
        System.out.println("The MovieCard" + " points I earned is ---> " + points);
        return y;
    }

    //REQUIRES: points >= 0
    //EFFECTS: calculate how many movies we can get so far according to the points we get
    public int freeMoviesCalculator() {
        int y = 0;
        for (double i = getPoints(); i >= 1000; i = i - 1000) {
            y++;
        }
        return y;
    }


    //EFFECTS: return true if the card is used within 6 months,
    //false otherVise
    @Override
    public boolean cardIsValid() {
        return shareMethod.cardIsValid();
    }
}

