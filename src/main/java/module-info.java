module javafxbackround.musicapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics; // Added explicit requirement for javafx.graphics
    requires jfugue;
    requires json.simple;
    requires java.desktop;
    
    // Explicitly exclude org.hamcrest.core from junit to resolve conflict
    // or you can completely remove junit if not needed
    
    opens javafxbackround.music to javafx.fxml;
    exports javafxbackround.music;

    opens javafxbackround.controllers to javafx.fxml;
    exports javafxbackround.controllers;
}