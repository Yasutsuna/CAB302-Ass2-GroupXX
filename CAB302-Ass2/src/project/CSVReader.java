package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException; 

public class CSVReader { 

    public static void main(String[] args) { 
        try { 
            BufferedReader reader = new BufferedReader(new FileReader("item_properties.csv"));
            reader.readLine();
            String line = null; 
            while((line=reader.readLine())!=null){ 
                String item[] = line.split(",");
                 
                String last = item[item.length-1];
                //int value = Integer.parseInt(last);
                System.out.println(last); 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
    
}

//CSVWriter (Not needed atm but reference)

/*
import java.io.BufferedWriter; 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.FileWriter; 
import java.io.IOException; 

public class Test { 

  public static void main(String[] args) { 
    try { 
      File csv = new File("F:/writers.csv"); // CSV folder

      BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
     
      bw.write("name" + "," + "1988" + "," + "1992"); 
      bw.newLine(); 
      bw.close(); 

    } catch (FileNotFoundException e) { 
      
      e.printStackTrace(); 
    } catch (IOException e) { 
      
      e.printStackTrace(); 
    } 
  }
}
*/