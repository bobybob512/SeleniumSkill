import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaErrors {

    public static void main(String[] args) throws IOException {

        //throw
        //throws
        //try - catch - finally

        //throw - ne folosim de el ca sa aruncam explicit o eroare
        //throws - atentionare ca o metoda sau un constructor arunca o eroare/exceptie
        //try - catch - finally -> handlers

        checkedException();
        System.out.println("S-a terminat metoda");

    }

    //checked exceptions
    public static void checkedException() throws IOException {
        FileReader file = new FileReader("C:\\Users\\ciurt\\OneDrive\\Desktop\\TestSkillBrain.txt");
        BufferedReader fileInput = new BufferedReader(file);
        System.out.println(fileInput.readLine());
        fileInput.close();

    }

    //unchecked exceptions
    public static void uncheckedExceptions(){

    }
}
