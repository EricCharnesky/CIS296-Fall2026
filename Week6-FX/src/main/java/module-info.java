module org.example.week6fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.week6fx to javafx.fxml;
    exports org.example.week6fx;
}