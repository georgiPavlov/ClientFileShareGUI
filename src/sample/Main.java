package sample;
;
import com.GP.ClientImplementator.ClientCommunicator;
import com.GP.ClientImplementator.ClientImplementor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.SocketCommunication.GUIcommunicator;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GUIcommunicator com = new GUIcommunicator();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("File Client");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
        //ClientImplementor implementor = new ClientImplementor(6666);
        //ClientCommunicator communicator = new ClientCommunicator(implementor.getOut(), implementor.getIn());

    }


    public static void main(String[] args) {
        launch(args);
    }
}
