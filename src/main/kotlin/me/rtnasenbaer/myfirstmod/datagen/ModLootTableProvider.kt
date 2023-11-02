package me.rtnasenbaer.myfirstmod.datagen

import me.rtnasenbaer.myfirstmod.block.ModBlocks
import me.rtnasenbaer.myfirstmod.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.item.ItemStack
import net.minecraft.loot.provider.number.LootNumberProvider

class ModLootTableProvider(dataOutput: FabricDataOutput) : FabricBlockLootTableProvider(dataOutput) {
    override fun generate() {
        addDrop(ModBlocks.ancientScaleBlock)
        addDrop(ModBlocks.scaleBlock)
        addDrop(ModBlocks.enclosedFossils, oreDrops(ModBlocks.enclosedFossils, ModItems.ancientScale))
    }
}