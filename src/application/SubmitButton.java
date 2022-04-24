package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SubmitButton extends Hint implements Initializable {

    @FXML
    private TextField answerTextField;
    @FXML
    private Label lastWordInput;

    protected static String endScreenAnswer;

    public SubmitButton() throws Exception {
        player = new Player();
        score = player.getScore();
        hp = player.getHp();
    }

    public void submit(ActionEvent event) throws Exception {
        String userAnswer = answerTextField.getText();
        String stageAnswer = super.getAnswer();
        if (userAnswer.equalsIgnoreCase(stageAnswer) && player.getHp() != 0) {
            score += 100;
            player.setScore(score);
            switchToGameScene(event);
        } else if (!userAnswer.equalsIgnoreCase(stageAnswer) && player.getHp() != 0) {
            hp -= 1;
            player.setHp(hp);
            answerTextField.clear();
        }
        //always check if player hp=0 ENDGAME!!
        if (!userAnswer.equalsIgnoreCase(stageAnswer) && player.getHp() == 0) {
            switchToEndScene(event);
        }

        //first time that player submit wrong answer -> turn on button
        //default hint_button_Stage = True
        if (hint_button_Stage) {
            hintButton.setDisable(false); //turn on button
        } else {
            hintButton.setDisable(true); //turn off button
        }

        //update score and hp between stage that player can pass
        currentScore.setText("" + score);
        currentHP.setText("" + hp);

        lastWordInput.setVisible(true);
        lastWordInput.setText("Last answer :  " + userAnswer);

        this.endScreenAnswer = stageAnswer;
    }

    @Override
    //update score and hp when go to next stage
    public void initialize(URL url, ResourceBundle rb) {
        super.initialize(url, rb);
        currentScore.setText("" + score);
        currentHP.setText("" + hp);
        lastWordInput.setVisible(false);
    }

    public int getScore() {
        return score;
    }

}
