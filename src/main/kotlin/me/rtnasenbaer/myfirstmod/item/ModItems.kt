package me.rtnasenbaer.myfirstmod.item

import me.rtnasenbaer.myfirstmod.MyFirstMod
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.ArmorItem
import net.minecraft.item.AxeItem
import net.minecraft.item.HoeItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.PickaxeItem
import net.minecraft.item.ShovelItem
import net.minecraft.item.SwordItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Identifier

object ModItems {

    val ANCIENT_SCALE : Item = registerItem("ancient_scale")
    val SCALE : Item = registerItem("scale")
    val CLAW : Item = registerItem("claw")

    val FOSSIL_SWORD = registerItem("fossil_sword", SwordItem(ModToolMaterial.FOSSIL, 3, -2.4F, FabricItemSettings()))
    val FOSSIL_SHOVEL = registerItem("fossil_shovel", ShovelItem(ModToolMaterial.FOSSIL, 1.5F, -3F, FabricItemSettings()))
    val FOSSIL_PICKAXE = registerItem("fossil_pickaxe", PickaxeItem(ModToolMaterial.FOSSIL, 1, -2.8F, FabricItemSettings()))
    val FOSSIL_AXE = registerItem("fossil_axe", AxeItem(ModToolMaterial.FOSSIL, 5F, -3F, FabricItemSettings()))
    val FOSSIL_HOE = registerItem("fossil_hoe", HoeItem(ModToolMaterial.FOSSIL, -4, 0F, FabricItemSettings()))

    val FOSSIL_HELMET = registerItem("fossil_helmet", ArmorItem(ModArmorMaterial.FOSSIL, ArmorItem.Type.HELMET, FabricItemSettings()))
    val FOSSIL_CHESTPLATE = registerItem("fossil_chestplate", ArmorItem(ModArmorMaterial.FOSSIL, ArmorItem.Type.CHESTPLATE, FabricItemSettings()))
    val FOSSIL_LEGGINGS = registerItem("fossil_leggings", ArmorItem(ModArmorMaterial.FOSSIL, ArmorItem.Type.LEGGINGS, FabricItemSettings()))
    val FOSSIL_BOOTS = registerItem("fossil_boots", ArmorItem(ModArmorMaterial.FOSSIL, ArmorItem.Type.BOOTS, FabricItemSettings()))

    private fun addItemsToItemGroup(itemGroup: RegistryKey<ItemGroup>, item: Item) {
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register { content -> content.add(item) }
    }

    private fun registerItem(name : String) : Item {
        return Registry.register(Registries.ITEM, Identifier(MyFirstMod.MOD_ID, name), Item(FabricItemSettings()))
    }

    private fun registerItem(name : String, item : Item) : Item {
        return Registry.register(Registries.ITEM, Identifier(MyFirstMod.MOD_ID, name), item)
    }

    fun registerModItems() {
        MyFirstMod.logger.info("Registering Mod Items for ${MyFirstMod.MOD_ID}")
    }

}