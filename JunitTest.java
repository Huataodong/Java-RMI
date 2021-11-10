import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

class JunitTest {

    @Test
    void isEmpty() throws RemoteException {
        Sorter test = new SorterImplementation();

        //pushed integer 4 to stack, then stack is not empty and will return false
        test.pushValue(4);
        assertFalse(test.isEmpty());

        // this one for testing not push any value, and stack is empty and will return true
        // assertTrue(test.isEmpty());

    }
    @Test
    void delayPop() throws InterruptedException, RemoteException {
        Sorter test = new SorterImplementation();
        test.pushValue(4);
        test.pushValue(2);
        test.pushValue(6);
        int count = 0;
        //testing for delay 2 milliseconds before each element popped
        while(count<3)
        {
            System.out.println(test.pop());
            assertEquals(2, test.delayPop(2));
            count ++;
        }
        System.out.println("\n");
    }

    @Test
    void pop() throws RemoteException {
        Sorter test = new SorterImplementation();

        //testing for push different value and pop the correct one
        test.pushValue(5);
        assertEquals(5, test.pop());

        test.pushValue(-3);
        assertEquals(-3, test.pop());

        test.pushValue(189);
        assertEquals(189, test.pop());

    }
    @Test
    void pushValue () throws RemoteException {
        Sorter test = new SorterImplementation();
        test.pushValue(4);
        test.pushValue(5);
        test.pushValue(6);

        // pushed elements 4,5,6. The element is popped from the top of the stack.
        // if it popped 6 that means pushValue () works well
        assertEquals(6, test.pop());

    }

    @Test
    //cannot find any method to return void, so i just print out and check the difference
    void pushOperator() throws RemoteException {
        Sorter haha =  new SorterImplementation();
        String val1 = "1,2,3";
        System.out.println("Test 1 Expected:");
        System.out.println("descending order:3,2,1\n" +
                "ascending order:1,2,3\n" +
                "Min value is : 1\n" +
                "Max value is : 3");
        System.out.println("\n");
        System.out.println("Test 1 Actual:");
        haha.pushOperator(val1);
        System.out.println("--------------------");

        System.out.println("Test 2 Expected:");
        System.out.println("descending order:45,4,-32,-234\n" +
                "ascending order:-234,-32,4,45\n" +
                "Min value is : -234\n" +
                "Max value is : 45");
        String val2 = "4,-32,-234,45";
        System.out.println("\n");
        System.out.println("Test 2 Actual:");
        haha.pushOperator(val2);
        System.out.println("--------------------");

        System.out.println("Test 3 Expected:");
        System.out.println("descending order:99,76,2,0\n" +
                "ascending order:0,2,76,99\n" +
                "Min value is : 0\n" +
                "Max value is : 99");
        String val3 = "76,2,0,99";
        System.out.println("\n");
        System.out.println("Test 3 Actual:");
        haha.pushOperator(val3);
        System.out.println("--------------------");

        System.out.println("Test 4 Expected:");
        System.out.println("descending order:85,34,4,4,2,0,-89\n" +
                "ascending order:-89,0,2,4,4,34,85\n" +
                "Min value is : -89\n" +
                "Max value is : 85");
        String val4 = "85,2,34,4,4,0,-89";
        System.out.println("\n");
        System.out.println("Test 4 Actual:");
        haha.pushOperator(val4);
        System.out.println("--------------------");

    }

}