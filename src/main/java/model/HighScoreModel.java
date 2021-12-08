package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class HighScoreModel {
    private final String pathToHighScoreFile = "src/main/resources/highScore";
    private final ArrayList <Integer> highScores = new ArrayList<>();
    private int highScore;
    private final File f;

    public HighScoreModel(){
        f = new File(pathToHighScoreFile);
        readHighScoreFile(f);
        highScores.sort(Collections.reverseOrder());
        highScore = highScores.get(0);
    }

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

    public int getHighScore(){
        return highScore;
    }

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

    public ArrayList<Integer> getHighScoreList() { return highScores;}
}