import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ProductReader
{

    public static void main(String[] args)
    {

        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        String Name = String.valueOf(target.getFileName());

        String heading1 = "ID|";
        String heading2 = "Name|";
        String heading3 = "Description";
        String heading4 = "Cost";

        boolean done = false;
        String productRec = "";
        String IDNum = "";
        String name = "";
        String description = "";
        double cost = 0;

        String divider = "====================================";



        chooser.setCurrentDirectory(target.toFile());


        try
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();


                inFile = new Scanner(target);





                while (inFile.hasNextLine()) {
                    line = inFile.next();
                    System.out.println(line);
                    String.format(line);


                }
                System.out.printf("%s\n %s\n %s\n %.2f", IDNum, name, description, cost);




                inFile.close();
            }
            else
            {
                System.out.println("Must select file, terminating now");
                System.exit(0);
            }

        }
        catch (IOException e)
        {
            System.out.println("File Not Found Error");
        }


    }
}
