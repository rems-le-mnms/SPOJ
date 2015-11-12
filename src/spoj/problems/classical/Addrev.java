/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/ADDREV/
==========================================================
STATUS : AC in 0.19s
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Addrev {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList <String> finalRes=new ArrayList <String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=0;
        try {
        	n=Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
        }
        int cnt=0;
        while(cnt<n) {
        	String[] str=br.readLine().split(" ");
        	StringBuffer strb1=new StringBuffer(str[0]);
        	StringBuffer strb2=new StringBuffer(str[1]);
        	boolean stop=true;
        	while(stop) {
        		if(strb1.charAt(0)=='0') {
        			strb1.deleteCharAt(0);
        		} else {
        			stop=false;
        		}
        	}
        	stop=true;
        	while(stop) {
        		if(strb2.charAt(0)=='0') {
        			strb2.deleteCharAt(0);
        		} else {
        			stop=false;
        		}
        	}
        	int nb1=Integer.parseInt(strb1.reverse().toString());
        	int nb2=Integer.parseInt(strb2.reverse().toString());
        	int sum=nb1 + nb2;
        	StringBuffer res=new StringBuffer(Integer.toString(sum)).reverse();
        	stop=true;
        	while(stop) {
        		if(res.charAt(0)=='0') {
        			res.deleteCharAt(0);
        		} else {
        			stop=false;
        		}
        	}
        	finalRes.add(res.toString());
        	cnt++;
        }
        for(int i=0;i<finalRes.size();i++) {
        	System.out.println(finalRes.get(i));
        }
    
	}

}
