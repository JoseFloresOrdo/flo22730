import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {

    


    private static ArrayList<String> Datos = new ArrayList<String>();
    private static Factory Factory = new Factory();


    public static void EscribirArchivo(){
        String Path = "Num.txt";

        try {
            File File = new File(Path);
            Scanner Read = new Scanner(File);
            while (Read.hasNextLine()) {
                String data = Read.nextLine();
                Datos.add(data);
            }
            Read.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}