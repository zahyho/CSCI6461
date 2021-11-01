import java.io.*;
import java.util.*;

public class Memory {
    static final int MEMORY_SIZE = 2048;
    // we use hashtable to implement memory
    // It has capacity of 4096 blocks of max 16bits
    public int size;
    private Hashtable<Integer,String> Mem;
    private int cap;
    private boolean upload;
    private boolean run;
    private boolean hlt;

    Memory(){
        //initialization of memory
        this.size = 16;
        this.cap = MEMORY_SIZE;
        this.Mem = new Hashtable<Integer,String>(cap);
        for(int i =0;i<cap;i++){
            this.Mem.put(i,"0000000000000000");
        }
        this.upload = false;
        this.run = false;
        this.hlt = false;
    }
    //Set memory value based on index
    public void setMem(int index, String data){
        try {
            if(index >= MEMORY_SIZE) {
                throw new Exception("Out of Boundary");
            }
        } catch (Exception e) {
            System.out.println("The maximum memory size is " + MEMORY_SIZE);
        }
        this.Mem.put(index,data);
    }

    // get memory value based on index
    public String getMem(int index){
        try {
            if(index >= MEMORY_SIZE) {
                throw new Exception("Out of Boundary");
            }
        } catch (Exception e) {
            System.out.println("The maximum memory size is " + MEMORY_SIZE);
        }
        return this.Mem.get(index);
    }

    public void setUpload(boolean upload) {
        this.upload = upload;
    }

    public boolean getUpload() {
        return this.upload;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public boolean getRun() {
        return this.run;
    }

    public void setHlt(boolean hlt) {
        this.hlt = hlt;
    }

    public boolean getHlt() {
        return this.hlt;
    }

    public void loadIPL() {
        try{
            // read IPL file
            this.upload = false;
            File file = new FileBrowser().Browse();
            FileInputStream filestream = new FileInputStream(file);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(filestream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String eachLine;

            while ((eachLine = br.readLine()) != null)   {
                String[] splited = eachLine.split("\\s+");

                System.out.println(Long.parseLong(splited[0], 16));
                System.out.println(Long.parseLong(splited[1], 16));
                System.out.println(Parser.decToBin((int)Long.parseLong(splited[1], 16), 16));
                // Long.parseLong(splited[0], 16) is convert first part to memory address.
                // Parser.decToBin((int)Long.parseLong(splited[1], 16), 16) is convert second part to 16-bits string.
                Mem.put((int)Long.parseLong(splited[0], 16), Parser.decToBin((int)Long.parseLong(splited[1], 16), 16));
            }
            this.upload = true;
            //Close the input stream
            in.close();
        }catch (Exception e){
            System.err.println(e);
            System.err.println("Could not find IPL file!");
        }
    }
}
