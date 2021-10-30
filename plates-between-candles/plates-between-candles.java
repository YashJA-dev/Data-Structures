class Solution {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int queryLength = queries.length;
        int l = 0;
        int r = s.length() - 1;
        boolean candle1 = true, candle2 = true;
        while (l < r) {
            if (!candle2 && !candle1) break; else {
                if (candle1) {
                    if (s.charAt(l) == '|') candle1 = false; else l++;
                }
                if (candle2) {
                    if (s.charAt(r) == '|') candle2 = false; else r--;
                }
            }
        }

        int[] prefix = new int[n], candleLeft = new int[n], candleRight = new int[n];
        int[] ans=new int[queryLength];
        formPrefix(candleLeft, candleRight, prefix, l, r, s);
        for(int i=0;i<queryLength;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            int iu=candleRight[u];
            int iv=candleLeft[v];
            if(iu>=v||iv<=u)ans[i]=0;
            else{
                ans[i]=(prefix[iv]-prefix[iu]);
            }
        }
        return ans;
    }

    public void formPrefix(int[] left, int[] right, int[] pre, int l, int r, String s) {
        int n = s.length();
        int val = -1, c = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') val = i;
            if (s.charAt(i) == '*' && i < r && i >= l) c++;
            pre[i] = c;
            left[i] = val;
        }
        val = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') val = i;
            right[i] = val;
        }
    }
}
