import org.example.Exception.ElementNotFoundException;
import org.example.Exception.InvalidIndexException;
import org.example.Exception.NullItemException;
import org.example.Exception.StorageIsFullException;
import org.example.StringList;
import org.example.StringListImpil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StringListTest {
    private StringListImpil stringList;

    @BeforeEach
    public void setUp() {
        stringList = new StringListImpil();
    }

    @Test
    void addTest() {
        stringList.add("AAA");
        assertEquals(1, stringList.size());
        assertTrue(stringList.contains("AAA"));
    }

    @Test
    void addForIndexTest() {
        stringList.add("BBB");
        stringList.add("CCC");
        stringList.add(1, "DDD");
        assertEquals("BBB", stringList.get(0));
        assertEquals("DDD", stringList.get(1));
        assertEquals("CCC", stringList.get(2));
        assertEquals(3, stringList.size());
    }
    @Test
    void removeTest(){
        stringList.add("EEE");
        stringList.remove("EEE");
        assertTrue(stringList.isEmpty());
    }
    @Test
    void indexOfTest() {
        stringList.add("Sveta");
        stringList.add("Anna");
        stringList.add("Marina");
        assertEquals(0, stringList.indexOf("Sveta"));
        assertEquals(1, stringList.indexOf("Anna"));
        assertEquals(2, stringList.lastIndexOf("Marina"));
        assertEquals(-1, stringList.indexOf("Bob"));
    }

    @Test
    void equalsTest() {
        StringList otherList = new StringListImpil();
        stringList.add("Hello");
        otherList.add("Hello");
        assertTrue(stringList.equals(otherList));
    }

    @Test
    void clearTest() {
        stringList.add("Hello");
        stringList.add("World");
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

    @Test
    void add_StorageIsFullExceptionTest() {
        for (int i = 0; i < 10; i++) {
            stringList.add("Item " + i);
        }
        assertThrows(StorageIsFullException.class, () ->
                stringList.add("Extra Item"));
    }

    @Test
    void add_InvalidIndexExceptionTest() {
        assertThrows(InvalidIndexException.class, () ->
                stringList.add(-1, "Sasha"));
    }

    @Test
    void add_ItemCannotBeNullException() {
        assertThrows(NullItemException.class, () ->
                stringList.add(null));
    }

    @Test
    void set_NullItemExceptionTest() {
       stringList.add("Hi");
       assertThrows(NullItemException.class,()->
               stringList.set(0,null));

    }

    @Test
    void remove_ElementNoFoundExceptionTest() {
        assertThrows(ElementNotFoundException.class, () ->
                stringList.remove("Sasha"));
    }
}




