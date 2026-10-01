package com.example.orespawnrevival;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OreSpawnRevival.MODID);

    public static final RegistryObject<CreativeModeTab> MAIN = TABS.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.orespawn_revival"))
                    .icon(() -> new ItemStack(ModItems.MINERS_DREAM.get()))
                    .displayItems((params, output) -> {
                        output.accept(ModItems.MINERS_DREAM.get());
                        output.accept(ModItems.URANIUM_ORE.get());
                        output.accept(ModItems.TITANIUM_ORE.get());
                        output.accept(ModItems.RUBY_ORE.get());
                        output.accept(ModItems.URANIUM_NUGGET.get());
                        output.accept(ModItems.TITANIUM_NUGGET.get());
                        output.accept(ModItems.URANIUM_INGOT.get());
                        output.accept(ModItems.TITANIUM_INGOT.get());
                        output.accept(ModItems.RUBY.get());
                        output.accept(ModItems.AMETHYST_HELMET.get());
                        output.accept(ModItems.AMETHYST_CHESTPLATE.get());
                        output.accept(ModItems.AMETHYST_LEGGINGS.get());
                        output.accept(ModItems.AMETHYST_BOOTS.get());
                        output.accept(ModItems.AMETHYST_SWORD.get());
                        output.accept(ModItems.AMETHYST_PICKAXE.get());
                        output.accept(ModItems.AMETHYST_AXE.get());
                        output.accept(ModItems.AMETHYST_SHOVEL.get());
                        output.accept(ModItems.AMETHYST_HOE.get());
                        output.accept(ModItems.EMERALD_HELMET.get());
                        output.accept(ModItems.EMERALD_CHESTPLATE.get());
                        output.accept(ModItems.EMERALD_LEGGINGS.get());
                        output.accept(ModItems.EMERALD_BOOTS.get());
                        output.accept(ModItems.EMERALD_SWORD.get());
                        ItemStack silkPickaxe = new ItemStack(ModItems.EMERALD_PICKAXE.get());
                        silkPickaxe.enchant(Enchantments.SILK_TOUCH, 1);
                        output.accept(silkPickaxe);
                        output.accept(ModItems.EMERALD_AXE.get());
                        output.accept(ModItems.EMERALD_SHOVEL.get());
                        output.accept(ModItems.EMERALD_HOE.get());
                        output.accept(ModItems.RUBY_HELMET.get());
                        output.accept(ModItems.RUBY_CHESTPLATE.get());
                        output.accept(ModItems.RUBY_LEGGINGS.get());
                        output.accept(ModItems.RUBY_BOOTS.get());
                        output.accept(ModItems.RUBY_SWORD.get());
                        output.accept(ModItems.RUBY_PICKAXE.get());
                        output.accept(ModItems.RUBY_AXE.get());
                        output.accept(ModItems.RUBY_SHOVEL.get());
                        output.accept(ModItems.RUBY_HOE.get());
                    })
                    .build());
}
