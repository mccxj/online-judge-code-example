package letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p/>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * <p/>
 * <p/>
 * <p/>
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Solution {
    Map<Character, Character[]> map;
    List<String> answers;
    char[] cs;
    char[] cons;

    public Solution() {
        map = new HashMap<Character, Character[]>();
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r', 's'});
        map.put('8', new Character[]{'t', 'u', 'v'});
        map.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        answers = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            answers.add("");
            return answers;
        }


        cs = digits.toCharArray();
        cons = new char[digits.length()];
        for (Character ch : map.get(cs[0])) {
            letterCombinationsHelper(0, ch);
        }
        return answers;
    }

    private void letterCombinationsHelper(int i, char c) {
        cons[i++] = c;
        if (i == cs.length) {
            answers.add(new String(cons));
            return;
        }
        for (Character ch : map.get(cs[i])) {
            letterCombinationsHelper(i, ch);
        }
    }
}
