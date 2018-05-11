package project;

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