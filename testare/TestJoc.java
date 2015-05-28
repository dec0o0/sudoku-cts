package testare;

import static org.junit.Assert.*;

import org.easymock.EasyMockRule;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import sudoku.*;

//@RunWith(EasyMockRunner.class)
public class TestJoc {
	int joc[][];
	StrategieJoc strat;

	
	@Before
	public void setUp() throws Exception {
		BlocS b = new BlocS(3);
		b.genereazaBlocIntreg(1, 1);
		joc = new int[b.getPerimetru()][b.getPerimetru()];
		for (int i = 1; i < b.getPerimetru(); i++)
			for (int j = 1; j < b.getPerimetru(); j++)
				joc[i][j] = b.getVal(i, j);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test (timeout = 50000)
	public void testGreu() throws Exception{
		(new JocGreu(joc)).genereazaJoc();
	}
	
	@Test
	public void testeazaStrategii() throws Exception{
		strat = new JocUsor(joc);
		strat.genereazaJoc();
		int temp[][] = strat.getJoc();
		strat = new JocGreu(joc);
		strat.genereazaJoc();
		assertNotEquals(temp, strat.getJoc());
	}

}
