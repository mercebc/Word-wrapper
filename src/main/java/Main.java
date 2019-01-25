public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface(System.in, System.out);
        WordWrap ww = new WordWrap();

        ui.welcome();
        ui.printResults(ww.wrap(ui.askForText(),ui.askForWidth()));
        ui.goodbye();
    }
}
