package com.snakefx;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private GridPane grid;
    @FXML
    private MenuButton menuButton;
    @FXML
    private MenuItem closeButton;
    @FXML
    private MenuItem newGameButton;
    private int x, y = 2;
    private int numOfRows = 15;
    private int numOfCols = 15;
    private int randomX, randomY, direction, movement;
    private Random random = new Random();
    private ArrayList<Rectangle> snakeBody = new ArrayList<>();
    private Rectangle[][] square = new Rectangle[numOfRows][numOfCols];
    private Rectangle snakeHead = new Rectangle(30, 30, Color.RED);
    private Rectangle snakeTail = new Rectangle(30, 30, Color.YELLOW);
    private Rectangle food = new Rectangle(30, 30, Color.GREEN);
    public void initialize() {
        System.out.println("init method");
        fillSquare();
        initializeGridPaneArray();
        setSnakeBody();
        moveSnake();
        setFood();

    }
    private void fillSquare() {
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {
                Rectangle rect = new Rectangle(30, 30, Color.BLACK);
                grid.add(rect, i, j);
                System.out.println("rc put");
            }
        }
    }
    private void initializeGridPaneArray() {
        square = new Rectangle[numOfRows][numOfCols];
        for (Node node : grid.getChildren()) {
            square[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)] = (Rectangle) node;
        }
    }
    private void setSnakeBody() {
        snakeBody.add(snakeHead);
        snakeBody.add(snakeTail);
        direction = 2;
        moveSnake();
    }
    public void moveSnake() {
        Timer timer = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                nextPosition();
            }
        };
        timer.schedule(tt, 300, 500);
    }
    protected void nextPosition() {
        if (x == randomX && y == randomY) {
            snakeGrowth(snakeTail);
            setFood();
            checkDirection();
        }
    }
    private void setFood() {
        randomX = random.nextInt(15);
        randomY = random.nextInt(15);
        square[randomX][randomY] = food;
    }
    private void snakeGrowth(Rectangle snakeTail) {
        snakeBody.add(snakeTail);
    }
    private void checkDirection() {
        if (direction == 1) {
            switch (movement) {
                case 2:
                    x++;
                    direction = 2;
                    movement = 0;
                    break;
                case 4:
                    x--;
                    direction = 4;
                    movement = 0;
                    break;
                default:
                    y--;
                    movement = 0;

            }
        if (direction == 2) {
            switch (movement) {
                    case 1:
                        y--;
                        direction = 1;
                        movement = 0;
                        break;
                    case 3:
                        y++;
                        direction = 3;
                        movement = 0;
                        break;
                    default:
                        y++;
                        movement = 0;

                }
        if (direction == 3) {
            switch (movement) {
                    case 2:
                            x++;
                            direction = 2;

                            break;
                    case 4:
                            x--;
                            direction = 4;
                            break;
                    default:
                            y++;
                            movement = 0;

                    }
        if (direction == 4) {
            switch (movement) {
                    case 1:
                        y--;
                        direction = 1;
                        movement = 0;
                        break;
                    case 3:
                        y--;
                        direction = 3;
                        break;
                    default:
                        x--;
                        movement = 0;
                        }
        grid.setOnKeyPressed(new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            System.out.println("key pressed");
            switch (event.getCode()) {
                case UP:
                    movement = 1;
                    System.out.println("UP");
                    break;
                case RIGHT:
                    movement = 2;
                    System.out.println("RIGHT");
                    break;
                case DOWN:
                    movement = 3;
                    System.out.println("DOWN");
                    break;
                case LEFT:
                    movement = 4;
                    System.out.println("LEFT");
                    break;
                default:
                    System.out.println("Wrong Key!");
                }
                    }
                            });
                        }
                    }
                }
            }
        }
    }



