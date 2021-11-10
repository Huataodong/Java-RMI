import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.Stack;

public class SorterClient {
    public static void main(String[] args) {

        try {
            //If the RMI Registry is on the local machine, the URL is: rmi://localhost:1099/Hello
            Registry registry = LocateRegistry.getRegistry("localhost");
            //Retrieve stubs/proxy for remote objects from the Registry
            Sorter myStack = (Sorter) registry.lookup("Hello");

            System.out.println("How many integers you want to push?");
            Scanner num = new Scanner(System.in);
            int n = num.nextInt();

            System.out.println("Please enter your integer:");
            Scanner input = new Scanner(System.in);

            for (int i=1; i <= n; i++) {

                while (true) {
                    String line = input.nextLine();
                    //input integer only
                    try {
                        // if input is empty
                        if (line.equals(" ")) {
                            System.out.println("cannot input empty value");
                        }
                        //push input value to remote method pushValue
                        int val = Integer.parseInt(line);
                        myStack.pushValue(val);
                        break;
                    } catch(Exception e) {
                        System.out.println("Enter integer only.");
                    }
                }
            }

            int []arr = new int[n];
            int count = 0;
            while(!myStack.isEmpty() && count<n)
            {
                System.out.println("delay pop....");
                //make a delay before each pop
                myStack.delayPop(10);
                //Call remote object pop
                arr[count] = myStack.pop();
                System.out.println("popped:" + arr[count]);
                count++;
            }

            //use StringBuilder to convert array to string
            StringBuilder sb = new StringBuilder();
            String separator = "";
            //append arr and separate with ,
            for (int j : arr) {
                sb.append(separator);
                sb.append(j);
                separator = ",";
            }

            Sorter operator = new SorterImplementation();
            //call and push str to pushOperator
            String str = sb.toString();
            operator.pushOperator(str);

        }

        catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
