package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class generates the high score's model
 *
 * @author Jason
 */
public class HighScoreModel {
    private final String pathToHighScoreFile = "src/main/resources/highScore";
    private final ArrayList <Integer> highScores = new ArrayList<>();
    private int highScore;
    private final File f;

    /**
     * This is the constructor of HighScoreModel class
     */
    public HighScoreModel(){
        f = new File(pathToHighScoreFile);
        readHighScoreFile(f);
        highScores.sort(Collections.reverseOrder());
        highScore = highScores.get(0);
    }

    /**
     * This method reads high score data stored in txt file
     * @param f File
     */
    private void readHighScoreFile(File f) {
        if(!f.exists()){
            System.err.println("Could not create highScore file.");
        }
        BufferedReader br = null;
        try{
            String currentLine;
            br = new BufferedReader(new FileReader(f));
            while ((currentLine = br.readLine()) != null){
                highScores.add(Integer.parseInt(currentLine));
            }
        }catch (IOException e){
            System.out.println("no data");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e){
                System.out.println("Cant close file");
            }
        }
    }

    /**
     * This method gets the high score value
     * @return High score
     */
    public int getHighScore(){
        return highScore;
    }

    /**
     * This method determines if the score will be displayed in high score list
     * @param score Player's score
     * @return Boolen either the player's score is in top 5
     */
    public boolean isInHighScoreList(int score) {
        return score > highScores.get(4);
    }

    /**
     * This method writes new high score into the txt file
     * @param highScore new high score
     */
    public void writeNewHighScore(int highScore){
        this.highScore = highScore;
        highScores.add(highScore);
        try {
            FileWriter fw = new FileWriter(f.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (Integer score : highScores) {
                bw.write(score + "\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not write to file " + pathToHighScoreFile);
        }
    }

    /**
     * This method gets the high score list
     * @return List of high score values
     */
    public ArrayList<Integer> getHighScoreList() { return highScores;}

}