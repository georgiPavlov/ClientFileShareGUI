package com.GP.GUIFileShare;

import com.GP.LocalDB_implementator.FileEntry;
import com.GP.LocalDB_implementator.LocalDB;
import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import com.GP.GUIFileShare.SearchDir.DirectorySearch;
import com.GP.GUIFileShare.SocketCommunication.GUIcommunicator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by user on 10/27/16.
 */
public class BasicUser implements Initializable,IController {

    @FXML
    ProgressBar bar;
    @FXML
    ComboBox<String>  comboServer;
    @FXML
    ComboBox<String>  downloadsCombo;
    @FXML
    Label messageErr;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    @Override
    public void ButtonClickUp(ActionEvent actionEvent) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < LocalDB.entries.size() ; i++) {
            LocalDB.entries.get(i).getName();
            list.add(LocalDB.entries.get(i).getName());
        }
           ObservableList<String> options = new ObservableListWrapper<String>(list);
           comboServer.setItems(options);
           comboServer.setVisibleRowCount(3);

    }

    @FXML
    @Override
    public void ButtonClickDownload(ActionEvent actionEvent) {
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
                GUIcommunicator.communicator.requestFileFromServer(e.getPath() , e.getName() ,
                        "/home/user/ClientFileShareGUI/downloads");
                System.out.println("end");
                startProgressbar();
                bar.setProgress(0);
            }
        }

    }



    @FXML
    @Override
    public void ButtonClickUpdateDownloads(ActionEvent actionEvent) {
       // String item = downloadsCombo.getValue();
        ArrayList<String> downloads = new DirectorySearch().searchForFiles();
        ObservableList<String> options1 = new ObservableListWrapper<String>(downloads);
        downloadsCombo.setItems(options1);
        downloadsCombo.setVisibleRowCount(3);

    }

    @Override
    public void startProgressbar(){
        Thread t1 = new Thread() {

            @Override
            public void run() {
                while (LocalDB.progressBar == 0){}
                double incrementor = 1 / LocalDB.progressBar;
                while (LocalDB.progressBar != LocalDB.currentProgressBarValue + 1){
                    System.out.println(LocalDB.progressBar + " progress");
                    System.out.println(LocalDB.currentProgressBarValue);
                    bar.setProgress(incrementor * LocalDB.currentProgressBarValue);
                }
                bar.setProgress(1);
            }
        };
        t1.start();
    }




}
