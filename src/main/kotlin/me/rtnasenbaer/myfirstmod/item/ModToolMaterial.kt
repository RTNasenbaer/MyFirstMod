package me.rtnasenbaer.myfirstmod.item

import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import java.util.function.Supplier

enum class ModToolMaterial : ToolMaterial {
    FOSSIL(5, 2569, 11.5F, 5.5F, 26, { Ingredient.ofItems(ModItems.ANCIENT_SCALE, ModItems.CLAW) });

    private val miningLevel: Int
    private val itemDurability: Int
    private val miningSpeed: Float
    private val attackDamage: Float
    private val enchantability: Int
    private val repairIngredient: Supplier<Ingredient>

    constructor(
        miningLevel: Int,
        itemDurability: Int,
        miningSpeed: Float,
        attackDamage: Float,
        enchantability: Int,
        repairIngredient: Supplier<Ingredient>
    ) {
        this.miningLevel = miningLevel
        this.itemDurability = itemDurability
        this.miningSpeed = miningSpeed
        this.attackDamage = attackDamage
        this.enchantability = enchantability
        this.repairIngredient = repairIngredient
    }

    override fun getDurability(): Int {
        return itemDurability
    }

    override fun getMiningSpeedMultiplier(): Float {
        return miningSpeed
    }

    override fun getAttackDamage(): Float {
        return attackDamage
    }

    override fun getMiningLevel(): Int {
        return miningLevel
    }

    override fun getEnchantability(): Int {
        return enchantability
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient.get()
    }

}