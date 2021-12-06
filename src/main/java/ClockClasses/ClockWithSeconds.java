package ClockClasses;

public class ClockWithSeconds extends Clock {

        protected int Sec = 0;

        public ClockWithSeconds(){}

        public ClockWithSeconds (int TPrice, String TName, int THour, int TMin, int TSec){
            Price = TPrice;
            Name = TName;
            SetValues(TSec, TMin, THour );
        }


        public final void AddTimeSecs(int TSec){
            if(TSec < 0) throw new IllegalArgumentException("AddTimeSecs argument exception");
            int AddSecs = Sec + TSec, AddMins = Min, AddHours = Hour;
            if (AddSecs >= 60) { AddMins += (int)(AddSecs / 60); AddSecs %= 60;}
            if (AddMins >= 60) { AddHours += AddMins / 60; AddMins %= 60;}
            if (AddHours >= 24) AddHours %= 24;
            SetValues(AddSecs, AddMins ,  AddHours );
        }


        private void SetValues(int TSec, int THour, int TMin){
            SetValues(TMin, THour);
            if (TSec  >= 60 || TSec < 0)  throw new IllegalArgumentException("Incorrect sec input");
            Sec = TSec;
        }

        @Override
        public void SetTime(int THour, int TMin, int TSec){
            SetValues (TSec, THour, TMin);
        }


        @Override
        public String GetTime(){
            return (Hour + " : " + Min + " : " + Sec);
        }

        @Override
        public void SetTimeValue(States Type, int Value){
            if (Type == States.H) Hour = Value;
            if (Type == States.M) Min = Value;
            if (Type == States.S) Sec = Value;
        }



}


