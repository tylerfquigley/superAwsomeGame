module com.example.superawsomegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.superawsomegame to javafx.fxml;
    exports com.example.superawsomegame;
}