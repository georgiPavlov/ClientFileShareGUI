package sample;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import sample.SearchDir.DirectorySearch;
import sample.SocketCommunication.GUIcommunicator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by user on 10/28/16.
 */
public interface IController {
     void ButtonClickUp(ActionEvent actionEvent);
     void ButtonClickDownload(ActionEvent actionEvent);
     void ButtonClickUpdateDownloads(ActionEvent actionEvent);
     void startProgressbar();


}
