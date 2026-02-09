package gui;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ControlGridPane extends VBox {

	private final String miningImageURL;
	private ControlPane controlPane;

	public ControlGridPane(ControlPane controlPane) {
		this.controlPane = controlPane;
		this.miningImageURL = "bitcoin.png";

		// Create ImageView from miningImageURL
		Image miningImage = new Image(ClassLoader.getSystemResourceAsStream(miningImageURL));
		ImageView imageView = new ImageView(miningImage);

		// Set image fit width and height
		imageView.setFitWidth(150);
		imageView.setFitHeight(150);

		// Create BorderPane for the image
		BorderPane borderPane = new BorderPane();
		borderPane.setPrefWidth(150);
		borderPane.setPrefHeight(200);
		borderPane.setCenter(imageView);

		// Add borderPane and controlPane to this grid in vertical order
		this.getChildren().addAll(borderPane, controlPane);
	}
}
