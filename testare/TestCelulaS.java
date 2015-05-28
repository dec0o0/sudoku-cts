package testare;

import static org.junit.Assert.*;

import org.junit.Test;

import sudoku.CelulaS;

public class TestCelulaS {

	@Test
    public void testAIncercat() {
        System.out.println("A incercat");
        int number = 3;
        CelulaS cel = new CelulaS();
        boolean result = cel.aIncercat(number);
        assertEquals(false, result);
    }

    @Test
    public void testIncearcaNumar() {
        System.out.println("Incearca numar");
        int number = 5;
        CelulaS cel = new CelulaS();
        cel.incearcaVal(number);
        boolean result = cel.aIncercat(number);
        assertEquals(true, result);
    }

    @Test
    public void testReset() {
        System.out.println("Reset");
        CelulaS cel = new CelulaS();
        cel.incearcaVal(2);
        cel.incearcaVal(4);
        cel.incearcaVal(6);
        assertEquals(cel.nrIncercari(), 3);
        cel.reset();
        assertEquals(0, cel.nrIncercari());
    }

    @Test
    public void testNumarIncercari() {
        System.out.println("Nr incercari");
        CelulaS cel = new CelulaS();
        assertEquals(0, cel.nrIncercari());
        cel.incearcaVal(2);
        cel.incearcaVal(4);
        cel.incearcaVal(6);
        assertEquals(3, cel.nrIncercari());
    }
    
    @Test
    public void testClear(){
    	System.out.println("Clear");
    	CelulaS cel = new CelulaS();
    	cel.set(22);
    	assertEquals(22, cel.getVal());
    	cel.clear();
    	assertEquals(0, cel.getVal());
    }
}
