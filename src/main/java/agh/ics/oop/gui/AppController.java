package agh.ics.oop.gui;

import agh.ics.oop.Engine;
import agh.ics.oop.Vector2d;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    @FXML
    private void startNewDay(){

    }

    public void renderMap(){
        mapPane.setGridLinesVisible(false);
        mapPane.getChildren().clear();
        mapPane.getColumnConstraints().clear();
        mapPane.getRowConstraints().clear();
        mapPane.setGridLinesVisible(true);
        for (int x=0;x<engine.getMap().getWidth();x++){
            for (int y=engine.getMap().getHeight()-1;y>=0 ;y--){
                Vector2d position = new Vector2d(x,y);
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
                mapPane.add(newPane,x,engine.getMap().getHeight()-1-y);
            }
        }
    }
}
