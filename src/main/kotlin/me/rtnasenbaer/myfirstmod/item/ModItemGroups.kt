package me.rtnasenbaer.myfirstmod.item

import me.rtnasenbaer.myfirstmod.MyFirstMod
import me.rtnasenbaer.myfirstmod.block.ModBlocks
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier

object ModItemGroups {
    val reptileGroup : ItemGroup = Registry.register(Registries.ITEM_GROUP,
        Identifier(MyFirstMod.MOD_ID, "reptile_group"),
        FabricItemGroup.builder().displayName(Text.translatable("itemGroup.myfirstmod.reptile_group"))
            .icon { ItemStack(ModItems.SCALE) }
            .entries { _, entries ->
                entries.add(ModItems.ANCIENT_SCALE)
                entries.add(ModItems.SCALE)
                entries.add(ModItems.CLAW)

                entries.add(ModItems.FOSSIL_SWORD)
                entries.add(ModItems.FOSSIL_SHOVEL)
                entries.add(ModItems.FOSSIL_PICKAXE)
                entries.add(ModItems.FOSSIL_AXE)
                entries.add(ModItems.FOSSIL_HOE)

                entries.add(ModBlocks.ANCIENT_SCALE_BLOCK)
                entries.add(ModBlocks.SCALE_BLOCK)
                entries.add(ModBlocks.ENCLOSED_FOSSILS)
            }
            .build())

    fun registerModItemGroups() {
        MyFirstMod.logger.info("Registering Item Groups for ${MyFirstMod.MOD_ID}")
    }
}