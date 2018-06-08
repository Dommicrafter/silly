/**
 * My own stack class
 * ADS 1 - Telematik - TH Wildau
 *
 * @author Roman Kobosil
 * @version 1.0, 29.03.17
 */
public class Stack<T> {

    //set the maximum size
    public final static int MAX_ITEMS = 20;

    private Object[] array = new Object[MAX_ITEMS];
    //point on the next position in the array
    private int nextIndex = 0;

    /**
     * Add item to the stack, if MAX_ITEMS is not reached
     *
     * @param item the item to add
     * @return success
     */
    public boolean push(T item) {
        //check if MAX_ITEMS is reached
        if (nextIndex <= MAX_ITEMS - 1) {
            //fill next position --> add to stack
            array[nextIndex] = item;
            //increase the index counter
            nextIndex++;
            //return success
            return true;
        } else {
            return false;
        }
    }

    /**
     * Give the last item from stack and remove it from stack
     *
     * @return the last item on the stack
     */
    public T pop() {
        //check if stack contains item
        if (nextIndex > 0) {
            //go one index back
            nextIndex--;
            //get value
            T result = (T) array[nextIndex];
            //delete from array
            array[nextIndex] = null;
            //return
            return result;
        } else {
            return null;
        }
    }

    /**
     * Give the last item from stack
     *
     * @return the last item on the stack
     */
    public T peek() {
        //check if stack contains item
        if (nextIndex > 0) {
            //return last item from stack
            return (T) array[nextIndex - 1];
        } else {
            return null;
        }
    }

    /**
     * Check the stack contains items
     *
     * @return if the stack contains items
     */
    public boolean isEmpty() {
        //when next index is 0, the stack has no items
        return nextIndex == 0;
    }
}
