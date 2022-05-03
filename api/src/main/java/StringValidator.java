

import java.util.*;

public class StringValidator {
    private static final Collection<Character> OPEN_BRACES;
    private static final Collection<Character> CLOSE_BRACES;
    private static final Map<Character, Character> BRACES;

    static {
        BRACES = new HashMap<>();
        BRACES.put(')', '(');
        BRACES.put(']', '[');
        BRACES.put('}', '{');
        BRACES.put('>', '<');
        OPEN_BRACES = BRACES.values();
        CLOSE_BRACES = BRACES.keySet();
    }

    public static boolean validateString(String string) {
        System.out.print("validateString:"+string+" ");
        if (string == null) {
            System.out.println("string is null");
            return false;
        }
        char startChar = string.charAt(0);
        char endChar = string.charAt(string.length() - 1);
        if (OPEN_BRACES.contains(startChar) && CLOSE_BRACES.contains(endChar)) {
            Stack<Character> stack = new Stack();
            for (char c : string.toCharArray()) {
                if (OPEN_BRACES.contains(c)) {
                    stack.push(c);
                } else if (CLOSE_BRACES.contains(c)) {
                    if (stack.empty()) {
                        System.out.println("close brace without open brace");
                        return false;
                    } else if (!stack.pop().equals(BRACES.get(c))) {
                        System.out.println("close brace not correct to open brace");
                        return false;
                    }
                }
            }
            if(stack.isEmpty()) {
                System.out.println("good string!!!");
                return true;
            }else{
                System.out.println("open brace without close brace");
                return false;
            }
        } else {
            System.out.println("The string should start and end with a braces.");
            return false;
        }
    }

    public static void main(String[] args) {
        validateString("(ggg)");
        validateString("hhh)");
        validateString("(gggg]");//??
        validateString("(({}){[java]})");
        validateString("{{})");
        validateString("(kk{})(hh)");
        validateString("((()");
        validateString("[[]]]");
    }

}
