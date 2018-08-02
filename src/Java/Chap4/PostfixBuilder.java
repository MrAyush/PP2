package Java.Chap4;

class PostfixBuild {
    private String input;
    private String output;
    private StackApp stack;
    private int length;

    public PostfixBuild(String s) {
        input = s;
        output = "";
        length = s.length();
        stack = new StackApp(length);
    }

    public int getPric(char c) {
        if (c == '+' || c == '-')
            return 1;
        else if (c == '*' || c == '/' || c == '%')
            return 2;
        else
            return -1;
    }

    public boolean isOpp(char c) {
        return ((c >= 'a' || c >= 'A') && (c <= 'Z' || c <= 'z'));
    }

    public boolean isBrack(char c) {
        return (c == '(' || c == ')');
    }

    public PostfixBuild builder() {
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (isOpp(c)) {
                output += c;
            } else {
                if (!isBrack(c)) {
                    if (stack.isEmpty())
                        stack.push(c);
                    else if (isBrack(stack.peek())) {
                        stack.push(c);
                    } else {
                        int p1 = getPric(c);
                        int p2 = getPric(stack.peek());
                        if (p2 <= p1) {
                            while (p2 <= p1) {
                                char t = stack.pop();
                                if (t != '(')
                                    output += t;
                                if (stack.isEmpty()) {
                                    stack.push(c);
                                    break;
                                }
                                p2 = getPric(stack.peek());
                            }
                        } else {
                            stack.push(c);
                        }
                    }
                } else {
                    if (c == '(') {
                        stack.push(c);
                    } else {
                        while (!stack.isEmpty()) {
                            if (stack.peek() == '(') {
                                stack.pop();
                                break;
                            } else
                                output += stack.pop();
                        }
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            output += stack.pop();
        }

        return this;
    }

    public String build() {
        return output;
    }
}

public class PostfixBuilder {
    public static void main(String[] args) {
        PostfixBuild p = new PostfixBuild("(a+(b/C)*d)");
        String s = p.builder().build();
        System.out.println("\n" + s + "\n");
    }
}
















