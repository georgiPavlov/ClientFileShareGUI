package sample;

import com.GP.LocalDB_implementator.LocalDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import sample.SocketCommunication.GUIcommunicator;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

public class Controller  implements Initializable  {

      @FXML
      TextField userName;
      @FXML
      PasswordField password;
      @FXML
      Button signIn;
      @FXML
      Label  messageID;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void sighIn(ActionEvent e) {
        String user= userName.getText();
        String password_t  = password.getText();
        //pattern_Matcher(user , password_t);
        boolean isLoginOK = GUIcommunicator.communicator.loginAuthentication(user , password_t);
        if(isLoginOK){
            if(!LocalDB.isAdmin){
                System.out.println("basic");
                setScene("BasicUserFX.fxml" , e);
            }else {
               setScene("AdminFX.fxml" , e);
            }

        }else {
            messageID.setText("There is a problem with login");

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


    public void pattern_Matcher(String name , String password) {

    }
}
