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
        for (int i = 0; i < 5; i++ ){
            circularBuffer.writeData("A" + i);
        }
        assertTrue("The buffer is not full, meaning that the bufferSize is not 5", circularBuffer.isFull());
    }

    @Test
    public void writing_A_to_buffer_should_read_A(){
        CircularBuffer<String> circularBuffer = new CircularBuffer<>();
        circularBuffer.writeData("A");
        circularBuffer.writeData("B");
        assertEquals("The retrieved data is not 'A'", "A", circularBuffer.readData());
        assertEquals("The retrieved data is not 'B'", "B", circularBuffer.readData());
    }

}