import org.example.Exception.ElementNotFoundException;
import org.example.Exception.InvalidIndexException;
import org.example.Exception.NullItemException;
import org.example.Exception.StorageIsFullException;
import org.example.IntegerList;
import org.example.IntegerListImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegerListTest {

    private IntegerListImpl integerList;

    @BeforeEach
    public void setUp() {
        integerList = new IntegerListImpl();
    }

    @Test
    void addTest() {
        integerList.add(123);
        assertEquals(1, integerList.size());
        assertTrue(integerList.contains(123));
    }

    @Test
    void addForIndexTest() {
        integerList.add(222);
        integerList.add(333);
        integerList.add(1, 444);
        assertEquals(222, integerList.get(0));
        assertEquals(444, integerList.get(1));
        assertEquals(333, integerList.get(2));
        assertEquals(3, integerList.size());
    }

    @Test
    void removeTest() {
        integerList.add(1);
        integerList.remove(1);
        assertTrue(integerList.isEmpty());
    }

    @Test
    void indexOfTest() {
        integerList.add(123);
        integerList.add(1234);
        integerList.add(12345);
        assertEquals(0, integerList.indexOf(123));
        assertEquals(1, integerList.indexOf(1234));
        assertEquals(2, integerList.lastIndexOf(12345));
        assertEquals(-1, integerList.indexOf(666));
    }


    @Test
    void clearTest() {
        integerList.add(123);
        integerList.add(456);
        integerList.clear();
        assertTrue(integerList.isEmpty());
    }




    @Test
    void add_InvalidIndexExceptionTest() {
        assertThrows(InvalidIndexException.class, () ->
                integerList.add(-1, 222));
    }

    @Test
    void add_ItemCannotBeNullException() {
        assertThrows(NullItemException.class, () ->
                integerList.add(null));
    }

    @Test
    void set_NullItemExceptionTest() {
        integerList.add(1);
        assertThrows(NullItemException.class, () ->
                integerList.set(0, null));

    }


}


