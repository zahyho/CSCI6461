import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class C1 {
    private JPanel ROOT;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton LDButton;
    private JButton LDButton1;
    private JButton LDButton2;
    private JButton LDButton3;
    private JButton LDButton4;
    private JButton LDButton5;
    private JButton LDButton6;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JButton LDButton7;
    private JButton LDButton8;
    private JButton LDButton9;
    private JButton storeButton;
    private JButton loadButton;
    private JButton IPLButton;
    private JButton SSButton;
    private JButton SIButton;
    private JButton runButton;
    private JButton a0Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a10Button;
    private JButton a11Button;
    private JButton a12Button;
    private JButton a13Button;
    private JButton a14Button;
    private JTextField textField13;
    private JTextField textField14;

    public C1() {
        LDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        LDButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        LDButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        LDButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        LDButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        LDButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        LDButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        LDButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        LDButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        LDButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        IPLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        SIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        SSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        storeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        a0Button.addActionListener(listener);
        a1Button.addActionListener(listener);
        a2Button.addActionListener(listener);
        a3Button.addActionListener(listener);
        a4Button.addActionListener(listener);
        a5Button.addActionListener(listener);
        a8Button.addActionListener(listener);
        a9Button.addActionListener(listener);
        a6Button.addActionListener(listener);
        a7Button.addActionListener(listener);
        a10Button.addActionListener(listener);
        a11Button.addActionListener(listener);
        a12Button.addActionListener(listener);
        a13Button.addActionListener(listener);
        a14Button.addActionListener(listener);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("C1");
        frame.setContentPane(new C1().ROOT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,600,500);
        frame.setVisible(true);
    }
}
