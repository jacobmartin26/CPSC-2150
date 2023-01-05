// By: Jacob Martin and David Novo

package cpsc2150.MyDeque;

import java.util.*;

/**
 * this class implements the IDeque interface using a list
 * IDeque is a double-sided que which resides inside the list myQ
 *
 * @invariant MAX_LENGTH = 100 and [values must be Double]
 * @correspondence MAX_LENGTH >= myLength and q = myQ
 */
public class ListDeque <T> extends AbsDeque <T> implements IDeque<T>{
    // this time store the deque in a list
    // myQ.get(0) is the front of the deque
    private List<T> myQ;

    // complete the class

    /**
     * Constructor that declares an empty deque implemented
     * as a list of type double
     *
     * @pre [myQ must have been initialized as a list]
     *
     * @post [myQ constructed] and [myQ is empty]
     */
    public ListDeque()
    {
        myQ = new ArrayList<T>();
        myQ.clear();
    }

    public void enqueue(T x)
    {
        myQ.add(x);
    }
    public T dequeue()
    {
        int index = 0;

        T temp = myQ.get(index);
        myQ.remove(index);

        return temp;
    }
    public void inject(T x)
    {
        int index = 0;

        myQ.add(index, x);
    }
    public T removeLast()
    {
        int index = myQ.size() - 1;
        T temp;

        temp = myQ.get(index);
        myQ.remove(index);

        return temp;
    }
    public int length()
    {
        return myQ.size();
    }
    public void clear()
    {
        myQ.clear();
    }

}
