package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class MineSweeperPane extends GridPane {

	private ArrayList<MineSweeperSquare> allCells;

	public MineSweeperPane() {
		// Initialize allCells
		this.allCells = new ArrayList<>();

		// Set horizontal and vertical gap
		this.setHgap(8);
		this.setVgap(8);

		// Set inset padding and preferred width
		this.setPadding(new Insets(8));
		this.setPrefWidth(500);

		// Set alignment
		this.setAlignment(Pos.CENTER);

		// Set border
		this.setBorder(new Border(new BorderStroke(
				Color.LIGHTGRAY,
				BorderStrokeStyle.SOLID,
				CornerRadii.EMPTY,
				BorderWidths.DEFAULT
		)));

		// Set background
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

		// Initialize MineSweeperSquare objects in 5x5 grid
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				MineSweeperSquare square = new MineSweeperSquare(i, j);
				allCells.add(square);
				this.add(square, i, j);
			}
		}
	}

	public ArrayList<MineSweeperSquare> getAllCells() {
		return allCells;
	}
}
