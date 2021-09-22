public class MCU {
    /*
    uses the mar and mbr to access and store to memory
    * */
    public void memoryDecode(MAR mar,MBR mbr,Memory mem){
        /*
        * decode mar and access memory and set mbr
        * */
        int addressInDec = new Parser().binToDec(mar.getValue());
        String inst = mem.getMem(addressInDec);
        mbr.setValue(inst);
    }
    public void memoryAccessGET(MAR mar,Memory mem,MBR mbr){
        // get from memory
        int addressInDec = new Parser().binToDec(mar.getValue());
        mbr.setValue(mem.getMem(addressInDec));
    }
    public void memoryAccessSET(Memory mem,MBR mbr,MAR mar){
        //store to memory
        int addressInDec = new Parser().binToDec(mar.getValue());
        mem.setMem(addressInDec, mbr.getValue());
    }
}
