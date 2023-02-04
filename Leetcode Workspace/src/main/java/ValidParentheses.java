import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

        System.out.println(isValid("()"));
    }
    public static boolean isValid(String s) {
        boolean isParenthesesValid = true;
        Stack parStack = new Stack<>();
        Map<String, String> parenthesesMatcher = new HashMap<>();
        parenthesesMatcher.put("[", "]");
        parenthesesMatcher.put("{", "}");
        parenthesesMatcher.put("(", ")");

        if(s.length() < 2 || !parenthesesMatcher.containsKey(String.valueOf(s.charAt(0)))){
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            String currPar = String.valueOf(s.charAt(i));
            try {
                if (parenthesesMatcher.containsKey(currPar)) {
                    parStack.push(currPar);
                } else if (currPar.equals((parenthesesMatcher.get(parStack.peek())))) {
                    parStack.pop();
                } else if (!currPar.equals(parenthesesMatcher.get(parStack.peek()))) {
                    isParenthesesValid = false;
                }
            } catch(Exception e){
              return false;
            }
        }
        return isParenthesesValid;
    }
}
