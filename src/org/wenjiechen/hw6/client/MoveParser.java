package org.wenjiechen.hw6.client;

import org.shared.chess.Move;
import org.shared.chess.PieceKind;
import org.shared.chess.Position;

public class MoveParser {
	public Move parseMove(String message){
		System.out.println("parseMove() :" + message); 
		PieceKind proKind = null;
		if(message.contains("QUEEN")){
			proKind = PieceKind.QUEEN;
		}else if(message.contains("ROOK")){
			proKind = PieceKind.ROOK;			
		}else if(message.contains("BISHOP")){
			proKind = PieceKind.BISHOP;			
		}else if(message.contains("KNIGHT")){
			proKind = PieceKind.KNIGHT;			
		}
		message = message.substring(0, 12);
		
		//(1,1)->(3,1)				
		Position from = new Position(Integer.parseInt(message.substring(1, 2)), Integer.parseInt(message.substring(3,4)));
//		System.out.println("from:"+ from.toString());
		Position to = new Position(Integer.parseInt(message.substring(8,9)), Integer.parseInt(message.substring(10,11)));
//		System.out.println("to:"+ to.toString());
		Move move = new Move(from, to, proKind);
		return move;		
	}

}
