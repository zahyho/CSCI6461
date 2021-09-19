import java.io.*;
import java.util.*;

public class Memory {
    private Hashtable<Integer,String> Mem;
    private int cap;
    Memory(){
        this. cap = 4096;
        this.Mem = new Hashtable<Integer,String>(cap);
        for(int i =0;i<cap;i++){
            this.Mem.put(i,"0000000000000000");
        }
    }
    public void setMem(int index, String data){
        this.Mem.put(index,data);
    }
    public String getMem(int index){
        return this.Mem.get(index);
    }
}
