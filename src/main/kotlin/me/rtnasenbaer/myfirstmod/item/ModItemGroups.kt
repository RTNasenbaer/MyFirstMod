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
            .icon { ItemStack(ModItems.scale) }
            .entries { displayContext, entries ->
                entries.add(ModItems.ancientScale)
                entries.add(ModItems.scale)

                entries.add(ModBlocks.ancientScaleBlock)
                entries.add(ModBlocks.scaleBlock)
                entries.add(ModBlocks.enclosedFossils)
            }
            .build())

    fun registerModItemGroups() {
        MyFirstMod.logger.info("Registering Item Groups for ${MyFirstMod.MOD_ID}")
    }
}