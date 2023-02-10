package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static java.lang.Math.min;

public class AppController {
    private final Double HEIGHT=667.0;
    private final Double WIDTH=667.0;
    private Engine engine;
    @FXML
    private Label everydayLabel;

    @FXML
    private Label dayCounter;

    @FXML
    private GridPane chooseFighter;

    @FXML
    private GridPane currentImage;

    @FXML
    private Label currentName;

    @FXML
    private Label currentDesctription;

    @FXML
    private GridPane mapPane;
    private HeroType activeHero=null;

    @FXML
    private void startNewDay(){
        engine.dayRitual();
        renderMap();
        dayCounter.setText(engine.getDayNumber().toString());
        everydayLabel.setText(getRandomText());
    }
    private EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if (!(activeHero ==null)){
                switch (event.getCode()){
                    case UP -> moveActiveHero(MoveDirection.FORWARD);
                    case DOWN -> moveActiveHero(MoveDirection.BACKWARD);
                    case RIGHT -> moveActiveHero(MoveDirection.RIGHT);
                    case LEFT -> moveActiveHero(MoveDirection.LEFT);
                    default -> {}
                }
            }
            event.consume();
        }
    };

    private void moveActiveHero(MoveDirection direction){
        MoveCoordinates coordinates=engine.moveHero(activeHero, direction);
        if (coordinates!=null){
            renderField(coordinates.oldCoordinates());
            renderField(coordinates.newCoordinates());
        }
    }

    public void renderField(Vector2d coordinates){
        mapPane.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == coordinates.getX() && GridPane.getRowIndex(node) == engine.getMap().getHeight()-1-coordinates.getY());
        mapPane.add(getPaneOfField(new Vector2d(coordinates.getX(),coordinates.getY())),coordinates.getX(),engine.getMap().getHeight()-1-coordinates.getY());
    }

    public void renderMap(){
        mapPane.setGridLinesVisible(false);
        mapPane.getChildren().clear();
        mapPane.getColumnConstraints().clear();
        mapPane.getRowConstraints().clear();
        mapPane.setGridLinesVisible(true);
        for (int x=0;x<engine.getMap().getWidth();x++){
            for (int y=engine.getMap().getHeight()-1;y>=0 ;y--){
                mapPane.add(getPaneOfField(new Vector2d(x,y)),x,engine.getMap().getHeight()-1-y);
            }
        }
    }

    private GridPane getPaneOfField(Vector2d position){
        GridPane newPane=new GridPane();
        newPane.getColumnConstraints().add(new ColumnConstraints(WIDTH/engine.getMap().getWidth()));
        newPane.getRowConstraints().add(new RowConstraints(HEIGHT/engine.getMap().getHeight()));
        newPane.setGridLinesVisible(true);
        newPane.setStyle(engine.getMap().getColorOnField(position));
        if (engine.getMap().isProblemOnField(position)){
            Image image = null;
            try {
                image = new Image(new FileInputStream(engine.getMap().getProblemImage(position)));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            newPane.add(new ImageView(image),0,0);
        }
        if (engine.getMap().isHeroOnField(position)){
            Image image = null;
            try {
                image = new Image(new FileInputStream(engine.getMap().getHeroImage(position)));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            newPane.add(new ImageView(image),0,0);
        }
        return newPane;
    }

    private String getRandomText(){
        return "turiruri";
    }
}
