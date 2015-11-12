package spoj.problems.partial;
/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/SKIPLIST/
==========================================================
STATUS : TODO
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* a concevoir */
public class SkipList {
	public static void main(String[] args) throws Exception {
		ArrayList <String> finalRes=new ArrayList <String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=0; i<t ; i++) {
			int max=0;
			;
			String[] input=br.readLine().split(" ");
			int n=Integer.parseInt(input[0]);
			String s=input[1];
			int cnt=1;
			String s0="";
			for(int j=1;j<s.length()-n+1;j++) {
				s0=s.substring(i, i+n);
				
				
			}
			if(cnt>max) {
				max=cnt;
			}
		}
		for(int i=0;i<finalRes.size();i++) {
			System.out.println(finalRes.get(i));
		}
	}
}
