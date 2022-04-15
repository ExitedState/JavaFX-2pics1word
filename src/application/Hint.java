package application;

import gameLogic.randomPic;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hint extends SceneController implements Initializable{

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
    
    public Hint() throws Exception {
        this.pic = new randomPic();
        pic1 = this.pic.getPicArr().get(1);
        pic2 = this.pic.getPicArr().get(2);
        answer = this.pic.getPicArr().get(0);
    }

    public void displayHint() throws Exception {
        hintButton.setDisable(true);
        hintLabel.setText(answer.length() + " LETTERS");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image hintImage1 = new Image(getClass().getResourceAsStream(pic1));
        hint1.setImage(hintImage1);
        Image hintImage2 = new Image(getClass().getResourceAsStream(pic2));
        hint2.setImage(hintImage2);
    }

    public String getAnswer(){
        return this.answer;
    }
}
