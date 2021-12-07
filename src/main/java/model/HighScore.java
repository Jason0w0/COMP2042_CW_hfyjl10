package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

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
        highScores.sort(new ascendingComparator());
        System.out.println(highScores);
        highScore = highScores.get(0);
    }

    public int getHighScore(){
        return highScore;
    }

    static class ascendingComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }
}