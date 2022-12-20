package UltimateTTT;
import java.util.Scanner;

public class DriverMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Set the two player objects to null
        Player x = null;
        Player o = null;

        // Create a new ultimate TTT board
        LargeBoard ultimateBoard = new LargeBoard();

        // Welcome message
        System.out.println("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====");
                
        // Get user's choice of game type
        System.out.println("Do you want to play against the computer or a friend?");
        System.out.println("Type 1 to take on the computer and type 2 to play against a human player. (Hint: Type 3 and watch the computer go berserk!): ");
        int num = input.nextInt();

        // Input validation
        while (num != 1 && num != 2 && num != 3){
            System.out.println("Woops! You've entered an invalid input! Try again.");
            System.out.println("Type 1 to take on the computer and type 2 to play against a human player. (Hint: Type 3 and watch the computer go berserk!): ");
            num = input.nextInt();
        }
        
        char userMark  = 'a';
        
        // The user wants to participate
        if(num != 3){
            
            // Prompt user for mark input
            System.out.println("Awesome! Choose your mark! Type 'X' to go first or type 'O' to go second: ");
            userMark = input.next().charAt(0);

            // Input validation
            while (userMark != 'x' && userMark != 'X' && userMark != 'o' && userMark != 'O') {
                System.out.println("Woops! You've entered an invalid input! Try again.");
                System.out.println("Choose your mark! Type 'X' to go first or type 'O' to go second: ");
                userMark = input.next().charAt(0);
            }
        }

        // If the user chose 'O' and wants a computer to be 'X'
        if (num == 1 && (userMark == 'o' || userMark == 'O')) {
            x = new Computer(new MyMark("X"), ultimateBoard);
            o = new Human(new MyMark("O"), ultimateBoard);
        }

        // If the user chose 'O' and wants a human to be 'X'
        else if (num == 2) {
            x = new Human(new MyMark("X"), ultimateBoard);
            o = new Human(new MyMark("O"), ultimateBoard);
        }

        // If the user chose 'X' and wants a computer to be 'O'
        else if (num == 1 && (userMark == 'x' || userMark == 'X')) {
            x = new Human(new MyMark("X"), ultimateBoard);
            o = new Computer(new MyMark("O"), ultimateBoard);   
        } 
        
        // User wants to watch the computer play against itself
        else if(num == 3){
            x = new Computer(new MyMark("X"), ultimateBoard);
            o = new Computer(new MyMark("O"), ultimateBoard);
        }

        // Create a MyGame object
        MyGame newGame = new MyGame(x, o, ultimateBoard);

        // Run the game
        newGame.run();

    }
}