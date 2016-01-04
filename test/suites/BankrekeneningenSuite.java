
package suites;

import categories.makeBankStuff;
import categories.makeCustomerStuff;
import internetbankieren.BankrekeningenTest;
import internetbankieren.KlantenTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author lars
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(makeBankStuff.class)
@Categories.ExcludeCategory(makeCustomerStuff.class)
@Suite.SuiteClasses({ BankrekeningenTest.class, KlantenTest.class })
public class BankrekeneningenSuite {
    
}
