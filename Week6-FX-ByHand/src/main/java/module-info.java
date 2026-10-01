module org.example.week6fxbyhand {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.week6fxbyhand to javafx.fxml;
    exports org.example.week6fxbyhand;
}