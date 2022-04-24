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
  
    private final randomPic pic;
    private final String pic1;
    private final String pic2;
    private final String answer;

    @FXML
    protected Label currentScore;
    @FXML
    protected Label currentHP;

    protected int score;
    protected int hp;
    protected Player player;

    //check if player used hint button ? false : true
    protected boolean hint_button_Stage = true;


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

        if (score > 0) { //do not minus score if it in start of the game
            this.score -= 10;
        }

        currentScore.setText("" + this.score); //update score
        hint_button_Stage = false; //set to false because player used HintButton
    }

    //override initialize to display hintPicture immediately
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        System.out.println(pic1);
//        System.out.println(pic2);
        Image hintImage1 = new Image(getClass().getResourceAsStream(pic1));
        hint1.setImage(hintImage1);
        Image hintImage2 = new Image(getClass().getResourceAsStream(pic2));
        hint2.setImage(hintImage2);

        
        hintButton.setDisable(true);    //can use hint button after get one wrong answer 
        //this chain to class SubmitButton
        
    }

    public String getAnswer() {
        return this.answer;
    }

}
