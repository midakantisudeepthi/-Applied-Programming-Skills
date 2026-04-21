import java.util.*;

class Solution {

    static class Pair {
        int i, j, sum;

        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0)
            return result;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
            (a, b) -> a.sum - b.sum
        );

        // Push first element of each row
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.add(new Pair(i, 0, nums1[i] + nums2[0]));
        }

        while (k-- > 0 && !minHeap.isEmpty()) {
            Pair p = minHeap.poll();

            result.add(Arrays.asList(nums1[p.i], nums2[p.j]));

            // move to next column in nums2
            if (p.j + 1 < nums2.length) {
                minHeap.add(new Pair(
                    p.i,
                    p.j + 1,
                    nums1[p.i] + nums2[p.j + 1]
                ));
            }
        }

        return result;
    }
}
