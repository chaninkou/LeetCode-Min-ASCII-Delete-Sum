package minimum;

public class Main {
	public static void main(String[] args){
		String s1 = "sea";
		String s2 = "eat";
		
		System.out.println("s1: " + s1 + " s2: " + s2);
		
		System.out.println("Solution: " + minimumDeleteSum(s1, s2));
	}
	
    public static int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int MAX = Integer.MAX_VALUE;
        
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = m; i >= 0; i--){
            for(int j = n; j >= 0; j--){
                if(i < m || j < n){
                    if(i < m && j < n && a[i] == b[j]){
                         dp[i][j] = dp[i + 1][j + 1];
                    }else{
                         dp[i][j] = Math.min((i < m ? a[i] + dp[i + 1][j] : MAX), (j < n ? b[j] + dp[i][j + 1] : MAX));
                    }
                    
                }
            }
        }
        
        return dp[0][0];
    }
}
