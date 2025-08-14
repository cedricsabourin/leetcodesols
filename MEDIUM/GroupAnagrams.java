class Solution {
    // If there IS NOT already a key in the map that is an anagram of the word,
    // create a key with a new list containing just that word
    // If there IS already a key in the map that corresponds to an anagram (sorted value), 
    // we add it to the existing list

    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramsMap = new HashMap<>();
        List<List<String>> tbr = new ArrayList<>();
        String sorted = "";

        for (int i = 0; i < strs.length; i++) {
            char[] carray = strs[i].toCharArray();
            Arrays.sort(carray);
            sorted = new String(carray);
            if (!anagramsMap.containsKey(sorted)) {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                anagramsMap.put(sorted, newList);
            } else {
                List<String> existingList = anagramsMap.get(sorted);
                existingList.add(strs[i]);
                anagramsMap.put(sorted, existingList);
            }
        }

        for (List<String> words : anagramsMap.values()) {
            tbr.add(words);
        }

        return tbr;

    }
}
