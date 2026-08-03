class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int time = -1 ;
        int n = grid.length;
        int m = grid[0].length;
        int rot = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)
                    q.add(new int[]{i,j});
                
                if(grid[i][j]==1)
                    rot++;
            }
        }

        if(rot == 0)
            return 0;

        //up,down,left,right
        int[] row = new int[]{-1,1,0,0};
        int[] col = new int[]{0,0,-1,1};
        while(!q.isEmpty()){
            int len = q.size();
            time++;
            for(int j=0;j<len;j++){
                int[] rf = q.poll();
                for(int i=0;i<4;i++){
                    int r = rf[0]+row[i];
                    int c = rf[1]+col[i];
                    if(r<0 || r>=n || c<0 || c>=m)
                        continue;
                    else if(grid[r][c]==1){
                        q.add(new int[]{r,c});
                        grid[r][c]=2;
                        rot--;
                    }
                }
            }
        }
        return rot==0?time:-1;
    }
}
