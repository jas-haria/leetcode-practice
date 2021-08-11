// https://leetcode.com/problems/group-anagrams/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String charString = new String(charArray);
            List<String> list = map.getOrDefault(charString, new ArrayList<String>());
            list.add(s);
            map.put(charString, list);
        }
        return new ArrayList<>(map.values());
    }
}