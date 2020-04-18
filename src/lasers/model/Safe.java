package lasers.model;

import lasers.ptui.LasersPTUI;

import java.io.*;
import java.util.Scanner;

public class Safe {


    public void add(String row, String col, String filename)throws IOException{
        int column = Integer.parseInt(col);
        int rows = Integer.parseInt(row);
        String stringold = "";
        Scanner scanner = new Scanner(new File(filename));
        String string = "";
        for (int i = 0; i < rows + 2; i++ ) {
            stringold = scanner.nextLine();
        }
        string = stringold.substring(0,column + column) + "L" + stringold.substring(column+column+1);
        Scanner sc = new Scanner(new File(filename));
        StringBuffer buffer = new StringBuffer();
         while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        sc.close();
        fileContents = fileContents.replaceAll(stringold, string);
        FileWriter writer = new FileWriter(filename);
        System.out.println("");
        System.out.println("Laser Added: \n"+fileContents);
        writer.append(fileContents);
        writer.flush();

    }

    public void display(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            System.out.println(string);
        }
    }
    public void help(){
        System.out.print("a\tadd\tr c\tAdd laser to (r, c)\n" +
                "d\tdisplay\t \tDisplay safe\n" +
                "h\thelp\t \tPrint this help message\n" +
                "q\tquit\t \tExit program\n" +
                "r\tremove\tr c\tRemove laser from (r, c)\n" +
                "v\tverify\t \tVerify safe correctness");
    }
    public void remove(String row, String col, String filename) throws IOException {
        int column = Integer.parseInt(col);
        int rows = Integer.parseInt(row);
        String stringold = "";
        Scanner scanner = new Scanner(new File(filename));
        String string = "";
        for (int i = 0; i < rows + 2; i++ ) {
            stringold = scanner.nextLine();
        }
        string = stringold.substring(0,column + column) + "." + stringold.substring(column+column+1);
        Scanner sc = new Scanner(new File(filename));
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }
        String fileContents = buffer.toString();
        sc.close();
        fileContents = fileContents.replaceAll(stringold, string);
        FileWriter writer = new FileWriter(filename);
        System.out.println("");
        System.out.println("Laser Removed: \n"+fileContents);
        writer.append(fileContents);
        writer.flush();
    }
    public void verify(){

    }
    public LasersPTUI.Status getStatus(){
        return LasersPTUI.Status.RUNNING;
    }
    public void quit(){
         System.exit(1);
    }
}
