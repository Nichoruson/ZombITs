import java.util.Scanner;

public class Questions {
    private static int lives = 3; // Initial number of lives
    private static int inventorySize; // Variable to store the player's inventory size

    public static void main(String[] args) {
        // Example: Display questions based on the player's inventory
        inventorySize = 2; // Change this value for testing
        playGame();
    }

    static void playGame() {
        for (int i = 1; i <= 5; i++) {
            String question = generateQuestion(i);
            System.out.println("Question " + i + ": " + question);

            // Set a 15-second countdown timer for each question
            CountdownTimer.startTimer();
            boolean questionAnswered = false;

            // Get user input and check if time has expired
            while (!questionAnswered && !CountdownTimer.isTimeExpired()) {
                String userAnswer = getUserAnswer();
                if (!CountdownTimer.isTimeExpired()) {
                    questionAnswered = true;
                    // Additional logic to check the user's answer could be added here
                }
            }

            if (CountdownTimer.isTimeExpired()) {
                decreaseLives();
            }
        }

        System.out.println("Game Over. Lives remaining: " + lives);
    }

    static String generateQuestion(int questionType) {
        String category;

        if (inventorySize >= 4) {
            category = "easiest";
        } else if (inventorySize == 3) {
            category = "easy";
        } else if (inventorySize == 2) {
            category = "difficult";
        } else {
            category = "extreme";
        }

        return generateQuestionByCategory(category, questionType);
    }

    static String generateQuestionByCategory(String category, int questionType) {
        switch (category.toLowerCase()) {
            case "easiest":
                return generateEasiestQuestion(questionType);
            case "easy":
                return generateEasyQuestion(questionType);
            case "difficult":
                return generateDifficultQuestion(questionType);
            case "extreme":
                return generateExtremeQuestion(questionType);
            default:
                return "Invalid category";
        }
    }

    static String generateEasiestQuestion(int questionType) {
        switch (questionType) {
            case 1:
                return "What is the result of 5 + 3?";
            case 2:
                return "If you have 10 apples and give away 2, how many apples do you have left?";
            case 3:
                return "What is the product of 4 * 6?";
            case 4:
                return "If you have 20 candies and want to share them equally among 4 friends, how many candies will each friend get?";
            default:
                return "Invalid question type";
        }
    }

    static String generateEasyQuestion(int questionType) {
        switch (questionType) {
            case 1:
                return "If John has 8 marbles and he buys 5 more, then gives away 3, how many marbles does he have now?";
            case 2:
                return "Calculate 7 * 9.";
            case 3:
                return "If you have 15 cookies and want to distribute them equally among 4 friends, how many cookies will each friend get, and how many will be left over?";
            case 4:
                return "What is 3/4 + 1/4?";
            case 5:
                return "Find the missing number in the sequence: 2, 4, 6, _, 10.";
            default:
                return "Invalid question type";
        }
    }

    static String generateDifficultQuestion(int questionType) {
        switch (questionType) {
            case 1:
                return "Sarah has 3 times as many books as Tom. If Tom has 5 books, how many books does Sarah have?";
            case 2:
                return "Calculate 8.6 - 3.2.";
            case 3:
                return "Compute 23 * 17.";
            case 4:
                return "Divide 5/8 by 2/4.";
            case 5:
                return "Find the perimeter of a rectangle with a length of 12 units and a width of 8 units.";
            default:
                return "Invalid question type";
        }
    }

    static String generateExtremeQuestion(int questionType) {
        switch (questionType) {
            case 1:
                return "Solve for x in the equation 2x + 5 = 17.";
            case 2:
                return "If you roll two six-sided dice, what is the probability of getting a sum of 9?";
            case 3:
                return "Calculate the derivative of f(x) = 3x^2 + 2x + 1.";
            case 4:
                return "Given matrices A and B, find A * B. (A = [[2, 4], [1, 3]], B = [[5, 2], [0, 1]])";
            case 5:
                return "If sin(theta) = 3/5, find the value of cos(theta).";
            default:
                return "Invalid question type";
        }
    }

    static String getUserAnswer() {
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static void decreaseLives() {
        lives--;
        System.out.println("Lives remaining: " + lives);
        if (lives == 0) {
            System.out.println("Game Over. No lives remaining.");
            System.exit(0);
        }
    }
}
