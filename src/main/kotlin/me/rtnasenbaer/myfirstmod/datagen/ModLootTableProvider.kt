package me.rtnasenbaer.myfirstmod.datagen

import me.rtnasenbaer.myfirstmod.block.ModBlocks
import me.rtnasenbaer.myfirstmod.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider

class ModLootTableProvider(dataOutput: FabricDataOutput) : FabricBlockLootTableProvider(dataOutput) {
    override fun generate() {
        addDrop(ModBlocks.ANCIENT_SCALE_BLOCK)
        addDrop(ModBlocks.SCALE_BLOCK)
        addDrop(ModBlocks.ENCLOSED_FOSSILS, oreDrops(ModBlocks.ENCLOSED_FOSSILS, ModItems.ANCIENT_SCALE))
    }
}