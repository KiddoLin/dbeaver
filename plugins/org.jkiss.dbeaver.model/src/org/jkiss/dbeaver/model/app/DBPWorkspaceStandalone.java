/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2022 DBeaver Corp and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jkiss.dbeaver.model.app;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.jkiss.code.NotNull;
import org.jkiss.code.Nullable;
import org.jkiss.dbeaver.DBException;
import org.jkiss.dbeaver.model.auth.SMAuthSpace;
import org.jkiss.dbeaver.model.auth.SMSessionContext;
import org.jkiss.dbeaver.model.runtime.DBRProgressMonitor;

import java.nio.file.Path;
import java.util.List;

/**
 * Desktop eclipse based workspace
 */
public interface DBPWorkspaceStandalone extends DBPWorkspace
{
    @NotNull
    IWorkspace getEclipseWorkspace();

    DBPResourceHandlerDescriptor[] getResourceHandlerDescriptors();
    DBPResourceHandlerDescriptor[] getAllResourceHandlers();
    @Nullable
    DBPResourceHandler getResourceHandler(IResource resource);
    @Nullable
    IFolder getResourceDefaultRoot(DBPProject project, DBPResourceHandlerDescriptor handler, boolean forceCreate);
    @Nullable
    IFolder getResourceDefaultRoot(DBPProject project, Class<? extends DBPResourceHandler> handlerType, boolean forceCreate);

}
