package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SkipStage extends SubmitButton {

    @FXML
    Button skipButton;

    private int counter;

    public SkipStage() throws Exception {
        this.counter = 0;
    }

    @Override
    //update score and hp when go to next stage
    public void initialize(URL url, ResourceBundle rb) {
        super.initialize(url, rb);
        skipButton.setDisable(true);
    }

    public void skip(ActionEvent event) throws Exception {
        if (score > 0) {
            this.player.setScore(score -= 50);
        }
        switchToGameScene(event);
    }

    @Override
    public void submit(ActionEvent event) throws Exception {
        super.submit(event);
        System.out.println(this.counter);
        //if score =0 can use skip free [not minus score])
        if ((getScore() >= 100 || score==0) && this.counter > 0) {
            skipButton.setDisable(false);
        }
        this.counter++;
    }

}
