import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Gui extends JFrame {

    private JButton reg;
    private JButton custom;
    private JTextField tf;
    private JCheckBox boldbox;
    private JCheckBox italicbox;

    Font font = null;


    public Gui(){

        super("The Title");
        setLayout(new FlowLayout());

        reg = new JButton("Test");
        reg.setActionCommand("Click Test");
        add(reg);


        tf = new JTextField("This is a senteces", 20);
        tf.setFont(new Font("serif",Font.PLAIN, 14));
        add(tf);

        boldbox = new JCheckBox("bold");
        italicbox = new JCheckBox("italic");
        add(boldbox);
        add(italicbox);

        boldbox.setSelected(true);


        Icon a = new ImageIcon(getClass().getResource("a.png"));
        Icon b = new ImageIcon(getClass().getResource("b.jpg"));

        custom = new JButton("Custom", a);
        custom.setRolloverIcon(b);
        add(custom);

        HandlerClass handler = new HandlerClass();
        reg.addActionListener(handler);
        custom.addActionListener(handler);


        HandlerClass2 handler2 = new HandlerClass2();
        boldbox.addItemListener(handler2);
        italicbox.addItemListener(handler2);

//        if (boldbox.isSelected() && italicbox.isSelected()) {
//            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
//        } else if (boldbox.isSelected()) {
//            font = new Font("Serif", Font.BOLD, 14);
//        } else if (italicbox.isSelected()) {
//            font = new Font("Serif", Font.ITALIC, 14);
//        } else {
//            font = new Font("Serif",Font.PLAIN, 14);
//        }
//        tf.setFont(font);
    }
    private class HandlerClass implements ActionListener{
        public void actionPerformed (ActionEvent event){
            JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()) );
        }
    }

    private class HandlerClass2 implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            if (boldbox.isSelected() && italicbox.isSelected()) {
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            } else if (boldbox.isSelected()) {
                font = new Font("Serif", Font.BOLD, 14);
            } else if (italicbox.isSelected()) {
                font = new Font("Serif", Font.ITALIC, 14);
            } else {
                font = new Font("Serif",Font.PLAIN, 14);
            }

            tf.setFont(font);

        }
    }
}
