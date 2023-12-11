import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class WelcomeScreen {
    static int screenWidth = 1200;
    static int screenHeight = screenWidth / 2;

    public static Scene createWelcomeScene(Stage primaryStage) {
        Rectangle background = new Rectangle(0, 0, screenWidth, screenHeight);
        background.setFill(Color.BEIGE);
        Pane welcomeScreen = new Pane();
        Scene welcomeScene = new Scene(welcomeScreen, screenWidth, screenHeight);
        Label lblTitle = new Label();
        lblTitle.setText("Hangman");
        lblTitle.setFont(new Font(50));
        lblTitle.setTranslateX(500);
        lblTitle.setTranslateY(100);
        Label lblCredits = new Label();
        lblCredits.setText("By Jack Dalton, Gage Kolojaco, and Giovanni Smith");
        lblCredits.setFont(new Font(25));
        lblCredits.setTranslateX(325);
        lblCredits.setTranslateY(200);

        Button startButton = new Button("Start");
        startButton.setOnAction(e -> startGame(primaryStage));

        double buttonWidth = 100;
        double buttonHeight = 50;
        startButton.setLayoutX((welcomeScene.getWidth() - buttonWidth) / 2);
        startButton.setLayoutY((welcomeScene.getHeight() - buttonHeight) / 2);
        startButton.setPrefSize(buttonWidth, buttonHeight);

        welcomeScreen.getChildren().addAll(background, startButton, lblTitle, lblCredits);

        return welcomeScene;
    }

    private static void startGame(Stage primaryStage) {
        GamePane gamePane = new GamePane();
        Scene gameScene = new Scene(gamePane, screenWidth, screenHeight);

        primaryStage.setScene(gameScene);
        primaryStage.setTitle("Hangman Game");
        primaryStage.show();
    }
}
