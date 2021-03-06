/*
 * Copyright (c) 2013, 2017 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.glassfish.tyrus.tests.qa;

import java.io.IOException;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.DeploymentException;

import org.glassfish.tyrus.tests.qa.lifecycle.config.CustomConfigurationProtocolsProgrammatic;
import org.glassfish.tyrus.tests.qa.lifecycle.config.MyExtension;
import org.glassfish.tyrus.tests.qa.lifecycle.handlers.text.ProgrammaticWholeMessageStringSession;
import org.glassfish.tyrus.tests.qa.tools.IssueManipulator;

import org.junit.Test;

/**
 * @author Michal Conos (michal.conos at oracle.com)
 */
public class LifeCycleProgrammaticExtensionsTest extends AbstractLifeCycleTestBase {
    @Test
    public void testLifeCycleProgrammaticExtensions() throws DeploymentException, InterruptedException, IOException {
        IssueManipulator.disableAll();

        lifeCycle(
                CustomConfigurationProtocolsProgrammatic.class,
                ProgrammaticWholeMessageStringSession.class,
                ClientEndpointConfig.Builder.create().extensions(MyExtension.initExtensions())
                                            .build());
    }
}
