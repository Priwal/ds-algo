
//asked in upstox
import java.util.*;
import java.lang.*;

public class BalancedParanthesis {
    static Boolean isValid(String str) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
                continue;
            }
            // if directly closing bracket appears then not valid
            if (st.isEmpty())
                return false;

            if (c == ')') {
                char check = st.pop();
                if (check == '{' || check == '[') {
                    return false;
                }

            }

            else if (c == '}') {
                char check = st.pop();
                if (check == '(' || check == '[') {
                    return false;
                }

            } else if (c == ']') {
                char check = st.pop();
                if (check == '{' || check == '(') {
                    return false;
                }
            }

        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String expr = "})()";

        if (isValid(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
