import java.util.LinkedList;
import java.util.List;

public class CircularBuffer<T> {

    private final int BUFFER_SIZE = 5;
    private int countElement;
    private final List<T> buffer;
    private int readPointer;
    private int writePointer;

    public CircularBuffer() {
        buffer = new LinkedList<>();
        countElement = 0;
        readPointer = 0;
        writePointer = 0;
    }

    public boolean isEmpty() {
        return countElement == 0;
    }

    public void writeData(T s) {
        buffer.add(writePointer, s);
        if (isFull()) {
            incrementReadPointer();
        } else {
            countElement++;
        }
        incrementWritePointer();
    }

    private void incrementWritePointer() {
        writePointer = (writePointer + 1) % BUFFER_SIZE;
    }

    private void incrementReadPointer() {
        readPointer = (readPointer + 1) % BUFFER_SIZE;
    }

    public boolean isFull() {
        return writePointer == readPointer && countElement == BUFFER_SIZE;
    }

    public T readData() throws Exception {
        if (isEmpty()) throw  new Exception("The buffer is empty");
        T result = buffer.get(readPointer);
        incrementReadPointer();
        countElement--;
        return result;
    }
}
