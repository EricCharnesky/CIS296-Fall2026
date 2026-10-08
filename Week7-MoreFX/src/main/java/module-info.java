module com.example.week7morefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.week7morefx to javafx.fxml;
    exports com.example.week7morefx;
}