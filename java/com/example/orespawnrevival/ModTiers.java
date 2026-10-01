package com.example.orespawnrevival;

import java.util.function.Supplier;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum ModTiers implements Tier {
    // level, uses, mining speed, attack damage bonus, enchantability, repair item
    AMETHYST(2, 300, 6.5F, 2.0F, 16, () -> Ingredient.of(Items.AMETHYST_SHARD)),
    EMERALD(2, 250, 6.0F, 2.0F, 15, () -> Ingredient.of(Items.EMERALD)),
    RUBY(3, 1561, 9.0F, 3.0F, 10, () -> Ingredient.of(ModItems.RUBY.get()));

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantability;
    private final Supplier<Ingredient> repair;

    ModTiers(int level, int uses, float speed, float damage, int enchantability, Supplier<Ingredient> repair) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantability = enchantability;
        this.repair = repair;
    }

    @Override public int getUses() { return uses; }
    @Override public float getSpeed() { return speed; }
    @Override public float getAttackDamageBonus() { return damage; }
    @Override public int getLevel() { return level; }
    @Override public int getEnchantmentValue() { return enchantability; }
    @Override public Ingredient getRepairIngredient() { return repair.get(); }
}
