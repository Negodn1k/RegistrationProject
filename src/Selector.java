import authorization.Authorization;
import registration.Registration;

import java.util.Scanner;

public class Selector {
    private Registration registration = new Registration();
    private Authorization authorization = new Authorization();
    private boolean isSelected = false;

    public void go() {
        select();
    }
    private void select() {
        Scanner input = new Scanner(System.in);
        System.out.println("Registration or Authorization?");
        String selected = input.next();

        while (!isSelected) {
            switch (selected) {
                case "Reg" -> {
                    registration.go();
                    isSelected = true;
                }
                case "Aut" -> {
                    authorization.go();
                    isSelected = true;
                }
            }
        }
    }
}
