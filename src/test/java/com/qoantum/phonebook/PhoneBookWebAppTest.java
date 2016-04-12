package com.qoantum.phonebook;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple PhoneBookWebApp.
 */
public class PhoneBookWebAppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PhoneBookWebAppTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PhoneBookWebAppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
