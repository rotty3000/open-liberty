/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.springboot.support.fat;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;

import componenttest.custom.junit.runner.FATRunner;
import componenttest.topology.utils.HttpUtils;

@RunWith(FATRunner.class)
public class JSPTests15 extends AbstractSpringTests {

    @Test
    public void testJSP() throws Exception {
        assertNotNull("The application was not installed", server
                        .waitForStringInLog("CWWKZ0001I:.*"));

        // NOTE we set the port to the expected port according to the test application.properties
        server.setHttpDefaultPort(8081);
        HttpUtils.findStringInUrl(server, "", "resources/text.txt");
    }

    @Override
    public Set<String> getFeatures() {
        return new HashSet<>(Arrays.asList("springBoot-1.5", "jsp-2.3"));
    }

    @Override
    public String getApplication() {
        return SPRING_BOOT_15_APP_WAR;
    }

}
