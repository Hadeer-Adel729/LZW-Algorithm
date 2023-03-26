package lz.w;

import java.util.Scanner;

public class Decompression {

    private static String seq;
    private int tagsNum;

    public static String[] array;

    public Decompression(int tNum) {
        Decompression.seq = "";
        tagsNum = tNum;
        Decompression.array = new String[1000];

    }

    public void Decompress() {
        String temp = "";
        for (int i = 0; i < tagsNum; i++) {
            // get tags

            Scanner Obj = new Scanner(System.in);

            int index = Obj.nextInt();
            if (index <= 255 && index >= 0) {
                if (i == 0) {
                    seq += (char) index;
                    temp = seq;

                } else {
                    
                    seq += (char) index;

                    array[i + 255] = temp.concat(Character.toString((char) index));

                }
                if (temp.length() == 1) {
                    temp = temp.substring(1);
                    temp += (char) index;

                } else {
                    temp = "";
                    temp += (char) index;

                }

            } else {
                //index hasn't a seq 
                if (array[index] == null) {
                    seq = seq.concat(temp.concat(Character.toString(temp.charAt(0))));

                    array[i + 255] = temp.concat(Character.toString(temp.charAt(0)));

                    temp = temp.concat(Character.toString(temp.charAt(0)));

                } else {

                    for (int k = 256; k < Decompression.array.length; k++) {

                        if (array[index] == null ? array[k] == null : array[index].equals(array[k])) {

                            seq = seq.concat(array[index]);

                            array[i + 255] = temp.concat(Character.toString(array[index].charAt(0)));

                            temp = "";
                            temp = temp.concat(array[index]);

                        }

                    }
                }

            }

            
        }
        System.out.println("Final seq is: " + seq);
    }
}
