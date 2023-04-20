import React, { useState, useEffect } from 'react';
import Maze from '../components/Maze';

const MazeGridContainer = ({ mazes }) => {
    const [mazeGrid, setMazeGrid] = useState([]);
    const [mazeSolve, setMazeSolve] = useState([]);
    const [selectedValue, setSelectedValue] = useState();

    
    const getMazeGrid = url => {
        fetch(url)
        .then(res => res.json())
        .then(mazeGrid => setMazeGrid(mazeGrid))
        .catch(err => console.error);
    }

    const getMazeSolve  = url => {
        fetch(url)
        .then(res => res.json())
        .then(mazeSolve => setMazeSolve(mazeSolve))
        .catch(err => console.error);
    }

    const handleChange = function(event) {
        setSelectedValue(event.target.value);
    }

    useEffect(() => {
        if (selectedValue){
            console.log(selectedValue)
            console.log(mazes[selectedValue].url);
            getMazeGrid(mazes[selectedValue].url)
            getMazeSolve(mazes[selectedValue].solve)
        }
    }, [selectedValue])

    return (
        <>
        <h4> Select Maze to solve</h4>
        <select onChange={handleChange} >
            <option selected disabled>Select a maze</option>
            <option value="0">1</option>
            <option value="1">2</option>
            <option value="2">3</option>
            <option value="3">4</option>
        </select>
        <Maze mazeGrid = {mazeGrid} mazeSolve = {mazeSolve} />
        </>


        
    )
}

export default MazeGridContainer;