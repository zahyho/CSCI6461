import java.io.*;
import java.util.*;

public class Memory {
    // we use hashtable to implement memory
    // It has capacity of 4096 blocks of max 16bits
    public int size;
    private Hashtable<Integer,String> Mem;
    private int cap;

    Memory(){
        //initialization of memory
        this.size = 16;
        this. cap = 4096;
        this.Mem = new Hashtable<Integer,String>(cap);
        for(int i =0;i<cap;i++){
            this.Mem.put(i,"0000000000000000");
        }
    }
    //getters and setters
    public void setMem(int index, String data){
        this.Mem.put(index,data);
    }
    public String getMem(int index){
        return this.Mem.get(index);
    }
}
