package com.snakefx;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Controller {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private GridPane grid;
    private int numOfRows = 15;
    private int numOfCols = 15;
    private ArrayList<Rectangle> snakeBody = new ArrayList<>();

    private Rectangle[][] square = new Rectangle[numOfRows][numOfCols];

    private Rectangle snakeHead = new Rectangle(30, 30, Color.RED);

    private Rectangle snakeTail = new Rectangle(30, 30, Color.YELLOW);




    public void initialize() {
        System.out.println("init method");
        fillSquare();
        intializeGridPaneArray();

    }

    private void fillSquare() {
        for(int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                Rectangle rect = new Rectangle(30, 30, Color.BLACK);
                grid.add(rect, i, j);
                System.out.println("rc put");
            }
        }
    }

    private void intializeGridPaneArray() {
        square = new Rectangle[numOfRows][numOfCols];
        for(Node node: grid.getChildren()) {
            square[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)] = (Rectangle) node;
        }
    }

}