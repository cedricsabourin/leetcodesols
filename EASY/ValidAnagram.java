class Solution {
    public boolean isAnagram(String s, String t) {
        // create hashmaps for the frequency of each character for the strings
        HashMap<Character, Integer> sCount = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tCount = new HashMap<Character, Integer>();

        // add all the characters of s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sCount.containsKey(c)) {
                sCount.put(c, sCount.get(c) + 1);
            } else {
                sCount.put(c, 1);
            }
        }

        // add all the characters of t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (tCount.containsKey(c)) {
                tCount.put(c, tCount.get(c) + 1);
            } else {
                tCount.put(c, 1);
            }
        }

        // if both hashmaps are the same then the strings are anagrams, since hashmaps don't care about the order
        return sCount.equals(tCount);
    }

    
}
