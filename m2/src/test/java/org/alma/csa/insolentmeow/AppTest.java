package org.alma.csa.insolentmeow;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.alma.csa.insolentmeow.*;
import org.alma.csa.insolentmeow.component.*;
import org.alma.csa.insolentmeow.component.binding.*;
import org.alma.csa.insolentmeow.connector.*;
import org.alma.csa.insolentmeow.connector.attachement.*;
import org.alma.csa.insolentmeow.connector.mapping.*;
import org.alma.csa.insolentmeow.interfaces.*;
import org.alma.csa.insolentmeow.interfaces.connexions.*;
import org.alma.csa.insolentmeow.interfaces.connexions.port.*;
import org.alma.csa.insolentmeow.interfaces.connexions.role.*;
import org.alma.csa.insolentmeow.interfaces.service.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void testApp() {
		assertTrue(true);
	}
}
