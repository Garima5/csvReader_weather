
/**
 * Write a description of CSVtemperature here.
 * Program to read weather files and retrieve data
 * @author Garima Aggarwal
 * 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class CSVtemperature {
     public CSVRecord hottesthour(CSVParser parser)
    {
         //returns hottest temperature and its time on the selected day
        CSVRecord largestsofar=null;
        for(CSVRecord currentRow :parser)
        {
            if (largestsofar==null)
            {
                largestsofar=currentRow;
            }
            else{
                double currentTemp=Double.parseDouble(currentRow.get("TemperatureF"));
                 double largetsTemp=Double.parseDouble(largestsofar.get("TemperatureF"));
                 if(currentTemp>largetsTemp)
                 {
                     largestsofar=currentRow;
                    }
                
                
            }
        }
        return largestsofar;
    }
    public void tester_hottest()
    {
        //prints hottest temperature and its time on the selected day
        FileResource fr=new FileResource();
        CSVRecord largest=hottesthour(fr.getCSVParser());
        System.out.println("Hottest Temperature was : "+largest.get("TemperatureF")+ " at : " +largest.get("TimeEST"));
        
    }
     public CSVRecord hottest_in_multiple()
     {
         //returns hottest temperature among multiple days that are selected
         CSVRecord largestSoFar=null;
         DirectoryResource dr=new DirectoryResource();//To select a directory
         for(File f:dr.selectedFiles())
         {
             FileResource fr=new FileResource(f);
             CSVRecord currentRow= hottesthour(fr.getCSVParser());
             
             if (largestSoFar==null)
            {
                largestSoFar=currentRow;
            }
            else{
                double currentTemp=Double.parseDouble(currentRow.get("TemperatureF"));
                 double largetsTemp=Double.parseDouble(largestSoFar.get("TemperatureF"));
                 if(currentTemp>largetsTemp)
                 {
                     largestSoFar=currentRow;
                    }
                
                
            }          
                
         
        }
        return largestSoFar;   
    
}
public void tester_hottest_many()
    {
        //prints hottest temperature among multiple days that are selected
        CSVRecord largest=hottest_in_multiple();
        System.out.println("Hottest Temperature was : "+largest.get("TemperatureF")+ " at : " +largest.get("DateUTC"));
        
    }
    public CSVRecord coldesthour(CSVParser parser)
    {
        //returns hottest temperature and its time on the selected day
        CSVRecord smallestsofar=null;
        for(CSVRecord currentRow :parser)
        {
            if (smallestsofar==null)
            {
                smallestsofar=currentRow;
            }
            else{
                double currentTemp=Double.parseDouble(currentRow.get("TemperatureF"));
                 double smallestTemp=Double.parseDouble(smallestsofar.get("TemperatureF"));
                 if(currentTemp<smallestTemp)
                 {
                     smallestsofar=currentRow;
                    }
                
                
            }
        }
        return smallestsofar;
    }
     public void tester_coldest()
    {
        //prints hottest temperature and its time on the selected day
        FileResource fr=new FileResource();
        CSVRecord smallest=coldesthour(fr.getCSVParser());
        System.out.println("Coldest Temperature was : "+smallest.get("TemperatureF"));
       
        
    }

    public CSVRecord lowestHumidityInFile (CSVParser parser)
    {
        //To return lowest humidity in a file
        CSVRecord lowestHumidity=null;
        int i=0;        
        for(CSVRecord currentRow :parser)
        {           
            
              if (lowestHumidity==null)
            {
                lowestHumidity=currentRow;
            }
            else{
                 String currentH=currentRow.get("Humidity");
                 
                 if(currentH=="N/A")
                 {
                      i=i+1;
                    }
                    else
                    {
                        double currentH1=Double.parseDouble(currentRow.get("Humidity"));
                        double largetsH=Double.parseDouble(lowestHumidity.get("Humidity"));
                 if(currentH1<largetsH)
                 {
                    lowestHumidity=currentRow;
                    }
                }
                
                
                
        }
       
        }
        return lowestHumidity;
    }
    public void tester_humidity()
    {
        //prints lowest humidity in a file
        FileResource fr=new FileResource();
        CSVRecord largest=lowestHumidityInFile (fr.getCSVParser());
        System.out.println("Lowest Humidity was : "+largest.get("Humidity")+ " at : " +largest.get("DateUTC")+" at Temperature : " +largest.get("TemperatureF"));
        
    }
     public CSVRecord lowest_humidity_in_multiple()
     {
         //returns lowest humidity in multiple files
         CSVRecord lowestsofar=null;
         DirectoryResource dr=new DirectoryResource();
         for(File f:dr.selectedFiles())
         {
             FileResource fr=new FileResource(f);
             CSVRecord currentRow= lowestHumidityInFile(fr.getCSVParser());
             
             if (lowestsofar==null)
            {
                lowestsofar=currentRow;
            }
            else{
                double currentH=Double.parseDouble(currentRow.get("Humidity"));
                 double lowestHH=Double.parseDouble(lowestsofar.get("Humidity"));
                 if(currentH<lowestHH)
                 {
                     lowestsofar=currentRow;
                    }
                
                
            }
            
         
         
         
        }
        return lowestsofar;   
    
}
public void tester_humidity_many()
    {
        //prints lowest humidity in multiple files
        CSVRecord largest=lowest_humidity_in_multiple();
        System.out.println("Lowest Humidity was : "+largest.get("Humidity")+" at : "+largest.get("DateUTC") );
        
    }
    public double  averageTemperatureInFile(CSVParser parser)
    {
        //returns average temperature in a file
        double sum=0,count=0;
        for(CSVRecord currentRow :parser)
        {
            
            
                double currentTemp=Double.parseDouble(currentRow.get("TemperatureF"));
                 sum=sum+currentTemp;
                 count++;             
                
            
        }
        double average=sum/count;
        return average;
    }
    public void tester_average_temperature()
    {
        //prints average temperature in a file
        FileResource fr=new FileResource();
        double averageTemp=averageTemperatureInFile (fr.getCSVParser());
        System.out.println("Average Temperature : "+averageTemp);
        
    }
    public double  averageTemperatureWithHighHumidityInFile(CSVParser parser,int value)
    {
       //returns average of temperatures with humidity greater than equal to specified value
        double sum=0,count=0;
        for(CSVRecord currentRow :parser)
        {          
                double currentTemp=Double.parseDouble(currentRow.get("TemperatureF"));
                double currentHumidity=Double.parseDouble(currentRow.get("Humidity"));
                if(currentHumidity>=value)
                {
                 sum=sum+currentTemp;
                 count++;             
                }
            
        }
        double average=sum/count;
        return average;
    }
    public void tester_average_temperature_highHumidity()
    {
        //prints average of temperatures with humidity greater than equal to specified value
        FileResource fr=new FileResource();
        double averageTemp=averageTemperatureWithHighHumidityInFile (fr.getCSVParser(),80);
        System.out.println("Average Humidity : "+averageTemp);
        
    }
    
    public CSVRecord coldest_in_multiple()
     {
         //returns coldest temperature in multiple files
         CSVRecord coldestSoFar=null;
         DirectoryResource dr=new DirectoryResource();
         String file="";
         for(File f:dr.selectedFiles())
         {
             FileResource fr=new FileResource(f);
             CSVRecord currentRow= coldesthour(fr.getCSVParser());
             
             
             if (coldestSoFar==null)
            {
               coldestSoFar=currentRow;
            }
            else{
                double currentTemp=Double.parseDouble(currentRow.get("TemperatureF"));
                 double coldestTemp=Double.parseDouble(coldestSoFar.get("TemperatureF"));
                 if(currentTemp==-9999)
                 {
                     currentTemp=coldestTemp;
                    }
                 if(currentTemp<coldestTemp)
                 {
                     coldestSoFar=currentRow;
                     file=f.getName();
                     
                    }
                
                
            }
            
         
         
         
        }
        System.out.println(file);
        return  coldestSoFar; 
    
}


 public void tester_coldest_many()
    {
         //prints coldest temperature in multiple files
        CSVRecord coldest=coldest_in_multiple();
        System.out.println("coldest Temperature was : "+coldest.get("TemperatureF"));
        
        String v1="25,000";
       
    }

}
