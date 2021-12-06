
import Visuals.WatchShop;

public class Main {
    public static void main(String[] args) {

        WatchShop WS = new WatchShop();
        int WatchCount = 25;

        for (int i = 0; i < WatchCount; i++){

            if ((i % 2 == 0)) {
                WS.AddWatch();
            } else {
                WS.AddWatchSec();
            }

        }

        WS.AllWatchSetTime(1,15,30);

        for (int i = 0; i < WatchCount ; i++){
            if (i < 8) {
               WS.ChangeNamePrice(i,"Gold", 15550);
            } else {
                WS.ChangeNamePrice(i,"Silver", 3200);
            }
        }
        WS.ChangeNamePrice(1,"Apple", 555555555);
        WS.ChangeTime(1, 1, 22 ,35);
        WS.ChangeNamePrice(15,"Diamond", 356000);
        WS.ChangeNamePrice(13,"Bronze", 180005);
        WS.ChangeNamePrice(14,"Bronze", 559900);
        WS.ChangeNamePrice(12,"Bronze MX", 1212333);
        WS.ChangeNamePrice(7,"Zyxel", 320000);

        System.out.println(WS.GetMostCommonMark());
        System.out.println( WS.MostExpDes());
        System.out.println( WS.GetAllMarksSorted());
        System.out.println( WS.GetAll());
    }
}
