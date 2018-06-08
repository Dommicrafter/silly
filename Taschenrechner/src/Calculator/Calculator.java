import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Calculator Class - use postfix to solve patterns
 * ADS 1 - Telematik - TH Wildau
 *
 * @author Roman Kobosil
 * @version 1.0, 29.03.17
 */
public class Calculator {

    /**
     * algorithm to convert a infix string to a postfix string
     *
     * @param infix infix string as input
     * @return a postfix string
     */
    private String getPostFix(String infix) {

        StringBuilder stringBuilder = new StringBuilder();

        // use StringTokenizer to split infix infix string on "+*-/()"
        StringTokenizer stringTokenizer = new StringTokenizer(infix, "+*-/()", true);
        //stack pending operators
        Stack<String> operators = new Stack<>();

        // end when stringTokenizer is empty
        while (stringTokenizer.hasMoreElements()) {
            String value = stringTokenizer.nextToken();

            //detect if value is operator, bracket or float
            switch (value) {
                case "+":
                    //pop operators with higher/same priority from stack and add him to postfix string
                    stringBuilder.append(filterOperators(operators, "*/-+"));

                    //add operator to stack
                    operators.push(value);
                    break;

                case "/":
                    //pop operators with higher/same priority from stack and add him to postfix string
                    stringBuilder.append(filterOperators(operators, "*/"));

                    //add operator to stack
                    operators.push(value);
                    break;

                case "-":
                    //pop operators with higher/same priority from stack and add him to postfix string
                    stringBuilder.append(filterOperators(operators, "*/-+"));

                    //add operator to stack
                    operators.push(value);
                    break;

                case "*":
                    ///pop operators with higher/same priority from stack and add him to postfix string
                    stringBuilder.append(filterOperators(operators, "*/"));

                    //add operator to stack
                    operators.push(value);
                    break;

                case "(":
                    //add bracket to stack
                    operators.push(value);
                    break;

                case ")": // bracket close detected
                    //stop flag
                    boolean stop = false;
                    // stop when operators stack is empty or stop flag is true
                    while (!operators.empty() && !stop) {
                        //stop when end bracket "(" is reached
                        if (operators.peek().equals("(")) {
                            //cancel while
                            stop = true;
                            //remove ( from stack
                            operators.pop();
                            continue;
                        }
                        //add the current operator to the postfix string and remove him from stack
                        stringBuilder.append(" ");
                        stringBuilder.append(operators.pop());
                    }
                    break;
                default:
                    //add to postfix string
                    stringBuilder.append(" ");
                    stringBuilder.append(value);
            }
        }

        // iterate last operators from stack
        while (!operators.empty()) {
            //add the current operator to the postfix string and remove him from stack
            stringBuilder.append(" ");
            stringBuilder.append(operators.pop());
        }

        // get stringBuilder result
        return stringBuilder.toString();

    }

    /**
     * algorithm to filter operators with higher priority
     *
     * @param operators       operator stack fo filter
     * @param higherOperators operators to add directly to the postfix string
     * @return string of operators that can directly append to the postfix string
     */
    private StringBuilder filterOperators(Stack<String> operators, String higherOperators) {
        StringBuilder stringBuilder = new StringBuilder();
        //stop flag
        boolean stop = false;

        //stack to collect the operators with lower priority, who will remain in the stack
        Stack<String> filteredOperators = new Stack<>();

        // stop when operators stack is empty or stop flag is true
        while (!operators.empty() && !stop) {
            //check next operator, without to remove him
            switch (operators.peek()) {
                //stop at (
                case "(":
                    //keep the ( in the stack
                    filteredOperators.push(operators.pop());
                    //set stop flag
                    stop = true;
                    break;

                // operator like * / + -
                default:
                    // check if the current operator is in the higher operators priority string
                    if (higherOperators.contains(operators.peek())) {
                        //add the current operator to the postfix string and remove him from stack
                        stringBuilder.append(" ");
                        stringBuilder.append(operators.pop());
                    } else {
                        /*if the current operator is not in the higher operators priority string
                          add it to the filteredOperators stack to remain him in the stack
                         */
                        filteredOperators.push(operators.pop());
                    }
                    break;

            }
        }

        // stop when filteredOperators stack is empty
        while (!filteredOperators.empty()) {
            //pop all operators from the temporary filteredOperators stack to the main operator stack
            operators.push(filteredOperators.pop());
        }
        return stringBuilder;
    }

    /**
     * algorithm to solve a postfix calculation with a stack
     *
     * @param postfix A postfix string with space delimiters
     * @return float value of calculation
     */
    private Double solvePostFix(String postfix) {
        Double x = 0d;
        Double y = 0d;

        // use StringTokenizer to split postfix
        StringTokenizer stringTokenizer = new StringTokenizer(postfix, " ", false);
        //stack for the interim result
        Stack<Double> valueStack = new Stack<>();

        // end when stringTokenizer is empty
        while (stringTokenizer.hasMoreElements()) {
            String value = stringTokenizer.nextToken();

            //detect if value is operator or float
            switch (value) {
                case "+":
                    // pop last 2 float values from stack
                    x = valueStack.pop();
                    y = valueStack.pop();

                    // add
                    valueStack.push(y + x);
                    break;

                case "/":
                    // pop last 2 float values from stack
                    x = valueStack.pop();
                    y = valueStack.pop();

                    // divide in right order
                    valueStack.push(y / x);
                    break;

                case "-":
                    // pop last 2 float values from stack
                    x = valueStack.pop();
                    y = valueStack.pop();

                    // subtract in right order
                    valueStack.push(y - x);
                    break;

                case "*":
                    // pop last 2 float values from stack
                    x = valueStack.pop();
                    y = valueStack.pop();

                    // multiply
                    valueStack.push(y * x);
                    break;

                default:
                    //when value not an operator, so add it to the stack
                    valueStack.push(Double.parseDouble(value));
            }

        }
        //last value on stack is the final result
        return valueStack.pop();

    }

    public String getResult(String infix) {
        //run the magic
        return String.valueOf(solvePostFix(getPostFix(infix)));
    }
}
