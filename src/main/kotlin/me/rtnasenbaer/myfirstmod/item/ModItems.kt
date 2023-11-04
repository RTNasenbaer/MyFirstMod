package me.rtnasenbaer.myfirstmod.item

import me.rtnasenbaer.myfirstmod.MyFirstMod
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemGroups
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.util.Identifier

object ModItems {

    val ancientScale : Item = registerItem("ancient_scale")
    val scale : Item = registerItem("scale")
    val claw : Item = registerItem("claw")

    private fun addItemsToItemGroup(itemGroup: RegistryKey<ItemGroup>, item: Item) {
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register { content -> content.add(item) }
    }

    private fun registerItem(name : String) : Item {
        return Registry.register(Registries.ITEM, Identifier(MyFirstMod.MOD_ID, name), Item(FabricItemSettings()))
    }

    fun registerModItems() {
        MyFirstMod.logger.info("Registering Mod Items for ${MyFirstMod.MOD_ID}")
    }

}