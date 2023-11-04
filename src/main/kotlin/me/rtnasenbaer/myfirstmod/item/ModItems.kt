package me.rtnasenbaer.myfirstmod.item

import me.rtnasenbaer.myfirstmod.MyFirstMod
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
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

    val FOSSIL_PICKAXE = registerItem("fossil_pickaxe", PickaxeItem(ModToolMaterial.FOSSIL, 7, 1.2F, FabricItemSettings().maxCount(1)))
    val FOSSIL_SHOVEL = registerItem("fossil_shovel", ShovelItem(ModToolMaterial.FOSSIL, 7.5F, 1F, FabricItemSettings().maxCount(1)))
    val FOSSIL_SWORD = registerItem("fossil_sword", SwordItem(ModToolMaterial.FOSSIL, 9, 1.6F, FabricItemSettings().maxCount(1)))
    val FOSSIL_AXE = registerItem("fossil_axe", AxeItem(ModToolMaterial.FOSSIL, 12F, 1F, FabricItemSettings().maxCount(1)))
    val FOSSIL_HOE = registerItem("fossil_hoe", HoeItem(ModToolMaterial.FOSSIL, 2, 4F, FabricItemSettings().maxCount(1)))

    /*private fun addItemsToItemGroup(itemGroup: RegistryKey<ItemGroup>, item: Item) {
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register { content -> content.add(item) }
    }*/

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