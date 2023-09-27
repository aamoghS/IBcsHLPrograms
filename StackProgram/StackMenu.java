import java.io.*;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStack Program\n");
            System.out.println("1) Evaluate postfix");
            System.out.println("2) Translate infix to postfix");
            System.out.println("3) Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the filename with postfix expressions: ");
                    String filename = scanner.nextLine();
                    try {
                        String postfixExpressions = readFile(filename);
                        String[] expressions = postfixExpressions.split("\n");

                        for (String postfix : expressions) {
                            try {
                                int result = evaluatePostfix(postfix);
                                System.out.println("Input data " + postfix);
                                System.out.println("Result: " + result);
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading the file: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter the filename with infix expressions: ");
                    filename = scanner.nextLine();
                    try {
                        String infixExpressions = readFile(filename);
                        String[] expressions = infixExpressions.split("\n");

                        for (String infix : expressions) {
                            try {
                                String translatedPostfix = infixToPostfix(infix);
                                System.out.println("Input data " + infix);
                                System.out.println("Postfix: " + translatedPostfix);
                                int result = evaluatePostfix(translatedPostfix);
                                System.out.println("Result: " + result);
                            } catch (Exception e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading the file: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("");
                    break;
                default:
                    System.out.println("Invalid input. Please choose 1-3.");
            }

        } while (choice != 3);
    }

    // ...
public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        StringTokenizer tokenizer = new StringTokenizer(expression, " ");

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(operand1, operand2, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static String infixToPostfix(String expression) {
        StringBuilder postfix = new StringBuilder();
        Stack<String> operators = new Stack<>();

        StringTokenizer tokenizer = new StringTokenizer(expression, "()+-*/^", true);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (isOperator(token)) {
                while (!operators.isEmpty() && getPrecedence(operators.peek()) >= getPrecedence(token)) {
                    postfix.append(operators.pop()).append(' ');
                }
                operators.push(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.peek().equals("(")) {
                    postfix.append(operators.pop()).append(' ');
                }
                operators.pop(); 
            } else {
                postfix.append(token).append(' ');
            }
        }

        while (!operators.isEmpty()) {
            postfix.append(operators.pop()).append(' ');
        }

        return postfix.toString().trim();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
    }

    private static int performOperation(int operand1, int operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            case "^":
                return (int) Math.pow(operand1, operand2);
            default:
                throw new UnsupportedOperationException("Unknown operator: " + operator);
        }
    }

    private static int getPrecedence(String operator) {
        switch (operator) {
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return -1;
        }
    }

    private static String readFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
