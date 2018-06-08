/**
 * Test Class for my stack and queue class
 * ADS 1 - Telematik - TH Wildau
 *
 * @author Roman Kobosil
 * @version 1.0, 29.03.17
 */
public class DataTypeTest {

    public static void main(String[] args) {

        //test my own stack class

        //stack class with generic types
        Stack<Integer> myStack = new Stack<>();

        System.out.println("myStack.isEmpty() check 1 should be true => " + myStack.isEmpty());

        for (int i = 1; i < 21; i++) {
            System.out.println("Can i add item " + i + "/" + Stack.MAX_ITEMS + "? Result: " + myStack.push(i));
        }

        //maximal of 20 items

        System.out.println("Can i add more than " + Stack.MAX_ITEMS + " items? Result: " + myStack.push(10000));

        System.out.println("myStack.isEmpty() check 2 should be false => " + myStack.isEmpty());

        //peek should not remove the items
        System.out.println("test peek should be 20 => " + myStack.peek());

        // end when stack is empty
        while (!myStack.isEmpty()) {
            //pop should remove the items
            System.out.println(myStack.pop());
        }

        System.out.println("myStack.isEmpty() check 3 should be true => " + myStack.isEmpty());


        //test my own queue class

        //stack class with generic types
        Queue<Integer> myQueue = new Queue<>();

        System.out.println("myQueue.isEmpty() check 1 should be true => " + myQueue.isEmpty());

        // add 5 items
        for (int i = 1; i < 6; i++) {
            System.out.println("enqueue item for index rotation test Result: " + myQueue.enqueue(i));
        }
        //remove 5 items, the virtual start index should be 5
        for (int i = 1; i < 6; i++) {
            //dequeue should remove the items
            System.out.println("dequeue:" + myQueue.dequeue());
        }

        //check the index rotation by adding 20 items
        for (int i = 1; i < 21; i++) {
            System.out.println("Can i enqueue item " + i + "/" + Queue.MAX_ITEMS + "? Result: " + myQueue.enqueue(i));
        }

        //maximal of 20 items

        System.out.println("Can i add more than " + Queue.MAX_ITEMS + " items? Result: " + myQueue.enqueue(10000));

        System.out.println("myQueue.isEmpty() check 2 should be false => " + myQueue.isEmpty());

        //peek should not remove the items
        System.out.println("test peek should be 1 => " + myQueue.peek());

        // end when queue is empty
        while (!myQueue.isEmpty()) {
            //dequeue should remove the items
            System.out.println("dequeue:" + myQueue.dequeue());
        }

        System.out.println("myQueue.isEmpty() check 3 should be true => " + myQueue.isEmpty());
    }
}
