import javax.swing.*;
import java.awt.*;
//**Graphics

public class Peach extends JPanel{
//    public void paintComponent(Graphics g){
//        super.paintComponent(g);
//        this.setBackground(Color.white);
//        g.setColor(Color.BLUE);
//        g.fillRect(25, 25, 100, 30);
//        g.setColor(new Color(190,81,215));
//        g.fillRect(25, 65, 100, 30);
//        g.setColor(Color.RED);
//        g.drawString("This is text", 25, 120);
//    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.BLUE);
        g.drawLine(10,25 ,200,45 );

        g.setColor(Color.RED);
        g.drawRect(10, 55, 100, 30);

        g.setColor(Color.GREEN);
        g.fillOval(10, 95, 100, 30);

        g.setColor(Color.ORANGE);
        g.fill3DRect(10, 160, 100,50 ,true );


    }
}


// Color Chooser

//public class Peach extends JFrame {
//    private JButton b;
//    private Color color = (Color.white);
//    private JPanel panel;
//
//    public Peach() {
//        super("Tittle");
//        panel = new JPanel();
//        panel.setBackground(color);
//
//        b = new JButton("Choose a color");
//        b.addActionListener(actionEvent -> {
//            color = JColorChooser.showDialog(null, "Pick your color", color);
//            if (color == null)
//                color = Color.white;
//            panel.setBackground(color);
//        });
//
//        add(panel, BorderLayout.CENTER);
//        add(b, BorderLayout.SOUTH);
//        setSize(400, 200);
//        setVisible(true);
//
//    }
//}