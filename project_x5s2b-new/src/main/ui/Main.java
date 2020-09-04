package ui;


import network.ReadWebPageEx;
import placeholder.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class Main {


    public static void main(String[] args) throws IOException {
        ReadWebPageEx read = new ReadWebPageEx();
        read.readWebPage();

        Card movieCard = new MovieCard();
        BankCard myCard = new BankCard("Tina's card");
        SpendingList spendingList = new SpendingList();
        SpendingListSuggester spendingListSuggester = new SpendingListSuggester();
//        MovieCard movieCard = new MovieCard();
        Scanner input = new Scanner(System.in);
        UserInput uip = new UserInput();
        System.out.println("Enter the money you spent");
        String money = input.nextLine();
        spendingListSuggester.addObserver(myCard);
        menuBar(money,myCard);
        String operation = input.next();
        operationBar(money,operation,myCard);
        String choice = input.next();
        mainHelper1(choice,movieCard,money);
        uip.setLines(uip.load());
        uip.save();
    }



    //EFFECTS: spentmoney function, catch the thrown
    public static void menuBar(String money,BankCard myCard) {
        try {
            myCard.spentMoney(money);
            System.out.println("-" + valueOf(money) + "dollars");
        } catch (NegativeAmountException e) {
            System.out.println("There is an error! Please enter the money you spent again.");
            System.out.println("still keep go on~");
        } catch (ImpossibleSituationException e) {
            System.out.println("The amount spent has exceeded your balance! please confirm again.");
            System.out.println("still keep go on~");
        }

        System.out.println("Type 1: view spending, "
                + "2: view balance, 3: view points, 4:movies earned, 5: check card is valid");
    }

    //EFFECTS: helper function: do the corresponding menu according to eh functions
    public static void operationBar(String money,String operation, BankCard myCard) {
        List<String> spendList = new ArrayList<>();
        if (operation.equals("1")) {
            spendList.add(money);
            System.out.println("Recent transaction : " + spendList.size() + "times");
            for (String x: spendList) {
                System.out.println("-" + x + "dollars\n");
            }

        }
        if (operation.equals("2")) {
            myCard.balance();
            System.out.println("Balance I had: " + myCard.balance() + " dollars");
        }

        if (operation.equals("3")) {
            myCard.moneyToPoints();
            myCard.getPoints();

        }
        System.out.println("Do you want to check your Movie Card? If you want, enter 1; Don't want, enter other keys");

        operationBar1(operation,myCard);

    }

    //EFFECTS: helper function: do the corresponding menu according to eh functions
    public static void operationBar1(String operation, BankCard myCard) {


        if (operation.equals("4")) {
            myCard.moneyToPoints();
            myCard.moviesEarned();
            System.out.println("Free movies earned: " + myCard.moviesEarned());
        }

        if (operation.equals("5")) {
            myCard.cardIsValid();
            System.out.println("the card is valid?" + myCard.cardIsValid());
        }
    }


    //EFFECTS: helper function: do the corresponding menu according to eh functions
    public static void mainHelper1(String choice, Card movieCard, String money) {


        if (choice.equals("1")) {
            System.out.println("Here you go:");
            movieCard.moneyToPoints();
//            movieCard.moviesEarned();
            movieCard.cardIsValid();

            System.out.println("You've got  " + movieCard.moviesEarned() + " Free Movies!");
            System.out.println("the Movie Card is valid?" + movieCard.cardIsValid());
        } else {
            System.out.println("GoodBye!");
        }




        BankCard card = new BankCard("Tina's card");
        card.addNewSpending("Tina");
        card.addToName("Tina",(double) valueOf(money));
        card.addToName("Tina",20.0);
        System.out.println(card.transactions);

    }
}

















