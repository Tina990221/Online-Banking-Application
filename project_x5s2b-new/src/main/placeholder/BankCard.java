package placeholder;


import ui.CreditCard;
import ui.DebitCard;

import java.util.*;


import static java.lang.Integer.valueOf;



public class BankCard extends Card implements DebitCard, CreditCard, SpendingListObserver {

//    public SpendingList spendingList;
//    public List<MovieCard> movieCardList;

    private MovieCardSuggester movieCardSuggester = new MovieCardSuggester();
    private SpendingListSuggester spendingListSuggester = new SpendingListSuggester();

    public ShareMethod shareMethod = new ShareMethod();


    private String name;
    public Map<String, List<Double>> transactions = new HashMap<>();
    public Integer time;

    public BankCard(String name) {
        super();
        input = new Scanner(System.in);
//        lines = load();
        this.name = name;
        spendingListSuggester.addObserver(this);
        time = 0;

    }


    //EFFECTS: add the moviecard to the cardlist
    public void addMovieCard(MovieCard m) {
        movieCardSuggester.addMovieCard(m);

//        if (!movieCardList.contains(m)) {
//            movieCardList.add(m);
//            m.addGoCard(this);
//        }

    }

    //EFFECTS: together the spendList and the card name
    public void addNewSpending(String name) {
        List<Double> spendList = new ArrayList<>();
        transactions.put(name,spendList);
    }

    //MODIFIES: THIS
    //EFFECTS: get the spendlist and add this spending to the spendlist
    public void addToName(String name, Double spending) {
        List<Double> spendList = transactions.get(name);
        spendList.add(spending);

    }


    //REQUIRES: the value of the initialAmount in the card
    //MODIFIES: this
    //EFFECTS: return the balance amount in the card account
    //according to the money spending(amount)
    public double balance() {

//        double temp = myAmount;
        return myAmount;

    }


    //EFFECTS: deduct the money and return the amount of money spending
    @Override
    public double spentMoney(String moneySpent) throws NegativeAmountException, ImpossibleSituationException {
        if ((valueOf(moneySpent)) < 0) {
            throw new NegativeAmountException();
        }

        if ((valueOf(moneySpent)) > myAmount) {
            throw new ImpossibleSituationException();
        }

        myAmount = myAmount - valueOf(moneySpent);
        addMoneyToList((double) valueOf(moneySpent));
        return valueOf(moneySpent);
    }



    //EFFECTS: add current money to the list
    public void addMoneyToList(Double i) {

        spendingListSuggester.addMoneyToList(i);


//        this.spendingList.insert(i);

    }


//    public void showList() {
//
//        spendingListSuggester.showList();
//
////        spendingList.printSpendingList();
//    }


    //REQUIRES: the value of spendingmoney(amount)
    //MODIFIES: this
    //EFFECTS: calculate the points we have made according to the spending money and "function"

    public void moneyToPoints() {
        double amount1 = myAmount;
        this.points += amount1 * 0.15;
    }

    //EFFECTS: return the value of the points we get from moneytopoints
    @Override
    public double getPoints() {
        int y = moviesCalculator();

        System.out.println("Free movies you have earned: " + y);
        System.out.println("The BankCard" + " points I earned is ---> " + points);
        return points;

    }

    //REQUIRES: points >= 0
    //EFFECTS: calculate how many movies we can get so far according to the points we get
    public int moviesCalculator() {
        int y = 0;
        for (double i = points; i >= 1000; i = i - 1000) {
            y++;
        }
        return y;
    }


    //REQUIRES: the value of initialAmount
    //MODIFIES: this
    //EFFECTS: return the movies we have earned according to the amount
    @Override
    public int moviesEarned() {
        int y = moviesCalculator();

        return y;


    }


    //EFFECTS: return true if the card is used within 6 months,
    //false otherVise
    @Override
    public boolean cardIsValid() {
        return shareMethod.cardIsValid();
//        boolean b = shareMethod.cardIsValid();
//        return b;


    }


    //EFFECTS: override equals, and return true if two card's names are the same,
    //         false otherwise
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankCard bankCard = (BankCard) o;
        return name.equals(bankCard.name) && transactions.equals(bankCard.transactions);
    }

    //EFFECTS: override hashCode to get the name and transactions
    @Override
    public int hashCode() {
        return Objects.hash(name, transactions);
    }


    //REQUIRES: money >= 0
    //MODIFIES: name, time
    //EFFECTS: add the times for transactions and update spending informaiton
    @Override
    public void update(Double money) {
        System.out.println(this.name + " : - " + money + " $ " + "just now. ");
        time++;
        System.out.println("Recent transaction: " + time + " times ");

    }
}











