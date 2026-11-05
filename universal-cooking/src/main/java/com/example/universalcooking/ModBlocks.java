package com.example.universalcooking;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public final class ModBlocks {
    public static final Block RICE_CROP = register("rice_crop");

    private static Block register(String name) {
        ResourceKey<Block> key = ResourceKey.create(
                Registries.BLOCK, Identifier.fromNamespaceAndPath(UniversalCooking.MOD_ID, name));
        BlockBehaviour.Properties props = BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).setId(key);
        return Registry.register(BuiltInRegistries.BLOCK, key, new RiceCropBlock(props));
    }

    public static void init() {
    }
}
