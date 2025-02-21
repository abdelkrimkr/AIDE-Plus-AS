/*******************************************************************************
 * Copyright (c) 2000, 2016 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jdt.core;

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Common protocol for Java elements that must be opened before they can be
 * navigated or modified. Opening a textual element (such as a compilation unit)
 * involves opening a buffer on its contents.  While open, any changes to the buffer
 * can be reflected in the element's structure;
 * see {@link #isConsistent} and {@link #makeConsistent(IProgressMonitor)}.
 * <p>
 * To reduce complexity in clients, elements are automatically opened
 * by the Java model as element properties are accessed. The Java model maintains
 * an LRU cache of open elements, and automatically closes elements as they
 * are swapped out of the cache to make room for other elements. Elements with
 * unsaved changes are never removed from the cache, and thus, if the client
 * maintains many open elements with unsaved
 * changes, the LRU cache can grow in size (in this case the cache is not
 * bounded). However, as elements are saved, the cache will shrink back to its
 * original bounded size.
 * </p>
 * <p>
 * To open an element, all openable parent elements must be open.
 * The Java model automatically opens parent elements, as it automatically opens elements.
 * Opening an element may provide access to direct children and other descendants,
 * but does not automatically open any descendents which are themselves {@link IOpenable}.
 * For example, opening a compilation unit provides access to all its constituent elements,
 * but opening a package fragment does not open all compilation units in the package fragment.
 * </p>
 *
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IOpenable {}
