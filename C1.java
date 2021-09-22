import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class C1 {
    /*
    This class contains the main function and this is where the components come together
    * */
    private JPanel ROOT;
    //GPRS
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    //IXRS
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    //ld buttons
    private JButton LDButton;
    private JButton LDButton1;
    private JButton LDButton2;
    private JButton LDButton3;
    private JButton LDButton4;
    private JButton LDButton5;
    private JButton LDButton6;
    private JButton LDButton7;
    private JButton LDButton8;
    private JButton LDButton9;
    //PC
    private JTextField textField8;
    //MAR
    private JTextField textField9;
    //MBR
    private JTextField textField10;
    //MFR
    private JTextField textField11;
    //IR
    private JTextField textField12;
    //FUNCTIONALITY BUTTONS
    private JButton storeButton;
    private JButton loadButton;
    private JButton IPLButton;
    private JButton SSButton;
    private JButton SIButton;
    private JButton runButton;
    //HALT and run
    private JTextField textField13;
    private JTextField textField14;
    // Radiobuttons for giving input
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
    // to hold status of the radio buttons
    private char bits[];
    //CPU memory
    public Memory mem;
    //Reisters
    public Register [] registers ;
    //PC
    public ProgramCounter pc;
    //MAR
    public MAR mar;
    //MBR
    public MBR mbr;
    //memory control unit
    public MCU mcu;
    // binary to/from converter
    public Parser parser;
    // instruction register
    public IR ir;
    // decoder class to decode instruction
    public Decoder decoder;
    //executor class to execute instructions
    public Executor executor;
    // initial result register
    public IRR irr;
    public C1(JFrame frame) {
        //Initialization
        mem = new Memory();
        registers = new Register[7];
        for(int i =0;i<registers.length;i++){
            registers[i] = new Register();
        }
        pc = new ProgramCounter();
        mar = new MAR();
        mbr = new MBR();
        mcu = new MCU();
        parser = new Parser();
        ir = new IR();
        decoder = new Decoder();
        executor = new Executor();
        irr = new IRR();
        bits = new char[17];
        for(int i = 0; i <bits.length;i++){
            bits[i]='0';
        }
        bits[bits.length-1] = '\0';
        /*
        ld buttons read the value of the bits variable
        and set corresponding textfield
        * */
        LDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField1.setText(value);
                registers[0].setValue(value);
            }
        });
        LDButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField2.setText(value);
                registers[1].setValue(value);
            }
        });
        LDButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField3.setText(value);
                registers[2].setValue(value);
            }
        });
        LDButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField4.setText(value);
                registers[3].setValue(value);
            }
        });
        LDButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField5.setText(value);
                registers[4].setValue(value);
            }
        });
        LDButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField6.setText(value);
                registers[5].setValue(value);
            }
        });
        LDButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField7.setText(value);
                registers[6].setValue(value);
            }
        });
        LDButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                char subArray[] = Arrays.copyOfRange(bits,4,16);
//                String value = String.valueOf(subArray);
//                textField8.setText(value);
            }
        });
        LDButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                char subArray[] = Arrays.copyOfRange(bits,4,16);
//                String value = String.valueOf(subArray);
//                textField9.setText(value);
            }
        });
        LDButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String value = String.valueOf(bits);
//                textField10.setText(value);
            }
        });
        IPLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                * IPL loads the instructions from file into memory and sets PC accordingly
                * */
                File file;
                try {
                    file = new FileBrowser().Browse();
                    FileReader fr=new FileReader(file);   //reads the file
                    BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
                    String line;
                    int index=64;
                    while((line=br.readLine())!=null)
                    {
                        pc.incrementPointer();
                        mem.setMem(index,line);
                        mem.setMem(pc.getPointer(),parser.decToBin(index,16));
                        System.out.println(parser.decToBin(index,16));
                        index++;
                    }
                    //pc.setPointer(-1);
                }
                catch(Exception ex){
                    System.out.println(e);
                }
            }

        });
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                * Run button runs the instruction from the top od the PC after the program is loaded
                * */
                while(true){
                    pc.setPointer(-1);
                    pc.nextInstruction(mem);
                    updateGUI();
//                    System.out.println(pc.getValue());
                    if(pc.getValue().contentEquals("000000000000")) {
                        pc.setPointer(-1);
                        break;
                    }
                    mar.getAddressfromPC(pc);
                    updateGUI();
                    mcu.memoryDecode(mar,mbr,mem);
                    updateGUI();
                    ir.getInsFromMBR(mbr);
                    updateGUI();
                    decoder.decode(ir);
                    updateGUI();
                    executor.execute(mem,registers,decoder,mbr,mar,irr,mcu);
                    updateGUI();
                }
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
                /*
                Performs the LDR instruction but takes in the radio button input to specify registers and address
                * */
                String op = "000001"+String.valueOf(bits).substring(0,10);
                ir.setValue(op);
                updateGUI();
                decoder.decode(ir);
                updateGUI();
                executor.execute(mem,registers,decoder,mbr,mar,irr,mcu);
                updateGUI();
                pc.incrementPointer();
            }
        });
        storeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                Performs the STR instruction but takes in the radio button input to specify registers and address
                * */
                String op = "000010"+String.valueOf(bits).substring(0,10);
                ir.setValue(op);
                updateGUI();
                decoder.decode(ir);
                updateGUI();
                executor.execute(mem,registers,decoder,mbr,mar,irr,mcu);
                updateGUI();
                pc.incrementPointer();
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Update the bits array when the radio buttons are changed
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
        // add listener to the radio buttons
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
    public void updateGUI(){
        /*
        update GUI after processing finishes
        * */
        textField1.setText(registers[0].getValue());
        textField2.setText(registers[1].getValue());
        textField3.setText(registers[2].getValue());
        textField4.setText(registers[3].getValue());
        textField5.setText(registers[4].getValue());
        textField6.setText(registers[5].getValue());
        textField7.setText(registers[6].getValue());
        textField8.setText(pc.getValue());
        textField9.setText(mar.getValue());
        textField10.setText(mbr.getValue());
        textField12.setText(ir.getValue());
    }
    public static void main(String[] args) {
        /*
        Main function
        * */
        JFrame frame = new JFrame("C1");
        C1 c1 = new C1(frame);
        frame.setContentPane(c1.ROOT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,600,500);
        frame.setVisible(true);
    }
}
