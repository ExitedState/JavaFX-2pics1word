package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SkipStage extends SubmitButton{
    
    @FXML
    Button skipButton;
    
    boolean skip_flag = true;
    int counter = 0;

    public SkipStage() throws Exception{
        
    }
    
    @Override
    //update score and hp when go to next stage
    public void initialize(URL url, ResourceBundle rb) {
        super.initialize(url, rb);
        skipButton.setDisable(skip_flag);
    }
    
    public void skip(ActionEvent event) throws Exception{
        int score = getScore();
        this.player.setScore(score-=100);
        switchToGameScene(event);
    }
    @Override
    public void submit(ActionEvent event) throws Exception {
        super.submit(event);
        if(getScore()>=100 && counter>=1){
            skipButton.setDisable(!skip_flag);
        }
        counter++;
    }
 
}
