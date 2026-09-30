module org.example.projetjavafxtest {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens iut.but.informatique.exemple.premierprojetjavafx to javafx.graphics;
    exports iut.but.informatique.exemple.premierprojetjavafx;
    exports iut.but.informatique.exemple.premierprojetjavafx.controleur;
    opens iut.but.informatique.exemple.premierprojetjavafx.controleur to javafx.fxml;
    exports iut.but.informatique.exemple.premierprojetjavafx.modele;
    opens iut.but.informatique.exemple.premierprojetjavafx.modele to javafx.fxml;
}