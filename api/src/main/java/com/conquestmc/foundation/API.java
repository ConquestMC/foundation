package com.conquestmc.foundation;

import com.conquestmc.foundation.player.FPlayerManager;

public class API {

    private static Foundation foundation;

    private API() throws IllegalAccessException {
        throw new IllegalAccessException("Utility class");
    }

    public static void setFoundation(Foundation coreFoundation) {
        foundation = coreFoundation;
    }

    public static FPlayerManager getUserManager() {
        return foundation.getPlayerManager();
    }
}
