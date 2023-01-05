// By: Jacob Martin and David Novo

package cpsc2150.MyDeque;

/**
 * Abstract class that contains
 * overridden implementation of toString()
 */
public abstract class AbsDeque<T> implements IDeque<T>
{
    /**
     * Returns a string representation of the object.
     * In general, the toString method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation
     *
     * @pre None
     *
     * @post toString = [String representation of deque] and this = #this
     *
     * @return returns string representation of the deque
     */
    @Override
    public String toString()
    {
        String deque = "<";

        //print deque
        for (int i = 0; i < this.length(); i++)
        {
            if (i != this.length() - 1)
            {
                deque += this.get(i + 1) + ", ";
            }
            else
            {
                deque += this.get(i + 1);
            }
        }
        deque += ">";

        return deque;
    }
}
