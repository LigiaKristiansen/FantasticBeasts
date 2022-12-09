module com.exercise.onlinestore {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires junit;


    exports com.exercise.onlinestore.model;
    opens com.exercise.onlinestore.model to javafx.fxml;
    exports com.exercise.onlinestore.main;
    opens com.exercise.onlinestore.main to javafx.fxml;
    exports com.exercise.onlinestore.test;
    opens com.exercise.onlinestore.test to javafx.fxml;
}