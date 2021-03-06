package com.GP.GUIFileShare;

import com.GP.GUIFileShare.UserInput.IUserInputImp;
import com.GP.LocalDB_implementator.LocalDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import com.GP.GUIFileShare.SocketCommunication.GUIcommunicator;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import com.GP.GUIFileShare.UserInput.UserInputImp;

import java.util.ResourceBundle;

public class Controller  implements Initializable  {

      private IUserInputImp pattern ;
      @FXML
      TextField userName;
      @FXML
      PasswordField password;
      @FXML
      Button signIn;
      @FXML
      Label  messageID;

    public Controller(){
        pattern = new UserInputImp();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void sighIn(ActionEvent e) {
        String user= userName.getText();
        String password_t  = password.getText();
        boolean isTrueUser = pattern.validateUsername(user);
       boolean isTruePass = pattern.validatePassword(password_t);
        if((!isTruePass) || (!isTrueUser)){
            problemMessage("There is a problem with username or password");
        }
        boolean isLoginOK = GUIcommunicator.communicator.loginAuthentication(user , password_t);
        if(isLoginOK){
            if(!LocalDB.isAdmin){
                System.out.println("basic");
                setScene("BasicUserFX.fxml" , e);
            }else {

               setScene("AdminFX.fxml" , e);
            }

        }else {
            problemMessage("There is a problem with login");

        }

    }

    private void setScene(String fxmlScene ,ActionEvent event){
        try {
            Parent homeP = FXMLLoader.load(getClass().getResource(fxmlScene));
            Scene home = new Scene(homeP,600, 400);
            Stage appStage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();
             appStage.setScene(home);
              appStage.show();

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    private void problemMessage(String message){
        messageID.setText(message);
    }



}
