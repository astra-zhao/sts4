/*******************************************************************************
 * Copyright (c) 2017 Pivotal, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pivotal, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.vscode.boot.java.utils;

import org.springframework.ide.vscode.commons.boot.app.cli.SpringBootApp;

public class HoverContentUtils {

	public static String getProcessInformation(SpringBootApp app) {
		return getProcessInformation(app.getProcessID(), app.getProcessName());
	}

	public static String getProcessInformation(String processId, String processName) {
		return "Process " + processId + ": " + processName;
	}

}