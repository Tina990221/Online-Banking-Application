package ui;

import placeholder.BankCard;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ValidateCardWindow extends JFrame implements ActionListener {

    private BankCard myCard;
//    private String status;

    public ValidateCardWindow(BankCard myCard) {
        super("Vertify Card");
        this.myCard = myCard;

//        String status = "known";

        setPreferredSize(new Dimension(500, 280));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(null);

        try {
            BufferedImage myImage = ImageIO.read(new File("./data/IMG_9085.jpg"));
            setContentPane(new ImagePanel(myImage));
        } catch (IOException e) {
            e.printStackTrace();
        }


        JLabel message = new JLabel("Your BankCard is valid? : " + myCard.cardIsValid(), JLabel.CENTER);
        message.setBounds(25,60,280,20);
        add(message);
        message.setForeground(Color.BLACK);

        pack();
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);



    }

    //EFFECTS: came out the message on the screen
    @Override
    public void actionPerformed(ActionEvent e) {
        //just came out the message

    }
}
