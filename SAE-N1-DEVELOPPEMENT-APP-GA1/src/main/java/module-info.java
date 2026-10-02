module dev.iut.sae.saen1developpementappga1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.iut.sae.saen1developpementappga1 to javafx.fxml;
    exports dev.iut.sae.saen1developpementappga1;
}