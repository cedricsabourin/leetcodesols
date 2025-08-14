class Solution {
    // Add all the numbers to a frequency hashtable
    // Add the Key of each frequency to a List where the Index is frequency
    // Loop backwards through this arraylist to get the K most frequent keys
    // Return array



    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqs = new HashMap<>();

        for (int i : nums) {
            if (freqs.containsKey(i)) {
                freqs.put(i, freqs.get(i) + 1);
            } else {
                freqs.put(i, 1);
            }
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        freqs.forEach((key, freq) -> {
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        });

        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i > 0 && result.size() < k ; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }

        int[] tbr = new int[k];
        for (int i = 0; i < tbr.length; i++) {
            tbr[i] = result.get(i);
        }
        
        return tbr;
    }
}
