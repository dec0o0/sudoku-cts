package testare;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sudoku.BlocS;

public class TestBlocS {
	Scanner sc;

	@Before
	public void setUp() throws Exception {
		sc = new Scanner(new File("/Users/macbookproritena/Documents/workspace/Sudoku/src/testare/sudoku.in"));
	}

	@After
	public void tearDown() throws Exception {
		sc.close();
	}

	@Test (expected = Exception.class)
	public void testBlocSConstructor() throws Exception {
			BlocS bloc = new BlocS(3);
			System.out.println("works");
			bloc  = new BlocS(-1);
			fail("wrong place");
	}
	
	
	@Test
	public void testValiditate(){
		try{
			BlocS bloc = new BlocS(3);
			int col = 1;
			while (sc.hasNextLine()){
				for (int r = 1; r < 10; r++){
					int val = sc.nextInt();
					bloc.setVal(val, r, col);
				}
				col++;
				if (col > 9){
					for (int i = 1; i < 10; i++)
						for (int j = 1; j < 10; j++){
							int aux = bloc.getVal(i, j);
							bloc.setVal(0, i, j);
							assertTrue(bloc.verificaNumar(aux, i, j));
							bloc.setVal(aux, i, j);
						}
					col = 1;
					bloc.reset();
				}
			}
			assertTrue(true);
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	
	
	@Test
	public void testGenereaza(){
		try{
			BlocS bloc = new BlocS(3);
			bloc.genereazaBlocIntreg(1, 1);
			assertTrue(bloc.areContinut());
			for (int i = 1 ; i <= 9; i++)
				for (int j = 1; j <= 9; j++){
					int x  = bloc.getVal(i, j);
					bloc.setVal(0, i, j);
					assertTrue(bloc.verificaNumar(x, i, j));
					bloc.setVal(x, i, j);
				}
		}
		catch (Exception ex){
			fail("exception raised");
			System.out.println(ex);
		}
	}
	
	

}
