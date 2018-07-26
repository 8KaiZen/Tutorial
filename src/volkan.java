import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class volkan extends JFrame {

    private JLabel message;
    private Scanner scan;
    private Formatter form;
    private JLabel message2;


    public volkan() {
        super("Dosya Oluşturma");
        setLayout(new FlowLayout());

        message2 = new JLabel();
        add(message2);
        JButton olustur = new JButton("Oluştur");
        add(olustur);
        JButton sil = new JButton("Sil");
        add(sil);
        message = new JLabel();
        add(message);

        File x = new File("/home/vkiper/IdeaProjects/Tutorial/volkan");
        olustur.addActionListener(actionEvent -> {
            if (!x.exists()) {
                try {
                    form = new Formatter("volkan");
                    message.setText("Created");
                } catch (Exception e) {
                    message.setText("Creating is fail");
                }
            } else {
                message.setText("File is already exist");
            }
            form.format("%s%s%s","20 ","bucky ","roberts\n");
            form.format("%s%s%s","30 ","lucy ","jhon\n");
            form.format("%s%s%s","40 ","marry ","luke");
            form.close();


        });
        sil.addActionListener(actionEvent -> {
            if (x.exists()) {
                if (x.delete()) {
                    message.setText("Deleted");
                } else {
                    message.setText("Deleting is fail.");
                }
            } else {
                message.setText("File is not exist");
            }
        });
    }
    public boolean openFile(){
        boolean b;
        try {
            scan = new Scanner(new File("volkan"));
            b = true;
        } catch (Exception e) {
            message2.setText("Could not find file");
            b=false;
        }
        return b;
    }
    public void readFile(){
        while (scan.hasNext()) {
            String a = scan.next();
            String b = scan.next();
            String c = scan.next();
            message2.setText(message2.getText() + String.format("%s %s %s",a,b,c));
        }
    }
    public void closeFile(){
        scan.close();
    }
}
