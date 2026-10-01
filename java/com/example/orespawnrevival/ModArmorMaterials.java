package com.example.orespawnrevival;

import java.util.function.Supplier;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum ModArmorMaterials implements ArmorMaterial {
    // name, durability multiplier, defense {helmet, chestplate, leggings, boots},
    // enchantability, equip sound, toughness, knockback resistance, repair item
    //
    // For comparison: iron = 15 / {2,6,5,2} / 0 toughness, diamond = 33 / {3,8,6,3} / 2 toughness
    AMETHYST("amethyst", 18, new int[]{3, 7, 5, 2}, 16, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F,
            () -> Ingredient.of(Items.AMETHYST_SHARD)),
    EMERALD("emerald", 15, new int[]{2, 6, 5, 2}, 12, SoundEvents.ARMOR_EQUIP_IRON, 2.0F, 0.0F,
            () -> Ingredient.of(Items.EMERALD)),
    RUBY("ruby", 35, new int[]{3, 8, 6, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.5F, 0.0F,
            () -> Ingredient.of(ModItems.RUBY.get()));

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13}; // helmet, chestplate, leggings, boots

    private final String name;
    private final int durabilityMultiplier;
    private final int[] defense;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repair;

    ModArmorMaterials(String name, int durabilityMultiplier, int[] defense, int enchantability,
                      SoundEvent equipSound, float toughness, float knockbackResistance,
                      Supplier<Ingredient> repair) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.defense = defense;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repair = repair;
    }

    private static int index(ArmorItem.Type type) {
        return switch (type) {
            case HELMET -> 0;
            case CHESTPLATE -> 1;
            case LEGGINGS -> 2;
            case BOOTS -> 3;
        };
    }

    @Override public int getDurabilityForType(ArmorItem.Type type) { return BASE_DURABILITY[index(type)] * durabilityMultiplier; }
    @Override public int getDefenseForType(ArmorItem.Type type) { return defense[index(type)]; }
    @Override public int getEnchantmentValue() { return enchantability; }
    @Override public SoundEvent getEquipSound() { return equipSound; }
    @Override public Ingredient getRepairIngredient() { return repair.get(); }
    @Override public String getName() { return OreSpawnRevival.MODID + ":" + name; }
    @Override public float getToughness() { return toughness; }
    @Override public float getKnockbackResistance() { return knockbackResistance; }
}
