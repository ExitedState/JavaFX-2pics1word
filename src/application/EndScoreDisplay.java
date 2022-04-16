package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class EndScoreDisplay extends SubmitButton implements Initializable {

    @FXML
    private Text gameOverScore;

    public EndScoreDisplay() throws Exception {
        player.newStatus();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameOverScore.setText("Your Score : " + getScore());
    }

}
