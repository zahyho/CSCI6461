public class IR {
    private String value;
    private int size;
    IR(){
        this.size = 16;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getInsFromMBR(MBR mbr){
        String instruction = mbr.getValue();
        this.setValue(instruction);
        return instruction;
    }
    public String decodeIns(String instruction){
        return "";
    }
}
