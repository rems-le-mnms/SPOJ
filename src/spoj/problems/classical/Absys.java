/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/ABSYS/
==========================================================
STATUS : AC in 0.13s
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Absys {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		int t=Integer.parseInt(br.readLine());
		int a=0, b=0, c=0;
		for(int i=0; i<t ; i++) {
			br.readLine();
			StringTokenizer tokenizer=new StringTokenizer(br.readLine());
			int pos=-1;
			String token = tokenizer.nextToken();
			if(pattern.matcher(token).matches()) {
				a=Integer.parseInt(token);
			} else {
				pos=0;
			}
			tokenizer.nextToken();
			token = tokenizer.nextToken();
			if(pattern.matcher(token).matches()) {
				b=Integer.parseInt(token);
			} else {
				pos=1;
			}
			tokenizer.nextToken();
			token = tokenizer.nextToken();
			if(pattern.matcher(token).matches()) {
				c=Integer.parseInt(token);
			} else {
				pos=2;
			}
			if(pos==0) {
				System.out.println( Integer.toString(c-b) +" + " + Integer.toString(b) + " = " + Integer.toString(c) );
			} else if(pos==1) {
				System.out.println( Integer.toString(a) + " + " + Integer.toString(c-a) + " = " + Integer.toString(c) );
			} else {
				System.out.println( Integer.toString(a) + " + " + Integer.toString(b) + " = " + Integer.toString(a+b) );
			}
		}
	}

}
