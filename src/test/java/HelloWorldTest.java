import org.junit.Test;

import static org.junit.Assert.*;


public class HelloWorldTest {
    @Test
    public void sayHi_should_return_hello_world() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHiTo("world");
        assertEquals("Hello world", result);
    }


    public void sayHi_should_return_Hello_natthawit() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHiTo("natthawit");
        assertEquals("Hello natthawit", result);
    }
}