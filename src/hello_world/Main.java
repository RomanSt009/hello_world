package hello_world;

import com.sun.org.apache.xml.internal.utils.XMLCharacterRecognizer;

import java.util.List;
import java.util.Scanner;

public class Main {
    enum Operators {
        PLUS,
        MINUS,
        DIV,
        MULT,
        NONE
    }

    private static class Unit {
        Operators type = Operators.NONE;
        float left = -1;
        float right = -1;
        float result = 0;

        Unit() {

        }
    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String expr = scanner.nextLine();

        Unit operation = new Unit();
//
//        for (int i = 0; i < expr.length(); i++) {
//            char c = expr.charAt(i);
//
//            if (Character.isDigit(c)) {
//                int temp_val = 0;
//
//                if (i != 0 && Character.isDigit(expr.charAt(i - 1))) {
//                    temp_val = Integer.parseInt(expr.substring(i - 1, i + 1));
//
//                    if (operation.left != -1 && operation.right == -1) {
//                        operation.left = temp_val;
//                    } else {
//                        operation.right = temp_val;
//                    }
//
//                    continue;
//                }
//
//                if (operation.left == -1) {
//                    operation.left = Character.getNumericValue(c);
//                } else if (operation.right == -1) {
//                    operation.right = Character.getNumericValue(c);
//                }
//
//            } else {
//                if (c == '+') {
//                    operation.type = Operators.PLUS;
//
//                } else if (c == '-') {
//                    operation.type = Operators.MINUS;
//
//                }
//            }
//        }

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (!Character.isDigit(c)) {
                if (c == '+') {
                    operation.type = Operators.PLUS;
                } else if (c == '-') {
                    operation.type = Operators.MINUS;
                } else if (c == '/') {
                    operation.type = Operators.DIV;
                } else if (c == '*') {
                    operation.type = Operators.MULT;
                }

                operation.left = Integer.parseInt(expr.substring(0, i));
                operation.right = Integer.parseInt(expr.substring(i + 1, expr.length()));
            }
        }

        // 111+222+333
        // 10%200

        if (operation.type == Operators.PLUS) {
            operation.result = operation.left + operation.right;
        } else if (operation.type == Operators.MINUS) {
            operation.result = operation.left - operation.right;
        } else if (operation.type == Operators.DIV) {
            operation.result = operation.left / operation.right;
        } else if (operation.type == Operators.MULT) {
            operation.result = operation.left * operation.right;
        }

        System.out.println(String.format("result = %f", operation.result));

    }
}