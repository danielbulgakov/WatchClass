package ClockClasses;

public class MyException  extends Exception {
    public MyException(States State, String Message) {
        super(State.toString() + " " +  Message + " Failure");


    }
}


