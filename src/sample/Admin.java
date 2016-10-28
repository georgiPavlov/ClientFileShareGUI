package sample;

import com.GP.LocalDB_implementator.FileEntry;
import com.GP.LocalDB_implementator.LocalDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.SocketCommunication.GUIcommunicator;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by user on 10/27/16.
 */
public class Admin extends BasicUser implements IController,IAdmin {

    @FXML
    Button updateButton;
    @FXML
    Button deleteID;
    @FXML
    Button downloadButton;
    @FXML
    Button updateDownloads;
    @FXML
    Button commitID;
    @FXML
    Label messageErr;
    @FXML
    ComboBox<String>  comboServer;
    @FXML
    ComboBox<String>  downloadsCombo;
    private static final String SERVER_DIR = "/home/user/FileShare/files/";





    @FXML
    @Override
    public void buttonClickCommit() {
        String item = downloadsCombo.getValue();
        if(item.equals(null)){
            messageErr.setText("please select file");
            return;
        }

        for (int i = 0; i < LocalDB.entries.size(); i++) {
            LocalDB.entries.get(i).getName().toString();
            if(LocalDB.entries.get(i).getName().equals(item)){
                FileEntry e = LocalDB.entries.get(i);
                System.out.println(GUIcommunicator.communicator.toString());
                e.toString();
                GUIcommunicator.communicator.commitFromAdmin(e.getPath() , e.getCategorie() ,
                        SERVER_DIR+ e.getName());
                System.out.println("end");
                startProgressbar();
                bar.setProgress(0);
                //need to update client jar file in order to progress bar to ork properly!!
                // #ClientFileSHare
            }
        }



    }
    @FXML
    @Override
    public void buttonClickDelete() {
        String item = comboServer.getValue();
        if(item.equals(null)){
            messageErr.setText("please select file");
            return;
        }


        for (int i = 0; i < LocalDB.entries.size(); i++) {
            LocalDB.entries.get(i).getName().toString();
            if(LocalDB.entries.get(i).getName().equals(item)){
                FileEntry e = LocalDB.entries.get(i);
                System.out.println(GUIcommunicator.communicator.toString());
                e.toString();
                GUIcommunicator.communicator.deleteFromAdmin(e.getPath());
                System.out.println("end");
                startProgressbar();
                bar.setProgress(0);
                //need to update client jar file in order to progress bar to ork properly!!
                // #ClientFileSHare
            }
        }

    }
}
