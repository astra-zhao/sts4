/*******************************************************************************
 * Copyright (c) 2019 Pivotal, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pivotal, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.vscode.commons.java;

import java.io.File;
import java.net.URI;

import reactor.core.Disposable;

public abstract class AbstractJavaProject implements IJavaProject, Disposable {

	private final IClasspath classpath;
	private final URI uri;

	private ClasspathIndex index;

	public AbstractJavaProject(URI uri, IClasspath classpath) {
		this.uri = uri;
		this.classpath = classpath;
	}
	@Override
	public IClasspath getClasspath() {
		return classpath;
	}

	@Override
	public synchronized ClasspathIndex getIndex() {
		if (index == null) {
			index = createIndex();
		}
		return index;
	}

	abstract protected ClasspathIndex createIndex();

	@Override
	public URI getLocationUri() {
		return uri;
	}

	@Override
	public void dispose() {
		Disposable toDispose = null;
		synchronized (this) {
			toDispose = index;
			index = null;
		}
		if (toDispose!=null) {
			toDispose.dispose();
		}
	}

	@Override
	public boolean exists() {
		return new File(uri).exists();
	}

	@Override
	public String toString() {
		return "JavaProject("+uri+")";
	}

}
