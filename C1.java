import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;


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
    private JRadioButton a14RadioButton;
    private JRadioButton a13RadioButton;
    private JRadioButton a11RadioButton;
    private JRadioButton a7RadioButton;
    private JRadioButton a6RadioButton;
    private JRadioButton a8RadioButton;
    private JRadioButton a9RadioButton;
    private JRadioButton a4RadioButton;
    private JRadioButton a3RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a1RadioButton;
    private JRadioButton a18RadioButton;
    private JRadioButton a15RadioButton;
    private JRadioButton a12RadioButton;
    private JRadioButton a10RadioButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton program1Button;
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
    // initial code condition
    public CC cc;
    // initial cache
    public Cache cache;

    public void initialization() {
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
        cc = new CC();
        bits = new char[16];
        for(int i = 0; i <bits.length;i++){
            bits[i]='0';
        }
        textArea1.setEditable(false);
        cache = new Cache();
        textField1.setText("0000000000000000");
        textField2.setText("0000000000000000");
        textField3.setText("0000000000000000");
        textField4.setText("0000000000000000");
        textField5.setText("0000000000000000");
        textField6.setText("0000000000000000");
        textField7.setText("0000000000000000");
        textField8.setText("000000000000");
        textField9.setText("000000000000");
        textField10.setText("0000000000000000");
        textField12.setText("0000000000000000");
        textField13.setText("");
        textField14.setText("");
    }

    public C1(JFrame frame) {
        //Initialization
        initialization();
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
        // PC Button
        LDButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char subArray[] = Arrays.copyOfRange(bits,4,16);
                String value = String.valueOf(subArray);
                textField8.setText(value);
                pc.setValue(value);
                print("PC value is " + value);
                //System.out.println("PC value is " + value);
            }
        });
        // MAR Button
        LDButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char subArray[] = Arrays.copyOfRange(bits,4,16);
                String value = String.valueOf(subArray);
                textField9.setText(value);
                mar.setValue(value);
                print("MAR value is " + value);
            }
        });
        // MBR Button
        LDButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = String.valueOf(bits);
                textField10.setText(value);
                mbr.setValue(value);
                print("MBR value is " + value);
            }
        });
        IPLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialization();
                mem.loadIPL();
                print("IPL Finished!");
                textField8.setText(Parser.decToBin(pc.getPointer(), 12));
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
                textArea1.append(textField1.getText() + "\n");
            }
        });
        SSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!mem.getUpload()) {
                    print("Please upload the IPL file.");
                } else {
                    if(mem.getHlt()) {
                        print("The HLT is trigger!");
                    } else {
                        mar.setValue(Parser.decToBin(pc.getPointer(), 12)); // PC -> MAR
                        mbr.setValue(mem.getMem(Parser.binToDec(mar.getValue()))); // MEM[MAR] -> MBR
                        ir.setValue(mbr.getValue()); // MBR -> IR
                        mem.setRun(true);
                        mem.setHlt(false);
                        decodeIns();
                        textField13.setText(Boolean.toString(mem.getHlt()));
                        textField14.setText(Boolean.toString(mem.getRun()));
                        updateGUI();
                    }
                }
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(mar.getValue());
                textField10.setText(mem.getMem(Parser.binToDec(mar.getValue())));
                print("In MAR " + mar.getValue() + ", MBR value is " + mem.getMem(Parser.binToDec(mar.getValue())));
            }
        });
        storeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mem.setMem(Parser.binToDec(mar.getValue()), mbr.getValue());
                print("Change MAR " + mar.getValue() + ", MBR value is " + mem.getMem(Parser.binToDec(mar.getValue())));
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Update the bits array when the radio buttons are changed
                if(e.getSource()==a15RadioButton){
                    if(a15RadioButton.isSelected()){
                        bits[0] = '1';
                    }
                    else{
                        bits[0] = '0';
                    }
                }
                else if(e.getSource()== a14RadioButton){
                    if(a14RadioButton.isSelected()){
                        bits[1] = '1';
                    }
                    else{
                        bits[1] = '0';
                    }
                }
                else if(e.getSource()== a13RadioButton){
                    if(a13RadioButton.isSelected()){
                        bits[2] = '1';
                    }
                    else{
                        bits[2] = '0';
                    }
                }
                else if(e.getSource()== a12RadioButton){
                    if(a12RadioButton.isSelected()){
                        bits[3] = '1';
                    }
                    else{
                        bits[3] = '0';
                    }
                }
                else if(e.getSource()== a11RadioButton){
                    if(a11RadioButton.isSelected()){
                        bits[4] = '1';
                    }
                    else{
                        bits[4] = '0';
                    }
                }
                else if(e.getSource()==a10RadioButton){
                    if(a10RadioButton.isSelected()){
                        bits[5] = '1';
                    }
                    else{
                        bits[5] = '0';
                    }
                }
                else if(e.getSource()== a9RadioButton){
                    if(a9RadioButton.isSelected()){
                        bits[6] = '1';
                    }
                    else{
                        bits[6] = '0';
                    }
                }
                else if(e.getSource()== a8RadioButton){
                    if(a8RadioButton.isSelected()){
                        bits[7] = '1';
                    }
                    else{
                        bits[7] = '0';
                    }
                }
                else if(e.getSource()==a7RadioButton){
                    if(a7RadioButton.isSelected()){
                        bits[8] = '1';
                    }
                    else{
                        bits[8] = '0';
                    }
                }
                else if(e.getSource()==a6RadioButton){
                    if(a6RadioButton.isSelected()){
                        bits[9] = '1';
                    }
                    else{
                        bits[9] = '0';
                    }
                }
                else if(e.getSource()== a5RadioButton){
                    if(a5RadioButton.isSelected()){
                        bits[10] = '1';
                    }
                    else{
                        bits[10] = '0';
                    }
                }
                else if(e.getSource()== a4RadioButton){
                    if(a4RadioButton.isSelected()){
                        bits[11] = '1';
                    }
                    else{
                        bits[11] = '0';
                    }
                }
                else if(e.getSource()== a3RadioButton){
                    if(a3RadioButton.isSelected()){
                        bits[12] = '1';
                    }
                    else{
                        bits[12] = '0';
                    }
                }
                else if(e.getSource()== a2RadioButton){
                    if(a2RadioButton.isSelected()){
                        bits[13] = '1';
                    }
                    else{
                        bits[13] = '0';
                    }
                }
                else if(e.getSource()== a1RadioButton){
                    if(a1RadioButton.isSelected()){
                        bits[14] = '1';
                    }
                    else{
                        bits[14] = '0';
                    }
                }
                else{
                    if(a0RadioButton.isSelected()){
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
        a14RadioButton.addActionListener(listener);
        a13RadioButton.addActionListener(listener);
        a12RadioButton.addActionListener(listener);
        a11RadioButton.addActionListener(listener);
        a5RadioButton.addActionListener(listener);
        a8RadioButton.addActionListener(listener);
        a9RadioButton.addActionListener(listener);
        a7RadioButton.addActionListener(listener);
        a6RadioButton.addActionListener(listener);
        a4RadioButton.addActionListener(listener);
        a3RadioButton.addActionListener(listener);
        a2RadioButton.addActionListener(listener);
        a1RadioButton.addActionListener(listener);
        a10RadioButton.addActionListener(listener);
        a15RadioButton.addActionListener(listener);
        program1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner fileScanner = new Scanner(textArea2.getText());
                print(fileScanner.nextLine());
                textArea2.setText(textArea2.getText().substring(textArea2.getText().indexOf('\n')+1));
            }
        });
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
        textField8.setText(Parser.decToBin(pc.getPointer(), 12));
        textField9.setText(mar.getValue());
        textField10.setText(mbr.getValue());
        textField12.setText(ir.getValue());
    }
    public void decodeIns(){
        String opcode = ir.getValue().substring(0,6);
        String R = ir.getValue().substring(6,8);
        String IX  = ir.getValue().substring(8,10);
        String I = ir.getValue().substring(10,11);
        String address = ir.getValue().substring(11,16);
        String AL = ir.getValue().substring(8, 9);
        String LR = ir.getValue().substring(9, 10);
        String count = ir.getValue().substring(12, 16);
        String immed = "";
        String rx = "";
        String ry = "";
        String devid = "";
        String EA = "";
        String result = "";

        switch(Parser.binToDec(opcode)) {
            case 0: //HLT Stops the machine.
                pc.setPointer(32); ///TODO Should be 16, change later.
                mem.setRun(false);
                mem.setHlt(true);
                textField13.setText(Boolean.toString(mem.getHlt()));
                textField14.setText(Boolean.toString(mem.getRun())); // Not running
                break;
            case 1: // LDR r, x, address[,I] r <- c(EA)
                EA = calculateEffectiveAddress(I, IX, address);
                result = mem.getMem(Parser.binToDec(EA));
                mar.setValue(EA);
                mbr.setValue(result);
                ir.setValue(mbr.getValue());
                registers[Parser.binToDec(R)].setValue(result);
                translateRtoTextField(Parser.binToDec(R), result);
                pc.incrementPointer();
                print("LDR Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                break;
            case 2: // STR r, x, address[,I] Memory(EA) <- c(r)
                EA = calculateEffectiveAddress(I, IX, address);
                mar.setValue(EA);
                mbr.setValue(registers[Parser.binToDec(R)].getValue());
                ir.setValue(mbr.getValue());
                cache.add(Parser.binToDec(mar.getValue()), Parser.binToDec(mbr.getValue()));
                pc.incrementPointer();
                print("STR Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                break;
            case 3: // LDA r, x, address[,I] r <- EA
                EA = calculateEffectiveAddress(I, IX, address);
                registers[Parser.binToDec(R)].setValue(EA);
                translateRtoTextField(Parser.binToDec(R), EA);
                pc.incrementPointer();
                print("LDA Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                break;
            case 33: // LDX x, address[,I] Xx <- c(EA)
                if(Parser.binToDec(IX) < 1) { // No Index Register 0
                    print("Index Register 0 is not created!");
                    break;
                } else {
                    EA = calculateEffectiveAddress(I, IX, address);
                    result = mem.getMem(Parser.binToDec(EA));
                    mar.setValue(EA);
                    mbr.setValue(result);
                    ir.setValue(result);
                    registers[Parser.binToDec(IX) + 3].setValue(result); // I1 = registers[4], I2 = registers[5], I3 = registers[6]
                    translateIXtoTextField(Parser.binToDec(IX), result);
                    pc.incrementPointer();
                    print("LDX Instruction " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                }
                break;
            case 34: // STX x, address[,I] Memory(EA) <- c(Xx)
                if(Parser.binToDec(IX) < 1) { // No Index Register 0
                    print("Index Register 0 is not created!");
                    break;
                } else {
                    EA = calculateEffectiveAddress(I, IX, address);
                    mar.setValue(EA);
                    mbr.setValue(registers[Parser.binToDec(IX) + 3].getValue());
                    ir.setValue(mbr.getValue());
                    cache.add(Parser.binToDec(mar.getValue()), Parser.binToDec(mbr.getValue()));
                    pc.incrementPointer();
                    print("STX Instruction " + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                }
                break;
            case 8: // JZ r, x, address[,I]
                // Jump If Zero:
                // If c(r) = 0, then PC <- EA
                // Else PC <- PC+1
                if(Parser.binToDec(registers[Parser.binToDec(R)].getValue()) == 0) {
                    EA = calculateEffectiveAddress(I, IX, address);
                    pc.setPointer(Parser.binToDec(EA));
                    print("JZ Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                } else {
                    pc.incrementPointer();
                    print("JZ Instruction Failed " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                }
                break;
            case 9: // JNE r, x, address[,I]
                // Jump If Not Equal:
                // If c(r) != 0, then PC - EA
                // Else PC <- PC + 1
                if(Parser.binToDec(registers[Parser.binToDec(R)].getValue()) != 0) {
                    EA = calculateEffectiveAddress(I, IX, address);
                    pc.setPointer(Parser.binToDec(EA));
                    print("JNE Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                } else {
                    pc.incrementPointer();
                    print("JNE Instruction Failed " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                }
                break;
            case 10: // JCC cc, x, address[,I]
                // Jump If Condition Code
                // cc replaces r for this instruction
                // cc takes values 0, 1, 2, 3 as above and specifies the bit in the Condition Code Register to check;
                // If cc bit  = 1, PC <- EA
                // Else PC <- PC + 1
                if(cc.getValueByPlace(Parser.binToDec(R)) == true) {
                    EA = calculateEffectiveAddress(I, IX, address);
                    pc.setPointer(Parser.binToDec(EA));
                    print("JCC Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                } else {
                    pc.incrementPointer();
                    print("JCC Instruction Failed " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                }
                break;
            case 11: // JMA x, address[,I]
                // Unconditional Jump To Address
                // PC <- EA,
                // Note: r is ignored in this instruction
                EA = calculateEffectiveAddress(I, IX, address);
                pc.setPointer(Parser.binToDec(EA));
                print("JMA Instruction " + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                break;
            case 12: // JSR x, address[,I]
                // Jump and Save Return Address:
                // R3 <- PC+1;
                // PC <- EA
                // R0 should contain pointer to arguments
                // Argument list should end with –1 (all 1s) value
                EA = calculateEffectiveAddress(I, IX, address);
                registers[3].setValue(Parser.decToBin(pc.getPointer() + 1, 16));
                pc.setPointer(Parser.binToDec(EA));
                print("JSR Instruction " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                break;
            case 13: // RFS Immed
                // Return From Subroutine w/ return code as Immed portion (optional) stored in the instruction’s address field.
                // R0 <- Immed; PC <- c(R3)
                // IX, I fields are ignored.
                registers[0].setValue(address);
                pc.setPointer(Parser.binToDec(registers[3].getValue()));
                print("RFS Instruction " + Integer.toString(Parser.binToDec(address)));
                break;
            case 14: // SOB r, x, address[,I]
                // Subtract One and Branch. R = 0..3
                // r <- c(r) – 1
                // If c(r) > 0,  PC <- EA;
                // Else PC <- PC + 1
                EA = calculateEffectiveAddress(I, IX, address);
                registers[Parser.binToDec(R)].setValue(Parser.decToBin(Parser.binToDec(registers[Parser.binToDec(R)].getValue()) - 1, 16));
                if(Parser.binToDec(registers[Parser.binToDec(R)].getValue()) > 0) {
                    pc.setPointer(Parser.binToDec(EA));
                    print("SOB Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                } else {
                    pc.incrementPointer();
                    print("SOB Instruction Failed " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                }
                break;
            case 15: // JGE r,x, address[,I]
                // Jump Greater Than or Equal To:
                // If c(r) >= 0, then PC <- EA
                // Else PC <- PC + 1
                EA = calculateEffectiveAddress(I, IX, address);
                if(Parser.binToDec(registers[Parser.binToDec(R)].getValue()) >= 0) {
                    pc.setPointer(Parser.binToDec(EA));
                    print("JGE Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                } else {
                    pc.incrementPointer();
                    print("JGE Instruction Failed " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                }
                break;
            case 4: // AMR r, x, address[,I]
                // Add Memory To Register, r = 0..3
                //r <- c(r) + c(EA)
                EA = calculateEffectiveAddress(I, IX, address);
                result = mem.getMem(Parser.binToDec(EA));
                int temp = Parser.binToDec(registers[Parser.binToDec(R)].getValue()) + Parser.binToDec(result);
                if(temp > 65535) { // check whether the sum is greater the maximum of 16 bits binary
                    cc.setOverflow(true);
                    print("AMR Instruction overflow " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                } else {
                    registers[Parser.binToDec(R)].setValue(Parser.decToBin(temp, 16));
                    print("AMR Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                }
                pc.incrementPointer();
                break;
            case 5: // SMR r, x, address[,I]
                // Subtract Memory From Register, r = 0..3
                // r <- c(r) – c(EA)
                EA = calculateEffectiveAddress(I, IX, address);
                result = mem.getMem(Parser.binToDec(EA));
                temp = Parser.binToDec(registers[Parser.binToDec(R)].getValue()) - Parser.binToDec(result);
                registers[Parser.binToDec(R)].setValue(Parser.decToBin(temp, 16));
                print("SMR Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(IX)) + " " + Integer.toString(Parser.binToDec(address)) + " " + Integer.toString(Parser.binToDec(I)));
                pc.incrementPointer();
                break;
            case 6: // AIR r, immed
                // Add  Immediate to Register, r = 0..3
                // r <- c(r) + Immed
                // Note:
                // 1. if Immed = 0, does nothing
                // 2. if c(r) = 0, loads r with Immed
                // IX and I are ignored in this instruction
                immed = address;
                if(Parser.binToDec(immed) != 0) {
                    if(Parser.binToDec(registers[Parser.binToDec(R)].getValue()) == 0) {
                        registers[Parser.binToDec(R)].setValue(immed);
                        print("AIR Instruction c(r) = 0 " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(address)));
                    } else {
                        temp = Parser.binToDec(registers[Parser.binToDec(R)].getValue()) + Parser.binToDec(immed);
                        if(temp > 65535) { // check whether the sum is greater the maximum of 16 bits binary
                            cc.setOverflow(true);
                            print("AIR Instruction overflow " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(address)));
                        } else {
                            registers[Parser.binToDec(R)].setValue(Parser.decToBin(temp, 16));
                            print("AIR Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(address)));
                        }
                    }
                } else {
                    print("AIR Instruction immed = 0 " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(address)));
                }
                pc.incrementPointer();
                break;
            case 7: // SIR r, immed
                // Subtract  Immediate  from Register, r = 0..3
                // r <- c(r) - Immed
                // Note:
                // 1. if Immed = 0, does nothing
                // 2. if c(r) = 0, loads r1 with –(Immed)
                // IX and I are ignored in this instruction
                immed = address;
                if(Parser.binToDec(immed) != 0) {
                    if(Parser.binToDec(registers[Parser.binToDec(R)].getValue()) == 0) {
                        temp = Parser.binToDec(immed) * -1;
                        if (temp >= 0) { // check whether need to fit the length
                            String fitLength = Integer.toBinaryString(temp);
                            while (fitLength.length() < 32) {
                                fitLength = "0" + fitLength;
                            }
                            registers[Parser.binToDec(R)].setValue(fitLength.substring(16, 32)); // Only get last 16 bits in Integer
                        } else {
                            registers[Parser.binToDec(R)].setValue(Integer.toBinaryString(temp).substring(16, 32)); // Only get last 16 bits in Integer
                        }
                        print("SIR Instruction c(r) = 0 " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(address)));
                    } else {
                        temp = Parser.binToDec(registers[Parser.binToDec(R)].getValue()) - Parser.binToDec(immed);
                        registers[Parser.binToDec(R)].setValue(Parser.decToBin(temp, 16));
                        print("SIR Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(address)));
                    }
                } else {
                    print("SIR Instruction immed = 0 " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(address)));
                }
                pc.incrementPointer();
                break;
            case 16: // MLT rx,ry
                // Multiply Register by Register
                // rx, rx+1 <- c(rx) * c(ry)
                // rx must be 0 or 2
                // ry must be 0 or 2
                // rx contains the high order bits, rx+1 contains the low order bits of the result
                // Set OVERFLOW flag, if overflow
                rx = R;
                ry = IX;
                if((Parser.binToDec(rx) == 0 || Parser.binToDec(rx) == 2) && (Parser.binToDec(ry) == 0 || Parser.binToDec(ry) == 2)) {
                    long bigTemp = Parser.binToDec(registers[Parser.binToDec(rx)].getValue()) * Parser.binToDec(registers[Parser.binToDec(ry)].getValue());
                    if(bigTemp > 4294967295L) { // check whether the sum is greater the maximum of 32 bits binary
                        cc.setOverflow(true);
                        print("MLT Instruction overflow " + Integer.toString(Parser.binToDec(rx)) + " " + Integer.toString(Parser.binToDec(ry)));
                    } else {
                        String fitLength = Integer.toBinaryString((int) bigTemp);
                        while (fitLength.length() < 32) {
                            fitLength = "0" + fitLength;
                        }
                        registers[Parser.binToDec(rx)].setValue(fitLength.substring(0, 16));
                        registers[Parser.binToDec(rx + 1)].setValue(fitLength.substring(16, 32));
                        print("MLT Instruction " + Integer.toString(Parser.binToDec(rx)) + " " + Integer.toString(Parser.binToDec(ry)));
                    }
                } else {
                    print("MLT Instruction rx or ry are not equal to 0 or 2 " + Integer.toString(Parser.binToDec(rx)) + " " + Integer.toString(Parser.binToDec(ry)));
                }
                pc.incrementPointer();
                break;
            case 17: // DVD rx,ry
                // Divide Register by Register
                // rx, rx+1 <- c(rx)/ c(ry)
                // rx must be 0 or 2
                // rx contains the quotient; rx+1 contains the remainder
                // ry must be 0 or 2
                // If c(ry) = 0, set cc(3) to 1 (set DIVZERO flag)
                rx = R;
                ry = IX;
                if((Parser.binToDec(rx) == 0 || Parser.binToDec(rx) == 2) && (Parser.binToDec(ry) == 0 || Parser.binToDec(ry) == 2)) {
                    if(Parser.binToDec(registers[Parser.binToDec(ry)].getValue()) == 0) {
                        cc.setDivzero(true);
                        print("DVD Instruction divided by zero " + Integer.toString(Parser.binToDec(rx)) + " " + Integer.toString(Parser.binToDec(ry)));
                    } else {
                        int quotient = Parser.binToDec(registers[Parser.binToDec(rx)].getValue()) /  Parser.binToDec(registers[Parser.binToDec(ry)].getValue());
                        int reminder = Parser.binToDec(registers[Parser.binToDec(rx)].getValue()) %  Parser.binToDec(registers[Parser.binToDec(ry)].getValue());
                        registers[Parser.binToDec(rx)].setValue(Parser.decToBin(quotient, 16));
                        registers[Parser.binToDec(rx + 1)].setValue(Parser.decToBin(reminder, 16));
                        print("DVD Instruction " + Integer.toString(Parser.binToDec(rx)) + " " + Integer.toString(Parser.binToDec(ry)));
                    }
                } else {
                    print("DVD Instruction rx or ry are not equal to 0 or 2 " + Integer.toString(Parser.binToDec(rx)) + " " + Integer.toString(Parser.binToDec(ry)));
                }
                pc.incrementPointer();
                break;
            case 18: // TRR rx, ry
                // Test the Equality of Register and Register
                // If c(rx) = c(ry), set cc(4) <- 1; else, cc(4) <- 0
                rx = R;
                ry = IX;
                if(Parser.binToDec(registers[Parser.binToDec(rx)].getValue()) == Parser.binToDec(registers[Parser.binToDec(ry)].getValue())) {
                    cc.setEqualornot(true);
                    print("TRR Instruction rx is equal to ry (EQUALORNOT) " + Integer.toString(Parser.binToDec(rx)) + " " + Integer.toString(Parser.binToDec(ry)));
                } else {
                    cc.setEqualornot(false);
                    print("TRR Instruction rx is not equal to ry " + Integer.toString(Parser.binToDec(rx)) + " " + Integer.toString(Parser.binToDec(ry)));
                }
                pc.incrementPointer();
                break;
            case 19: // AND rx, ry
                // Logical And of Register and Register
                // c(rx) <- c(rx) AND c(ry)
                rx = R;
                ry = IX;
                registers[Parser.binToDec(rx)].setValue(Parser.decToBin(Parser.binToDec(registers[Parser.binToDec(rx)].getValue()) & Parser.binToDec(registers[Parser.binToDec(ry)].getValue()), 16));
                print("AND Instruction " + Integer.toString(Parser.binToDec(rx)) + " " + Integer.toString(Parser.binToDec(ry)));
                pc.incrementPointer();
                break;
            case 20: // ORR rx, ry
                // Logical Or of Register and Register
                // c(rx) <- c(rx) OR c(ry)
                rx = R;
                ry = IX;
                registers[Parser.binToDec(rx)].setValue(Parser.decToBin(Parser.binToDec(registers[Parser.binToDec(rx)].getValue()) | Parser.binToDec(registers[Parser.binToDec(ry)].getValue()), 16));
                print("ORR Instruction " + Integer.toString(Parser.binToDec(rx)) + " " + Integer.toString(Parser.binToDec(ry)));
                pc.incrementPointer();
                break;
            case 21: // NOT rx
                // Logical Not of Register To Register
                // C(rx) <- NOT c(rx)
                rx = R;
                String flipString = "";
                String fitLength = registers[Parser.binToDec(rx)].getValue();
                while (fitLength.length() < 16) {
                    fitLength = "0" + fitLength;
                }
                for(int i = 0; i < fitLength.length(); i++) {
                    if(fitLength.charAt(i) == '0') {
                        flipString += "1";
                    } else {
                        flipString += "0";
                    }
                }
                registers[Parser.binToDec(rx)].setValue(flipString);
                print("NOT Instruction " + Integer.toString(Parser.binToDec(rx)));
                pc.incrementPointer();
                break;
            case 25: // SRC r, count, L/R, A/L
                // Shift Register by Count
                // c(r) is shifted left (L/R =1) or right (L/R = 0) either logically (A/L = 1) or arithmetically (A/L = 0)
                // XX, XXX are ignored
                // Count = 0…15
                // If Count = 0, no shift occurs
                if(Parser.binToDec(count) == 0) {
                    print("SRC Instruction no shift occurs " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(count)) + Integer.toString(Parser.binToDec(LR)) + " " + Integer.toString(Parser.binToDec(AL)));
                } else {
                    if(Parser.binToDec(AL) == 0 && Parser.binToDec(LR) == 0) { // Arithmetically Right Shift
                        int shiftNumber = Parser.binToDec(registers[Parser.binToDec(R)].getValue());
                        String fitLengthSRC = Integer.toBinaryString(shiftNumber);
                        String resultSRC = "";
                        while (fitLengthSRC.length() < 16) { // fit 16 bits length
                            fitLengthSRC = "0" + fitLengthSRC;
                        }
                        for(int i = 0; i < Parser.binToDec(count); i++) { // check the first bit
                            if(fitLengthSRC.charAt(0) == '0') {
                                resultSRC = resultSRC + "0";
                            } else {
                                resultSRC = resultSRC + "1";
                            }
                        }
                        resultSRC = resultSRC + fitLengthSRC.substring(0, 16 - Parser.binToDec(count));
                        registers[Parser.binToDec(R)].setValue(resultSRC);
                    }
                    if(Parser.binToDec(AL) == 0 && Parser.binToDec(LR) == 1) { // Arithmetically Left Shift
                        int shiftNumber = Parser.binToDec(registers[Parser.binToDec(R)].getValue());
                        shiftNumber = shiftNumber << Parser.binToDec(count);
                        registers[Parser.binToDec(R)].setValue(Parser.decToBin(shiftNumber, 16));
                    }
                    if(Parser.binToDec(AL) == 1 && Parser.binToDec(LR) == 0) { // Logical Right Shift
                        int shiftNumber = Parser.binToDec(registers[Parser.binToDec(R)].getValue());
                        shiftNumber = shiftNumber >> Parser.binToDec(count);
                        registers[Parser.binToDec(R)].setValue(Parser.decToBin(shiftNumber, 16));
                    }
                    if(Parser.binToDec(AL) == 1 && Parser.binToDec(LR) == 1) { // // Logical Left Shift
                        int shiftNumber = Parser.binToDec(registers[Parser.binToDec(R)].getValue());
                        shiftNumber = shiftNumber << Parser.binToDec(count);
                        registers[Parser.binToDec(R)].setValue(Parser.decToBin(shiftNumber, 16));
                    }
                    print("SRC Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(count)) + Integer.toString(Parser.binToDec(LR)) + " " + Integer.toString(Parser.binToDec(AL)));
                }
                pc.incrementPointer();
                break;
            case 26: // RRC r, count, L/R, A/L
                // Rotate Register by Count
                // c(r) is rotated left (L/R = 1) or right (L/R =0) either logically (A/L =1)
                // XX, XXX is ignored
                // Count = 0…15
                // If Count = 0, no rotate occurs
                if(Parser.binToDec(count) == 0) {
                    print("RRC Instruction no shift occurs " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(count)) + Integer.toString(Parser.binToDec(LR)) + " " + Integer.toString(Parser.binToDec(AL)));
                } else {
                    String resultRRC = "";
                    String tempRRC = registers[Parser.binToDec(R)].getValue();
                    if(Parser.binToDec(LR) == 0) { // rotated right
                        resultRRC = tempRRC.substring(tempRRC.length() - Parser.binToDec(count), tempRRC.length()) + tempRRC.substring(0, tempRRC.length() - Parser.binToDec(count));
                        // target.substring(length - 5, length) + target.substring(0, length - 5)
                        registers[Parser.binToDec(R)].setValue(resultRRC);
                    }
                    if(Parser.binToDec(LR) == 1) { // rotated left
                        resultRRC = tempRRC.substring(Parser.binToDec(count), tempRRC.length()) + tempRRC.substring(0, Parser.binToDec(count));
                        //target.substring(5, length) + target.substring(0, 5))
                        registers[Parser.binToDec(R)].setValue(resultRRC);
                    }
                    print("RRC Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(count)) + Integer.toString(Parser.binToDec(LR)) + " " + Integer.toString(Parser.binToDec(AL)));
                }
                pc.incrementPointer();
                break;
            case 49: // IN r, devid
                // Input Character To Register from Device, r = 0..3
                devid = address;
                String resultIN = "";
                //if(Parser.binToDec(devid) == 0) {
                    Scanner fileScanner = new Scanner(textArea2.getText());
                    resultIN = fileScanner.nextLine();
                    textArea2.setText(textArea2.getText().substring(textArea2.getText().indexOf('\n') + 1));
                    registers[Parser.binToDec(R)].setValue(Parser.decToBin(Integer.parseInt(resultIN), 16));
                //}
                pc.incrementPointer();
                print("IN Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(devid)));
                break;
            case 50: // OUT r, devid
                // Output Character to Device from Register, r = 0..3
                devid = address;
                int resultOUT;
                resultOUT = Parser.binToDec(registers[Parser.binToDec(R)].getValue());
                print(Integer.toString(resultOUT));
                pc.incrementPointer();
                print("OUT Instruction " + Integer.toString(Parser.binToDec(R)) + " " + Integer.toString(Parser.binToDec(devid)));
                break;
            default:
                print("The opcode " + Parser.binToDec(opcode) + "is not listed!");
                break;
        }
    }
    public void translateRtoTextField(int r, String result) {
        switch(r) {
            case 0:
                textField1.setText(result);
                break;
            case 1:
                textField2.setText(result);
                break;
            case 2:
                textField3.setText(result);
                break;
            case 3:
                textField4.setText(result);
                break;
        }
    }
    public void translateIXtoTextField(int IX, String result) {
        switch(IX) {
            case 1:
                textField5.setText(result);
                break;
            case 2:
                textField6.setText(result);
                break;
            case 3:
                textField7.setText(result);
                break;
        }
    }
    public String calculateEffectiveAddress(String I, String IX, String address) {
        String result = "";

        if (Parser.binToDec(I) == 0) { // NO indirect addressing
            if (Parser.binToDec(IX) == 0) { // IX == 00
                result = address;
                //result = mem.getMem(Parser.binToDec(address));
            } else { // IX == 1..3 EA = c(IX) + c(Address Field)
                int EA = Parser.binToDec(address) + Parser.binToDec(registers[Parser.binToDec(IX) + 3].getValue()); // I1 = registers[4], I2 = registers[5], I3 = registers[6]
                result = Parser.decToBin(EA, 16);
                //result = mem.getMem(EA);
            }
        } else {
            if (Parser.binToDec(IX) == 0) { // indirect addressing, but NO indexing
                result = mem.getMem(Parser.binToDec(address));
                //result = mem.getMem(Parser.binToDec(mem.getMem(Parser.binToDec(address))));
            } else { // both indirect addressing and indexing
                int EA = Parser.binToDec(address) + Parser.binToDec(registers[Parser.binToDec(IX) + 3].getValue());
                result = mem.getMem(EA);
                //result = mem.getMem(Parser.binToDec(mem.getMem(EA)));
            }
        }
        return result;
    }
    public void print(String result) {
        textArea1.append(result + "\n");
    }

    public static void main(String[] args) {
        /*
        Main function
        * */
        JFrame frame = new JFrame("C1");
        C1 c1 = new C1(frame);
        frame.setContentPane(c1.ROOT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,950,700);
        frame.setVisible(true);
    }
}