import java.io.*;
import java.util.*;
public class Parser {
    public int binToDec(String bin){
        String temp = "";
        for(String st:bin.split(" ")){
            temp += st;
        }
        return Integer.parseInt(temp,2);
    }
    public String decToBin(int dec,int size){
        String binString = Integer.toBinaryString(dec);
        int length = binString.length();
        int numZeros = size-length;
        String str = "";
        for(int i = 0;i<numZeros;i++){
            str = "0"+str;
        }
        str = str.trim();
        return str;
    }
}
