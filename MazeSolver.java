import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MazeSolver {

	//2D representation of the maze. The maze will always be 12x12
	private char[][] maze = new char[12][12];
	
	public MazeSolver() {

	}
	
	public char[][] loadMaze(String filename){
		try {
			FileReader maze_file = new FileReader(filename);
			Scanner scan_file = new Scanner(maze_file);
			int tally = 0;
			while(scan_file.hasNext()) {
				maze[tally] = scan_file.next().toCharArray();
				tally ++;
			}
			scan_file.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		print_maze(maze);
		return maze;
	}
	
	private void print_maze(char[][] maze2) {
		for (char [] row: maze) {
			String row_str = "";
			for (char c: row) {
				row_str += c;
			}
			System.out.println(row_str);
		}
	}

	public void solveMaze() {
		// PART 3: You don't really need to do anything here
		// starting parameters for "maze.txt"
		// If you are using a different maze, you will need to change these four values
		int start_x  = 0;
		int start_y = 2;
		int start_hand_x = 0;
		int start_hand_y = 3;
		maze[start_y][start_x] = 'X';
		make_move(start_x, start_y, start_hand_x, start_hand_y);
	}
	
	public void make_move(int x, int y, int hand_x, int hand_y) {
		// Part 4: Making a single move in the maze 
		// Part 4.1: Determine direction (north, east, south, west) using the method inputs
		if(hand_y == y && hand_x == x+1) {
			//facing NORTH
			if(maze[y-1][x] == 'F') {
				y--; hand_y--;
				System.out.println("Maze Solved!");
				return;
			}
			if(maze[hand_y][hand_x] == '.' || maze[hand_y][hand_x] == 'X') {
				x = hand_x; y = hand_y;
				hand_y = hand_y+1;
				maze[y][x] = 'X';
				print_maze(maze);
				make_move(x, y, hand_x, hand_y);
			}
			else if (maze[y-1][x] == '.' ||maze[y-1][x] == 'X') {
				y--; hand_y--;
				maze[y][x] = 'X';
				print_maze(maze);
				make_move(x,y, hand_x, hand_y);
			}
			else {
				hand_x--; hand_y--;
				print_maze(maze);
				make_move(x,y,hand_x, hand_y);
			}
		}
		else if (hand_y == y+1 && hand_x == x) {
			// facing EAST
			if(maze[y][x+1] == 'F') {
				x++; hand_x++;
				System.out.println("Maze Solved!");
				return;
			}
			if(maze[hand_y][hand_x] == '.'||maze[hand_y][hand_x] == 'X') {
				x = hand_x; y = hand_y;
				hand_x--; 
				maze[y][x] = 'X';
				print_maze(maze);
				make_move(x,y,hand_x,hand_y);
			}
			else if(maze[y][x+1] == '.'||maze[y][x+1] == 'X') {
				x++; hand_x++;
				maze[y][x] = 'X';
				print_maze(maze);
				make_move(x,y,hand_x, hand_y);
			}
			else {
				hand_x++; hand_y--;
				print_maze(maze);
				make_move(x,y,hand_x,hand_y);
			}
		}
		else if (hand_y == y && hand_x == x-1) {
			// facing SOUTH
			if(maze[y+1][x] == 'F') {
				y++;hand_y++;
				System.out.println("Maze Solved!");
				return;
			}
			if(maze[hand_y][hand_x] == '.'||maze[hand_y][hand_x] == 'X') {
				x = hand_x; y = hand_y;
				hand_y--;
				maze[y][x] = 'X';
				print_maze(maze);
				make_move(x,y,hand_x,hand_y);
			}
			else if(maze[y+1][x] == '.'||maze[y+1][x] =='X') {
				y++; hand_y++;
				maze[y][x] = 'X';
				print_maze(maze);
				make_move(x,y,hand_x,hand_y);
			}
			else {
				hand_x++;hand_y++;
				print_maze(maze);
				make_move(x,y,hand_x,hand_y);
			}
		}
		else {
			// facing WEST
			if(maze[y][x-1] == 'F') {
				x--; hand_x--;
				System.out.println("Maze Solved!");
				return;
			}
			if(maze[hand_y][hand_x] == '.'||maze[hand_y][hand_x] =='X') {
				x = hand_x; y = hand_y;
				hand_x++;
				maze[y][x] = 'X';
				print_maze(maze);
				make_move(x,y,hand_x,hand_y);
			}
			else if(maze[y][x-1]=='.'||maze[y][x-1]=='X') {
				x--;hand_x--;
				maze[y][x] = 'X';
				print_maze(maze);
				make_move(x,y,hand_x,hand_y);
			}
			else {
				hand_x--;hand_y++;
				print_maze(maze);
				make_move(x,y,hand_x,hand_y);
			}
		}
	}
}