class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i=0;i<points.length;i++){
            int dis = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.add(new int[]{dis,i});
        }

        int[][] res = new int[k][2];
        int i=0;
        while(k>0){
            int idx = pq.poll()[1];
            res[i][0]=points[idx][0];
            res[i][1]=points[idx][1];
            i++;
            k--;
        }
        return res;
    }
}
