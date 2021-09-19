import java.io.*;
import java.util.*;
public class ProgramCounter {
    //memory for the PC
    private Hashtable<Integer,String> PCMem;
    //capacity for the PC
    private int cap;
    //current PC pointer
    private int pointer;
    //current PC value
    private String value;
    //PC size
    private int size;
    //Initializing Program Counter
    ProgramCounter(){
        this.size = 12;
        this.cap = 4096;
        this.PCMem = new Hashtable<Integer,String>(cap);
        for(int i =0;i<cap;i++){
            this.PCMem.put(i,"000000000000");
        }
        this.pointer = 0;
        this. value = this.PCMem.get(this.pointer);
    }
    public String nextInstruction(){
        //check for out of memory in future
        this.value = this.PCMem.get(this.pointer+1);
        return this.value;
    }
    public String getValue(){
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void load(String data){
        this.setValue(data);
    }
}
