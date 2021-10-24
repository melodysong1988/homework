package com.techbow.homework.y2021.m10.MelodySong0827;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null) {
            return -1;
        }
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        set.remove(beginWord);
        int minDis = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curStr = queue.poll();
                char[] curChars = curStr.toCharArray();
                for (int i = 0; i < curChars.length; i++) {
                    char temp = curChars[i];
                    for (char c = 'a';c <= 'z'; c++) {
                        curChars[i] = c;
                        String possibleStr = String.valueOf(curChars);
                        if (!possibleStr.equals(curStr) && set.contains(possibleStr)) {
                            if (possibleStr.equals(endWord)) {
                                return minDis + 1;
                            }
                            queue.offer(possibleStr);
                            set.remove(possibleStr);
                        }
                    }
                    curChars[i] = temp;
                }
            }
            minDis++;
        }
        return 0;
    }
}
