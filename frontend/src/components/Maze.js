import Grid from './Grid';
import React, { useState, useEffect } from 'react';


const Maze = ({mazeGrid, mazeSolve }) => {


    if (mazeGrid == null || mazeGrid.length === 0) {
        return <p>Maze Loading...</p>;
    }

    const grid2d = []
    for (let i = 0; i < mazeGrid.length; i = i + Math.sqrt(mazeGrid.length)) {
        const gridRow = []
        for (let x = 0; x < Math.sqrt(mazeGrid.length); x++) {
            gridRow.push(
                <Grid
                x={mazeGrid[i + x].x}
                y={mazeGrid[i + x].y}
                coordType={mazeGrid[i + x].coordType}
                />
            )
        }
        grid2d.push(gridRow)
    }

    const handleClick = function(){
        for(let i = 0; i < mazeSolve[1].length; i++){
            for(let x = 0; x < mazeGrid.length; x++){
                if (mazeSolve[1][i].x === mazeGrid[x].x && mazeSolve[1][i].y === mazeGrid[x].y){
                    mazeGrid[x].coordType = 'VISITED'
                    console.log(mazeGrid[x].coordType)
                    console.log(mazeGrid[x].x)
                    console.log(mazeGrid[x].y)
                }
            }
        }
        showRoute()
    }

    const showRoute = function(){
        console.log("SHOW ROUTE")
        for(let i = 0; i < mazeSolve[0].length; i++){
            for(let x = 0; x < mazeGrid.length; x++){
                if (mazeSolve[0][i].x === mazeGrid[x].x && mazeSolve[0][i].y === mazeGrid[x].y){
                    mazeGrid[x].coordType = 'ROUTE'
                    console.log(mazeGrid[x].coordType)
                    console.log(mazeGrid[x].x)
                    console.log(mazeGrid[x].y)
                }
            }
        }
    }

    


    
    return (
        <>
        <button onClick={handleClick}>
            Solve!
        </button>
        <div className = "MazeGridCSS">
        <table>
        {
        grid2d.map((row, index) => (
            <tr key={row[0]}>
                {row.map(cellId => <th key={cellId}>{cellId}</th>)}
            </tr>
        ))
        }
        </table>
        </div>
        </>
    );
}

export default Maze;