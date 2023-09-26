module ec.edu.espol.super_smash_bros {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.super_smash_bros to javafx.fxml;
    exports ec.edu.espol.super_smash_bros;
}
