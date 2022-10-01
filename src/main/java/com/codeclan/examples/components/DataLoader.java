//package com.codeclan.examples.components;
//
//import com.codeclan.examples.models.CoordType;
//import com.codeclan.examples.models.Coordinate;
//import com.codeclan.examples.models.MazeGrid;
//import com.codeclan.examples.repositories.CoordinateRepository;
//import com.codeclan.examples.repositories.MazeGridRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//
////@Component
//public class DataLoader implements ApplicationRunner {
//
//    public DataLoader(){
//
//    }
//    @Autowired
//    CoordinateRepository coordinateRepository;
//
//    @Autowired
//    MazeGridRepository mazeGridRepository;
//
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        MazeGrid mazeGrid = new MazeGrid(5,5);
//        mazeGridRepository.save(mazeGrid);
//
//        Coordinate coordinate1 = new Coordinate(0,4, CoordType.START, mazeGrid);
//        Coordinate coordinate2 = new Coordinate(1,4,CoordType.PATH, mazeGrid);
//        Coordinate coordinate3 = new Coordinate(2,4,CoordType.PATH, mazeGrid);
//        Coordinate coordinate4 = new Coordinate(3,4,CoordType.WALL, mazeGrid);
//        Coordinate coordinate5 = new Coordinate(4,4,CoordType.END, mazeGrid);
//        Coordinate coordinate6 = new Coordinate(0,3,CoordType.PATH, mazeGrid);
//        Coordinate coordinate7 = new Coordinate(1,3,CoordType.WALL, mazeGrid);
//        Coordinate coordinate8 = new Coordinate(2,3,CoordType.PATH, mazeGrid);
//        Coordinate coordinate9 = new Coordinate(3,3,CoordType.WALL, mazeGrid);
//        Coordinate coordinate10 = new Coordinate(4,3,CoordType.PATH, mazeGrid);
//        Coordinate coordinate11 = new Coordinate(0,2,CoordType.PATH, mazeGrid);
//        Coordinate coordinate12 = new Coordinate(1,2, CoordType.WALL, mazeGrid);
//        Coordinate coordinate13 = new Coordinate(2,2,CoordType.PATH, mazeGrid);
//        Coordinate coordinate14 = new Coordinate(3,2,CoordType.WALL, mazeGrid);
//        Coordinate coordinate15 = new Coordinate(4,2,CoordType.PATH, mazeGrid);
//        Coordinate coordinate16 = new Coordinate(0,1,CoordType.PATH, mazeGrid);
//        Coordinate coordinate17 = new Coordinate(1,1,CoordType.WALL, mazeGrid);
//        Coordinate coordinate18 = new Coordinate(2,1,CoordType.PATH, mazeGrid);
//        Coordinate coordinate19 = new Coordinate(3,1,CoordType.PATH, mazeGrid);
//        Coordinate coordinate20 = new Coordinate(4,1,CoordType.PATH, mazeGrid);
//        Coordinate coordinate21 = new Coordinate(0,0,CoordType.PATH, mazeGrid);
//        Coordinate coordinate22 = new Coordinate(1,0,CoordType.WALL, mazeGrid);
//        Coordinate coordinate23 = new Coordinate(2,0,CoordType.PATH, mazeGrid);
//        Coordinate coordinate24 = new Coordinate(3,0,CoordType.PATH, mazeGrid);
//        Coordinate coordinate25 = new Coordinate(4,0,CoordType.PATH, mazeGrid);
//
//        coordinateRepository.save(coordinate1);
//        coordinateRepository.save(coordinate2);
//        coordinateRepository.save(coordinate3);
//        coordinateRepository.save(coordinate4);
//        coordinateRepository.save(coordinate5);
//        coordinateRepository.save(coordinate6);
//        coordinateRepository.save(coordinate7);
//        coordinateRepository.save(coordinate8);
//        coordinateRepository.save(coordinate9);
//        coordinateRepository.save(coordinate10);
//        coordinateRepository.save(coordinate11);
//        coordinateRepository.save(coordinate12);
//        coordinateRepository.save(coordinate13);
//        coordinateRepository.save(coordinate14);
//        coordinateRepository.save(coordinate15);
//        coordinateRepository.save(coordinate16);
//        coordinateRepository.save(coordinate17);
//        coordinateRepository.save(coordinate18);
//        coordinateRepository.save(coordinate19);
//        coordinateRepository.save(coordinate20);
//        coordinateRepository.save(coordinate21);
//        coordinateRepository.save(coordinate22);
//        coordinateRepository.save(coordinate23);
//        coordinateRepository.save(coordinate24);
//        coordinateRepository.save(coordinate25);
//
//
//
//    }
//}
