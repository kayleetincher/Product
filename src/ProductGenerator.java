import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator
{
    public static void main(String[] args)
    {
        ArrayList<String> drinks = new ArrayList<>();
        Scanner in = new Scanner(System.in);


        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\productData.txt");

        boolean done = false;
        String productRec = "";
        String IDNum = "";
        String name = "";
        String description = "";
        double cost = 0;




        do {

            Product DrPepper = new Product("Dr.Pepper", "Best drink", 2.99);
            System.out.println(DrPepper);
            drinks.add(String.valueOf(DrPepper));


            Product Pepsi = new Product("Pepsi", "carbonated soft drink", 3.01);
            System.out.println(Pepsi);
            drinks.add(String.valueOf(Pepsi));

            Product OrangeCrush = new Product("OrangeCrush", "Orange flavored Drink", 2.49);
            System.out.println(OrangeCrush);
            drinks.add(String.valueOf(OrangeCrush));

            done = SafeInput.getYNConfirm(in, "Are you done?");




        }while (!done);

        for (String p : drinks)
            System.out.println(p);
        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(String rec : drinks)
            {
                writer.write(rec, 0, rec.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}