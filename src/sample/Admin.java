package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by user on 10/27/16.
 */
public class Admin implements IController,IAdmin {

    @FXML
    TextField userName;
    @FXML
    PasswordField password;
    @FXML
    Button signIn;
    @FXML
    Label messageID;
    @FXML
    @Override
    public void ButtonClickUp(ActionEvent actionEvent) {

    }
    @FXML
    @Override
    public void ButtonClickDownload(ActionEvent actionEvent) {

    }
    @FXML
    @Override
    public void ButtonClickUpdateDownloads(ActionEvent actionEvent) {

    }
    @FXML
    @Override
    public void startProgressbar() {

    }
    @FXML
    @Override
    public void buttonClickCommit() {

    }
    @FXML
    @Override
    public void buttonClickDelete() {

    }
}
