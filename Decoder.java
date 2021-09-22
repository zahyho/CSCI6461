public class Decoder {
    //decode the expression
    //decoded opcode
    private int opcode;
    //decoded gpr
    private int gpr;
    //decode ixr
    private int ixr;
    //indirect addressing
    private int i;
    //address
    private int address;
    Decoder(){
        this.opcode = 0;
        this.address = 0;
        this.i = 0;
        this.ixr = 0;
        this.gpr = 0;
    }
    //takes the Instruction register to decode the value in it
    public void decode(IR ir){
        String ins = ir.getValue();
        String op_str = ins.substring(10);
        String gpr_str = ins.substring(8,10);
        String ixr_str = ins.substring(6,8);
        String i_str = ""+ins.charAt(5);
        String address_str = ins.substring(0,5);
        Parser parser = new Parser();
        this.opcode = parser.binToDec(op_str);
        this.gpr = parser.binToDec(gpr_str);
        this.ixr = parser.binToDec(ixr_str);
        this.i = parser.binToDec(i_str);
        this.address = parser.binToDec(address_str);
    }

    public int getAddress() {
        return address;
    }

    public int getGpr() {
        return gpr;
    }

    public int getI() {
        return i;
    }

    public int getIxr() {
        return ixr;
    }

    public int getOpcode() {
        return opcode;
    }
}
