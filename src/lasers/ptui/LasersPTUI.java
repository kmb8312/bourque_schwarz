package lasers.ptui;

import lasers.model.Safe;

import java.io.*;
import java.util.Scanner;

public class LasersPTUI {
    /***
     * The status of the game
     */
    public enum Status {
        GOOD,
        ERROR,
        END
    }

    private Safe safe;
    private final static String ADD = "a";
    private final static String DISPLAY = "d";
    private final static String HELP = "h";
    private final static String QUIT = "q";
    private final static String REMOVE = "r";
    private final static String VERIFY = "v";
    private PrintWriter userOut;
    private BufferedReader userIn;
    private Status status;


    public LasersPTUI(String[] args) {
        this.safe = new Safe();
        this.status = Status.GOOD;
    }
    public void readFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        while(scanner.hasNextLine()){
            String[] string = scanner.nextLine().split(" ");
            if(string[0].equals(ADD)){

            }
            if(string[0].equals(DISPLAY)){

            }
            if(string[0].equals(HELP)){

            }
            if (string[0].equals(QUIT)) {

            }
            if (string[0].equals(REMOVE)) {

            }
            if(string[0].equals(VERIFY)){

            }
        }
    }

    /***
     * runs the command prompt
     */
    public void run() throws IOException {
        this.userIn = new BufferedReader(new InputStreamReader(System.in));
        this.userOut = new PrintWriter(System.out, true);
        while (this.safe.getStatus() = Status.GOOD) {
            String input = this.userIn.readLine();
            if (input.equals(ADD)) {

            }
            if (input.equals(DISPLAY)) {

            }
            if (input.equals(HELP)) {

            }
            if (input.equals(QUIT)) {
                this.status = Status.END;
            }
            if (input.equals(REMOVE)) {

            }
            if (input.equals(VERIFY)) {

            }
        }
    }

    /**
     * The main method
     *
     * @param args command line arguments
     */
    public static void main(String[] args) throws IOException {
        // check sanity of input
        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage: java LasersPTUI safe-file [input]");
        } else {
                LasersPTUI ptui = new LasersPTUI(args);
                if(args.length >1){
                    ptui.readFile(args[1]);
                }
                else{
                    ptui.run();
                }

        }
    }
}
