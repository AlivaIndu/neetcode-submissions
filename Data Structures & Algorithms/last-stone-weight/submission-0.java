class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int s:stones)
            pq.add(s);

        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            if(x>y) pq.add(x-y);
            else if (x<y) pq.add(y-x);
        }

        return pq.isEmpty()?0:pq.poll();
    }
}
