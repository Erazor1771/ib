/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Categories.IncludeCategory(makeCustomerStuff.class)
@Categories.ExcludeCategory(makeBankStuff.class)
@Suite.SuiteClasses({ BankrekeningenTest.class, KlantenTest.class })
public class KlantenSuite {
    
}
