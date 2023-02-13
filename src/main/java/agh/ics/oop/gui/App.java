package agh.ics.oop.gui;

import agh.ics.oop.Engine;
import agh.ics.oop.MoveDirection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GameView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        AppController controller=fxmlLoader.getController();
        controller.initial(new Engine());
        scene.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent key) -> {
            switch(key.getCode()){
                case UP->controller.moveActiveHero(MoveDirection.FORWARD);
                case DOWN->controller.moveActiveHero(MoveDirection.BACKWARD);
                case LEFT->controller.moveActiveHero(MoveDirection.LEFT);
                case RIGHT->controller.moveActiveHero(MoveDirection.RIGHT);
                default->{}
            }
        });
        primaryStage.setTitle("THE BEST GAME EVER!!!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
