/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2023 DBeaver Corp and others
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
package org.jkiss.dbeaver.ui.actions.datasource;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.jkiss.dbeaver.model.DBPDataSourceContainer;
import org.jkiss.dbeaver.model.app.DBPProject;
import org.jkiss.dbeaver.ui.actions.AbstractDataSourceHandler;
import org.jkiss.dbeaver.ui.navigator.NavigatorUtils;

public class DataSourceDisconnectProjectHandler extends AbstractDataSourceHandler
{
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException
    {
        DBPProject activeProject = NavigatorUtils.getSelectedProject(HandlerUtil.getCurrentSelection(event), HandlerUtil.getActivePart(event));
        if (activeProject != null) {
            for (final DBPDataSourceContainer dataSourceContainer : activeProject.getDataSourceRegistry().getDataSources()) {
                if (dataSourceContainer.isConnected()) {
                    DataSourceHandler.disconnectDataSource(dataSourceContainer, null);
                }
            }
        }
        return null;
    }

}