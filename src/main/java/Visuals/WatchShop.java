package Visuals;

import ClockClasses.Clock;
import ClockClasses.ClockWithSeconds;
import ClockClasses.IWatch;
import ClockClasses.States;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


        
import java.util.*;

public class WatchShop {

   private ArrayList<IWatch> listClocks = new ArrayList<>();

   public void AddWatch(){ listClocks.add(new Clock(0,"", 0,0)); }

   public void AddWatchSec(){ listClocks.add(new ClockWithSeconds(0,"", 0,0,0)); }

   public void ChangeNamePrice(int ind, String Name, int Price) {
       listClocks.get(ind).SetPrice(Price);
       listClocks.get(ind).SetName(Name);

   }
   
   public WatchShop(){};

    public void ChangeTime(int ind, int Hour,int Min,int Sec) {
        if(Hour >= 60 || Min >= 60 || Sec >= 60) throw new IllegalArgumentException("Incorrect min input");
        listClocks.get(ind).SetTimeValue(States.H, Hour);
        listClocks.get(ind).SetTimeValue(States.M, Min);
        try {listClocks.get(ind).SetTimeValue(States.S, Sec);}
        finally {return;}
    }


   public IWatch FindMostExpensive(){

       int temp = -1;
       IWatch temp_ = new ClockWithSeconds() ;

       for(IWatch listClock : listClocks){
            if(listClock.GetPrice() > temp){
                temp = listClock.GetPrice();
                temp_ = listClock;
            }
       }

       return temp_;
   }

   public String MostExpDes(){
       IWatch temp = FindMostExpensive();
       String Des = "";
       Des += "Most Expensive Watch in the shop\n";
       Des += "Name - " + temp.GetName() + '\n';
       Des += "Price - " + temp.GetPrice() + '\n';
       Des += "Time - " + temp.GetTime() + '\n';

       return Des;

   }

   public void AllWatchSetTime(int Hour, int Min, int Sec){
       for(IWatch listClock : listClocks){
            listClock.SetTimeValue(States.H, Hour);
            listClock.SetTimeValue(States.M, Min);
            try {listClock.SetTimeValue(States.S, Sec);}
            finally {return;}
       }
   }

   public String GetMostCommonMark(){

       Map<String, Integer> CountMap = new HashMap<>();
       int Counter = 0;
       for( IWatch listClock : listClocks){
           if(CountMap.get(listClock.GetName()) != null){
               CountMap.put(listClock.GetName(), CountMap.get(listClock.GetName()) + 1);
           }
           else CountMap.put(listClock.GetName(), 1);
       }
       return Collections.max(CountMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();

   }

   public ArrayList<String> GetAllMarksSorted(){
       ArrayList<String> Marks = new ArrayList<>();
       for( IWatch listClock : listClocks){
           if (!Marks.contains(listClock.GetName())) Marks.add(listClock.GetName());
       }
       Collections.sort(Marks);
       return Marks;
   }

    public ArrayList<String> GetAll(){
        ArrayList<String> Marks = new ArrayList<>();
        for( IWatch listClock : listClocks){
             Marks.add(listClock.GetName());
        }

        return Marks;
    }
    
    public String GetName(int ind){
        return (listClocks.get(ind)).GetName();
    }
    
    public String GetPrice(int ind){
        return Integer.toString((listClocks.get(ind)).GetPrice());
    }
    
    public String GetTime(int ind){
        return (listClocks.get(ind)).GetTime();
    }
    
    public int ShopSize(){
        return listClocks.size();
    }
    
    public void RemoveWatch(int ind){
        listClocks.remove(ind);
    }
    
    public void SaveToFile (String Path){
        
        try(FileWriter Writer = new FileWriter(Path, false))
        {
            Writer.write("JAVA Watch Shop\n\n");
            
            int counter = 1;
            for( IWatch listClock : listClocks){
                Writer.write("= " + (counter++) + " =" + '\n');
                Writer.write("Name: " + listClock.GetName() + '\n');
                Writer.write("Price: " + listClock.GetPrice() + '\n');
                Writer.write("Current time: " + listClock.GetTime() + '\n');
                Writer.append('\n');
                
                
             
            }
            
            if (counter == 1) Writer.write("EMPTY!");
           
             
            Writer.flush();
            Writer.close();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    } 
        
    
    public void GetFromFile(String Path){
        
        File file = new File(Path);     
        
        
        try(Scanner Scan = new Scanner(file)){
            
            String Buff, Name = "", Price = "", Time= "";
            
            while (Scan.hasNextLine()){
                Buff = Scan.nextLine();
                if (Buff.contains("Name")){
                    Name = Buff.replace("Name:", "");
                }
                if (Buff.contains("Price")){
                    Price = Buff.replace("Price:", "");
                }
                if (Buff.contains("Current time")){
                    Time = Buff.replace("Current time: ", "");
                    String[] timearr = Time.split(":");
                    if (timearr.length == 3){
                        listClocks.add(new ClockWithSeconds(Integer.parseInt(Price.trim()), 
                                Name, 
                                Integer.parseInt(timearr[0].trim()),
                                Integer.parseInt(timearr[1].trim()),
                                Integer.parseInt(timearr[2].trim())));
                    }
                    else{
                        listClocks.add(new Clock(Integer.parseInt(Price), 
                                Name, 
                                Integer.parseInt(timearr[0].trim()),
                                Integer.parseInt(timearr[1].trim()))); 
                    }
                    Name = ""; Time = ""; Price = ""; 
                        
                    
                }
                
                    
                    
                
            
            
            }
            
            
        
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
        
        
        
        
    }
    
    



}
