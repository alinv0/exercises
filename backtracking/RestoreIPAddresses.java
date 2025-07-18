package backtracking;

// https://leetcode.com/problems/restore-ip-addresses/description/

import java.util.ArrayList;
import java.util.List;

/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is
 * between 0 and 255 (inclusive) and cannot have leading zeros. For example, "0.1.2.201" and
 * "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are
 * invalid IP addresses. Given a string s containing only digits, return all possible valid IP
 * addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove
 * any digits in s. You may return the valid IP addresses in any order.
 */
public class RestoreIPAddresses {
  public List<String> restoreIpAddresses(String s) {
    final var result = new ArrayList<String>();
    backtrack(s, 0, 0, new ArrayList<>(), result);

    return result;
  }

  private boolean isValidSegment(String segment) {
    if (segment == null || segment.isEmpty()) {
      return false;
    }

    if (segment.length() > 1 && segment.charAt(0) == '0') {
      return false;
    }

    if (segment.length() > 3) {
      return false;
    }

    try {
      final int number = Integer.parseInt(segment);
      if (255 < number || 0 > number) {
        return false;
      }
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  private void backtrack(
      final String s,
      final int cPos,
      final int noDots,
      final List<String> path,
      final List<String> result) {

    if (noDots > 4) return;

    if (noDots == 4 && cPos == s.length()) {
      result.add(String.join(".", path));
      return;
    }

    for (int len = 1; len <= 3; len++) {
      if (cPos + len > s.length()) {
        break;
      }

      var segment = s.substring(cPos, cPos + len);
      if (isValidSegment(segment)) {
        path.add(segment);
        backtrack(s, cPos + len, noDots + 1, path, result);
        path.remove(path.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    var solution = new RestoreIPAddresses();
    var s = "101023";
    var ips = solution.restoreIpAddresses(s);
    for (String i : ips) {
      System.out.println(i);
    }
  }
} 