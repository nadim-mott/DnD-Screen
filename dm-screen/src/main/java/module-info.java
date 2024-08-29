module namfo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    opens namfo to javafx.fxml;
    opens namfo.Controllers; 
    exports namfo;
    exports namfo.Controllers to javafx.fxml;
}
