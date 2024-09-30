package exercise1;

import javax.swing.JOptionPane;
import java.util.Random;

public class Test {
    //declaring verbals
    public int correctAnswers;
    public int incorrectAnswers;

    // creating random object
    public Random random = new Random();

    //creating all required methods with JOptionPane

    public void simulateQuestion(String question, String[] options, int correctOption) {
        int userAnswer = JOptionPane.showOptionDialog(null, question, "Quiz",
                0, 3, null, options, options[0]);
        checkAnswer(userAnswer, correctOption,options);
    }

    public void inputAnswer() {
        String[] questions = {
                "Which of the following Java program units defines a group of related objects?",
                "What does an instance variable describe?",
                "Which one of the following terms is correct for a Java class that creates object  of another class, then calls the object’s methods?",
                "How many significant digits does a floating-point number have?",
                "Which of the following typically groups related classes so that they could be imported into programs and reused?"
        };

        String[][] options = {
                {"Java default constructor", "Java method", "Java class", "Java"},
                {"Height of an object", "Properties of an object", "Behaviour of an object", "Measurement of an object"},
                {"Driver class", "Subscribe class", "Concrete class", "Abstract class"},
                {"10", "7", "5", "15"},
                {"Package", "IDE", "Function", "Method"}
        };

        int[] correctOptions = {2, 1, 0, 1, 0};

        for (int i = 0; i < questions.length; i++) {
            simulateQuestion(questions[i], options[i], correctOptions[i]);
        }

        int percentageCorrect = (correctAnswers * 100) / questions.length;
        JOptionPane.showMessageDialog(null, "Test finished!\nCorrect answers: " + correctAnswers +
                "\nIncorrect answers: " + incorrectAnswers + "\nPercentage correct: " + percentageCorrect + "%");
    }

    public void checkAnswer(int userAnswer, int correctAnswer, String[] option) {
        if (userAnswer == correctAnswer) {
            correctAnswers++;
            JOptionPane.showMessageDialog(null, generateMessage(true));
        } else {
            incorrectAnswers++;
            JOptionPane.showMessageDialog(null, generateMessage(false) + " The correct answer is: " + option[correctAnswer]);
        }
    }

    public String generateMessage(boolean Correct) {
        switch (random.nextInt(4)) {
            case 0:
                if (Correct) {return "Excellent!";}else{return "No. Please try again.";}
            case 1:
                if (Correct) {return "Good!";}else{return "Wrong. Try once more.";}
            case 2:
                if (Correct) {return "Keep up the good work!";}else{return "Don't give up!";}
            case 3:
                if (Correct) {return  "Nice work!";}else{return "No. Keep trying.";}
        }
        return "";
    }

}


