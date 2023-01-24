module com.snakefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.snakefx to javafx.fxml;
    exports com.snakefx;
}