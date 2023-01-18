module agh.ics.oop.gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens agh.ics.oop.gui  to javafx.fxml;
    exports agh.ics.oop.gui;
    exports agh.ics.oop;
    opens agh.ics.oop to javafx.fxml;
}