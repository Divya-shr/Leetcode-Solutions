class Solution {
    public int videoStitching(int[][] clips, int time) {
        List<Pair> intervals = new ArrayList<>();
        for (int[] clip : clips) {
            intervals.add(new Pair(clip[0], clip[1]));
        }

        // Sort intervals based on the start time
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        int minClips = 0;
        int currentEnd = 0;
        int index = 0;
        int n = intervals.size();

        while (currentEnd < time) {
            minClips++;
            int furthestEnd = currentEnd;

            // Find the clip that extends furthest while starting within or before currentEnd
            while (index < n && intervals.get(index).start <= currentEnd) {
                furthestEnd = Math.max(furthestEnd, intervals.get(index).end);
                index++;
            }

            // If we can't extend further, it's impossible to cover the entire time
            if (furthestEnd <= currentEnd) {
                return -1;
            }

            currentEnd = furthestEnd;
        }

        return minClips;
    }

    class Pair {
        int start;
        int end;
        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}