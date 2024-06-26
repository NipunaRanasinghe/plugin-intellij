/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.ballerina.plugins.idea;

import java.util.Locale;

/**
 * Utility functions used by launcher.
 *
 * @since 2.0.0
 */
public class OSUtils {

    public static final String WINDOWS = "windows";
    public static final String UNIX = "unix";
    public static final String MAC = "mac";

    private static final String OS = System.getProperty("os.name").toLowerCase(Locale.getDefault());

    /**
     * Returns name of the operating system running. null if not a unsupported operating system.
     *
     * @return operating system
     */
    public static String getOperatingSystem() {
        if (OSUtils.isWindows()) {
            return WINDOWS;
        } else if (OSUtils.isUnix() || OSUtils.isSolaris()) {
            return UNIX;
        } else if (OSUtils.isMac()) {
            return MAC;
        }
        return null;
    }

    public static boolean isWindows() {
        return (OS.contains("win"));
    }

    public static boolean isMac() {
        return (OS.contains("mac"));
    }

    public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }

    public static boolean isSolaris() {
        return (OS.contains("sunos"));
    }
}
