package com.joshua.battleship;

import java.util.ArrayList;
import java.util.List;

public class BFS {
	
	public static List<Square> queue = new ArrayList<Square>();
	public static List<ArrayList<Square>> grid = new ArrayList<ArrayList<Square>>();
	
	
	public static void enqueue(Square square) {
		queue.add(square);
	}
	
	public static Square dequeue() {
		if(queue.size() != 0) {
			return queue.remove(0);
		}else return null;
	}
	
	
	public static void setup(Integer maxIndex) {
		
		if(!grid.isEmpty()) {
			return;
		}
		
		for(int i=0;i<maxIndex;i++) {
			ArrayList<Square> row = new ArrayList<Square>();
			for(int j=0;j<maxIndex;j++) {
				row.add(new Square(i,j,false));
			}
			grid.add(row);
		}
	}
	
	public static Boolean changeStatus(Integer x, Integer y, Boolean status) {
		
		try {
			grid.get(x).set(y, new Square(x,y,status));
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	
	public static List<Square> getAdjMatrix(Integer x, Integer y) {
		
		List<Square> adjMatr = new ArrayList<Square>();
		
		try {
			Square square = grid.get(x-1).get(y-1);
			adjMatr.add(square);
		}catch(Exception e) {}
		
		try {
			Square square = grid.get(x-1).get(y);
			adjMatr.add(square);
		}catch(Exception e) {}
		
		try {
			Square square = grid.get(x-1).get(y+1);
			adjMatr.add(square);
		}catch(Exception e) {}
		
		try {
			Square square = grid.get(x).get(y-1);
			adjMatr.add(square);
		}catch(Exception e) {}
		
		try {
			Square square = grid.get(x).get(y+1);
			adjMatr.add(square);
		}catch(Exception e) {}
		
		try {
			Square square = grid.get(x+1).get(y-1);
			adjMatr.add(square);
		}catch(Exception e) {}
		
		try {
			Square square = grid.get(x+1).get(y);
			adjMatr.add(square);
		}catch(Exception e) {}
		
		try {
			Square square = grid.get(x+1).get(y+1);
			adjMatr.add(square);
		}catch(Exception e) {}
		
		return adjMatr;
	}
	
	
	public static List<Square> discoverNeighbors(Integer x, Integer y) {
		
		List<Square> neighbors = new ArrayList<Square>();
		
		Square origin = grid.get(x).get(y);
		
		origin.setColor("grey");
		BFS.enqueue(origin);
		
		while(!queue.isEmpty()) {
			Square current = BFS.dequeue();
			
			for(Square neighbor : BFS.getAdjMatrix(current.getX(), current.getY())) {
				if(neighbor.isOccupied() && neighbor.getColor().equals("white")) {
					neighbor.setColor("grey");
					BFS.enqueue(neighbor);
				}
			}
			
			current.setColor("black");
			neighbors.add(current);
		}
		
		for(Square neighbor : neighbors) {
			neighbor.setColor("white");
		}
		
		return neighbors;
	}
	

}
