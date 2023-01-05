// By: Jacob Martin and David Novo

package cpsc2150.MyDeque;

/**
 * this class implements the IDeque interface using an array
 * IDeque is a double-sided que which resides inside the array myQ
 *
 * @invariant MAX_LENGTH = 100 and [values must be Double]
 * @correspondence MAX_LENGTH >= myLength and q = myQ
 */

public class ArrayDeque<T> extends AbsDeque<T> implements IDeque<T>{

    // where the data is stored. myQ[0] is the front of the deque
    private T[] myQ;
    // tracks how many items are in the deque
    // also used to find the end of the deque
    // is set to the first empty element of the deque
    private int myLength;
    // complete the class

    /**
     * this constructor declares an empty deque implemented as an array of type Double, with a max length of 100
     * AND sets myLength to 0
     * @post [myQ = new Double[MAX_LENGTH] AND myLength = 0]
     */
    public ArrayDeque()
    {
        myQ = (T[])new Object[MAX_LENGTH];
        myLength = 0;
    }
    public void enqueue(T x)
    {
        //sets last element to x
        //myLength is set to first empty element
        myQ[myLength] = x;
        myLength++;
    }
    public T dequeue()
    {
        //temp variable to hold first element
        T temp = myQ[0];
        //iterating from front of array and moving each element up by one
        int i = 0;
        while(i < myLength - 1)
        {
            myQ[i] = myQ[i + 1];
            i++;
        }
        myLength--;
        return temp;
    }
    public void inject(T x)
    {
        //iterates towards the first element from the last element of the array and shifts each element up by one
        int i = myLength;
        while(i > 0)
        {
            myQ[i] = myQ[i - 1];
            i--;
        }
        myLength++;
        myQ[0] = x;
    }
    public T removeLast()
    {
        myLength--;
        return myQ[myLength];
    }
    public int length()
    {
        return myLength;
    }
    public void clear()
    {
        myLength = 0;
    }
}
