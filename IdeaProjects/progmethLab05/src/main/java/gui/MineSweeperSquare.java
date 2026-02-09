package gui;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import logic.GameLogic;
import logic.SquareMark;
import logic.SquareState;
import javafx.event.EventHandler;
import javafx.geometry.Insets;

public class MineSweeperSquare extends Pane{
	
	private boolean isDrawn;
	private Color baseColor;
	private int xPosition;
	private int yPosition;
	private final String oURL;
	private final String oneURL;
	private final String mineURL;
	private final String flagURL;

	public MineSweeperSquare(int x, int y) {
		this.oURL = "o.png";
		this.oneURL = "one.png";
		this.mineURL = "mine.png";
		this.flagURL = "flag.png";

		this.xPosition = x;
		this.yPosition = y;

		this.setPrefWidth(100);
		this.setPrefHeight(100);
		this.setMinWidth(100);
		this.setMinHeight(100);

		this.baseColor = Color.MOCCASIN;
		this.initializeCellColor();

		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				onClickHandler();
			}
		});
	}

	private void onClickHandler() {
		// Check if game has ended
		if (GameLogic.getInstance().isGameEnd()) {
			return;
		}

		// Check if game is in secure mode
		if (GameLogic.getInstance().isSecureMode()) {
			// In secure mode: secure the square if not drawn
			if (!isDrawn) {
				Image flagImage = new Image(ClassLoader.getSystemResourceAsStream(flagURL));
				draw(flagImage, Color.GREEN);
				GameLogic.getInstance().updateState(xPosition, yPosition, SquareState.SECURED);
			}
		} else {
			// Not in secure mode: reveal the square if not revealed
			if (GameLogic.getInstance().getBoardState()[xPosition][yPosition] != SquareState.REVEALED) {
				SquareMark mark = GameLogic.getInstance().getBoardMark()[xPosition][yPosition];

				switch (mark) {
					case ONE:
						Image oneImage = new Image(ClassLoader.getSystemResourceAsStream(oneURL));
						draw(oneImage, Color.ORANGE);
						break;
					case NOTHING:
						Image oImage = new Image(ClassLoader.getSystemResourceAsStream(oURL));
						draw(oImage, Color.YELLOW);
						break;
					case MINE:
						Image mineImage = new Image(ClassLoader.getSystemResourceAsStream(mineURL));
						draw(mineImage, Color.RED);
						break;
				}

				GameLogic.getInstance().updateState(xPosition, yPosition, SquareState.REVEALED);
			}
		}
	}

	private void draw(Image image, Color backgroundColor) {
		BackgroundFill bgFill = new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = {bgFill};
		BackgroundSize bgSize = new BackgroundSize(100,100,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		this.setBackground(new Background(bgFillA,bgImgA));
		this.isDrawn = true;
	}

	public void initializeCellColor() {
		BackgroundFill bgFill = new BackgroundFill(baseColor, CornerRadii.EMPTY, Insets.EMPTY);
		this.setBackground(new Background(bgFill));
		this.isDrawn = false;
	}

	// Getters and setters
	public boolean isDrawn() {
		return isDrawn;
	}

	public void setDrawn(boolean drawn) {
		isDrawn = drawn;
	}

	public Color getBaseColor() {
		return baseColor;
	}

	public void setBaseColor(Color baseColor) {
		this.baseColor = baseColor;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public String getoURL() {
		return oURL;
	}

	public String getOneURL() {
		return oneURL;
	}

	public String getMineURL() {
		return mineURL;
	}
	
	public String getFlagURL() {
		return flagURL;
	}
}
