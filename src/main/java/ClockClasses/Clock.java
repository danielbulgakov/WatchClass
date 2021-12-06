package ClockClasses;



public class Clock implements IWatch {

    protected int  Min = 0, Hour = 0;

    int Price = 0 ;
    String Name = "";

    public Clock(){};
    

    public Clock (int TPrice, String TName, int THour, int TMin){
        Price = TPrice;
        Name = TName;
        SetValues(TMin, THour );
    }

    public void  AddTimeMins (int TMin){
        if(TMin < 0) throw new IllegalArgumentException("AddTimeMins argument exception");
        int AddMins = Min + TMin, AddHours = Hour;
        if (AddMins >= 60) { AddHours += AddMins / 60; AddMins %= 60;}
        if (AddHours >= 24) AddHours %= 24;
        SetValues(AddMins ,  AddHours );
    }

    public void  AddTimeHours (int THour){
        if(THour < 0) throw new IllegalArgumentException("AddTimeHours argument exception");
        SetValues(Min , (Hour + THour) % 24 );
    }

    protected void SetValues (int TMin, int THour){
        if (TMin  >= 60 || TMin < 0)  throw new IllegalArgumentException("Incorrect min input");
        if (THour >= 24 || THour < 0)  throw new IllegalArgumentException("Incorrect hour input");
        Min = TMin; Hour = THour;
    }

    public void SetTime(int THour, int TMin, int TSec){
        SetValues (TMin, THour);
    }

    public void SetTime(int THour, int TMin){
        SetValues (TMin, THour);
    }

    public String GetName () {return Name;}

    public int GetPrice() {return Price;}

    public String GetTime(){
        return(Hour + " : " + Min );
    }

    public void SetName(String TName){ Name = TName;}
    public void SetPrice(int TPrice) {Price = TPrice;}



    public void SetTimeValue(States Type, int Value){
        if (Type == States.H) Hour = Value;
        if (Type == States.M) Min = Value;
    }




}
