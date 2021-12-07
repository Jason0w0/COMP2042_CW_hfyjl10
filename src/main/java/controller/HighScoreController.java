package controller;

import model.HighScoreModel;
import view.HighScoreView;

import javax.swing.*;

public class HighScoreController {

    public HighScoreController(JFrame owner) {
        HighScoreModel highScoreModel = new HighScoreModel();
        HighScoreView highScoreView = new HighScoreView(owner);
        highScoreView.setHighScoreList(highScoreModel.getHighScoreList());
        highScoreView.displayContent();
    }
}
