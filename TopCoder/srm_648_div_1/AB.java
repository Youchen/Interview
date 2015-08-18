//2015-08-13 14:51:37
public class AB{
    public String createString(int N, int K){
		if(K > (N / 2) * (N - N / 2) )
			return "";
		if(K == 0)
			return nChars(N >> 1, 'B') + nChars(N - (N >> 1), 'A');
        
		StringBuilder s = new StringBuilder();

		int k = K >> 1;
		while(k > 0){
			s.append("A");
			k--;
		}

		if(K == (K >> 1) * (N - K >> 1) ){
			int appendB = N - K >> 1;
			while(appendB > 0){
				s.append("B");
				appendB--;
			}
			return s.toString();
		}
		else{// if(K < (K >> 1) * (N - K >> 1) ){
			
			//compute the insert position
			int[] pos = new int[(N >> 1) + 1];
			int insertedB = 0;
			
		    for(int i = pos.length - 1; i > 0; i--){
				pos[i] = K / i;
				insertedB += pos[i];
				K = K % i;
			}
		    pos[0] = N - (N >> 1) - insertedB;
		    
		    //insertion
		    String[] res = new String[pos.length];
		    for(int i = 0; i < res.length; i++) {
		    	if(i < res.length - 1)
		    		res[i] = nChars(pos[i], 'B') + "A";
		    	else
		    		res[i] = nChars(pos[i], 'B');
		    }
		    
		    String ans = "";
		    for(String ss : res)
		    	ans += ss;
		    return ans;
		}
	}
	private String nChars(int n, char A) {
		String res = "";
		while(n > 0) {
			res += A;
			n--;
		}
		return res;
	}
}