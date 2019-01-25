import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserInterfaceTest {
    private ByteArrayOutputStream out;
    private PrintStream output;
    private UserInterface ui;

    private UserInterface mockUi(String mockInput) {
        ByteArrayInputStream input = new ByteArrayInputStream(mockInput.getBytes());

        return new UserInterface(input, output);
    }

    @Before
    public void setUp() {
        out = new ByteArrayOutputStream();
        output = new PrintStream(out);
    }

    @Test
    public void asksUserForText(){
        ui = mockUi("This is te text that I introduced to wrap");
        assertThat (ui.askForText(), is("This is te text that I introduced to wrap"));
    }

    @Test
    public void asksUserForWidth(){
        ui = mockUi("5");
        assertThat (ui.askForWidth(), is(5));
    }

    @Test
    public void printResults(){
        ui = mockUi("User Input");
        String results = "These are my results";
        ui.printResults(results);
        assertThat(out.toString(), containsString("These are my results"));
    }

    @Test
    public void welcomesUser(){
        ui = mockUi("User Input");
        ui.welcome();
        assertThat(out.toString(), containsString("Welcome!"));
    }

    @Test
    public void goodbyeUser(){
        ui = mockUi("User Input");
        ui.goodbye();
        assertThat(out.toString(), containsString("Goodbye!"));
    }
}