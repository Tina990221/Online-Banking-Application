package ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.Integer.getInteger;
import static java.lang.Integer.valueOf;

public class UserInput {
    public Scanner input;
    public String str;
    private List<String> lines;



    public UserInput() throws IOException {
        str = "";
        lines = load();

    }

    public String getInput() {
        return str;
    }

    public void setInput(String str) {
        this.str = str;
    }

    public String getUserInput() {
        input = new Scanner(System.in);
        str = input.nextLine();
        return str;
    }

    public List<String> load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./data/GoCard.txt"));

        return lines;

    }


    public void save() throws IOException {
        PrintWriter writer = new PrintWriter("./data/GoCard.txt", "UTF-8");

        for (String line : lines) {
            writer.println(line);
        }
        writer.close();

    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }


//    public HashMap<Integer, Integer> createMap() {
//        Map map = new HashMap<Integer, Integer>();
//        int x = 3;
//        map.put (x, 10);
//        map.get (x); //return 10
//    }
}




