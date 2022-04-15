package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class Submit extends Hint {

    private int score;
    private int hp;

    @FXML
    TextField answerTextField;

    Player player;

    public Submit() throws Exception {
        this.player = new Player();
        this.score = player.getScore();
        this.hp = player.getHp();
    }

    public void submit(ActionEvent event) throws Exception {
        if (answerTextField.getText().equalsIgnoreCase(super.getAnswer()) && this.player.getHp() != 0) {
            this.score += 100;
            this.player.setScore(score);
            switchToGameScene(event);
            System.out.println("Score : " + score);
        } else if (!answerTextField.getText().equalsIgnoreCase(super.getAnswer()) && this.player.getHp() != 0) {
            hp -= 1;
            player.setHp(hp);
            System.out.println("HP :" + hp);
        } else {
            player.newStatus();
            switchToEndScene(event);
        }
    }
}
