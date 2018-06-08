/**
 * My own queue class
 * ADS 1 - Telematik - TH Wildau
 *
 * @author Roman Kobosil
 * @version 1.0, 29.03.17
 */
public class Queue<T> {

    //set the maximum size
    public final static int MAX_ITEMS = 20;

    private Object[] array = new Object[MAX_ITEMS];
    //virtual start index
    private int startIndex = 0;
    //actual items count
    private int itemsCount = 0;

    /**
     * Add item to the end of the queue
     *
     * @param item the item
     * @return success
     */
    public boolean enqueue(T item) {
        //check if MAX_ITEMS is reached
        if (itemsCount < MAX_ITEMS) {
            /*add the item at the right position, starting at the virtual startIndex
              if needed rotate the index when reach MAX_ITEMS - 1 */
            array[(startIndex + itemsCount >= MAX_ITEMS ? (startIndex + itemsCount) - MAX_ITEMS : startIndex + itemsCount)] = item;
            //increase item counter
            itemsCount++;
            //success
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the first item from the queue and remove it (move the startIndex)
     *
     * @return first item from the queue
     */
    public T dequeue() {
        //check if queue contains item/s
        if (itemsCount > 0) {
            //get the item at startIndex
            T result = (T) array[startIndex];
            //clear array
            array[startIndex] = null;
            //move index, rotate the index when reach MAX_ITEMS - 1
            startIndex = nextIndex(startIndex);
            //decrease item counter
            itemsCount--;
            return result;
        } else {
            return null;
        }
    }

    /**
     * Get the first item from the queue
     *
     * @return first item from the queue
     */
    public T peek() {
        //check if queue contains item/s
        if (itemsCount > 0) {
            //get the item at startIndex
            return (T) array[startIndex];
        } else {
            return null;
        }
    }


    /**
     * Check the queue contains items
     *
     * @return if the stack contains items
     */
    public boolean isEmpty() {
        return itemsCount == 0;
    }

    /**
     * Get the next logical index, rotate if needed
     *
     * @param startIndex actual index
     * @return new index
     */
    private int nextIndex(int startIndex) {
        //if MAX_ITEMS is reached, reset the index
        if (startIndex + 1 == MAX_ITEMS) {
            return 0;
        } else {
            //next index
            return startIndex + 1;
        }
    }
}
