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

public class SecondWindow extends JFrame implements ActionListener {

    private String money;
    private BankCard myCard;
    private Card movieCard;
    private int getXposition = 100;
    private int buttonWidth = 280;
    private int buttonHeight = 20;


    public SecondWindow(String money,Card movieCard,BankCard myCard) {
        super("Online Banking Self-service");
        this.money = money;
        this.myCard = myCard;
        this.movieCard = movieCard;


        setPreferredSize(new Dimension(500, 280));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(null);

        try {
            BufferedImage myImage = ImageIO.read(new File("./data/IMG_9085.jpg"));
            setContentPane(new ImagePanel(myImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int m = Integer.parseInt(String.valueOf(money));

        JLabel message = new JLabel("Tina's BankCard: - " + m + " $ just now. ", JLabel.CENTER);
        message.setBounds(25,60,280,20);
        add(message);
        message.setForeground(Color.BLACK);

        JButton more = new JButton("View more");
        more.setBounds(getXposition, 110, buttonWidth, buttonHeight);
        add(more);
        more.setBorder(new OptionWindow.RoundedBorder(10));
        more.setActionCommand("more");
        more.setForeground(Color.BLACK);
        more.addActionListener(this);

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    //REQUIRES: ActionCommand.Equals("more")
    //EFFECTS: if actioncommand is the corresponding one, Do the OptionWindow
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("more")) {
            new OptionWindow(money,movieCard,myCard);
        }

    }
}
