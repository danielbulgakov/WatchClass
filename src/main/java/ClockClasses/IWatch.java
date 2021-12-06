package ClockClasses;

public interface IWatch{

    String GetName () ;
    int GetPrice() ;
    String GetTime();

    void SetTimeValue(States Type, int Value);

    void SetName(String TName);
    void SetPrice(int TPrice);


}

