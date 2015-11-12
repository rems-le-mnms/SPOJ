/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/CANDY/
==========================================================
STATUS : AC in 0.08s
 */package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CandyI {
	public static void main(String[] args) throws Exception {
		ArrayList <String> finalRes=new ArrayList <String>();
		ArrayList <ArrayList<Integer>> input=new ArrayList<ArrayList<Integer>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer str;
		boolean stop=true;
		int cnt=0;
		while(stop) {
			str=new StringBuffer(br.readLine());
			if (Integer.parseInt(str.toString())==-1) {
				stop=false;
			} else {
				input.add(new ArrayList<Integer>());
			}
			int n=Integer.parseInt(str.toString());
			for(int i=0; i<n;i++) {
				str=new StringBuffer(br.readLine());
				input.get(cnt).add(Integer.parseInt(str.toString()));
			}
			cnt++;
		}
		
		for(int i=0;i<input.size();i++) {
			int sum=0;
			for (int j=0;j<input.get(i).size();j++) {
				sum=sum+input.get(i).get(j);
			}
			if(sum % input.get(i).size()==0) {
				int res=0;
				for(int j=0;j<input.get(i).size();j++) {
					if(input.get(i).get(j) > sum / input.get(i).size()) {
						res=res + (input.get(i).get(j) - (sum / input.get(i).size()));
					}
				}
				finalRes.add(Integer.toString(res));
			} else {
				finalRes.add(Integer.toString(-1));
			}
		}
		
		for(int i=0;i<finalRes.size();i++) {
			System.out.println(finalRes.get(i));
		}
				
	}
}

