class Solution {
    class Pair {
        char c;
        int freq;
        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (p, q) -> Integer.compare(q.freq, p.freq)
        );

        if (a > 0) pq.offer(new Pair('a', a));
        if (b > 0) pq.offer(new Pair('b', b));
        if (c > 0) pq.offer(new Pair('c', c));

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {

            Pair first = pq.poll();
            
            if (sb.length() >= 2 &&
                sb.charAt(sb.length() - 1) == first.c &&
                sb.charAt(sb.length() - 2) == first.c) {

                if (pq.isEmpty())
                    break;

                Pair second = pq.poll();

                sb.append(second.c);
                second.freq--;

                if (second.freq > 0)
                    pq.offer(second);

                pq.offer(first);
            }
            else {

                sb.append(first.c);
                first.freq--;

                if (first.freq > 0)
                    pq.offer(first);
            }
        }

        return sb.toString();
    }
}