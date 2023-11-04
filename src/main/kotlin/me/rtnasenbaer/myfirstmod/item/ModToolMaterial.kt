package me.rtnasenbaer.myfirstmod.item

import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import java.util.function.Supplier

enum class ModToolMaterial(private val miningLevel: Int, private val itemDurability: Int, private val miningSpeed: Float, private val attackDamage: Float, private val enchantability: Int, private val repairIngredient: Supplier<Ingredient>) : ToolMaterial {
    FOSSIL(5, 650, 4.5F, 3.5F, 26, { Ingredient.ofItems(ModItems.ANCIENT_SCALE, ModItems.CLAW) });

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