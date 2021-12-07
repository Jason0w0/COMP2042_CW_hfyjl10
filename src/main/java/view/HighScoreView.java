package view;

import javax.swing.*;
import java.util.ArrayList;

public class HighScoreView {
    private ArrayList<Integer> highScoreList;
    private final JFrame owner;
    public HighScoreView (JFrame owner) {
        this.owner = owner;
    }

    public void displayContent () {
        JOptionPane.showMessageDialog(owner,getMessage(),"HIGHSCORE",JOptionPane.PLAIN_MESSAGE);
    }

    private String getMessage() {
        StringBuilder message = new StringBuilder();
        for (int i=0;i<highScoreList.size();i++){
            if (i == 5)
                break;
            message.append(String.format("%d. %d\n", i + 1, highScoreList.get(i)));
        }
        return message.toString();
    }

    public void setHighScoreList(ArrayList<Integer> highScoreList) {this.highScoreList = highScoreList;}
}
