package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;

public class ControlPane extends VBox {

	private Text gameText;
	private Button newGameButton;
	private Button secureModeButton;
	private MineSweeperPane mineSweeperPane;

	public ControlPane(MineSweeperPane mineSweeperPane) {
		this.mineSweeperPane = mineSweeperPane;

		// Set alignment
		this.setAlignment(Pos.CENTER);

		// Set preferred width
		this.setPrefWidth(300);

		// Set spacing
		this.setSpacing(20);

		// Initialize components
		initializeGameText();
		initializeNewGameButton();
		initializeSecureModeButton();

		// Add components to this pane
		this.getChildren().addAll(gameText, newGameButton, secureModeButton);
	}

	private void initializeGameText() {
		gameText = new Text("Tiles left : " + GameLogic.getInstance().getTileCount());
		gameText.setFont(new Font(35));
	}

	public void updateGameText(String text) {
		gameText.setText(text);
	}

	private void initializeNewGameButton() {
		newGameButton = new Button("New Game");
		newGameButton.setPrefWidth(100);
		newGameButton.setOnAction(event -> newGameButtonHandler());
	}

	private void initializeSecureModeButton() {
		secureModeButton = new Button("Secure mode : OFF");
		secureModeButton.setPrefWidth(150);
		secureModeButton.setOnAction(event -> secureModeButtonHandler());
	}

	private void newGameButtonHandler() {
		// Reset game state
		GameLogic.getInstance().newGame();

		// Reset secure mode button text
		secureModeButton.setText("Secure mode : OFF");

		// Reset game text
		gameText.setText("Tiles left : " + GameLogic.getInstance().getTileCount());

		// Reset all cells in mineSweeperPane
		for (MineSweeperSquare cell : mineSweeperPane.getAllCells()) {
			cell.initializeCellColor();
		}
	}

	private void secureModeButtonHandler() {
		// Toggle secure mode
		GameLogic.getInstance().toggleSecureMode();

		// Update button text based on secure mode state
		if (GameLogic.getInstance().isSecureMode()) {
			secureModeButton.setText("Secure mode : ON");
		} else {
			secureModeButton.setText("Secure mode : OFF");
		}
	}
}
