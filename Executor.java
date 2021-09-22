public class Executor {

    /*
    *
    * Calculates effective addres and takes necessary action
    * */
    private String effAdress;

    public void calcEA(Register[] reg,int i,int ixr,int address,Memory mem){
        /*
        * Calculates effective address
        *
        * */
        int size  = mem.size;
        Parser parser = new Parser();
        int regValue;
        //if direct addressing
        if(i==0){
            //if ixr is not selected
            if(ixr==0){
                this.effAdress = parser.decToBin(address,size);
            }
            // if ixr is selected
            else{
                regValue = parser.binToDec(reg[3+ixr].getValue());
                this.effAdress = parser.decToBin(regValue+address,size);
            }
        }
        // if indirect adressing
        else{
            //in indirect addressing the effective address is resolved from the value in the given address
            //if ixr is not selected
            if(ixr==0){
                this.effAdress = mem.getMem(address);
            }
            //if ixr is selected
            else{
                regValue = parser.binToDec(reg[3+ixr].getValue());
                this.effAdress = mem.getMem(regValue+address);
            }
        }
    }
    public void execute(Memory mem,Register[] reg,Decoder decoder,MBR mbr, MAR mar,IRR irr,MCU mcu){
        //To execute the instruction

        //initialization
        int i,ixr,gpr,address,opcode;
        Parser parser = new Parser();
        i = decoder.getI();
        ixr = decoder.getIxr();
        gpr = decoder.getGpr();
        address = decoder.getAddress();
        opcode = decoder.getOpcode();
        String result;

        //calculate effective address
        calcEA(reg,i,ixr,address,mem);

        switch(opcode){
            //LDR
            case 1:
                //set mar
                mar.setValue(this.effAdress);
                //get from mem and store to mbr
                mcu.memoryAccessGET(mar,mem,mbr);
                // move to irr
                irr.setValue(mbr.getValue());
                // move to register
                irr.pushToRegister(reg[gpr]);
                break;
            //STR
            case 2:
                // set mar
                mar.setValue(this.effAdress);
                //set irr
                irr.setValue(reg[gpr].getValue());
                // move to mbr
                mbr.setValue(irr.getValue());
                // use mar for addres mbr for data and store to memory
                mcu.memoryAccessSET(mem,mbr,mar);
                break;
                /*
                * Similar concept is followed below
                * */
            //LDA
            case 3:
                irr.setValue(this.effAdress);
                irr.pushToRegister(reg[gpr]);
                break;
                //LDX
            case 41:
                mar.setValue(this.effAdress);
                mcu.memoryAccessGET(mar,mem,mbr);
                irr.setValue(mbr.getValue());
                irr.pushToRegister(reg[3+ixr]);
                break;
                //STX
            case 42:
                mar.setValue(this.effAdress);
                irr.setValue(reg[3+ixr].getValue());
                mbr.setValue(irr.getValue());
                mcu.memoryAccessSET(mem,mbr,mar);
            default:
                break;
        }
    }
}
