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
        this.player = new Player();
        this.score = player.getScore();
        this.hp = player.getHp();
    }

    public void submit(ActionEvent event) throws Exception {
        if (answerTextField.getText().equalsIgnoreCase(super.getAnswer()) && this.player.getHp() != 0) {
            this.score += 100;
            this.player.setScore(score);
            switchToGameScene(event);
            System.out.println("Score : " + this.score);

        } else if (!answerTextField.getText().equalsIgnoreCase(super.getAnswer()) && this.player.getHp() != 0) {
            hp -= 1;
            player.setHp(hp);
            System.out.println("HP :" + hp);

        } else {
            switchToEndScene(event);
        }

        if (button_Stage) {
            hintButton.setDisable(false); //if button stage TRUE -> turn on button
        } else {
            hintButton.setDisable(true); // if button used -> turn off button
        }

        //change score and hp between stage
        currentScore.setText("" + this.score);
        currentHP.setText("" + this.hp);

    }

    @Override
    //update score and hp when go to next stage
    public void initialize(URL url, ResourceBundle rb) {
        super.initialize(url, rb);
        currentScore.setText("" + this.score);
        currentHP.setText("" + this.hp);
    }

    public int getScore() {
        return this.score;
    }

}
