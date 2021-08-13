// https://leetcode.com/problems/word-ladder
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        int wordLength = beginWord.length();
        Map<String, List<String>> wordMap = new HashMap<>();
        wordList.forEach(word -> {
           for (int i = 0; i < wordLength; i++) {
               String modifiedWord = word.substring(0, i) + "*"
                   + word.substring(i + 1, wordLength);
               List<String> words = wordMap.getOrDefault(modifiedWord, new ArrayList<>());
               words.add(word);
               wordMap.put(modifiedWord, words);
           } 
        });
        for (int i = 0; i < wordLength; i++) {
            String modifiedWord = beginWord.substring(0, i) + "*" 
                + beginWord.substring(i + 1, wordLength);
            List<String> words = wordMap.getOrDefault(modifiedWord, new ArrayList<>());
            words.add(beginWord);
            wordMap.put(modifiedWord, words);
        } 
        for (int i = 0; i < wordLength; i++) {
            String modifiedWord = endWord.substring(0, i) + "*" 
                + endWord.substring(i + 1, wordLength);
            List<String> words = wordMap.getOrDefault(modifiedWord, new ArrayList<>());
            words.add(endWord);
            wordMap.put(modifiedWord, words);
        } 
        Set<String> visitedWords = new HashSet<>();
        List<Pair<String, Integer>> queue = new ArrayList<>();
        queue.add(new Pair(beginWord, 1));
        visitedWords.add(beginWord);
        while(!queue.isEmpty()) {
            String word = queue.get(0).getKey();
            int distance = queue.get(0).getValue();
            queue.remove(0);
            for (int i = 0; i < wordLength; i++) {
                String modifiedWord = word.substring(0, i) + "*" 
                    + word.substring(i + 1, wordLength);
                for(String nextWord: wordMap.get(modifiedWord)) {
                    if (!visitedWords.contains(nextWord)) {
                        if (nextWord.equals(endWord))
                            return distance + 1;
                        queue.add(new Pair(nextWord, distance + 1));
                        visitedWords.add(nextWord);
                    }
                }
            } 
        }
        return 0;
    }
}