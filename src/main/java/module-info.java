module com.unstuck.snake_and_ladder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.unstuck.snake_and_ladder to javafx.fxml;
    exports com.unstuck.snake_and_ladder;
}