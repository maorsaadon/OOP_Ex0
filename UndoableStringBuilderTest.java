package OOP_Ex1;

import OOP_Ex1.UndoableStringBuilder;

import static org.junit.jupiter.api.Assertions.*;

public class UndoableStringBuilderTest {

    /**
     * Test for the method <u>append</u>.
     */

    @org.junit.jupiter.api.Test
    void append() {
        //Create a new UndoableStringBuilder object for the test.
        UndoableStringBuilder usb = new UndoableStringBuilder();

        //Appending String to empty StringBuilder.
        //Expected: Test
        usb.append("Test ");
        assertEquals("Test ", usb.toString());

        //Appending String to a non-empty StringBuilder.
        //Expected: Test work
        usb.append("work ");
        assertEquals("Test work ",usb.toString());

        //Appending 'null' to a non-empty StringBuilder.
        //Expected: Test work null (should append the String 'null' as the method does at stringBuilder).
        usb.append(null);
        assertEquals("Test work null",usb.toString());

        //Appending empty String to a non-empty StringBuilder.
        //Expected: Test work null (shouldn't change a thing).
        String emptyString = "";
        usb.append(emptyString);
        assertEquals("Test work null",usb.toString());

        //Appending '\n' to a non-empty StringBuilder.
        //Expected: Test work null   (supposed to downline).
        //          addLine
        String addLine = "\naddLine";
        usb.append(addLine);
        assertEquals("Test work null\naddLine",usb.toString());


    }

    /**
     * Test for the method <u>delete</u>.
     */
    @org.junit.jupiter.api.Test
    void delete() {
        //Create a new UndoableStringBuilder object for the test.
        UndoableStringBuilder usb = new UndoableStringBuilder();

        //Delete from empty StringBuilder.
        //Expected:  (shouldn't change a thing).
        usb.delete(0, 100);
        assertEquals("", usb.toString());

        //Delete the first char from a non-empty StringBuilder.
        //Expected: Test (delete the first char)
        usb.append("1Test");
        usb.delete(0, 1);
        assertEquals("Test", usb.toString());

        //start index < 0.
        //Expected: Test (shouldn't change a thing and throw an error).
        usb.delete(-1, 1);
        assertEquals("Test", usb.toString());

        //start index > end index.
        //Expected: Test (shouldn't change a thing and throw an error).
        usb.delete(2,1);
        assertEquals("Test", usb.toString());

        //start index && end index - out of bounds.
        //Expected: Test (shouldn't change a thing and throw an error).
        usb.delete(5,10);
        assertEquals("Test", usb.toString());

        //start index = end index .
        //Expected: Test (shouldn't change a thing and throw an error).
        usb.delete(2,2);
        assertEquals("Test", usb.toString());

    }

    /**
     * Test for the method <u>insert</u>.
     */
    @org.junit.jupiter.api.Test
    void insert() {
        //Create a new UndoableStringBuilder object for the test.
        UndoableStringBuilder usb = new UndoableStringBuilder();
        //Insert empty String to empty StringBuilder
        //expected: (shouldn't change the StringBuilder)
        usb.insert(0, "");
        assertEquals("", usb.toString());

        //Insert the first word String to empty StringBuilder
        //expected: Test
        usb.insert(0, "Test");
        assertEquals("Test",usb.toString());

        //Insert String in the first index.
        //Expected: For Test.
        usb.insert(0,"For ");
        assertEquals("For Test",usb.toString());

        //Insert String in the last index.
        //Expected: For Test example.
        usb.insert(8," example");
        assertEquals("For Test example",usb.toString());

        //Insert String in the middle.
        //Expected: For 1 Test example.
        usb.insert(4,"1 ");
        assertEquals("For 1 Test example",usb.toString());

        //Insert String in index that out of bounds.
        //Expected: For 1 Test example(shouldn't change a thing and throw an error).
        usb.insert(20,"1 ");
        assertEquals("For 1 Test example",usb.toString());

        //Insert String in negative index.
        //Expected: For 1 Test example(shouldn't change a thing and throw an error).
        usb.insert(-1,"1 ");
        assertEquals("For 1 Test example",usb.toString());

        //Insert 'null'.
        //Expected: nullFor 1 Test example (should insert the String 'null' as the method does at stringBuilder).
        usb.insert(0,null);
        assertEquals("nullFor 1 Test example",usb.toString());

        //Insert empty String.
        //Expected: nullFor 1 Test example.
        String emptyString = "";
        usb.insert(0,emptyString);
        assertEquals("nullFor 1 Test example",usb.toString());

        //Insert '\n' to a non-empty StringBuilder.
        //Expected: nullFor 1 Test example   (supposed to downline).
        //          addLine
        String addLine = "\naddLine";
        usb.insert(0,addLine);
        assertEquals("nullFor 1 Test example\naddLine",usb.toString());

    }

