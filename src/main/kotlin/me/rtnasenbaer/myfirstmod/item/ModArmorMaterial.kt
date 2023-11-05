package me.rtnasenbaer.myfirstmod.item

import me.rtnasenbaer.myfirstmod.MyFirstMod
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import java.util.function.Supplier

enum class ModArmorMaterial : ArmorMaterial {
    FOSSIL("fossil", 41, intArrayOf(3, 8, 6, 3), 26, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 3.5F, 0.1F, {Ingredient.ofItems(ModItems.ANCIENT_SCALE, ModItems.CLAW)});

    private val material: String
    private val durabilityMultiplier: Int
    private val protectionAmounts: IntArray
    private val enchantability: Int
    private val equipSound: SoundEvent
    private val toughness: Float
    private val knockbackResistance: Float
    private val repairIngredient: Supplier<Ingredient>

    constructor(
        material: String,
        durabilityMultiplier: Int,
        protectionAmounts: IntArray,
        enchantability: Int,
        equipSound: SoundEvent,
        toughness: Float,
        knockbackResistance: Float,
        repairIngredient: Supplier<Ingredient>
    ) {
        this.material = material
        this.durabilityMultiplier = durabilityMultiplier
        this.protectionAmounts = protectionAmounts
        this.enchantability = enchantability
        this.equipSound = equipSound
        this.toughness = toughness
        this.knockbackResistance = knockbackResistance
        this.repairIngredient = repairIngredient
        this.BASE_DURABILITY = intArrayOf(11, 16, 15, 13)
    }


    private val BASE_DURABILITY : IntArray

    override fun getDurability(type: ArmorItem.Type): Int {
        return BASE_DURABILITY[type.ordinal] * durabilityMultiplier
    }

    override fun getProtection(type: ArmorItem.Type): Int {
        return protectionAmounts[type.ordinal]
    }

    override fun getEnchantability(): Int {
        return enchantability
    }

    override fun getEquipSound(): SoundEvent {
        return equipSound
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient.get()
    }

    override fun getName(): String {
        return "${MyFirstMod.MOD_ID}:$material"
    }

    override fun getToughness(): Float {
        return toughness
    }

    override fun getKnockbackResistance(): Float {
        return knockbackResistance
    }

}