package com.GP.GUIFileShare;
;
import com.GP.GUIFileShare.SocketCommunication.GUIcommunicator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    static Stage rootStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        GUIcommunicator com = new GUIcommunicator();
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        primaryStage.setTitle("File Client");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
        primaryStage.setResizable(false);
        rootStage = primaryStage;
        /*primaryStage.setOnCloseRequest(event -> {
            System.out.println("Stage is closing");
            // Save file
        });*/

        //ClientImplementor implementor = new ClientImplementor(6666);
        //ClientCommunicator communicator = new ClientCommunicator(implementor.getOut(), implementor.getIn());

    }

    @FXML
    public void exitApplication(ActionEvent event) {
        ((Stage)rootStage.getScene().getWindow()).close();
    }

    @Override
    public void stop(){
        System.out.println("Stage is closing");
        GUIcommunicator.communicator.closeSocket();
        // Save file
    }

    public static void main(String[] args) {
        launch(args);
    }
}
