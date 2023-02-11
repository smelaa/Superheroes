package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.Math.min;

public class AppController {
    private final Double HEIGHT=550.0;
    private final Double WIDTH=550.0;
    private Engine engine;
    @FXML
    private GridPane wholeScene;

    @FXML
    private Label dayCounter;
    @FXML
    private Label trustPoints;

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

    public void initial(Engine newEngine){
        this.engine=newEngine;
        renderFighterGrid();
        renderMap();
    }

    @FXML
    private void startNewDay(){
        engine.dayRitual();
        dayCounter.setText(engine.getDayNumber().toString());
        trustPoints.setText(engine.getTrustPoints().toString());
        if(engine.isGameWon()){gameWon();}
        else if (engine.isGameLost()){gameLost();}
        else {
            renderMap();
        }
    }

    public void moveActiveHero(MoveDirection direction){
        MoveCoordinates coordinates=engine.moveHero(activeHero, direction);
        if (coordinates!=null){
            renderMap();
            //tu może można zrobić tak żeby nie renderować całej mapy tylko dwa pola - ale wychodzą błędy
//            renderField(coordinates.oldCoordinates());
//            renderField(coordinates.newCoordinates());
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

    private void showProblem(IProblem problem){
        activeHero=null;
        renderDescriptionGrid(problem);
    }

    private GridPane getPaneOfField(Vector2d position){
        GridPane newPane=new GridPane();
        newPane.getColumnConstraints().add(new ColumnConstraints(WIDTH/engine.getMap().getWidth()));
        newPane.getRowConstraints().add(new RowConstraints(HEIGHT/engine.getMap().getHeight()));
        newPane.setGridLinesVisible(true);
        newPane.setStyle(engine.getMap().getColorOnField(position));
        if (engine.getMap().isProblemOnField(position)){
            IProblem problem=engine.getMap().getProblem(position);
            Image image;
            try {
                image = new Image(new FileInputStream(problem.getImage()),WIDTH/engine.getMap().getWidth(),HEIGHT/engine.getMap().getHeight(),false,false);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            ImageView imageView=new ImageView(image);
            imageView.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    showProblem(problem);
                }
            });
            newPane.add(imageView,0,0);
        }
        if(engine.getMap().isHeroOnField(position,activeHero)){
            Image image;
            try {
                image = new Image(new FileInputStream(engine.getMap().getHeroImage(activeHero)),WIDTH/engine.getMap().getWidth(),HEIGHT/engine.getMap().getHeight(),false,false);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            newPane.add(new ImageView(image),0,0);
        }
        else if (engine.getMap().isHeroOnField(position)){
            Image image;
            try {
                image = new Image(new FileInputStream(engine.getMap().getHeroImage(position)),WIDTH/engine.getMap().getWidth(),HEIGHT/engine.getMap().getHeight(),false,false);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            newPane.add(new ImageView(image),0,0);
        }
        return newPane;
    }

    private void activateHero(HeroType hero){
        activeHero=hero;
        renderDescriptionGrid(engine.getHero(hero));
        renderMap();
    }
    private void renderDescriptionGrid(IMapElement element){
        currentImage.getChildren().clear();
        try {
            Image image = new Image(new FileInputStream(element.getPortrait()),150,150,false,false);
            currentImage.add(new ImageView(image),0,0);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        currentName.setText(element.getName());
        currentDesctription.setText(element.getDescription());
    }
    private void renderFighterGrid(){
        try {

            ImageView scientistImage=new ImageView(new Image(new FileInputStream("src/main/resources/pictures/scientist_p.png"),100,100,false,false));
            ImageView detectiveImage=new ImageView(new Image(new FileInputStream("src/main/resources/pictures/detective_p.png"),100,100,false,false));
            ImageView fighterImage=new ImageView(new Image(new FileInputStream("src/main/resources/pictures/fighter_p.png"),100,100,false,false));
            ImageView firemanImage=new ImageView(new Image(new FileInputStream("src/main/resources/pictures/fireman_p.png"),100,100,false,false));
            scientistImage.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    activateHero(HeroType.ComputerScientist);
                }
            });
            detectiveImage.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    activateHero(HeroType.Detective);
                }
            });
            fighterImage.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    activateHero(HeroType.Fighter);
                }
            });
            firemanImage.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    activateHero(HeroType.Fireman);
                }
            });
            chooseFighter.add(scientistImage,0,0);
            chooseFighter.setValignment(scientistImage, VPos.CENTER);
            chooseFighter.setHalignment(scientistImage, HPos.CENTER);
            chooseFighter.add(detectiveImage,0,1);
            chooseFighter.setValignment(detectiveImage, VPos.CENTER);
            chooseFighter.setHalignment(detectiveImage, HPos.CENTER);
            chooseFighter.add(fighterImage,0,2);
            chooseFighter.setValignment(fighterImage, VPos.CENTER);
            chooseFighter.setHalignment(fighterImage, HPos.CENTER);
            chooseFighter.add(firemanImage,0,3);
            chooseFighter.setValignment(firemanImage, VPos.CENTER);
            chooseFighter.setHalignment(firemanImage, HPos.CENTER);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void gameWon(){
        wholeScene.getChildren().clear();
        wholeScene.getColumnConstraints().clear();
        wholeScene.getRowConstraints().clear();
        try {
            wholeScene.add(new ImageView(new Image(new FileInputStream("src/main/resources/won.jpg"))),0,0);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void gameLost(){
        wholeScene.getChildren().clear();
        wholeScene.getColumnConstraints().clear();
        wholeScene.getRowConstraints().clear();
        try {
            wholeScene.add(new ImageView(new Image(new FileInputStream("src/main/resources/lost.jpg"))),0,0);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void showRules() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/RulesView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Superheroes game rules");
        stage.setScene(scene);
        stage.show();
    }

}
