import java.io.*;
import java.util.*;
import java.util.regex.*;

public class task50 {
    private static final String HISTORY_FILE = "history.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadHistory();

        while (true) {
            System.out.println("\nВведите выражение для вычисления или 'exit' для выхода:");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("history")) {
                printHistory();
            } else {
                try {
                    double result = evaluateExpression(input);
                    System.out.println("Результат: " + result);
                    saveToHistory(input + " = " + result);
                } catch (Exception e) {
                    System.out.println("Ошибка в выражении: " + e.getMessage());
                }
            }
        }
    }

    // Загрузка истории из файла
    private static void loadHistory() {
        System.out.println("История ранее выполненных вычислений:");
        try (BufferedReader br = new BufferedReader(new FileReader(HISTORY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Файл может не существовать — игнорируем
        }
    }

    // Вывод всей истории
    private static void printHistory() {
        System.out.println("История:");
        try (BufferedReader br = new BufferedReader(new FileReader(HISTORY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Нет сохраненной истории.");
        }
    }

    // Сохранение выражения и результата
    private static void saveToHistory(String entry) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(HISTORY_FILE, true))) {
            bw.write(entry);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении истории.");
        }
    }

    // Основная функция для вычисления выражения
    private static double evaluateExpression(String expr) throws Exception {
        // Обработка функций: |k| и ^ (возведение в степень)
        expr = processFunctions(expr);
        // Парсинг и вычисление выражения
        return evaluate(expr);
    }

    // Обработка функций |k| и ^ (возведение в степень)
    private static String processFunctions(String expr) throws Exception {
        // Обработка модуля |k|
        Pattern patternAbs = Pattern.compile("\\|([^|]+)\\|");
        Matcher matcherAbs = patternAbs.matcher(expr);
        while (matcherAbs.find()) {
            String inside = matcherAbs.group(1);
            double val = evaluate(inside);
            int absVal = (int) Math.abs(val);
            expr = expr.replaceFirst(Pattern.quote("|" + inside + "|"), String.valueOf(absVal));
        }

        // Обработка возведения в степень ^ (правила: a ^ b)
        Pattern patternPow = Pattern.compile("([\\d.]+)\\s*\\^\\s*([\\d.]+)");
        Matcher matcherPow = patternPow.matcher(expr);
        while (matcherPow.find()) {
            double base = Double.parseDouble(matcherPow.group(1));
            double exponent = Double.parseDouble(matcherPow.group(2));
            double powResult = Math.pow(base, exponent);
            String toReplace = matcherPow.group(0);
            expr = expr.replaceFirst(Pattern.quote(toReplace), String.valueOf(powResult));
        }

        return expr;
    }

    // Внутренний парсер и вычислитель выражения
    private static double evaluate(String expr) throws Exception {
        List<String> tokens = tokenize(expr);
        return parseExpression(tokens);
    }

    // Токенизация выражения
    private static List<String> tokenize(String expr) {
        List<String> tokens = new ArrayList<>();
        Matcher m = Pattern.compile(
            "\\d+\\.\\d+|\\d+|[+\\-*/%()|]|//|\\^"
        ).matcher(expr);
        while (m.find()) {
            tokens.add(m.group());
        }
        return tokens;
    }

    // Парсинг и вычисление с учетом приоритетов
    private static double parseExpression(List<String> tokens) throws Exception {
        // Используем алгоритм "Shunting Yard" для преобразования в постфиксную нотацию
        List<String> postfix = infixToPostfix(tokens);
        return evaluatePostfix(postfix);
    }

    // Преобразование инфиксного выражения в постфиксное
    private static List<String> infixToPostfix(List<String> tokens) throws Exception {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();
        Map<String, Integer> precedence = new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("*", 2);
        precedence.put("/", 2);
        precedence.put("%", 2);
        precedence.put("//", 2);
        precedence.put("^", 3);
        precedence.put("|", 0); // для модулей, но тут обрабатываем отдельно

        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (isNumber(token)) {
                output.add(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                if (operators.isEmpty() || !operators.pop().equals("("))
                    throw new Exception("Несовпадение скобок");
            } else {
                while (!operators.isEmpty() && !operators.peek().equals("(")
                        && precedence.getOrDefault(operators.peek(), 0) >= precedence.getOrDefault(token, 0)) {
                    output.add(operators.pop());
                }
                operators.push(token);
            }
        }
        while (!operators.isEmpty()) {
            String op = operators.pop();
            if (op.equals("(") || op.equals(")"))
                throw new Exception("Несовпадение скобок");
            output.add(op);
        }
        return output;
    }

    // Вычисление постфиксного выражения
    private static double evaluatePostfix(List<String> postfix) throws Exception {
        Stack<Double> stack = new Stack<>();
        for (String token : postfix) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                if (stack.size() < 2)
                    throw new Exception("Некорректное выражение");
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": 
                        if (b == 0) throw new Exception("Деление на ноль");
                        stack.push(a / b); 
                        break;
                    case "%": 
                        if (b == 0) throw new Exception("Деление по модулю на ноль");
                        stack.push(a % b); 
                        break;
                    case "//": 
                        if (b == 0) throw new Exception("Деление без остатка на ноль");
                        stack.push(Math.floor(a / b)); 
                        break;
                    case "^": stack.push(Math.pow(a, b)); break;
                    default: throw new Exception("Неизвестный оператор: " + token);
                }
            }
        }
        if (stack.size() != 1)
            throw new Exception("Некорректное выражение");
        return stack.pop();
    }

    private static boolean isNumber(String token) {
        return token.matches("\\d+(\\.\\d+)?");
    }
}
