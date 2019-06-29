package DayEighteenth;

public class ArithExpJava {
    private class Node {
        private char content;
        private Node left;
        private Node right;
        private boolean isLeaf() {
            return (left==null && right ==null);
        }
        Node(char item) {
            content = item;
            left = right = null;
        }
    }
    boolean isOperator(char c) {
        if(c == '+' || c=='-' || c=='*' || c=='/') return true;
        return false;
    }
    public double evaluate(char c, double left, double right) {
        double result = 0;
        switch (c) {
            case '+':
                result = left + right;
                break;
            case '-' :
                result = left - right;
                break;
            case '*':
                result =left * right;
            case '/':
                result = left / right;
        }
        return result;
    }
    public double evalTree(Node tree) {
        if(tree == null) return 0;
        if(Character.isDigit(tree.content)) return tree.content;
        else {
            char op = tree.content;
            double left = Character.digit((char) evalTree(tree.left),10);
            double right = Character.digit((char) evalTree(tree.right),10);
            return evaluate(op,left,right);
        }
    }

}
