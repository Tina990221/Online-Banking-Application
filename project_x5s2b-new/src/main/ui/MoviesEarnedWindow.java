package ui;

import placeholder.BankCard;
import placeholder.Card;
import placeholder.MovieCard;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MoviesEarnedWindow extends JFrame implements ActionListener {

    DefaultTableModel model;
    JTable table;
    private Card movieCard;
    private String money;

    private BankCard myCard;


    public MoviesEarnedWindow(String money,Card movieCard, BankCard myCard) {

        super("My Movies Account");
        this.money = money;
        this.movieCard = movieCard;
        this.myCard = myCard;

        setPreferredSize(new Dimension(500, 280));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(null);

        try {
            BufferedImage myImage = ImageIO.read(new File("./data/IMG_9085.jpg"));
            setContentPane(new ImagePanel(myImage));
        } catch (IOException e) {
            e.printStackTrace();
        }




        String[] columns = new String[] {
                " Free movies you have earned ", " Your Card is valid? "
        };
        final Class[] columnClass = new Class[] {
                String.class, String.class
        };
        model = new DefaultTableModel(null, columns) {

            @Override
            public boolean isCellEditable(int row, int column) {

                return column == 1;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {

                return columnClass[columnIndex];
            }
        };

        table = new JTable(model);
        System.out.println(movieCard);

        movieCard.moneyToPoints();

        Vector row = new Vector();
        row.add(movieCard.moviesEarned());
        row.add(movieCard.cardIsValid());

        model.addRow(row);


        add(new JScrollPane(table));

        JButton goBack = new JButton("Go back");
        add(goBack);
        goBack.setActionCommand("goback");
        goBack.addActionListener(this);
        goBack.setBorder(new OptionWindow.RoundedBorder(10));
        goBack.setForeground(Color.darkGray);



        setTitle("My MovieCard information");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
        setVisible(true);

    }

    //REQUIRES: ActionCommand.Equals("goBack")
    //EFFECTS: if actioncommand is the corresponding one, Do the OptionWindow
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("goback")) {
            new OptionWindow(money,movieCard,myCard);
        }

    }

}
