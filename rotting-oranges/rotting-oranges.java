class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        Queue<Node> qu=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    qu.add(new Node(i,j,0));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int[][] traversal=new int[4][];
        traversal[0]=new int[]{-1,0};
        traversal[1]=new int[]{0,-1};
        traversal[2]=new int[]{1,0};
        traversal[3]=new int[]{0,1};
        int c=0,routine=0;
        while(!qu.isEmpty()){
            Node node=qu.poll();
            int px=node.x;
            int py=node.y;
            int time=node.time;
            routine++;
           c=Math.max(c,time);
            for(int i=0;i<traversal.length;i++){
                int x=px+traversal[i][0];
                int y=py+traversal[i][1];
                if((x>=0&&x<grid.length)&&(y>=0&&y<grid[0].length)){
                    if(grid[x][y]==1){
                        fresh--;
                        grid[x][y]=2;
                        qu.add(new Node(x,y,time+1));
                    }
                }
                // x-=traversal[i][0];
                // y-=traversal[i][1];
            }
        }
        if(fresh==0)return c;
        return -1;
    }
    class Node{
        int x,y,time;
        Node(int x,int y,int time){
            this.x=x;
            this.y=y;
            this.time=time;
        }
    }
}