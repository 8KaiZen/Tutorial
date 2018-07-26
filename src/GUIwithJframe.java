import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUIwithJframe extends JFrame {
    private JLabel item1;

    public GUIwithJframe (){
        super("The Title Bar");
        setLayout(new FlowLayout());

        item1 = new JLabel("This is a sentecew");
        item1.setToolTipText("This is gonna show up on hover");
        add(item1);
    }

}

