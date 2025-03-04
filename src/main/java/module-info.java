module javafxbackround.musicapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires jfugue;

    opens javafxbackround.music to javafx.fxml;
    exports javafxbackround.music;

    opens javafxbackround.controllers to javafx.fxml;
    exports javafxbackround.controllers;
}
