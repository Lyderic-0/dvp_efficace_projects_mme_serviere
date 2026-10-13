module dev.iut.sae.saen1developpementappga1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.iut.sae to javafx.fxml;
    exports dev.iut.sae;
    exports dev.iut.sae.controleur;
    opens dev.iut.sae.controleur to javafx.fxml;
    exports dev.iut.sae.modele;
    opens dev.iut.sae.modele to javafx.fxml;
}