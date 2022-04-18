package gameLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class wordList {

    private List<String> wordsList;
    
    public wordList() throws Exception{
        this.wordsList = new ArrayList<>();
        this.wordsList = getRandWord();
    }
    
    private static List<String> getRandWord() throws Exception {
        List<String> wordsList = new ArrayList<>();
        File myFile = new File("src\\gameLogic\\word_list.txt").getAbsoluteFile();
        BufferedReader reader = new BufferedReader(new FileReader(myFile));
        String line = reader.readLine();
        while (line != null) {
            wordsList.add(line);
            line = reader.readLine();
        }
        reader.close();
        return wordsList;
    }
    
    public List<String> getWordsList(){
        return this.wordsList;
    }
    
}
