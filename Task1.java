import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {

    private ArrayList<Integer> grades;

    public Task1() {
        grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public int getHighestGrade() {
        if (grades.isEmpty()) {
            return -1; // Return -1 if no grades are present
        }
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public int getLowestGrade() {
        if (grades.isEmpty()) {
            return -1; // Return -1 if no grades are present
        }
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    public static void main(String[] args) {
        Task1 calculator = new Task1();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter grades (type 'done' to finish):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int grade = Integer.parseInt(input);
                calculator.addGrade(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer or 'done' to finish.");
            }
        }

        scanner.close();

        double average = calculator.calculateAverage();
        int highest = calculator.getHighestGrade();
        int lowest = calculator.getLowestGrade();

        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);
    }
}