import javax.swing.*;

public class Register {
    //Used to simulate a register
    private String value;
    private int size;
    Register(){
        this.value = "0000000000000000";
        this.size = 16;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
