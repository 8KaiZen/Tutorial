import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gui3 extends JFrame {

    private String details;
    private JLabel statusBar;

    public Gui3(){
        super("Tittle");

        statusBar=new JLabel("This is default");
        add(statusBar, BorderLayout.SOUTH);
        addMouseListener(new MouseClass());

    }

    private class MouseClass extends MouseAdapter{

        public void mouseClicked (MouseEvent mouseEvent){
            details = String.format("You clicked %d ",mouseEvent.getClickCount());

            if (mouseEvent.isMetaDown()) {
                details += "with right mouse button";
            } else if (mouseEvent.isAltDown()) {
                details += "with center mouse button";
            } else {
                details += "with left mouse button";
            }

            statusBar.setText(details);
        }

    }
}
