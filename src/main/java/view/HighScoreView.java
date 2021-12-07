package view;

import javax.swing.*;

public class HighScoreView {
    public HighScoreView (JFrame owner){
        JOptionPane.showMessageDialog(owner,getMessage(),"HIGHSCORE",JOptionPane.PLAIN_MESSAGE);
    }

    private String getMessage() {
        String message = "";
        return message;
    }
}
