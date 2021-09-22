import java.io.*;
import java.util.*;
public class Parser {
    // to parse the binary to deimal and decimal to binary

    //bin to decimal
    public int binToDec(String bin){
        String temp = "";
        for(String st:bin.split(" ")){
            temp += st;
        }
        return Integer.parseInt(temp,2);
    }

    //decimal to binary and gives output in specified length
    //useful for 12 and 16bits registers
    public String decToBin(int dec,int size){
        String binString = Integer.toBinaryString(dec);
        int length = binString.length();
        int numZeros = size-length;
        String str = binString;
        for(int i = 0;i<numZeros;i++){
            str = "0"+str;
        }
        return str;
    }
}
