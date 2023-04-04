package registration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Registration {
    public static final String DATABASE_PATH =
            "C:\\Users\\Havka\\IdeaProjects\\Registration\\src\\database.txt";
    Scanner input = new Scanner(System.in);

    public void go() {
        registrate();
    }
    private void registrate() {
        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        try {
            FileWriter fileWriter = new FileWriter(DATABASE_PATH, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("\n" + username + " - " + password);
            writer.close();
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
