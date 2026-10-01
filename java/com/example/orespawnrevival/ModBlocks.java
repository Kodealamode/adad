package com.example.orespawnrevival;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, OreSpawnRevival.MODID);

    public static final RegistryObject<Block> URANIUM_ORE = BLOCKS.register("uranium_ore",
            () -> new Block(oreProperties()));

    public static final RegistryObject<Block> TITANIUM_ORE = BLOCKS.register("titanium_ore",
            () -> new Block(oreProperties()));

    // Drops rubies (affected by Fortune) and experience, like diamond ore.
    public static final RegistryObject<Block> RUBY_ORE = BLOCKS.register("ruby_ore",
            () -> new DropExperienceBlock(oreProperties(), UniformInt.of(3, 7)));

    private static BlockBehaviour.Properties oreProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.STONE)
                .requiresCorrectToolForDrops()
                .strength(3.0F, 3.0F)
                .sound(SoundType.STONE);
    }
}
