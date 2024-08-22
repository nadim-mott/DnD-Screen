module namfo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens namfo to javafx.fxml;
    exports namfo;
}
