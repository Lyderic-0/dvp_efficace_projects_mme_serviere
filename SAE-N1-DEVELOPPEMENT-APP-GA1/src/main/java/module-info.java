module iut.ga1.saen1developpementappga1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens iut.ga1.saen1developpementappga1 to javafx.fxml;
    exports iut.ga1.saen1developpementappga1;
}