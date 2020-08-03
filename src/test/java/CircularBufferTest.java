import org.junit.Test;

import static org.junit.Assert.*;

public class CircularBufferTest {

    @Test
    public void create_new_buffer_should_be_empty() {
        CircularBuffer<String> circularBuffer = new CircularBuffer<>();
        // When the write and read pointer point to the same
        boolean isEmpty = circularBuffer.isEmpty();
        assertTrue("The buffer is not empty", isEmpty);
    }

    @Test
    public void newly_created_buffer_should_be_five() {
        CircularBuffer<String> circularBuffer = new CircularBuffer<>();
        for (int i = 0; i < 5; i++) {
            circularBuffer.writeData("A" + i);
        }
        assertTrue("The buffer is not full, meaning that the bufferSize is not 5", circularBuffer.isFull());
    }

    @Test
    public void writing_A_to_buffer_should_read_A() throws Exception {
        CircularBuffer<String> circularBuffer = new CircularBuffer<>();
        circularBuffer.writeData("A");
        circularBuffer.writeData("B");
        assertEquals("The retrieved data is not 'A'", "A", circularBuffer.readData());
        assertEquals("The retrieved data is not 'B'", "B", circularBuffer.readData());
    }

    @Test
    public void write_pointer_should_wrap_around_the_buffer() throws Exception {
        CircularBuffer<String> circularBuffer = new CircularBuffer<>();
        for (int i = 0; i < 4; i++) {
            circularBuffer.writeData("A" + i);
        }
        assertEquals("The first read is not A0", "A0", circularBuffer.readData());
        //the writer pointer goes back

        circularBuffer.writeData("A4");
        circularBuffer.writeData("B0"); //Read pointer now is the same as write pointer now
        String result = null;
        for (int i = 0; i < 5; i++) {
            result = circularBuffer.readData();
        }
        assertEquals("This read data is not B0", "B0", result);
    }

    @Test
    public void linearly_read_data_should_be_correct() throws Exception {
        CircularBuffer<String> circularBuffer = new CircularBuffer<>();
        for (int i = 0; i < 4; i++) {
            circularBuffer.writeData("A" + i);
        }
        assertEquals("1st data is not A0", "A0", circularBuffer.readData());
        assertEquals("1st data is not A1", "A1", circularBuffer.readData());
        assertEquals("1st data is not A2", "A2", circularBuffer.readData());
        assertEquals("1st data is not A3", "A3", circularBuffer.readData());

    }


    @Test
    public void when_the_buffer_is_full_the_oldest_object_will_get_evicted() throws Exception {
        CircularBuffer<String> circularBuffer = new CircularBuffer<>();
        for (int i = 0; i < 5; i++) {
            circularBuffer.writeData("A" + i);
        }
        assertTrue("The buffer is still not full", circularBuffer.isFull());
        // Evicted the oldest one and replaced it with the new value
        circularBuffer.writeData("New data");
        String result = null;
        for (int i = 0; i < 5; i++) {
            result = circularBuffer.readData();
        }
        assertEquals("The new data didn't replace the old", "New data", result);
    }

    @Test(expected = Exception.class)
    public void reading_from_newly_created_buffer_should_throw_exception() throws Exception {
        CircularBuffer<String> circularBuffer = new CircularBuffer<>();
        circularBuffer.readData();
    }


}