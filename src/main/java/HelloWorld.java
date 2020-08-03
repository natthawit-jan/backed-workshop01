public class HelloWorld {
    public String sayHiTo(String sayHiWith){
        String result = sayHiWith.substring(0, 1).toUpperCase() + sayHiWith.substring(1);
        return String.format("Hello %s", result);
    }

}