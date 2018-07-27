import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Layout extends JFrame {
    private JButton lb;
    private JButton cb;
    private JButton rb;
    private FlowLayout layout;
    private Container container;

    public Layout() {
        super("Titlle");
        layout = new FlowLayout();
        container = getContentPane();
        setLayout(layout);
        HandlerClass handler = new HandlerClass();
        ActionListener actionListener  = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        };
        lb = new JButton("left");
        add(lb);
        lb.addActionListener(handler);
        cb = new JButton("center");
        add(cb);
        cb.addActionListener(handler);
        rb = new JButton("right");
        add(rb);
        rb.addActionListener(handler);
    }

    public void alignmentFunc(int flow) {
        layout.setAlignment(flow);
        layout.layoutContainer(container);
    }

    public class HandlerClass implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == lb) {
                alignmentFunc(FlowLayout.LEFT);
            } else if (event.getSource() == rb) {
                alignmentFunc(FlowLayout.RIGHT);
            } else if (event.getSource() == cb) {
                alignmentFunc(FlowLayout.CENTER);
            }
        }
    }
}
