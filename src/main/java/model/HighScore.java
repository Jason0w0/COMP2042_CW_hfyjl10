package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class HighScore {

    private final String pathToHighScoreFile = "src/main/resources/highScore";
    private ArrayList <Integer> highScores = new ArrayList<>();
    private int highScore;

    public HighScore(){
        File f = new File(pathToHighScoreFile);
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
        highScores.sort(Collections.reverseOrder());
        System.out.println(highScores);
        highScore = highScores.get(0);
    }

    public int getHighScore(){
        return highScore;
    }

    public void newHighScore(int highScore){
        highScores.add(highScore);
        File f = new File(pathToHighScoreFile);
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
}