package testare;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestBlocS.class, 
	TestCelulaS.class,
	TestJoc.class
})
public class AllTests {

}
