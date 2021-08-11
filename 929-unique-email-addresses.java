// https://leetcode.com/problems/unique-email-addresses/
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<String>();
        for (String email: emails) {
            StringBuilder sb = new StringBuilder();
            for (char c: email.toCharArray()) {
                if (c == '.') continue;
                if (c == '@' || c== '+') break;
                sb.append(c);
            }
            sb.append(email.substring(email.indexOf('@')));
            uniqueEmails.add(sb.toString());
        }
        return uniqueEmails.size();
    }
}