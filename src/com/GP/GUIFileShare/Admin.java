package com.GP.GUIFileShare;

import com.GP.LocalDB_implementator.FileEntry;
import com.GP.LocalDB_implementator.LocalDB;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.GP.GUIFileShare.SocketCommunication.GUIcommunicator;

/**
 * Created by user on 10/27/16.
 */
public class Admin extends BasicUser implements IController,IAdmin {
    //private static final String SERVER_DIR = "/home/user/FileShare/files/images/test.jpg";

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


    @Override
    public void startProgressbar() {
        Thread t1 = new Thread() {

            @Override
            public void run() {
                while (LocalDB.progressBar == 0){}
                System.out.println(LocalDB.progressBar);
                double incrementor = 1 / LocalDB.progressBar;
                while (LocalDB.progressBar != LocalDB.currentProgressBarValue + 1){
                   // System.out.println(LocalDB.progressBar + " progress");
                   // System.out.println(LocalDB.currentProgressBarValue);
                    bar.setProgress(incrementor * LocalDB.currentProgressBarValue);
                  //  System.out.println(incrementor * LocalDB.currentProgressBarValue + " inc value");
                }
                bar.setProgress(1);
            }
        };
        t1.start();
    }


    @FXML
    @Override
    public void buttonClickCommit() {
        String item = downloadsCombo.getValue();
        if(item == null){
            messageErr.setText("please select file");
            System.out.println("in");
            return;
        }
        //GUIcommunicator.communicator.commitFromAdmin("/home/user/FileShareClient/files/images/test.jpg" , "laptops_images" ,
                //"/home/user/FileShare/files/images/test.jpg");


        for (int i = 0; i < LocalDB.entries.size(); i++) {
            LocalDB.entries.get(i).getName().toString();
            if(LocalDB.entries.get(i).getName().equals(item)){
                FileEntry e = LocalDB.entries.get(i);
                System.out.println("size " + LocalDB.entries.size());
                System.out.println(GUIcommunicator.communicator.toString());
                e.toString();
                System.out.println(e.toString());
                System.out.println( SERVER_DIR+ e.getName());
                GUIcommunicator.communicator.commitFromAdmin(e.getPath() , e.getCategorie() ,
                        SERVER_DIR+ e.getName());
                System.out.println("end");
                //startProgressbar();
                //bar.setProgress(0);
                //need to update client jar file in order to progress bar to ork properly!!
                // #ClientFileSHare
                return;
            }
        }



    }
    @FXML
    @Override
    public void buttonClickDelete() {
        String item = comboServer.getValue();
        if(item == null){
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
