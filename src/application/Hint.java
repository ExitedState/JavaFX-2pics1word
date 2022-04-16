package application;

import gameLogic.randomPic;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hint extends SceneController implements Initializable {

    @FXML
    Label hintLabel;
    @FXML
    Button hintButton;
    @FXML
    ImageView hint1;
    @FXML
    ImageView hint2;

    randomPic pic;

    String pic1;
    String pic2;
    String answer;

    @FXML
    protected Label currentScore;
    @FXML
    protected Label currentHP;

    protected int score;
    protected int hp;
    protected Player player;

    boolean button_Stage = true;

    boolean hintFlag = false; //check if player use hint button score minus 10

    public Hint() throws Exception {
        this.pic = new randomPic();
        List<String> temp = this.pic.getPicArr();
        pic1 = temp.get(1);
        pic2 = temp.get(2);
        answer = temp.get(0);

    }

    public void displayHint() throws Exception {
        hintButton.setDisable(true);    //can press hint button only 1 time
        hintLabel.setText(answer.length() + " LETTERS");

        if (score > 0) {
            this.score -= 10;
        }

        currentScore.setText("" + this.score);
        button_Stage = false;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(pic1);
        System.out.println(pic2);
        Image hintImage1 = new Image(getClass().getResourceAsStream(pic1));
        hint1.setImage(hintImage1);
        Image hintImage2 = new Image(getClass().getResourceAsStream(pic2));
        hint2.setImage(hintImage2);

        hintButton.setDisable(true);    //can use hint button after get wrong answer
    }

    public String getAnswer() {
        return this.answer;
    }

}