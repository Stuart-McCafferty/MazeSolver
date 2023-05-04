
<h1 align="center">
  <br>
 <img src="https://raw.githubusercontent.com/Stuart-McCafferty/MazeSolver/main/img/pngwing.com (1).png" width="200px" height= "200px">
<br>
  Maze Solver
  <br>
</h1>

<h4 align="center">A webapp that generates and solves mazes with Depth-First Search(DFS) and displays the result</h4>

<p align="center">
  <a href="#key-features">Key Features</a> •
  <a href="#how-to-use">How To Use</a> 
</p>

<p align="center">

  <img src="https://raw.githubusercontent.com/Stuart-McCafferty/MazeSolver/main/img/MazeSolverVideo_AdobeExpress.gif" alt="Markdownify" width="90%" height= "500px">
</p>

## Key Features

* Given any list of coordinates and its type (Wall || Path) it will find a route from the Start to End
* Shows the nodes the program visits on the way to the end node (indicated by the blue squares)
* Shows the route from start to end (indicated by the green squares)
* Follows SOLID principles
* Uses many data structures such as 2D arrays, linked lists, queues and stacks
* Uses adjacency lists for graph representation so the program can perform DFS
* Fetches the maze grid and the solve from the backend on request

## How To Use

From your command line:

```bash
# Clone this repository
$ git clone https://github.com/Stuart-McCafferty/MazeSolver.git

# Go into the repository
$ cd MazeSolver

# Install dependencies
$ npm install

# Run the frontend
$ cd frontend
$ npm start

# To run the backend
# Go src -> main -> java -> com.codeclan.examples 
# Run MazeSolverApplication
```





