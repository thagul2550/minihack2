package main;

import gui.ControlGridPane;
import gui.ControlPane;
import gui.MineSweeperPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.GameLogic;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create horizontal box as root
		HBox root = new HBox();

		// Set inset padding
		root.setPadding(new Insets(10));

		// Set spacing
		root.setSpacing(10);

		// Set preferred height and width
		root.setPrefHeight(400);
		root.setPrefWidth(800);

		// Initialize MineSweeperPane
		MineSweeperPane mineSweeperPane = new MineSweeperPane();

		// Initialize ControlPane with MineSweeperPane
		ControlPane controlPane = new ControlPane(mineSweeperPane);

		// Initialize ControlGridPane with ControlPane
		ControlGridPane controlGridPane = new ControlGridPane(controlPane);

		// Set the control pane to game logic
		GameLogic.getInstance().setControlPane(controlPane);

		// Add MineSweeperPane and ControlGridPane to root
		root.getChildren().addAll(mineSweeperPane, controlGridPane);

		// Create scene with root
		Scene scene = new Scene(root);

		// Set primaryStage scene
		primaryStage.setScene(scene);

		// Set primaryStage title
		primaryStage.setTitle("MineSweeper");

		// Show primaryStage
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}


