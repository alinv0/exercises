package string;

// https://leetcode.com/problems/guess-the-word

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Master {
  String secretWord = "hbaczn";

  default int guess(String word) {
    int count = 0;
    int i = 0;
    String secret = new String(secretWord);
    while(i < word.length()) {
      String part = word.substring(i);
      char c = part.charAt(0);
      int index = secret.indexOf(c);
      if(index != -1) {
        secret = secret.substring(0, index) + secret.substring(index+1);
        count++;
      }
      i++;
    }
    return count;
  }
}

public class GuessTheWord {
  static class Solution {
    public void findSecretWord(String[] words, Master master) {
      int match = 0;
      final Map<String, Integer> visited = new HashMap<>();
      List<String> wordList = Arrays.asList(words);
      int i=0;
      while(match == 0 && i < wordList.size()) {
        match = master.guess(wordList.get(i));
        visited.put(wordList.get(i), match);
        i++;
      }

      while(match < 6) {
        if(i==wordList.size()) {
          break;
        }

        String word = "";
        for(String w : wordList) {
          var newMatch = master.guess(w);
          if(visited.get(w) == null) {
            visited.put(w, newMatch);
          }

          if(newMatch > match) {
            match = newMatch;
            word = w;
            break;
          }
        }

        if(match == 6 || word.isEmpty()) {
          break;
        }

        wordList = filterWords(wordList, visited, word, match);
        i++;
      }
    }

    private List<String> filterWords(
        final List<String> wordList,
        final Map<String, Integer> visited,
        final String word,
        final int match) {
      return wordList.stream()
          .filter(w -> visited.get(w) == null)
          .filter(w -> wordHasAtLeastNoChars(w, word.toCharArray(), match))
          .toList();
    }

    private boolean wordHasAtLeastNoChars(String word, char[] chs, int occurences) {
      int numberOfFindings = 0;
      char[] wordChars = word.toCharArray();
      boolean[] visited = new boolean[wordChars.length];
      for (final char ch : chs) {
        for (int w = 0; w < wordChars.length; w++) {
          if (wordChars[w] == ch && !visited[w]) {
            visited[w] = true;
            numberOfFindings++;
          }
        }
      }

      return numberOfFindings >= occurences;
    }
  }

  public static void main(String[] args){
    //words ["gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos","acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla","ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy","novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp","jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"]
    String[] words = new String[] {"gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos","acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla","ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy","novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp","jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"};
    new Solution().findSecretWord(words, new Master() {});
  }
} 