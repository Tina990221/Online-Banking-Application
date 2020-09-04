package ui;

import placeholder.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Integer.valueOf;


public class InitialWindow extends JFrame implements ActionListener {

    JTextField moneySpent;
    private SpendingListSuggester spendingListSuggester;
    public Card movieCard = new MovieCard();
    public BankCard myCard;




    public InitialWindow() {

        super("Online Banking Self-service");

        myCard = new BankCard("Tina's card");

        Card movieCard = new MovieCard();
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(550, 330));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(null);

        try {
            BufferedImage myImage = ImageIO.read(new File("./data/IMG_6813.JPG"));
            setContentPane(new ImagePanel(myImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel initialWelcome = new JLabel("Hi Tina, Welcome to Your online banking self-service! ",
                JLabel.CENTER);
        initialWelcome.setBounds(25,70, 500,20);
        add(initialWelcome);
        initialWelcome.setForeground(Color.WHITE);

        JLabel enterMoneySpent = new JLabel("Please enter the money you spent: ", JLabel.CENTER);
        enterMoneySpent.setBounds(70,110, 400,20);
        add(enterMoneySpent);
        enterMoneySpent.setForeground(Color.WHITE);

        moneySpent = new JTextField(10);
        moneySpent.setBounds(220,150, 100,20);
        add(moneySpent);

        JButton button = new JButton("Enter");
        button.setBounds(240,190, 60,20);
        add(button);
        button.setBorder(new OptionWindow.RoundedBorder(10));
        button.setForeground(Color.WHITE);
        button.setActionCommand("Enter");
        button.addActionListener(this);


        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);


    }



    //EFFECTS: if actioncommand is the corresponding one, Do the Second Window, false do the thrown
    @Override
    public void actionPerformed(ActionEvent e) {
        String money = moneySpent.getText();

        spendingListSuggester = new SpendingListSuggester();

        if (e.getActionCommand().equals("Enter")) {

            try {
                myCard.spentMoney(money);
                spendingListSuggester.addObserver(myCard);
                new SecondWindow(money,movieCard,myCard);
            } catch (NegativeAmountException exception) {
                JOptionPane.showMessageDialog(null, "There is an error! "
                        + "Please enter the money you spent again. Try Again!  :) ");
            } catch (ImpossibleSituationException exception) {
                JOptionPane.showMessageDialog(null, "The amount spent has exceeded your "
                        + "balance! please confirm and try Again :) ");
            }
        }





    }

    public static void main(String[] args) {
        new InitialWindow();
    }


}
