package sample.SocketCommunication;

import com.GP.ClientImplementator.ClientCommunicator;
import com.GP.ClientImplementator.ClientImplementor;

/**
 * Created by user on 10/27/16.
 */
public class GUIcommunicator {
    public static ClientImplementor implementor;
    public static ClientCommunicator communicator;
    private static final int PORT = 6666;


    public GUIcommunicator() {
        implementor = new ClientImplementor(PORT);
        communicator = new ClientCommunicator(implementor.getOut(), implementor.getIn());
    }
}
