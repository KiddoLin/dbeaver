/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2021 DBeaver Corp and others
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
package org.jkiss.dbeaver.ui.editors.sql;

import org.jkiss.dbeaver.model.DBPMessageType;
import org.jkiss.dbeaver.runtime.DBeaverNotifications;
import org.jkiss.dbeaver.ui.ShellUtils;
import org.jkiss.utils.CommonUtils;

import java.time.LocalDate;
import java.time.Month;

class AprilFoolsJokeUtils {
    private static final Object lock = new Object();
    private static final boolean isAprilFirst = LocalDate.now().equals(LocalDate.of(2022, Month.APRIL, 1));
    private static boolean isJokeMade;

    private AprilFoolsJokeUtils() {
        // intentionally left blank
    }

    public static void joke() {
        if (!isAprilFirst || isJokeMade) {
            return;
        }

        synchronized (lock) {
            if (isJokeMade) {
                return;
            }
            isJokeMade = true;
            DBeaverNotifications.showNotification(
                    "april_fools",
                    "Check out our new Voice Query Builder!",
                    "With our new Beaver voice assistant, you can use"
                            + CommonUtils.getLineSeparator()
                            + "your voice to execute database queries. Click the"
                            + CommonUtils.getLineSeparator()
                            + "link above to participate in the beta test!",
                    DBPMessageType.INFORMATION,
                    () -> ShellUtils.launchProgram("https://www.youtube.com/watch?v=dQw4w9WgXcQ")
            );
        }
    }
}
