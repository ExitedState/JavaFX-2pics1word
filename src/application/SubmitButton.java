package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class SubmitButton extends Hint implements Initializable {

    @FXML
    private TextField answerTextField;

    public SubmitButton() throws Exception {
        player = new Player();
        score = player.getScore();
        hp = player.getHp();
    }

    public void submit(ActionEvent event) throws Exception {
        if (answerTextField.getText().equalsIgnoreCase(super.getAnswer()) && player.getHp() != 0) {
            score += 100;
            player.setScore(score);
            switchToGameScene(event);
            System.out.println("Score : " + score);
        }
        else if (!answerTextField.getText().equalsIgnoreCase(super.getAnswer()) && player.getHp() != 0) {
            hp -= 1;
            player.setHp(hp);
            answerTextField.clear();
            System.out.println("HP :" + hp);
        }
        //always check if player hp=0 ENDGAME!!
        if (!answerTextField.getText().equalsIgnoreCase(super.getAnswer()) && player.getHp() == 0) {
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

    }

    @Override
    //update score and hp when go to next stage
    public void initialize(URL url, ResourceBundle rb) {
        super.initialize(url, rb);
        currentScore.setText("" + score);
        currentHP.setText("" + hp);
    }

    public int getScore() {
        return score;
    }

}
