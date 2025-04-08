package master.java.ui.ventanas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class LoginWindow extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. Configuración básica de la ventana
        primaryStage.setTitle("CompuWork - Inicio de Sesión");
        primaryStage.setResizable(false);

        // 2. Componentes UI
        Label lblTitle = new Label("Inicio de Sesión");
        lblTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField txtUser = new TextField();
        txtUser.setPromptText("Usuario");
        PasswordField txtPass = new PasswordField();
        txtPass.setPromptText("Contraseña");

        Button btnLogin = new Button("Ingresar");
        btnLogin.setDefaultButton(true);

        // 3. Diseño con GridPane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        grid.add(new Label("Usuario:"), 0, 0);
        grid.add(txtUser, 1, 0);
        grid.add(new Label("Contraseña:"), 0, 1);
        grid.add(txtPass, 1, 1);

        // 4. Contenedor principal
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(lblTitle, grid, btnLogin);

        // 5. Escena y muestra
        Scene scene = new Scene(root, 350, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

        // 6. Evento del botón (conexión básica)
        btnLogin.setOnAction(e -> {
            String username = txtUser.getText();
            String password = txtPass.getText();

            // Validación simple (luego se conectará al controlador)
            if (username.isEmpty() || password.isEmpty()) {
                showAlert("Error", "Debe completar ambos campos");
            } else {
                System.out.println("Intento de login: " + username);
                // Aquí irá la lógica real de autenticación
            }
        });
    }

    // Método auxiliar para alertas
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Punto de entrada (para pruebas independientes)
    public static void main(String[] args) {
        launch(args);
    }
}