class Solution {
    public int nearestExit(char[][] maze, int[] start) {
        int n=maze.length;
        int m=maze[0].length;
        int[][] traversal=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int[][] vis=new int[n][m];
        boolean[][] corner=new boolean[n][m];
        Arrays.fill(corner[0],true);   
        Arrays.fill(corner[n-1],true);
        for(int i=1;i<n-1;i++){
            corner[i][0]=true;
            corner[i][m-1]=true;
        }
        
        for(int i=0;i<n;i++){
            Arrays.fill(vis[i],0); 
            // System.out.println(Arrays.toString(corner[i]));
        }
        Queue<Pair> qu=new LinkedList<>();
        qu.add(new Pair(start[0],start[1],0));
        vis[start[0]][start[1]]=1;
        int ans=Integer.MAX_VALUE;
        // System.out.println(" 1 1"+atSides(1,1,m,n));
        while(!qu.isEmpty()){
            int x=qu.peek().x;
            int y=qu.peek().y;
            int steps=qu.poll().steps;
            int i=0;
            
            if(x!=start[0]||y!=start[1]){
                System.out.println(x+" "+y+" "+steps);
               if(corner[x][y])ans=Math.min(ans,steps);
            }
            for(i=0;i<traversal.length;i++){
                int xt=x;
                int yt=y;
                int st=steps;
                if((xt>=0&&xt<n)&&(yt>=0&&yt<m)&&maze[xt][yt]=='.'){
                    xt+=traversal[i][0];
                    yt+=traversal[i][1];
                    st++;                   
                }
                if(((xt<0||xt>=n)||(yt<0||yt>=m))||maze[xt][yt]=='+'){
                    xt-=traversal[i][0];
                    yt-=traversal[i][1];
                    st--;
                }
               
                if(vis[xt][yt]==0){
                    vis[xt][yt]=1;
                    qu.add(new Pair(xt,yt,st));                    
                }
            }
           
        }
        
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    class Pair{
        int x,y,steps;
        Pair(int x,int y,int steps){
            this.x=x;
            this.y=y;
            this.steps=steps;
        }
    }
    // private boolean atSides(int x,int y,int m,int n){
    //     return true;
    // }
}
// ["+",".","+","+","+","+","+"]
// ["+",".","+",".",".",".","+"]
// ["+",".","+",".","+",".","+"]
// ["+",".",".",".",".",".","+"]
// ["+","+","+","+",".","+","."]