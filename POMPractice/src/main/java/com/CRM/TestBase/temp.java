package com.CRM.TestBase;

import java.util.Scanner;

public class temp {
    public String rev(String str){
        String temp = "";
        for (int i=str.length(); i>0;i--){
            temp = temp + str.charAt(i);
           
        }
    return temp;
    } 
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        boolean call = false;
        temp s = new temp();
        Scanner scan = new Scanner(System.in);
        String inpstr = scan.nextLine();
        String []arr = inpstr.split(" "); 
        for (int val = 0; val<arr.length;val++){
            if (arr[val].equalsIgnoreCase("t")){
                if(val%2==0){
                    call = true;
                }
            }
        }
        if (call){
            s.rev(inpstr);
        }
    }
}
