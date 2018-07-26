import javax.swing.*;
import java.util.Scanner;

public class Tutorial {

    public static void main(String[] argh) {
//        Gui3 go = new Gui3();
//        go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        go.setSize(400, 200);
//        go.setVisible(true);
//
//        File x = new File("/home/vkiper/IdeaProjects/Tutorial/greg");
//        if (x.exists()) {
//            System.out.println(x.getName() + " exist!");
//        } else {
//            System.out.println("This thing doesnt exist");
//        }

//        volkan v = new volkan();
//        if (v.openFile()) {
//            v.readFile();
//            v.closeFile();
//        }
//        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        v.setSize(400, 200);
//        v.setVisible(true);

        int x = 1;

        do {
            try {
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter first num");
                int n1 = scan.nextInt();
                System.out.println("Enter second num");
                int n2 = scan.nextInt();
                int sum = n1 / n2;
                System.out.println(sum);
                x = 2;
            } catch (Exception e) {
                System.out.println("You can do that ");
            }
        } while (x == 1);
    }
}
