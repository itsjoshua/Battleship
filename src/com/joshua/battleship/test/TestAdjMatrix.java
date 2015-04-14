package com.joshua.battleship.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.joshua.battleship.BFS;
import com.joshua.battleship.Square;


@RunWith(Parameterized.class)
public class TestAdjMatrix {

	private List<Square> expectedAdjMatrix = new ArrayList<Square>();
	private List<Square> actual = new ArrayList<Square>();
	private Integer x;
	private Integer y;
	
	@Before
	public void setupGrid() {
		BFS.setup(10);
		actual = BFS.getAdjMatrix(x, y);
	}
	
	public TestAdjMatrix(Integer x, Integer y, List<Square> expectedAdjMatrix) {
		this.expectedAdjMatrix = expectedAdjMatrix;
		this.x = x;
		this.y = y;
	}
	
	@Parameters
	public static Collection<Object[]> testData() {
		
		List<Object[]> returnData = new ArrayList<Object[]>();
		List<Square> expectedCenter = new ArrayList<Square>();
		
		expectedCenter.add(new Square(3,3,false));
		expectedCenter.add(new Square(3,4,false));
		expectedCenter.add(new Square(3,5,false));
		expectedCenter.add(new Square(4,3,false));
		expectedCenter.add(new Square(4,5,false));
		expectedCenter.add(new Square(5,3,false));
		expectedCenter.add(new Square(5,4,false));
		expectedCenter.add(new Square(5,5,false));
		
		returnData.add(new Object[]{4,4,expectedCenter});
		
		List<Square> expectedSide = new ArrayList<Square>();
		
		expectedSide.add(new Square(4,0,false));
		expectedSide.add(new Square(4,1,false));
		expectedSide.add(new Square(5,1,false));
		expectedSide.add(new Square(6,0,false));
		expectedSide.add(new Square(6,1,false));
		
		returnData.add(new Object[]{5,0,expectedSide});
		
		List<Square> expectedCorner = new ArrayList<Square>();
		
		expectedCorner.add(new Square(0,8,false));
		expectedCorner.add(new Square(1,8,false));
		expectedCorner.add(new Square(1,9,false));
		
		returnData.add(new Object[]{0,9,expectedCorner});
		
		
		
		return returnData;
	}
	
	@Test
	public void testAdjSizeEquality() {
		assertEquals(expectedAdjMatrix.size(), actual.size());
	}
	
	@Test
	public void testAdj() {
		
		for(int i=0;i<actual.size();i++) {
			assertEquals(expectedAdjMatrix.get(i).getX(), actual.get(i).getX());
			assertEquals(expectedAdjMatrix.get(i).getY(), actual.get(i).getY());
			assertEquals(expectedAdjMatrix.get(i).isOccupied(), actual.get(i).isOccupied());
		}
	}
}
