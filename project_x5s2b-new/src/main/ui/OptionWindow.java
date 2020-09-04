package ui;

import placeholder.BankCard;
import placeholder.Card;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class OptionWindow extends JFrame implements ActionListener {

    private int getXposition = 100;
    private int buttonWidth = 280;
    private int buttonHeight = 20;
    private String money;
    private BankCard myCard;
    private Card movieCard;
    private JLabel label;
    private JTextField field;
    Clip clip;



    public OptionWindow(String money, Card movieCard, BankCard myCard) {
        super("Online Banking Self-service");
        this.money = money;
        this.myCard = myCard;
        this.movieCard = movieCard;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 280));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(null);

        try {
            BufferedImage myImage = ImageIO.read(new File("./data/IMG_6813.jpg"));
            setContentPane(new ImagePanel(myImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        setLayout(new FlowLayout());
//        JButton btn = new JButton("Enter");
//        btn.setActionCommand("myButton");
//        btn.addActionListener(this);
//
//        label = new JLabel("flag");
//        field = new JTextField(5);
//        add(field);
//        add(btn);
//        add(label);
//        pack();
//        setLocationRelativeTo(null);
//        setVisible(true);
//        setResizable(false);

        JLabel menuBar = new JLabel("What would you like to do?  please select one : ", JLabel.CENTER);
        menuBar.setBounds(25,10,280,20);
        add(menuBar);
        menuBar.setForeground(Color.WHITE);

        JButton movies = new JButton("Movies Earned");
        movies.setBounds(getXposition, 40, buttonWidth, buttonHeight);
        add(movies);
        movies.setActionCommand("Movies");
        movies.addActionListener(this);
        movies.setBorder(new RoundedBorder(10));
        movies.setForeground(Color.BLACK);

        JButton balance = new JButton("View Current Balance");
        balance.setBounds(getXposition, 80, buttonWidth, buttonHeight);
        add(balance);
        balance.setActionCommand("viewBalance");
        balance.addActionListener(this);
        balance.setBorder(new RoundedBorder(10));
        balance.setForeground(Color.BLACK);

        JButton viewList = new JButton("View Spending");
        viewList.setBounds(getXposition, 120, buttonWidth, buttonHeight);
        add(viewList);
        viewList.setActionCommand("viewSpending");
        viewList.addActionListener(this);
        viewList.setBorder(new RoundedBorder(10));
        viewList.setForeground(Color.BLACK);


        JButton points = new JButton("View Points");
        points.setBounds(getXposition, 160, buttonWidth, buttonHeight);
        add(points);
        points.setActionCommand("viewPoints");
        points.addActionListener(this);
        points.setBorder(new RoundedBorder(10));
        points.setForeground(Color.BLACK);


        JButton validate = new JButton("Validate Card");
        validate.setBounds(getXposition, 200, buttonWidth, buttonHeight);
        add(validate);
        validate.setActionCommand("validate");
        validate.addActionListener(this);
        validate.setBorder(new RoundedBorder(10));
        validate.setForeground(Color.BLACK);

        //background music

//        try {
//            // Open an audio input stream.
//            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File ("src/ui/music.wav"));
//            // Get a sound clip resource.
//            clip = AudioSystem.getClip();
//            // Open audio clip and load samples from the audio input stream.
//            clip.open(audioIn);
//            clip.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }




    //EFFECTS: if actioncommand is the corresponding one, Do the specific next windows
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Movies")) {
            new MoviesEarnedWindow(money,movieCard,myCard);
        }

        if (e.getActionCommand().equals("viewBalance")) {

            new ViewCurrentBalanceWindow(money,myCard);
        }


        if (e.getActionCommand().equals("viewSpending")) {
            new ViewSpendingWindow(money,myCard);
        }


        if (e.getActionCommand().equals("viewPoints")) {
            new ViewPointsWindow(money,myCard);
        }


        if (e.getActionCommand().equals("validate")) {
            new ValidateCardWindow(myCard);
        }









    }

    protected static class RoundedBorder implements Border {
        private int radius;

        //MODIFIES: this
        //EFFECTS: set the radius to the "radius"
        RoundedBorder(int radius) {
            this.radius = radius;
        }



        //MODIFIES: this
        //EFFECTS:return a new Insets
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        //EFFECTS: return true if it is border opaque
        public boolean isBorderOpaque() {
            return true;
        }


        //MODIFIES: this
        //EFFECTS: create the border we created
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }


}