import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.concurrent.TimeUnit;

//extends UnicastRemoteObject to allow the JVM to create remote stubs/proxy
public class SorterImplementation extends UnicastRemoteObject implements Sorter {

    //Instantiating stack
    private final List<Integer> stack;

    public SorterImplementation() throws RemoteException {
        stack = new ArrayList<Integer>();
    }

    public void pushValue(int val) throws RemoteException {
        stack.add(0,val);
        return;
    }

    public void pushOperator(String operator) throws RemoteException {

        int max = 0;
        int min = 9999999;
        //split String operator
        String[] a = operator.split(",");
        int[] arr = new int[a.length];
        //calculate min and max value
        for (int i = 0; i < a.length; i++) {
            arr[i] = Integer.parseInt(a[i]);
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        String separator1 = "";
        StringBuilder de = new StringBuilder();
        //sort array
        Arrays.sort(arr);
        //descending order
        for (int b = arr.length - 1; b >= 0; b--) {
            de.append(separator1);
            de.append(arr[b]);
            separator1 = ",";
        }

        String separator2 = "";
        StringBuilder as = new StringBuilder();
        //reverse to ascending order
        for (int j : arr) {
            as.append(separator2);
            as.append(j);
            separator2 = ",";
        }
        //output
        System.out.println("descending order:" + de);
        System.out.println("ascending order:" + as);
        System.out.println("Min value is : " + min);
        System.out.println("Max value is : " + max);

    }

    public boolean isEmpty() throws RemoteException {
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public int pop() throws RemoteException
    {
        if(!stack.isEmpty()){
            int val= stack.get(0);
            stack.remove(0);
            return val;
        }
        else{
            return 0;
        }
    }

    public int delayPop(int millis) throws InterruptedException {
        System.out.println("waiting " + millis + " milliseconds");
        //delay millis MILLISECONDS
        TimeUnit.MILLISECONDS.sleep(millis);
        return millis;
    }
}
