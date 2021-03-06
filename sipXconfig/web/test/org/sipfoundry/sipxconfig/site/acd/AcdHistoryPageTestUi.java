/*
 *
 *
 * Copyright (C) 2007 Pingtel Corp., certain elements licensed under a Contributor Agreement.
 * Contributors retain copyright to elements licensed under a Contributor Agreement.
 * Licensed to the User under the LGPL license.
 *
 * $
 */
package org.sipfoundry.sipxconfig.site.acd;

import net.sourceforge.jwebunit.junit.WebTestCase;

import org.sipfoundry.sipxconfig.site.SiteTestHelper;

public class AcdHistoryPageTestUi extends WebTestCase {

    public void testReports() {
        getTestContext().setBaseUrl(SiteTestHelper.getBaseUrl());
        SiteTestHelper.home(getTester());
        clickLink("seedLocationsManager");
        clickLink("toggleNavigation");
        clickLink("menu.locations");
        clickLink("editLocationLink");
        SiteTestHelper.assertNoUserError(tester);
        clickLink("link:configureBundle");
        SiteTestHelper.assertNoUserError(tester);
        setWorkingForm("Form_0");
        assertElementPresent("MultiplePropertySelection.0");
        uncheckCheckbox("MultiplePropertySelection", "0");
        clickButton("form:ok");
        SiteTestHelper.assertNoUserError(tester);
        clickLink("menu.acdHistory");
        SiteTestHelper.assertUserError(tester);

        clickLink("menu.locations");
        clickLink("editLocationLink");
        SiteTestHelper.assertNoUserError(tester);
        clickLink("link:configureBundle");
        setWorkingForm("Form_0");
        assertElementPresent("MultiplePropertySelection.0");
        checkCheckbox("MultiplePropertySelection", "0");
        clickButton("form:ok");
        clickLink("menu.acdHistory");
        SiteTestHelper.assertNoUserError(tester);
        clickLink("report0");
        clickLink("report1");
        clickLink("report2");
        clickLink("report3");
        clickLink("report4");
        clickLink("report5");
        clickLink("report6");
    }
}