    /**
     * Test for the method <u>replace</u>.
     */
    @org.junit.jupiter.api.Test
    void replace() {
        //Create a new UndoableStringBuilder object for the test.
        UndoableStringBuilder usb=new UndoableStringBuilder();

        //Replace an empty String with empty StringBuilder
        //expected: (shouldn't change the StringBuilder)
        usb.replace(0, 0, "");
        assertEquals("", usb.toString());

        //Replace the first word with empty StringBuilder
        //expected: Test
        usb.replace(0, 0, "Test");
        assertEquals("Test", usb.toString());

        //Replace with 'null' .
        //Expected: Test (shouldn't change a thing and throw an error).
        usb.replace(1,4,null);
        assertEquals("Test",usb.toString());
        //Replace the whole String .
        //Expected: For .

        usb.replace(0,4,"For");
        assertEquals("For",usb.toString());
        //index start = index end - in the start of the String .
        //Expected: TestFor.

        usb.replace(0,0,"Test");
        assertEquals("TestFor",usb.toString());

        //index start = index end - in the end of the String .
        //Expected: TestForTest.
        usb.replace(7,7,"Test");
        assertEquals("TestForTest",usb.toString());

        //index start = index end - out of bounds .
        //Expected: TestForTest(shouldn't change a thing and throw an error).
        usb.replace(13,30,"Test");
        assertEquals("TestForTest",usb.toString());

        //index start > index end .
        //Expected: TestForTest(shouldn't change a thing and throw an error).
        usb.replace(30,13,"Test");
        assertEquals("TestForTest",usb.toString());
        //index start < 0.
        //Expected: TestForTest(shouldn't change a thing and throw an error).
        usb.replace(-1,5,"Test");
        assertEquals("TestForTest",usb.toString());

        //Replace one char.
        //Expected: TestFurTest .
        usb.replace(5,6,"u");
        assertEquals("TestFurTest",usb.toString());

        //Replace with empty String.
        //Expected: TestFrTest.
        String emptyString = "";
        usb.replace(5,6,emptyString);
        assertEquals("TestFrTest",usb.toString());

        //Replace with '\n' .
        //Expected: TestFrTest   (supposed to downline).
        //          addLine
        String addLine = "\naddLine";
        usb.replace(9,10,addLine);
        assertEquals("TestFrTes\naddLine",usb.toString());

    }

    /**
     * Test for the method <u>reverse</u>.
     */
    @org.junit.jupiter.api.Test
    void reverse() {
        //Create a new UndoableStringBuilder object for the test.
        UndoableStringBuilder usb=new UndoableStringBuilder();

        //Reverse an empty StringBuilder
        //expected:
        usb.reverse();
        assertEquals("", usb.toString());

        //Reverse a non-empty StringBuilder
        //expected: tseT
        usb.append("Test");
        usb.reverse();
        assertEquals("tseT", usb.toString());

    }

    /**
     * Test for the method <u>undo</u>.
     */
    @org.junit.jupiter.api.Test
    void undo() {
        //Create a new UndoableStringBuilder object for the test.
        UndoableStringBuilder usb=new UndoableStringBuilder();

        //Undo to an empty StringBuilder
        //expected:
        usb.undo();
        assertEquals("", usb.toString());

        //Undo after the first change
        //expected:
        usb.append("Test");
        usb.undo();
        assertEquals("", usb.toString());

        //undo after two changes
        //expected: undo
        usb.append("undo");
        usb.reverse();
        usb.undo();
        assertEquals("undo", usb.toString());

    }
}
