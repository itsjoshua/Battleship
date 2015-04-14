package com.joshua.battleship.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.joshua.battleship.BFS;
import com.joshua.battleship.Square;

public class TestBFSNeighbors {
	
	@Before
	public void gridSetup() {
		BFS.setup(10);
		BFS.changeStatus(4, 1, true);
		BFS.changeStatus(3, 2, true);
		BFS.changeStatus(4, 2, true);
		BFS.changeStatus(4, 3, true);
		BFS.changeStatus(6, 5, true);
		BFS.changeStatus(6, 6, true);
		BFS.changeStatus(7, 7, true);
		BFS.changeStatus(5, 4, true);
	}
	
	@Test
	public void testNeighbors() {
		List<Square> neighbors = BFS.discoverNeighbors(6, 6);
		for(Square neighbor : neighbors) {
			System.out.println(neighbor.getX() + " " + neighbor.getY() + " " 
					+ neighbor.getColor() + " " + neighbor.isOccupied());
		}
	}

}
