module javafxbackround.musicapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics; // Added explicit requirement for javafx.graphics
    requires jfugue;
    requires json.simple;
    requires java.desktop;
        
    opens javafxbackround.music to javafx.fxml;
    exports javafxbackround.music;

    opens javafxbackround.controllers to javafx.fxml;
    exports javafxbackround.controllers;
}