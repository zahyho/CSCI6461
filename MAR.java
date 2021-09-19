import java.io.*;
import java.util.*;
public class MAR {
    // MAR Value
    private String value;
    //MAR size
    private int size;
    MAR(){
        this.size = 12;
    }
    public String getAddressfromPC(ProgramCounter pc){
        String address = pc.getValue();
        this.setValue(address);
        return address;
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
