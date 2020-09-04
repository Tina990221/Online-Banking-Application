package ui;

import placeholder.BankCard;
import placeholder.Card;
import placeholder.SpendingList;

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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ViewSpendingWindow extends JFrame implements ActionListener {

    DefaultTableModel model;
    JTable table;
    private String money;
    private BankCard myCard;
    private Card movieCard;
    public LocalDateTime date;


    public ViewSpendingWindow(String money, BankCard myCard) {
        super("Online Banking Self-service");
        this.money = money;
        this.movieCard = movieCard;
        this.myCard = myCard;
        date = LocalDateTime.now();

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
                "Recent transaction", "Spending", "Date"
        };
        final Class[] columnClass = new Class[] {
                String.class,String.class, String.class
        };
        model = new DefaultTableModel(null, columns) {

            @Override
            public boolean isCellEditable(int row, int column) {

                return column == 2;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {

                return columnClass[columnIndex];
            }
        };

        table = new JTable(model);
        List<String> spendList = new ArrayList<>();
        spendList.add(money);
        int m = Integer.parseInt(String.valueOf(money));
        System.out.println("list size is " + spendList.size());

        for (String i: spendList) {
            Vector row = new Vector();
            row.add(spendList.size());
            row.add(" - " + m + " $ ");
            row.add(date);

            model.addRow(row);
        }

        add(new JScrollPane(table));

        JButton goBack = new JButton("Go back");
        add(goBack);
        goBack.setActionCommand("goback");
        goBack.addActionListener(this);
        goBack.setBorder(new OptionWindow.RoundedBorder(10));
        goBack.setForeground(Color.darkGray);



        setTitle("My SpendingList");
        setLayout(new FlowLayout());
//        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
        setVisible(true);
        setResizable(false);



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
