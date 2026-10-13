module org.example.saen1developpementappga1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens iut.ga1 to javafx.fxml;
    exports iut.ga1;
}