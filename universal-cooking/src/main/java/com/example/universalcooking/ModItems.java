package com.example.universalcooking;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public final class ModItems {
    // 이름, 허기(nutrition), 포화도(saturation)
    public static final Item FRIED_EGG    = food("fried_egg",     4, 0.6f);
    public static final Item EGG_SANDWICH = food("egg_sandwich",  8, 0.7f);
    public static final Item HAMBURGER    = food("hamburger",    10, 0.8f);
    public static final Item FRUIT_SALAD  = food("fruit_salad",   7, 0.6f);
    public static final Item HONEY_TOAST  = food("honey_toast",   6, 0.7f);
    public static final Item FISH_SKEWER  = food("fish_skewer",   8, 0.7f);

    public static final Item CHEESE            = food("cheese",            3, 0.5f);
    public static final Item BOILED_EGG        = food("boiled_egg",        5, 0.6f);
    public static final Item COOKED_RICE       = food("cooked_rice",       4, 0.6f);
    public static final Item ONIGIRI           = food("onigiri",           7, 0.7f);
    public static final Item CUP_RAMEN         = food("cup_ramen",         9, 0.6f);
    public static final Item CHEESE_TTEOKBOKKI = food("cheese_tteokbokki", 10, 0.8f);

    // 재료 아이템 (먹을 수 없음)
    public static final Item SALT   = ingredient("salt");
    public static final Item PEPPER = ingredient("pepper");

    // 쌀 작물: 볍씨(심으면 벼가 자람) -> 다 자라면 쌀 수확
    public static final Item RICE_SEEDS = seeds("rice_seeds");
    public static final Item RICE       = ingredient("rice");

    private static Item seeds(String name) {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM, Identifier.fromNamespaceAndPath(UniversalCooking.MOD_ID, name));
        Item.Properties props = new Item.Properties().setId(key).useItemDescriptionPrefix();
        return Registry.register(BuiltInRegistries.ITEM, key, new BlockItem(ModBlocks.RICE_CROP, props));
    }

    private static Item ingredient(String name) {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM, Identifier.fromNamespaceAndPath(UniversalCooking.MOD_ID, name));
        return Registry.register(BuiltInRegistries.ITEM, key, new Item(new Item.Properties().setId(key)));
    }

    private static Item food(String name, int nutrition, float saturation) {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM, Identifier.fromNamespaceAndPath(UniversalCooking.MOD_ID, name));
        FoodProperties food = new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturation)
                .build();
        Item.Properties props = new Item.Properties().setId(key).food(food);
        return Registry.register(BuiltInRegistries.ITEM, key, new Item(props));
    }

    public static void init() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(SALT);
            output.accept(PEPPER);
            output.accept(RICE_SEEDS);
            output.accept(RICE);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(output -> {
            output.accept(FRIED_EGG);
            output.accept(EGG_SANDWICH);
            output.accept(HAMBURGER);
            output.accept(FRUIT_SALAD);
            output.accept(HONEY_TOAST);
            output.accept(FISH_SKEWER);
            output.accept(CHEESE);
            output.accept(BOILED_EGG);
            output.accept(COOKED_RICE);
            output.accept(ONIGIRI);
            output.accept(CUP_RAMEN);
            output.accept(CHEESE_TTEOKBOKKI);
        });
    }
}
