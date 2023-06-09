package authorization;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Authorization {
    public static final String DATABASE_PATH =
            "C:\\Users\\Havka\\IdeaProjects\\Registration\\src\\database.txt";
    int counter = 0;
    String line;

    File databaseFile = new File(DATABASE_PATH);
    HashMap<Integer, User> data = new HashMap<>();

    public void go() {
        readDatabase();
    }

    private void readDatabase() {
        try (FileReader fileReader = new FileReader(databaseFile)) {
            Scanner input = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(fileReader);

            System.out.print("Username = ");
            String login = input.next();

            login += " - ";

            System.out.print("Password = ");
            login += input.next();

            line = reader.readLine();

            while (!(line == null)) {

                if (line.equals(login)) {
                    createUser(line, counter);
                    System.out.println("Log in successful");
                    break;
                } else {
                    line = reader.readLine();
                }
            }

            if (line == null) {
                System.out.println("Wrong name or password");
            }

        } catch (FileNotFoundException exception) {
            System.out.println("Database not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void parsePassword(String databaseLine, User user) {
        char[] chars = databaseLine.toCharArray();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            String symbol = String.valueOf(chars[i]);
            if (symbol.equals(" ")) {
                for (int k = i + 3; k < chars.length; k++) {
                    password.append(chars[k]);
                }
                user.setPassword(password.toString());
                break;
            }
        }
    }

    private void parseUsername(String databaseLine, User user) {
        char[] chars = databaseLine.toCharArray();
        StringBuilder username = new StringBuilder();

        for (char aChar : chars) {
            String symbol = String.valueOf(aChar);

            if (symbol.equals(" ")) {
                user.setUsername(username.toString());
                break;
            } else {
                username.append(symbol);
            }
        }
    }

    private void createUser(String line, int counter) {
        User user = new User();
        parseUsername(line, user);
        parsePassword(line, user);
        data.put(counter, user);
    }
}
