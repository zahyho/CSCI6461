public class IR {
    private String value;
    private int size;
    IR(){
        this.size = 16;
    }

    public void getInsFromMBR(MBR mbr){
        String instruction = mbr.getValue();
        this.setValue(instruction);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }

    public String decodeIns(String instruction){

        return "";
    }
}
