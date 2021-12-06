/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuals;

import java.util.ArrayList;

/**
 *
 * @author evgeniy.kozinov
 */
public class Model {
  WatchShop WS = new WatchShop();
  ArrayList<IObserver> o = new ArrayList<>();
  
  public void addO(IObserver obj)
  {
    o.add(obj);
  }
  
  public void add(String name, String price, int h, int m, int s){
    WS.AddWatchSec();
    WS.ChangeNamePrice(WS.ShopSize() - 1, name, Integer.parseInt(price));
    WS.ChangeTime(WS.ShopSize() - 1, h, m, s);
    event();
  }
  
  public  void remove(int ind)
  {
    WS.RemoveWatch(ind);
    event();
  }
  
  void event()
  {
    for (IObserver obj : o) {
      obj.event(this);
    }
  }
  
    WatchShop GetShop(){
      return WS;
    }
    
    public void SetTime(int h, int m, int s, int ind){
        WS.ChangeTime(ind, h, m ,s);
    }
    
    void reval(){
        event();
    }
  

  
}
