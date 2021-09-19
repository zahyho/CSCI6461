import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
    private JTextField textField13;
    private JTextField textField14;
    private JRadioButton a5RadioButton;
    private JRadioButton a0RadioButton;
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a4RadioButton;
    private JRadioButton a6RadioButton;
    private JRadioButton a7RadioButton;
    private JRadioButton a8RadioButton;
    private JRadioButton a9RadioButton;
    private JRadioButton a10RadioButton;
    private JRadioButton a11RadioButton;
    private JRadioButton a12RadioButton;
    private JRadioButton a13RadioButton;
    private JRadioButton a14RadioButton;
    private JRadioButton a15RadioButton;
    private JRadioButton a3RadioButton;
    private char bits[];

    public C1() {
        bits = new char[17];
        for(int i = 0; i <bits.length;i++){
            bits[i]='0';
        }
        bits[bits.length-1] = '\0';
        LDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField1.setText(value);

            }
        });
        LDButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField2.setText(value);
            }
        });
        LDButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField3.setText(value);
            }
        });
        LDButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField4.setText(value);
            }
        });
        LDButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField5.setText(value);
            }
        });
        LDButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField6.setText(value);
            }
        });
        LDButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField7.setText(value);
            }
        });
        LDButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char subArray[] = Arrays.copyOfRange(bits,4,16);
                String value = String.valueOf(subArray);
                textField8.setText(value);
            }
        });
        LDButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char subArray[] = Arrays.copyOfRange(bits,4,16);
                String value = String.valueOf(subArray);
                textField9.setText(value);
            }
        });
        LDButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField10.setText(value);
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
                if(e.getSource()==a0RadioButton){
                    if(a0RadioButton.isSelected()){
                        bits[0] = '1';
                    }
                    else{
                        bits[0] = '0';
                    }
                }
                else if(e.getSource()==a1RadioButton){
                    if(a1RadioButton.isSelected()){
                        bits[1] = '1';
                    }
                    else{
                        bits[1] = '0';
                    }
                }
                else if(e.getSource()==a2RadioButton){
                    if(a2RadioButton.isSelected()){
                        bits[2] = '1';
                    }
                    else{
                        bits[2] = '0';
                    }
                }
                else if(e.getSource()==a3RadioButton){
                    if(a3RadioButton.isSelected()){
                        bits[3] = '1';
                    }
                    else{
                        bits[3] = '0';
                    }
                }
                else if(e.getSource()==a4RadioButton){
                    if(a4RadioButton.isSelected()){
                        bits[4] = '1';
                    }
                    else{
                        bits[4] = '0';
                    }
                }
                else if(e.getSource()==a5RadioButton){
                    if(a5RadioButton.isSelected()){
                        bits[5] = '1';
                    }
                    else{
                        bits[5] = '0';
                    }
                }
                else if(e.getSource()==a6RadioButton){
                    if(a6RadioButton.isSelected()){
                        bits[6] = '1';
                    }
                    else{
                        bits[6] = '0';
                    }
                }
                else if(e.getSource()==a7RadioButton){
                    if(a7RadioButton.isSelected()){
                        bits[7] = '1';
                    }
                    else{
                        bits[7] = '0';
                    }
                }
                else if(e.getSource()==a8RadioButton){
                    if(a8RadioButton.isSelected()){
                        bits[8] = '1';
                    }
                    else{
                        bits[8] = '0';
                    }
                }
                else if(e.getSource()==a9RadioButton){
                    if(a9RadioButton.isSelected()){
                        bits[9] = '1';
                    }
                    else{
                        bits[9] = '0';
                    }
                }
                else if(e.getSource()==a10RadioButton){
                    if(a10RadioButton.isSelected()){
                        bits[10] = '1';
                    }
                    else{
                        bits[10] = '0';
                    }
                }
                else if(e.getSource()==a11RadioButton){
                    if(a11RadioButton.isSelected()){
                        bits[11] = '1';
                    }
                    else{
                        bits[11] = '0';
                    }
                }
                else if(e.getSource()==a12RadioButton){
                    if(a12RadioButton.isSelected()){
                        bits[12] = '1';
                    }
                    else{
                        bits[12] = '0';
                    }
                }
                else if(e.getSource()==a13RadioButton){
                    if(a13RadioButton.isSelected()){
                        bits[13] = '1';
                    }
                    else{
                        bits[13] = '0';
                    }
                }
                else if(e.getSource()==a14RadioButton){
                    if(a14RadioButton.isSelected()){
                        bits[14] = '1';
                    }
                    else{
                        bits[14] = '0';
                    }
                }
                else{
                    if(a15RadioButton.isSelected()){
                        bits[15] = '1';
                    }
                    else{
                        bits[15] = '0';
                    }
                }
            }
        };
        a0RadioButton.addActionListener(listener);
        a1RadioButton.addActionListener(listener);
        a2RadioButton.addActionListener(listener);
        a3RadioButton.addActionListener(listener);
        a4RadioButton.addActionListener(listener);
        a5RadioButton.addActionListener(listener);
        a8RadioButton.addActionListener(listener);
        a9RadioButton.addActionListener(listener);
        a6RadioButton.addActionListener(listener);
        a7RadioButton.addActionListener(listener);
        a10RadioButton.addActionListener(listener);
        a11RadioButton.addActionListener(listener);
        a12RadioButton.addActionListener(listener);
        a13RadioButton.addActionListener(listener);
        a14RadioButton.addActionListener(listener);
        a15RadioButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("C1");
        frame.setContentPane(new C1().ROOT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,600,500);

//        System.out.println(new MAR().getAddressfromPC(new ProgramCounter()));

        frame.setVisible(true);
    }
}
