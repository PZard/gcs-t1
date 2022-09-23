package hash;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int reps = in.nextInt();

        in.nextLine();
        
        String[] output = new String[reps];
        for(int i = 0; i < reps; i++){
            String input = in.nextLine();
            String[] tableInfos = input.split(" ", -1);

            input = in.nextLine();
            String[] keysStr = input.split(" ", -1);

            int[] infos = new int[tableInfos.length];
            for(int j = 0; j < tableInfos.length; j++){
                infos[j] = Integer.parseInt(tableInfos[j]);
            }

            int[] keys = new int[keysStr.length];
            for(int j = 0; j < keys.length; j++){
                keys[j] = Integer.parseInt(keysStr[j]);
            }

            int[] addresses = new int[keys.length];
            for(int j = 0; j < keys.length; j++){
                int address = keys[j] % infos[0];
                addresses[j] = address;
            }
            
            String table = "";
            for(int j = 0; j < infos[0]; j++){
                String out = "";
                if(!(j == 0 && i == 0)){
                    out += "\n";
                }
                out += j + " -> ";
                for(int k = 0; k < addresses.length; k++){
                    if(j == addresses[k]){
                        out += keys[k] + " -> ";
                    }
                }
                out += "\\";
                table += out;
            }

            output[i] = table;
        }
        String ret = "";
        for(int i = 0; i < output.length; i++){
            ret += output[i] + "\n";
        }

        System.out.print(ret);
        in.close();
    }
 
}
