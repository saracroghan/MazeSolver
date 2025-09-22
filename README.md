# Java Maze Solver

This is a command-line Java application that automatically solves a 12x12 maze provided in a text file. The program uses a "right-hand rule" (wall follower) algorithm to navigate from a starting point to the finish.

## Description

The program reads a maze layout from a file named `maze.txt`. It then places a solver at a hardcoded starting position and begins navigating. After each step, the program prints the updated maze to the console, showing the path taken. The path is marked with an 'X'. The program terminates once it reaches the 'F' (finish) character in the maze.

The core logic is implemented using a recursive `make_move` method that determines the next step based on the solver's current position and orientation.

## Features

* **Maze Loading**: Loads a 12x12 maze from an external text file (`maze.txt`).
* **Wall Follower Algorithm**: Implements the "right-hand rule" to ensure it can solve any simple maze (a maze without detached walls or loops).
* **Step-by-Step Visualization**: Prints the entire maze to the console after every single move, allowing you to visualize the solver's path.
* **Path Marking**: Marks the traversed path with an 'X' character to distinguish it from open paths.

---

##  Getting Started

### Prerequisites

* Java Development Kit (JDK) installed on your system.
* A text file named `maze.txt` in the same directory as the Java files.

### `maze.txt` Format

The `maze.txt` file must be a 12x12 grid of characters. The characters represent:
* `#` - A wall
* `.` - An open path
* `F` - The finish line

*(Note: The actual start position is hardcoded in `MazeSolver.java` at coordinates x=0, y=2 for the maze above.)*

### How to Run

1.  **Place Files**: Ensure `Program5Demo.java`, `MazeSolver.java`, and `maze.txt` are all in the same directory.

2.  **Compile**: Open a terminal or command prompt in the project's directory and compile the Java source files.
    ```bash
    javac Program5Demo.java MazeSolver.java
    ```

3.  **Execute**: Run the main program to start the solver.
    ```bash
    java Program5Demo
    ```
    The program will immediately start printing the maze state as it solves it.

---

## Code Overview

### `MazeSolver.java`

This file contains the primary logic for the solver.

* `maze[][]`: A 12x12 `char` array that holds the maze structure in memory.
* `loadMaze(String filename)`: Reads the specified file and populates the `maze` array. It then calls `print_maze` to show the initial state.
* `solveMaze()`: A simple method that hardcodes the starting coordinates and initial "hand" position for the solver, marks the start with an 'X', and makes the first call to the recursive `make_move` method.
* `make_move(int x, int y, int hand_x, int hand_y)`: The core recursive function that implements the solving logic. It checks the solver's orientation and decides whether to turn right (towards its "hand"), move forward, or turn left.
* `print_maze(char[][] maze2)`: A helper method to print the current state of the 2D maze array to the console.

### `Program5Demo.java`

The main driver for the application.

* `main(String[] args)`: The entry point of the program. It creates an instance of `MazeSolver`, calls `loadMaze` to initialize the maze, and then calls `solveMaze` to begin the solving process.

## Limitations

* **Fixed Maze Size**: The program is hardcoded to only work with 12x12 mazes.
* **Hardcoded Start Position**: The starting coordinates (`start_x`, `start_y`) are hardcoded within the `solveMaze()` method. To use a different maze, these values must be changed in the source code.
