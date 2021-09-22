import java.io.*;
import java.util.*;
public class MAR {
    /*
    the Memory control unit uses the value in the MAR to acces that location
    * */
    // MAR Value
    private String value;
    //MAR size
    private int size;
    MAR(){
        this.size = 12;
    }
    //gets the value from PC
    public String getAddressfromPC(ProgramCounter pc){
        String address = pc.getValue();
        this.setValue(address);
        return address;
    }
    //getters and setters
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
