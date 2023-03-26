package lz.w;

import java.util.Scanner;

public class LZW {

    public static void main(String[] args) {
        Scanner Obj = new Scanner(System.in);

        System.out.println("Choose an option:\n 1-Compression \n 2-Decompression \n 3-Exit");
        int option = Obj.nextInt();

        switch (option) {

            case 1:

                System.out.println("Enter Sequence:");
                String seq = Obj.next();
                Compression compress = new Compression(seq);
                compress.compress();
                compress.Display();

                break;

            case 2:
                System.out.println("Enter number of tags:");
                int tnum = Obj.nextInt();
                Decompression obj = new Decompression(tnum);
                System.out.println("Enter Tags: ");
                obj.Decompress();

                break;

            case 3:
                System.out.println("Exit!");
                break;
        }

    }
}
