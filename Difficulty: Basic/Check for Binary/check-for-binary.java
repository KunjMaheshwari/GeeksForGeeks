//{ Driver Code Starts
import java.util.*;


class checkBinary
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		while(T>0)
		{
			String str = sc.nextLine();
			GfG g = new GfG();
			boolean b = g.isBinary(str);
			if(b== true)
				System.out.println(1);
			else
			    System.out.println(0);
		T--;
		}
	}
}


// } Driver Code Ends


class GfG
{
	boolean isBinary(String str)
	{
	  //Your code here
	  int n = str.length();
	  
	  int sum = 0;
	  
	  for(int i=0;i<n;i++){
	      sum += Integer.parseInt(String.valueOf(str.charAt(i)));
	  }
	  
	  if(sum <= n){
	      return true;
	  }
	  return false;
	}
}