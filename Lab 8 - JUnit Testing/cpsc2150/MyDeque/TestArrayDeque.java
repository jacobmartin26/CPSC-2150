package cpsc2150.MyDeque;

import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class TestArrayDeque {

    //test_Lower_Boundary will test only adding 1 element
    // and then checking whatever operation/string needs
    // to be checked

    //test_Upper does the same except at the final element
    // as max length is 100, so it will perform the operations
    // on the final element

    //test_Routine does the test somewhere in the middle
    static final Double EPSILON = 0.0001;
    private IDeque<Double> MakeADeque(){
        IDeque<Double> z = new ArrayDeque<Double>();
        return z;
    }

    @Test
    public void testEnqueue_Lower_Boundary(){
        IDeque testQ = MakeADeque();

        testQ.enqueue(1.0);
        String expected = "<1.0>";

        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testEnqueue_Upper_Boundary(){
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 100; i++)
        {
            testQ.enqueue(1.0);
            if(i == 99)
            {
                expected += "1.0>";
            }
            else
            {
                expected += "1.0, ";
            }
        }
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testEnqueue_Routine()
    {
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 50; i++)
        {
            testQ.enqueue(1.0);
            if(i == 49)
            {
                expected += "1.0>";
            }
            else
            {
                expected += "1.0, ";
            }
        }
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testDequeue_Upper_Bound(){
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 100; i++)
        {
            testQ.enqueue((double)i);
            if(i > 0 && i < 99)
            {
                expected += (double)i + ", ";
            }
            else if(i == 99)
            {
                expected += (double)i + ">";
            }
        }
        Double returnValue = (Double)testQ.dequeue();
        Double expectedVal = 0.0;
        assertEquals(returnValue, expectedVal, EPSILON);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testDequeue_Lower_Bound()
    {
        IDeque testQ = MakeADeque();

        testQ.enqueue(1.0);
        String expected = "<>";
        Double expDouble = 1.0;

        Double returned = (Double)testQ.dequeue();
        assertEquals(returned, expDouble, EPSILON);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testDequeue_Routine()
    {
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 50; i++)
        {
            testQ.enqueue((double)i);
            if(i > 0 && i < 49)
            {
                expected += (double)i + ", ";
            }
            else if(i == 49)
            {
                expected += (double)i + ">";
            }
        }
        Double returnValue = (Double)testQ.dequeue();
        Double expectedVal = 0.0;
        assertEquals(returnValue, 0.0, EPSILON);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testInject_Lower_Bound(){
        IDeque testQ = MakeADeque();

        testQ.inject(1.0);
        String expected = "<1.0>";

        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testInject_Upper_Bound()
    {
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 100; i++)
        {
            testQ.inject(1.0);
            if(i == 99)
            {
                expected += "1.0>";
            }
            else
            {
                expected += "1.0, ";
            }
        }
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testInject_Routine(){
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 50; i++)
        {
            testQ.inject(1.0);
            if(i == 49)
            {
                expected += "1.0>";
            }
            else
            {
                expected += "1.0, ";
            }
        }
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testRemoveLast_Lower_Bound()
    {
        IDeque testQ = MakeADeque();

        testQ.enqueue(1.0);
        String expected = "<>";
        Double expDouble = 1.0;

        Double returned = (Double)testQ.removeLast();
        assertEquals(returned, expDouble, EPSILON);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testRemoveLast_Upper_Bound()
    {
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 100; i++)
        {
            testQ.enqueue((double)i);
            if(i >= 0 && i < 98)
            {
                expected += (double)i + ", ";
            }
            else if(i == 98)
            {
                expected += (double)i + ">";
            }
        }
        Double returnValue = (Double)testQ.removeLast();
        Double expectedVal = 99.0;
        assertEquals(returnValue, expectedVal, EPSILON);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testRemoveLast_Routine()
    {
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 50; i++)
        {
            testQ.enqueue((double)i);
            if(i >= 0 && i < 48)
            {
                expected += (double)i + ", ";
            }
            else if(i == 48)
            {
                expected += (double)i + ">";
            }
        }
        Double returnValue = (Double)testQ.removeLast();
        Double expectedVal = 49.0;
        assertEquals(returnValue, expectedVal, EPSILON);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testClear_Lower_Boundary(){
        IDeque testQ = MakeADeque();

        testQ.enqueue(1.0);
        testQ.clear();
        String expected = "<>";

        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testClear_Upper_Boundary(){
        IDeque testQ = MakeADeque();

        String expected = "<>";
        for (int i = 0; i < 100; i++)
        {
            testQ.enqueue((double)i);
        }
        testQ.clear();
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testClear_Routine(){
        IDeque testQ = MakeADeque();

        String expected = "<>";
        for (int i = 0; i < 50; i++)
        {
            testQ.enqueue((double)i);
        }
        testQ.clear();
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testPeek_Lower_Bound()
    {
        IDeque testQ = MakeADeque();

        testQ.enqueue(1.0);
        String expected = "<1.0>";
        Double expDouble = 1.0;

        Double returned = (Double)testQ.peek();
        assertEquals(returned, expDouble, EPSILON);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testPeek_Upper_Boundary(){
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 100; i++)
        {
            testQ.enqueue((double)i);
            if(i == 99)
            {
                expected += (double)i + ">";
            }
            else
            {
                expected += (double)i + ", ";
            }
        }
        Double expDouble = 0.0;
        Double returned = (Double)testQ.peek();
        assertEquals(returned, expDouble);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testPeek_Routine(){
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 50; i++)
        {
            testQ.enqueue((double)i);
            if(i == 49)
            {
                expected += (double)i + ">";
            }
            else
            {
                expected += (double)i + ", ";
            }
        }
        Double expDouble = 0.0;
        Double returned = (Double)testQ.peek();
        assertEquals(returned, expDouble);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testEndOfDeque_Lower_Bound()
    {
        IDeque testQ = MakeADeque();

        testQ.enqueue(1.0);
        String expected = "<1.0>";
        Double expDouble = 1.0;

        Double returned = (Double)testQ.endOfDeque();
        assertEquals(returned, expDouble, EPSILON);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testEndOfDeque_Upper_Bound(){
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 100; i++)
        {
            testQ.enqueue((double)i);
            if(i == 99)
            {
                expected += (double)i + ">";
            }
            else
            {
                expected += (double)i + ", ";
            }
        }
        Double expDouble = 99.0;
        Double returned = (Double)testQ.endOfDeque();
        assertEquals(returned, expDouble);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testEndOfDeque_Routine(){
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 50; i++)
        {
            testQ.enqueue((double)i);
            if(i == 49)
            {
                expected += (double)i + ">";
            }
            else
            {
                expected += (double)i + ", ";
            }
        }
        Double expDouble = 49.0;
        Double returned = (Double)testQ.endOfDeque();
        assertEquals(returned, expDouble);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testInsert_Lower_Bound()
    {
        IDeque testQ = MakeADeque();

        testQ.insert(1.0, 1);
        String expected = "<1.0>";

        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testInsert_Upper_Bound()
    {
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 100; i++)
        {
            if(i < 99)
            {
                expected += (double)i + ", ";
                testQ.enqueue((double) i);
            }
            else if(i == 99)
            {
                testQ.insert((double)i, 100);
                expected += (double)i + ">";
            }
        }
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testInsert_Routine()
    {
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 50; i++)
        {
            if(i < 49)
            {
                expected += (double)i + ", ";
                testQ.enqueue((double) i);
            }
            else if(i == 49)
            {
                testQ.insert((double)i, 50);
                expected += (double)i + ">";
            }
        }
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testRemove_Lower_Bound()
    {
        IDeque testQ = MakeADeque();

        testQ.enqueue(1.0);
        String expected = "<>";
        Double expDouble = 1.0;

        Double returned = (Double)testQ.remove(1);
        assertEquals(returned, expDouble, EPSILON);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testRemove_Upper_Bound()
    {
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 100; i++)
        {
            testQ.enqueue((double)i);
            if(i >= 0 && i < 98)
            {
                expected += (double)i + ", ";
            }
            else if(i == 98)
            {
                expected += (double)i + ">";
            }
        }
        Double returnValue = (Double)testQ.remove(100);
        Double expectedVal = 99.0;
        assertEquals(returnValue, expectedVal, EPSILON);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testRemove_Routine()
    {
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 50; i++)
        {
            testQ.enqueue((double)i);
            if(i >= 0 && i < 48)
            {
                expected += (double)i + ", ";
            }
            else if(i == 48)
            {
                expected += (double)i + ">";
            }
        }
        Double returnValue = (Double)testQ.remove(50);
        Double expectedVal = 49.0;
        assertEquals(returnValue, expectedVal, EPSILON);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testGet_Lower_Bound()
    {
        IDeque testQ = MakeADeque();

        testQ.insert(1.0, 1);
        String expected = "<1.0>";

        Double returnValue = (Double)testQ.get(1);
        Double expectedVal = 1.0;
        assertEquals(returnValue, expectedVal, EPSILON);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testGet_Upper_Bound()
    {
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 100; i++)
        {
            if(i < 99)
            {
                expected += (double)i + ", ";
                testQ.enqueue((double) i);
            }
            else if(i == 99)
            {
                testQ.insert((double)i, 100);
                expected += (double)i + ">";
            }
        }
        Double returnValue = (Double)testQ.get(100);
        Double expValue = 99.0;
        assertEquals(returnValue, expValue, EPSILON);
        assertTrue(testQ.toString().equals(expected));
    }

    @Test
    public void testGet_Routine()
    {
        IDeque testQ = MakeADeque();

        String expected = "<";
        for (int i = 0; i < 50; i++)
        {
            if(i < 49)
            {
                expected += (double)i + ", ";
                testQ.enqueue((double) i);
            }
            else if(i == 49)
            {
                testQ.insert((double)i, 50);
                expected += (double)i + ">";
            }
        }
        Double returnValue = (Double)testQ.get(50);
        Double expValue = 49.0;
        assertEquals(returnValue, expValue, EPSILON);
        assertTrue(testQ.toString().equals(expected));
    }
}
