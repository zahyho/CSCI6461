import java.io.*;
import java.util.*;
public class ProgramCounter {
    /*
    * The value of the program counter is the address of the next instruction
    * */
    //current PC pointer
    private int pointer;
    //current PC value
    private String value;
    //PC size
    private int size;
    //Initializing Program Counter
    ProgramCounter(){
        this.size = 12;
        this.pointer = -1;
    }
    //increment pointer
    public void incrementPointer(){
        this.pointer++;
    }
    //get next instruction
    public void nextInstruction(Memory mem){
        this.incrementPointer();
        String address = mem.getMem(this.pointer);
        this.setValue(address.substring(4));
    }
    //getters and setters
    public String getValue(){
        return this.value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public int getPointer() {
        return pointer;
    }
}
