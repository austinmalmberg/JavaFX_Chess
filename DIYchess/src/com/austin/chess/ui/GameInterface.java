package com.austin.chess.ui;

import com.austin.chess.Ruleset;
import com.austin.chess.logic.board.LogicBoardInitializer;
import com.austin.chess.ui.board.InteractiveChessBoard;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class GameInterface extends Application  {
	
	private FlowPane root;
	
	private InteractiveChessBoard board;
	
	public Parent createContent() {
		initObjects();
		
		root = new FlowPane();
		
		root.getChildren().add(board);
		
		return root;
	}
	
	@Override
	public void start(Stage stage) throws Exception {		
		stage.setScene(new Scene(createContent()));
		stage.setResizable(false);
		stage.sizeToScene();
		stage.show();
		
		stage.setOnCloseRequest(event -> Platform.exit());
	}
	
	private void initObjects() {		
		// load board
		board = new InteractiveChessBoard(LogicBoardInitializer.CLASSIC_LAYOUT, Ruleset.CLASSICAL);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
