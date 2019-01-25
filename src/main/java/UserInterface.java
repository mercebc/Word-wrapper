import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UserInterface {
    private PrintStream output;
    private Scanner input;

    public UserInterface(InputStream inputStream, PrintStream output) {
        this.output = output;
        this.input = new Scanner(inputStream);
    }

    public String askForText(){
        output.println("Please write the text you would like to wrap");
        return input.nextLine();
    }

    public int askForWidth(){
        output.println("please insert the width of the columns");
        return input.nextInt();
    }

    public void printResults(String result){
        output.println(result);
    }

    public  void welcome() {
        output.println("Welcome!");
    }

    public void goodbye() {
        output.println("Goodbye!");
    }
}
