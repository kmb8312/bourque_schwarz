package lasers.ptui;

import lasers.model.Safe;

import java.io.*;
import java.util.Scanner;

/***
 * This class handles the user inputs
 * Author: Peter Schwarzkopf
 */
public class LasersPTUI {
    /***
     * The status of the game
     */
    public enum Status {
        RUNNING,
        END
    }
    public static String filesafe;
    private Safe safe;
    private final static String ADD = "a";
    private final static String DISPLAY = "d";
    private final static String HELP = "h";
    private final static String QUIT = "q";
    private final static String REMOVE = "r";
    private final static String VERIFY = "v";
    private BufferedReader userIn;
    private Status status;


    public LasersPTUI(String[] args) {
        this.safe = new Safe();
        this.status = Status.RUNNING;
        this.filesafe = args[0];
    }

    /***
     * runs a file input
     * @param filename
     * @throws FileNotFoundException
     */
    public void readFile(String filename) throws IOException {
        Scanner scanner = new Scanner(new File(filename));
        while(scanner.hasNextLine()){
            String[] string = scanner.nextLine().split(" ");
            if(string[0].equals(ADD)){
                safe.add(string[1],string[2], LasersPTUI.filesafe);
            }
            if(string[0].equals(DISPLAY)){
                safe.display(LasersPTUI.filesafe);
            }
            if(string[0].equals(HELP)){
                safe.help();
            }
            if (string[0].equals(QUIT)) {
                this.status = Status.END;
            }
            if (string[0].equals(REMOVE)) {
                safe.remove(string[1],string[2], LasersPTUI.filesafe);
            }
            if(string[0].equals(VERIFY)){
                safe.verify();
            }
        }
    }

    /***
     * runs the command prompt
     */
    public void run() throws IOException {
        this.userIn = new BufferedReader(new InputStreamReader(System.in));
        while (this.safe.getStatus() == Status.RUNNING) {
            String[] input = this.userIn.readLine().split(" ");
            if (input[0].equals(ADD)) {
                safe.add(input[1],input[2], LasersPTUI.filesafe);
            }
            if (input[0].equals(DISPLAY)) {
                safe.display(LasersPTUI.filesafe);
            }
            if (input[0].equals(HELP)) {
                safe.help();
            }
            if (input[0].equals(QUIT)) {
                this.status = Status.END;
            }
            if (input[0].equals(REMOVE)) {
                safe.remove(input[1],input[2], LasersPTUI.filesafe);
            }
            if (input[0].equals(VERIFY)) {
                safe.verify();
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
