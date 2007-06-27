/*
 * 
 * 
 * Copyright (C) 2007 Pingtel Corp., certain elements licensed under a Contributor Agreement.  
 * Contributors retain copyright to elements licensed under a Contributor Agreement.
 * Licensed to the User under the LGPL license.
 * 
 * $
 */
package org.sipfoundry.sipxconfig.site.user_portal;

import junit.framework.Test;
import net.sourceforge.jwebunit.WebTestCase;

import org.sipfoundry.sipxconfig.site.SiteTestHelper;

/**
 * UserCallForwardingTestUi
 */
public class UserCallForwardingTestUi extends WebTestCase {
    public static Test suite() throws Exception {
        return SiteTestHelper.webTestSuite(UserCallForwardingTestUi.class);
    }

    protected void setUp() throws Exception {
        getTestContext().setBaseUrl(SiteTestHelper.getBaseUrl());
    }

    public void testAdminDisplay() throws Exception {
        SiteTestHelper.home(getTester(), true);
        clickLink("UserCallForwarding");
        assertTextNotPresent("An exception has occurred.");
        assertTextPresent("Call Forwarding");
        assertButtonPresent("form:ok");
        assertButtonPresent("form:cancel");
        assertButtonPresent("form:apply");
    }
    
    public void testNonAdminDisplay() throws Exception {
        SiteTestHelper.home(getTester());
        tester.clickLink("loginFirstTestUser");
        clickLink("UserCallForwarding");
        assertTextPresent("Call Forwarding");

        // at the time, no where to go to, e.g. callback null, so 
        // apply is only option        
        assertButtonNotPresent("form:ok");
        assertButtonNotPresent("form:cancel");
        assertButtonPresent("form:apply");
    }
    
    public void testAddAddress() throws Exception {
        SiteTestHelper.home(getTester());
        tester.clickLink("resetCallForwarding");
        SiteTestHelper.setScriptingEnabled(true);
        tester.clickLink("loginFirstTestUser");
        clickLink("UserCallForwarding");

        // Javascript submit link
        clickLink("addRingLink");        
        setFormElement("number", "123");
        clickButton("form:apply");
        assertElementPresent("user:success");

        setFormElement("number", "john@example.com");
        clickButton("form:apply");
        assertElementPresent("user:success");

        setFormElement("number", "john@example@bogus.com");
        clickButton("form:apply");
        assertElementPresent("user:error");

        clickLinkWithText("Delete");
        clickButton("form:apply");
        SiteTestHelper.assertNoUserError(tester);
    }

    public void testAddSchedule() throws Exception {
        SiteTestHelper.home(getTester());
        SiteTestHelper.setScriptingEnabled(true);
        clickLink("loginFirstTestUser");
        clickLink("toggleNavigation");
        clickLink("menu.callForwarding");
        clickLink("addRingLink");

        assertOptionEquals("schedule", "Always");
        setFormElement("number", "222");
        clickButton("form:apply");
        SiteTestHelper.assertNoUserError(tester);
        clickLinkWithText("Delete");
        clickButton("form:apply");
        SiteTestHelper.assertNoUserError(tester);

        clickLink("menu.schedules");
        clickLinkWithText("Add Schedule");
        setFormElement("name", "schedule");
        clickLink("addPeriod");
        clickButton("form:ok");
        SiteTestHelper.assertNoUserError(tester);

        clickLink("menu.callForwarding");
        clickLink("addRingLink");
        selectOption("schedule", "schedule");
        clickButton("form:apply");
        SiteTestHelper.assertUserError(tester);

        setFormElement("number", "222");
        clickButton("form:apply");
        SiteTestHelper.assertNoUserError(tester);

        clickLinkWithText("Delete");
        clickButton("form:apply");
        SiteTestHelper.assertNoUserError(tester);

        clickLink("menu.schedules");
        checkCheckbox("checkbox");
        clickButton("schedule:delete");
        SiteTestHelper.assertNoUserError(tester);
    }
}
