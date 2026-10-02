module org.example.week6fxmlandbyhand {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.week6fxmlandbyhand to javafx.fxml;
    exports org.example.week6fxmlandbyhand;
}