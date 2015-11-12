/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/TOANDFRO/
==========================================================
STATUS : AC in 0.06s
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ToAndFro {
	
	public static void main(String[] args) throws Exception {
		ArrayList <String> finalRes=new ArrayList <String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList <String> input;
		StringBuffer str;
		boolean stop=true;
		while(stop) {
			str=new StringBuffer(br.readLine());
			if(Integer.parseInt(str.toString())==0) {
				stop = false ;
			} else {
				input=new ArrayList<String>();
				int column=Integer.parseInt(str.toString());
				str=new StringBuffer(br.readLine());
				int cnt=0;
				for(int i=0;i<str.length();i=i+column) {
					if(cnt%2==0) {
						input.add(str.substring(i, i+column));
					} else {
						input.add(new StringBuilder(str.substring(i, i+column)).reverse().toString());
					}
					cnt++;
				}
				StringBuilder res=new StringBuilder();
				int j=0;
				while(j<column) {
					for(int i=0;i<input.size();i++) {
						res.append(input.get(i).charAt(j));
					}
					j++;
				}
				finalRes.add(res.toString());
			}	
		}
		
		
		for(int i=0;i<finalRes.size();i++) {
			System.out.println(finalRes.get(i));
		}
	}
	
}
