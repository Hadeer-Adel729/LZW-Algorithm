package lz.w;

import java.util.ArrayList;

public class Compression {

    private String seq;
    public static ArrayList<Integer> tags = new ArrayList<Integer>();
    public static String[] dic;

    public Compression(String str) {
        seq = str;
        this.dic = new String[1000];
        for (int i = 0; i <= 255; i++) {
            String ch = "";
            ch += (char) i;
            dic[i] = ch;
        }
    }

    public void compress() {
        String st = "", temp = "";
        int counter =0;
        int indx = 256;
        for (int i = 0; i < seq.length(); i++) {
            st += seq.charAt(i);

            temp = st + seq.charAt(i + 1);
            if (search(temp) != -1) {
                i += 2;
                if (i < seq.length()) {
                    temp += seq.charAt(i);
                    while (search(temp) != -1) {
                        temp += seq.charAt(i);
                        i++;
                    }
                    
                    tags.add(search(temp.substring(0, temp.length()-1 )));
                   // System.out.println(tags);
                  
                    dic[counter+256]=temp;
                   // System.out.println("Dic is" + search(dic[counter+256]));
                    counter++;
                    i--;
                   

                } else {
                    
                    tags.add(search(temp));
                   // System.out.println(tags);
                    break;
                    
                }

            } else {//ABAABABBAABAABAAAABABBBBBBBB
                tags.add(search(st));
              //  System.out.println(tags);
                dic[counter+256]= temp;
                //System.out.println("Dic is" + search(dic[counter+256]));
                counter++;
                

            }

            st = "";
            temp="";
        }
    }

    public void Display() {


        for (int i = 0; i < tags.size(); i++) {
            System.out.print(tags.get(i) + " ");
        }
    }

    public int search(String st) {
        for (int i = 0; i < dic.length; i++) {
            if (st.equals(dic[i])) {
                // System.out.println("st= " + st + " i= " + i);
                return i;
            }
        }
        return -1;
    }
}
