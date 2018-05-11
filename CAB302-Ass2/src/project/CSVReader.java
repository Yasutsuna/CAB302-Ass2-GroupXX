package project;

import java.io.BufferedReader; 
import java.io.FileReader; 

public class CSVReader { 

    public static void main(String[] args) { 
        try { 
            BufferedReader reader = new BufferedReader(new FileReader("a.csv"));
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