import java.util.Scanner;
import java.util.Random;

public class App {

    private static Scanner scanner;
    private static Random random;

    public static void main(String[]args) {
        scanner = new Scanner(System.in);
        random = new Random();
        int userResponse = askTheUser();
        int pcResponse = askThePC();
        System.out.println("The PC choosed: " + translate(pcResponse) + "!");
	System.out.println(getTheWinner(userResponse, pcResponse));
    }

    public static int askTheUser() {
        System.out.println("Choose: rock, paper, scissor");
        String response = scanner.nextLine().toLowerCase();
        switch (response) {
            case "rock":
                return 0;
            case "paper":
                return 1;
            case "scissor":
                return 2;
            default:
                System.out.println("Sorry, I can't understand.");
                return askTheUser();
        }
    }

    public static int askThePC() {
        return random.nextInt(3);
    }

    public static String translate(int pcResponse) {
        switch (pcResponse) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            default:
                return "scissor";
        }
    }

    public static String getTheWinner(int userResponse, int pcResponse) {
        if( userResponse == pcResponse ) return "TIE!";
	int diference = Math.abs(userResponse - pcResponse);
	if( diference == 1 ) return (userResponse>pcResponse)?"User wins!":"PC wins!";
	return (userResponse<pcResponse)?"User wins!":"PC wins!";
    }
}
