// By: Jacob Martin and David Novo

package cpsc2150.MyDeque;
/**
 * A deque containing floating-point numbers.
 * A deque is a data structure a double-ended queue that allows you
 * to insert and remove from both ends.
 * This deque is bounded by MAX_LENGTH
 *
 * Initialization ensures: Deque is empty and has length of MAX_LENGTH
 * Defines: MAX_LENGTH: Z
 * Constraints: 0 <= myLength <= MAX_LENGTH
 */

public interface IDeque <T> {
    public static final int MAX_LENGTH = 100;

    /**
     * Adds x to the end of the deque
     * @pre [deque must be initialized AND have enough space]
     * @post [x at end of deque] and myLength++
     * @param x = value added to end of deque
     */
    public void enqueue(T x);

    /**
     * Removes the double at the front of the deque
     * @pre [deque must be initialized and have value to remove]
     * @post [double at front returned] and myLength--
     * @return Returns the double at the front of the deque
     */
    public T dequeue();

    /**
     * Adds x to the front of the deque
     * @pre [deque must be initialized AND have enough space]
     * @post [x at front of deque] and myLength++
     * @param x = value added to front of deque
     */
    public void inject(T x);

    /**
     * Removes the double at the end of the deque
     * @pre [deque must be initialized and have value to remove]
     * @post [double at end returned] and myLength--
     * @return Returns double at the end of the deque
     */
    public T removeLast();

    /**
     * Displays length of the deque
     * @pre [deque must be initialized]
     * @post [Length returned]
     * @return Returns number of double in the deque
     */
    public int length();

    /**
     * Clears the entire deque
     * @pre [deque must be initialized]
     * @post [deque is empty]
     */
    public void clear();

    /**
     * returns the floating point number at front of deque
     * but does not remove it
     *
     * @pre [deque must have been initialized] and
     *      [deque must have a value at front to return]
     *
     * @post [Double at front returned] and deque = #deque
     *       and length = #length
     *
     * @return returns number at front of deque
     */
    default T peek()
    {
        return get(1);
    }

    /**
     * returns floating point number at the end of deque
     * but does not remove it
     *
     * @pre [deque must have been initialized] and
     *      [deque must have value at end to return]
     *
     * @post [Double at end returned] and deque = #deque
     *       and length = #length
     *
     * @return returns number at front of deque
     */
    default T endOfDeque()
    {
        return get(length());
    }

    /**
     * inserts x at pos in the deque, pos starts at 1 so
     * front item in deque is pos 1
     *
     * @pre [deque must have been initialized] and
     *      [deque must not be full] and
     *      [values passed in must be valid]
     *
     * @post length++ and [x place at pos in deque]
     *
     * @param x = value to be placed in deque
     * @param pos = position in deque to place x
     */
    default void insert(T x, int pos)
    {
        T temp;
        for(int i = 1; i < pos; i++)
        {
            temp = dequeue();
            enqueue(temp);
        }

        enqueue(x);

        for(int j = pos; j < length(); j++)
        {
            temp = dequeue();
            enqueue(temp);
        }
    }

    /**
     * removes the floating point number at pos in the
     * deque and returns it
     *
     * @pre [deque must have been initialized] and
     *      [deque must have a value at pos to remove]
     *      [pos must be valid]
     *
     * @post length-- and [value at pos removed in deque]
     *
     * @param pos = position in deque where value is removed
     *
     * @return returns value removed at pos
     */
    default T remove(int pos)
    {
        T temp;
        T temp2 = null;

        if(pos == 1)
        {
            temp2 = dequeue();
        }
        else if (pos == length())
        {
            temp2 = removeLast();
        }
        else
        {
            for(int i = 1; i <= length(); i++)
            {
                if(i == pos && pos == length() - 1)
                {
                    temp2 = dequeue();
                    temp = dequeue();

                    enqueue(temp);
                }
                else if(i == pos && pos != length() - 1)
                {
                    temp2 = dequeue();
                    temp = dequeue();

                    enqueue(temp);
                }
                else
                {
                    temp = dequeue();
                    enqueue(temp);
                }
            }
        }
        return temp2;
    }

    /**
     * returns floating point number at pos in deque
     * but does not remove it
     *
     * @pre [deque must be initialized] and
     *      [deque must have value at pos to return] and
     *      [pos must be valid type]
     *
     * @post [value at pos in deque returned] and
     *       length = #length and deque = #deque
     *
     * @param pos = position in deque where value is received
     *
     * @return returns value that is at pos in deque
     */
    default T get(int pos)
    {
        T temp = null;
        T temp2;

        for(int i = 1; i <= pos; i++)
        {
            temp = dequeue();
            enqueue(temp);
        }

        temp2 = temp;

        for(int i = pos; i < length(); i++)
        {
            temp = dequeue();
            enqueue(temp);
        }
        return temp2;
    }
}
