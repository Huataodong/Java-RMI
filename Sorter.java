import java.rmi.Remote;
import java.rmi.RemoteException;

//interface Sorter extends to Remote from RMI
//become a remote object that exists on the server side,
public interface Sorter extends Remote {

    //method throws RemoteException means it can be called by client remote access
    public void pushValue(int val) throws RemoteException;
    public void pushOperator(String operator) throws RemoteException;
    public int pop() throws RemoteException;
    public boolean isEmpty() throws RemoteException;
    public int delayPop(int millis) throws RemoteException, InterruptedException;

}
