import java.util.Scanner;

public class TicTacToe {
    private char[][] grid = new char[3][3];
    public char winner;
    private int[] availableCells = new int[9];
    private char currentPlayer = 'x';

    // Constructor
    TicTacToe(){
        char k = '1';
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                grid[i][j] = k;
                k++;
            }
        }

        for(int i = 0; i < 9; i++) availableCells[i] = i+1;
    }

    // function to print the tic-tac-toe grid
    public void printGrid(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(j < 2)
                    System.out.print(grid[i][j] + " | ");
                else
                    System.out.print(grid[i][j]);
            }
            if(i < 2)
                System.out.print("\n__ ___ __ \n");
        }
        System.out.println("\n\n");

    }

    //function to print available spaces grid
    private void printAvailableCells(){
        for (int availableCell : availableCells)
            System.out.print(availableCell + " ");
        System.out.println("\n");
    }

    //function to update available cells spaces
    /*
    Now, this function can be made as private, but I am making it public so that in future we can create a
    module to make a bot which can select empty places on behalf of opponent. Right now, this game is
    multiplayer.
    */
    public boolean updateAvailableCells(int choice){
        // updating value in available cell grid
        for(int i = 0; i < availableCells.length; i++){

            if(availableCells[i] == -1 && choice == i+1){
                System.out.println("Cell already occupied\n");
                return true;
            }

            if(availableCells[i] == choice)
                availableCells[i] = -1;
        }
        return false;
    }

    // function to add character to the grid
    public void addToGrid(){
        System.out.println("****** " + this.currentPlayer + " turn ******");
        System.out.print("Enter a cell number: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice > 9 || choice < 1){
            System.out.println("You have enter invalid number");
            return;
        }

        // updating available cells and returning from the function if cell is already occupied.
        boolean res = updateAvailableCells(choice);
        if(res) return;

        // adding value to the tic-tac-toe grid
        /*
            if the cell is already occupied by x or y then we're just putting it back, but else if
            cell is a number then we are replacing it with the user choice.
         */
        switch(choice){
            case 1:
                grid[0][0] = (grid[0][0] != 'x' && grid[0][0] != 'y') ?  currentPlayer : grid[0][0];
                break;
            case 2:
                grid[0][1] = (grid[0][1] != 'x' && grid[0][1] != 'y') ?  currentPlayer : grid[0][1];
                break;
            case 3:
                grid[0][2] = (grid[0][2] != 'x' && grid[0][2] != 'y') ?  currentPlayer : grid[0][2];
                break;
            case 4:
                grid[1][0] = (grid[1][0] != 'x' && grid[1][0] != 'y') ?  currentPlayer : grid[1][0];
                break;
            case 5:
                grid[1][1] = (grid[1][1] != 'x' && grid[1][1] != 'y') ?  currentPlayer : grid[1][1];
                break;
            case 6:
                grid[1][2] = (grid[1][2] != 'x' && grid[1][2] != 'y') ?  currentPlayer : grid[1][2];
                break;
            case 7:
                grid[2][0] = (grid[2][0] != 'x' && grid[2][0] != 'y') ?  currentPlayer : grid[2][0];
                break;
            case 8:
                grid[2][1] = (grid[2][1] != 'x' && grid[2][1] != 'y') ?  currentPlayer : grid[2][1];
                break;
            case 9:
                grid[2][2] = (grid[2][2] != 'x' && grid[2][2] != 'y') ?  currentPlayer : grid[2][2];
                break;
        }

        this.currentPlayer = (currentPlayer == 'x') ? 'y' : 'x';

        // printing grid at the end of choosing option
        printGrid();

    }

    // function to check winner in tic-tac-toe
    public boolean checkWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                winner = grid[i][0];
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
                winner = grid[0][i];
                return true;
            }
        }

        // Check diagonals
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            winner = grid[0][0];
            return true;
        }

        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            winner = grid[0][2];
            return true;
        }

        return false;
    }

    // function to check if any cell is available or not
    public boolean isCellAvailable(){
        for(int i = 0; i < availableCells.length; i++)
            if(availableCells[i] > -1)
                return false;
        return true;
    }


}
