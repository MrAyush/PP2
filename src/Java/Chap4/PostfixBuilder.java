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
    
    public boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    public boolean isBrack(char c) {
        return (c == '(' || c == ')');
    }

    public PostfixBuild builder() {
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (isOpp(c) || isDigit(c)) {
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
                        if (p2 >= p1) {
                            while (p2 >= p1) {
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
    
    public StackApp makeStack () {
    	int l = output.length();
    	System.out.println(l + "\n");
    	stack = new StackApp(l);
    	for (int i = 0; i < l; i++) {
    		stack.push(output.charAt(i));
    	}
    	stack.display();
    	return stack;
    }
    
    static class Evaluate
    {
    	public void Evaluater() {
    		System.out.println("\nInside Evaluater\n");
    	}
    	
    	public static PostfixBuild builder(String s) {
    		PostfixBuild p = new PostfixBuild(s).builder();
    		StackApp stack = p.makeStack();
    		return p;
    	}
    }
}

public class PostfixBuilder {
    public static void main(String[] args) {
        /*PostfixBuild p = new PostfixBuild("(a+b)/c");
        String s = p.builder().build();
        System.out.println("\n" + s + "\n");*/
	    String s = PostfixBuild.Evaluate.builder("5/2+1/3").build();
        System.out.println("\n" + s + "\n");
    }
}


