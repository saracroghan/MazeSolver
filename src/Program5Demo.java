
public class Program5Demo {

	public static void main(String[] args) {
		
		MazeSolver m = new MazeSolver();
		char[][] maze = m.loadMaze("maze.txt");
		m.solveMaze();
	
	}

}