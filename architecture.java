package component1;

import javax.swing.*;

public class architecture {
    private JPanel root;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JButton IPLButton;
    private JButton SSButton;
    private JButton loadButton;
    private JButton haltButton;
    private JButton storeButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("architecture");
        frame.setContentPane(new architecture().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.setVisible(true);
    }
}
