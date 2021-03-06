/*
 *
 *
 * Copyright (C) 2011 eZuce Inc., certain elements licensed under a Contributor Agreement.
 * Contributors retain copyright to elements licensed under a Contributor Agreement.
 * Licensed to the User under the AGPL license.
 *
 * $
 */
package org.sipfoundry.sipxivr.rest;

import java.util.Map;

import org.mortbay.jetty.servlet.ServletHandler;
import org.sipfoundry.commons.freeswitch.FreeSwitchConfigurationInterface;
import org.sipfoundry.commons.userdb.ValidUsers;
import org.sipfoundry.sipxivr.SipxIvrConfiguration;
import org.sipfoundry.voicemail.Mwi;
import org.sipfoundry.voicemail.mailbox.MailboxManager;

public class SipxIvrServletHandler extends ServletHandler {
    public final static String IVR_CONFIG_ATTR = "ivrConfig";
    public final static String VALID_USERS_ATTR = "validUsers";
    public final static String FS_CONFIG_ATTR = "fsConfig";
    public final static String DEPOSIT_MAP_ATTR = "depositMap";
    public final static String MAILBOX_MANAGER = "mailboxManager";
    public final static String MWI_MANAGER = "mwiManager";
    private SipxIvrConfiguration m_ivrConfig;
    private ValidUsers m_validUsers;
    private FreeSwitchConfigurationInterface m_fsConfig;
    private Map<String, String> m_depositMap;
    private MailboxManager m_mailboxManager;
    private Mwi m_mwi;

    @Override
    public void handle(java.lang.String pathInContext, java.lang.String pathParams,
            org.mortbay.http.HttpRequest httpRequest, org.mortbay.http.HttpResponse httpResponse)
            throws java.io.IOException {
        httpRequest.setAttribute(IVR_CONFIG_ATTR, m_ivrConfig);
        httpRequest.setAttribute(VALID_USERS_ATTR, m_validUsers);
        httpRequest.setAttribute(FS_CONFIG_ATTR, m_fsConfig);
        httpRequest.setAttribute(DEPOSIT_MAP_ATTR, m_depositMap);
        httpRequest.setAttribute(MAILBOX_MANAGER, m_mailboxManager);
        httpRequest.setAttribute(MWI_MANAGER, m_mwi);
        super.handle(pathInContext, pathParams, httpRequest, httpResponse);
    }

    public void setIvrConfig(SipxIvrConfiguration config) {
        m_ivrConfig = config;
    }

    public void setValidUsers(ValidUsers validUsers) {
        m_validUsers = validUsers;
    }

    public void setFsConfig(FreeSwitchConfigurationInterface fsConfig) {
        m_fsConfig = fsConfig;
    }

    public void setDepositMap(Map depositMap) {
        m_depositMap = depositMap;
    }

    public void setMailboxManager(MailboxManager mailboxManager) {
        m_mailboxManager = mailboxManager;
    }

    public void setMwiManager(Mwi mwiManager) {
        m_mwi = mwiManager;
    }
}
