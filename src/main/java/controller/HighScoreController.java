package controller;

import model.HighScoreModel;
import view.HighScoreView;

import javax.swing.*;

public class HighScoreController {
    private HighScoreModel highScoreModel;
    private HighScoreView highScoreView;
    public HighScoreController(JFrame owner) {
        this.highScoreModel = new HighScoreModel();
        this.highScoreView = new HighScoreView(owner);
    }
}
