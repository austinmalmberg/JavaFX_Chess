package com.austin.chess.logic.piece;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.austin.chess.logic.board.Board;

public class Rook extends Piece {
	
	public Rook(Board board, Point location, PieceColor color) {
		super(board, location, color, PieceType.ROOK);
	}
	
	@Override
	protected void updateAttackMoves() {		
		attackMoves = new ArrayList<>(board.getRelatedPoints().getRank(location.x));
		attackMoves.addAll(board.getRelatedPoints().getFile(location.y));
	}

	@Override
	protected void updatePassiveMoves() {}
	
	@Override
	public void updateValidMoves() {
		
		List<Point> rank = board.getRelatedPoints().getRank(location.x);
		List<Point> file = board.getRelatedPoints().getFile(location.y);
		
		// horizontal moves right of rook
		validMoves = new ArrayList<>(getValidLinearAttackingMoves(rank.stream()
					.filter(point -> point.y > location.y)
					.collect(Collectors.toList())));	
		
		// horizontal moves left of rook
		validMoves.addAll(getValidLinearAttackingMoves(reverse(rank).stream()
					.filter(point -> point.y < location.y)
					.collect(Collectors.toList())));	
		
		// vertical moves above rook
		validMoves.addAll(getValidLinearAttackingMoves(file.stream()
					.filter(point -> point.x > location.x)
					.collect(Collectors.toList())));	
		
		// vertical moves below rook
		validMoves.addAll(getValidLinearAttackingMoves(reverse(file).stream()
					.filter(point -> point.x < location.x)
					.collect(Collectors.toList())));	
	}
	
	@Override
	public boolean offeringCheck() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() { return color == PieceColor.WHITE ? "R" : "H"; }
}
