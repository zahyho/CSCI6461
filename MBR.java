public class MBR {
    private String value;
    private int size;
    MBR(){
        this.size = 16;
    }
    public String getInstruction(MAR mar,Memory mem){
        int addressInDec = new Parser().binToDec(mar.getValue());
        String inst = mem.getMem(addressInDec);
        this.setValue(inst);
        return inst;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void load(String data){
        this.setValue(data);
    }
}
