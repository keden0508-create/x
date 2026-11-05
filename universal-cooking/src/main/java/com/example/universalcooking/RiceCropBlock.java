package com.example.universalcooking;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class RiceCropBlock extends CropBlock {
    public static final MapCodec<RiceCropBlock> CODEC = simpleCodec(RiceCropBlock::new);

    public RiceCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<? extends CropBlock> codec() {
        return CODEC;
    }

    // 뼛가루 등으로 자랄 때, 파괴 시 되돌려줄 씨앗
    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.RICE_SEEDS;
    }
}
