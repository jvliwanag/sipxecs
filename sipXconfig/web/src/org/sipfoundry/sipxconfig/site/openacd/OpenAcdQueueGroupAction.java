/**
 *
 *
 * Copyright (c) 2010 / 2011 eZuce, Inc. All rights reserved.
 * Contributed to SIPfoundry under a Contributor Agreement
 *
 * This software is free software; you can redistribute it and/or modify it under
 * the terms of the Affero General Public License (AGPL) as published by the
 * Free Software Foundation; either version 3 of the License, or (at your option)
 * any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more
 * details.
 */
package org.sipfoundry.sipxconfig.site.openacd;

import org.apache.tapestry.IActionListener;
import org.sipfoundry.sipxconfig.components.selection.OptionAdapter;
import org.sipfoundry.sipxconfig.openacd.OpenAcdQueueGroup;

public abstract class OpenAcdQueueGroupAction implements OptionAdapter, IActionListener {
    private Integer m_id;

    private OpenAcdQueueGroup m_queueGroup;

    public OpenAcdQueueGroupAction(OpenAcdQueueGroup queueGroup) {
        m_queueGroup = queueGroup;
    }

    public Integer getId() {
        return m_id;
    }

    public void setId(Integer id) {
        m_id = id;
    }

    public OpenAcdQueueGroup getQueueGroup() {
        return m_queueGroup;
    }

    public void setQueueGroup(OpenAcdQueueGroup queueGroup) {
        m_queueGroup = queueGroup;
    }

    public Object getValue(Object option, int index) {
        return this;
    }

    public String getLabel(Object option, int index) {
        return m_queueGroup.getName();
    }

    public String squeezeOption(Object option, int index) {
        return getClass().getName() + m_queueGroup.getId();
    }

    public String getMethodName() {
        return null;
    }
}
