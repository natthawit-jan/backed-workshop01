import org.junit.Test;

import static org.junit.Assert.*;


public class HelloWorldTest {
    @Test
    public void sayHi_should_return_hello_World() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHiTo("world");
        assertEquals("Hello World", result);
    }


    public void sayHi_should_return_Hello_Natthawit() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHiTo("natthawit");
        assertEquals("Hello Natthawit", result);
    }
}