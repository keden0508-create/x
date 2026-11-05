package com.example.universalcooking;

import net.fabricmc.api.ModInitializer;

public class UniversalCooking implements ModInitializer {
    public static final String MOD_ID = "universal_cooking";

    @Override
    public void onInitialize() {
        ModItems.init();
    }
}
