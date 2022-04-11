package com.bh.assign;

// Import required classes
import java.io.File;
import org.ini4j.Wini;

/**
 * Basic example of the use of the ini4j library.
 *
 * @author Carlos Delgado <dev@ourcodeworld.com>
 */
public class Index {

    public static void main(String[] args){
        try{
            Wini ini = new Wini(new File("src\\test\\resources\\util\\IniFile\\mysample.ini"));
            int age = ini.get("owner", "age", int.class);
            double height = ini.get("owner", "height", double.class);
            String server = ini.get("database", "server");


            System.out.print("Age: " + age + "\n");
            System.out.print("Geight: " + height + "\n");
            System.out.print("Server IP: " + server + "\n");
            // To catch basically any error related to finding the file e.g
            // (The system cannot find the file specified)
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}