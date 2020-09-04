package ui;

import placeholder.BankCard;
import placeholder.Card;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ViewCurrentBalanceWindow extends JFrame implements ActionListener {

    private String money;
    private BankCard myCard;
    private Card movieCard;
    private int getXposition = 100;
    private int buttonWidth = 280;
    private int buttonHeight = 20;
    private OptionWindow optionWindow;

    public ViewCurrentBalanceWindow(String money,BankCard myCard) {

        super("My Balance");
        this.myCard = myCard;
        this.money = money;
        this.movieCard = movieCard;
        this.optionWindow = optionWindow;

        setPreferredSize(new Dimension(500, 280));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(null);


        try {
            BufferedImage myImage = ImageIO.read(new File("./data/IMG_9085.jpg"));
            setContentPane(new ImagePanel(myImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        double balance = myCard.balance();
        JLabel message = new JLabel("The balance I have: " + balance + " $ ", JLabel.CENTER);
        message.setBounds(25,60,280,20);
        add(message);
        message.setForeground(Color.BLACK);

        JButton more = new JButton("Go back");
        more.setBounds(getXposition, 110, buttonWidth, buttonHeight);
        add(more);
        more.setActionCommand("goback");
        more.addActionListener(this);
        more.setBorder(new OptionWindow.RoundedBorder(10));
        more.setForeground(Color.BLACK);

        pack();
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("goback")) {
            new OptionWindow(money,movieCard,myCard);
        }
    }
}
