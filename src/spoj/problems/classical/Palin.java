/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/PALIN/
==========================================================
STATUS : WA
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Palin {

	public static void main(String[] args) throws Exception {
		ArrayList <String> finalRes=new ArrayList <String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n=0;
		n=Integer.parseInt(br.readLine());
		int cnt=0;
	    while(cnt<n) {
	    	StringBuffer str=new StringBuffer(br.readLine());
	    	boolean stop=true;
	    	while(stop) {
	    		int i=str.length()-1;
	    		if(str.charAt(i)==9) {
	    			str.replace(i, i+1, "0");
	    			i--;
	    			while(i>=0 && str.charAt(i)=='9') {
	    				str.replace(i, i+1, "0");
	    				i--;
	    			}
	    			if(i==-1) {
	    				str.reverse();
	    				str.append('1');
	    				str.reverse();
	    			} else {
	    				str.replace(i,i+1,Integer.toString(Integer.parseInt(str.substring(i,i+1))+1));
	    			}
	    		} else {
	    			str.replace(i,i+1,Integer.toString(Integer.parseInt(str.substring(i,i+1))+1));
	    		}
		    	if(str.toString().equals(str.reverse().toString())) {
		    		finalRes.add(str.toString());
		    		stop=false;
		    	}
		    	
		    	System.out.println(str.toString());
	    	}
	    	cnt++;
	    }
	    for(int i=0;i<finalRes.size();i++) {
        	System.out.println(finalRes.get(i));
        }
	}

}
