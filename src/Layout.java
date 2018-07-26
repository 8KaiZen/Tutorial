import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layout extends JFrame{
    private JButton lb;
    private JButton cb;
    private JButton rb;
    private FlowLayout layout;
    private Container container;

    public Layout(){
        super("Titlle");
        layout = new FlowLayout();
        container = new Container();
        setLayout(layout);

        lb = new JButton("left");
        add(lb);
        lb.addActionListener(actionEvent -> {
            layout.setAlignment(FlowLayout.LEFT);
            layout.layoutContainer(container);
        });
    }
}
