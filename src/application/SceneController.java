package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToMainMenu(ActionEvent event) throws Exception {
        this.root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.show();
    }

    public void switchToGameScene(ActionEvent event) throws Exception {
        this.root = FXMLLoader.load(getClass().getResource("GameScene.fxml"));
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.show();
    }

    public void switchToEndScene(ActionEvent event) throws Exception {
        this.root = FXMLLoader.load(getClass().getResource("EndScene.fxml"));
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.show();
    }

    @FXML
    public Button exitButton;

    public void exitGame(ActionEvent event) {
        this.stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
