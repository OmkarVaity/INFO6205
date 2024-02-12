package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UFClient {

    public static void main(String[] args) {
        int count = 0;
        int n = 0;
        int d = 100;
        if (args.length != 0){
            count = count(Integer.parseInt(args[0]));
        } else{
            Random random = new Random();
            for(int i=0; i< 15; i++){
                for(int j=0; j<10; j++){
                    count = count + count(d);
                }
                count = count / 10;
                System.out.println("For n: " + d + " Total connections made: " + count);
                d = d  * 2;
            }
        }
    }

    public static int count(int n){
        UF_HWQUPC uf = new UF_HWQUPC(n);
        int count = 0;
        if(n != 0){
            Random random = new Random();

            while(uf.components() != 1){
                int x = random.nextInt(n);
                int y = random.nextInt(n);
                if(!uf.connected(x,y)){
                    uf.union(x,y);
                }
                count++;
            }
        }
        return count;
    }
}
