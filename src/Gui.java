import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private Font pf;
    private Font bf;
    private Font itf;
    private Font bif;
    private JRadioButton prb;
    private JRadioButton brb;
    private JRadioButton irb;
    private JRadioButton birb;
    private ButtonGroup group;
    private JComboBox cbox;
    private JLabel picture;
    private JList list;
    private JList leftList;
    private JList rightList;
    private JButton moveButton;
    private static String[] filename = {"b.jpg", "a.png"};
    private Icon[] pics = {new ImageIcon(getClass().getResource(filename[0])), new ImageIcon(getClass().getResource(filename[1]))};
    private static String[] colornames = {"black", "blue", "white", "red"};
    private static Color[] colors = {Color.BLACK, Color.BLUE, Color.WHITE, Color.RED};
    private static String[] foods = {"bacon", "wings", "ham", "beef", "morebacon"};


    public Gui() {

        super("The Title");
        setLayout(new FlowLayout());
//BUTON
        reg = new JButton("Test");
        reg.setActionCommand("Click Test");
        add(reg);

//TEXTFIELD
        tf = new JTextField("This is a senteces", 20);
        tf.setFont(new Font("serif", Font.PLAIN, 14));
        add(tf);
//CHECKBOX
        boldbox = new JCheckBox("bold");
        add(boldbox);
        italicbox = new JCheckBox("italic");
        add(italicbox);
//ICON
        Icon a = new ImageIcon(getClass().getResource("a.png"));
        Icon b = new ImageIcon(getClass().getResource("b.jpg"));
//BUTON
        custom = new JButton("Custom", a);
        custom.setRolloverIcon(b);
        add(custom);
//HANDLERCLASS
        HandlerClass handler = new HandlerClass();
        reg.addActionListener(handler);
        custom.addActionListener(handler);

        HandlerClass2 handler2 = new HandlerClass2(pf);
        boldbox.addItemListener(handler2);
        italicbox.addItemListener(handler2);
//RADIOBUTTON
        prb = new JRadioButton("plain", true);
        add(prb);
        brb = new JRadioButton("bold", false);
        add(brb);
        irb = new JRadioButton("italic", false);
        add(irb);
        birb = new JRadioButton("bold and italic", false);
        add(birb);
//RADIOBUTTON GROUP
        group = new ButtonGroup();
        group.add(prb);
        group.add(brb);
        group.add(irb);
        group.add(birb);
//FONT
        pf = new Font("Serif", Font.PLAIN, 14);
        bf = new Font("Serif", Font.BOLD, 14);
        itf = new Font("Serif", Font.ITALIC, 14);
        bif = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
//RADIOBUTTON
        prb.addItemListener(new HandlerClass2(pf));
        brb.addItemListener(new HandlerClass2(bf));
        irb.addItemListener(new HandlerClass2(itf));
        birb.addItemListener(new HandlerClass2(bif));
//CHECKBOX
        cbox = new JComboBox(filename);
        //ANOTHER WAY FOR USING ADDITEMLISTENER
        cbox.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent event) {
                        if (event.getStateChange() == ItemEvent.SELECTED) {
                            picture.setIcon(pics[cbox.getSelectedIndex()]);
                        }
                    }
                }
        );
        add(cbox);
        picture = new JLabel(pics[0]);
        add(picture);
//LIST
        list = new JList(colornames);
        list.setVisibleRowCount(colornames.length);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list));
        list.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent listSelectionEvent) {
                        getContentPane().setBackground(colors[list.getSelectedIndex()]);
                    }
                }
        );
        leftList = new JList(foods);
        leftList.setVisibleRowCount(foods.length);
        leftList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(leftList));

        moveButton = new JButton("Move -->");
        moveButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        rightList.setListData(leftList.getSelectedValues());
                    }
                }
        );
        add(moveButton);
    }

    private class HandlerClass implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
        }
    }

    private class HandlerClass2 implements ItemListener {
        Font font = null;

        public HandlerClass2(Font f) {
            font = f;
        }

        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == boldbox || event.getSource() == italicbox) {
                if (boldbox.isSelected() && italicbox.isSelected()) {
                    font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
                } else if (boldbox.isSelected()) {
                    font = new Font("Serif", Font.BOLD, 14);
                } else if (italicbox.isSelected()) {
                    font = new Font("Serif", Font.ITALIC, 14);
                } else if (!italicbox.isSelected() && !boldbox.isSelected()) {
                    font = new Font("Serif", Font.PLAIN, 14);
                }
            }
            tf.setFont(font);
        }
    }
}
