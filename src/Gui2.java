import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Gui2 extends JFrame {

    private JPanel mousePanel;
    private JLabel statusBar;

    public Gui2() {
        super("Tittle");


        mousePanel = new JPanel();
        mousePanel.setBackground(Color.WHITE);
        add(mousePanel, BorderLayout.CENTER);

        statusBar = new JLabel();
        add(statusBar, BorderLayout.SOUTH);

        HandlerClass handler = new HandlerClass();

        mousePanel.addMouseListener(handler);
        mousePanel.addMouseMotionListener(handler);

    }

    private class HandlerClass implements MouseListener, MouseMotionListener {
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            statusBar.setText(String.format("Clicked at %d, %d",mouseEvent.getX(),mouseEvent.getY()));
        }
        public void mousePressed(MouseEvent mouseEvent){
            statusBar.setText("You pressed down the mouse");
        }
        public void mouseReleased(MouseEvent mouseEvent){
            statusBar.setText("You released the button");
        }
        public void mouseEntered(MouseEvent mouseEvent){
            statusBar.setText("You entered the area");
            mousePanel.setBackground(Color.RED);
        }
        public void mouseExited(MouseEvent mouseEvent){
            statusBar.setText("The mouse has left the window");
            mousePanel.setBackground(Color.WHITE);
        }
        //these are mouse notion event
        public void mouseDragged(MouseEvent mouseEvent){
            statusBar.setText("You are dragging the mouse");
        }
        public void mouseMoved(MouseEvent mouseEvent){
            statusBar.setText("You are moved the mouse");
        }
    }
}
