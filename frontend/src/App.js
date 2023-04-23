import './App.css';
import MazeGridContainer from './containers/MazeGridContainer';

// PLAN
// drop down to select maze 
// select maze button
// fetches correct maze data, shows maze
// solve button
// fetches correct results
// shows visited nodes, one grid square every .25 seconds?
// once visited nodes has been looped through
// loop through path 

function App() {

  const mazes = [
    {url: "http://localhost:8080/maze/1", solve: "http://localhost:8080/solve/1"},
    {url: "http://localhost:8080/maze/2", solve: "http://localhost:8080/solve/2"},
    {url: "http://localhost:8080/maze/3", solve: "http://localhost:8080/solve/3"},
    {url: "http://localhost:8080/maze/4", solve: "http://localhost:8080/solve/4"},
    {url: "http://localhost:8080/maze/5", solve: "http://localhost:8080/solve/5"}
  ]
  return (
    <div>
      <h1>Maze Solver</h1>
      <MazeGridContainer mazes = { mazes } />
    </div>

  );
}

export default App;
