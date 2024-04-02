package core;

import java.util.Collection;
import java.util.Scanner;

public class View {
    String filename;
    Collection<String> words;

    public View(String filename) {
        this.filename = filename;
        Repository repository = new Repository(this.filename);
        try {
            this.words = repository.getWords();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Analyzer analyzer = new Analyzer(this.words);
        while (true) {
            int action = getOperator();
            if (action < 4) {
                analyzer.analyze(action);
                System.out.println("--------------------------------");
            } else if (action == 4) {
                break;
            } else {
                System.out.println("You entered an incorrect value!");
            }
        }
    }

    private int getOperator() {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("Enter a number from 1 to 4: \n");
        sb.append("1: Count the number of words\n");
        sb.append("2: Find the longest word\n");
        sb.append("3: Calculate the frequency of words in the text\n");
        sb.append("4: Exit\n");
        System.out.println(sb);
        try {
            int act = Integer.parseInt(in.nextLine());
            return act;
        } catch (NumberFormatException e) {
            System.out.println("You didn't enter a number");
            return getOperator();
        }


    }
}