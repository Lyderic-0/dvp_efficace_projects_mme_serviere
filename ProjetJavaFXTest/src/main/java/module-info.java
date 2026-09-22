module org.example.projetjavafxtest {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.projetjavafxtest to javafx.fxml;
    exports org.example.projetjavafxtest;
}