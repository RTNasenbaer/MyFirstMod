package me.rtnasenbaer.myfirstmod.datagen

import me.rtnasenbaer.myfirstmod.block.ModBlocks
import me.rtnasenbaer.myfirstmod.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Model
import net.minecraft.data.client.Models

class ModModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ancientScaleBlock)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.scaleBlock)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.enclosedFossils)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        itemModelGenerator.register(ModItems.ancientScale, Models.GENERATED)
        itemModelGenerator.register(ModItems.scale, Models.GENERATED)
        itemModelGenerator.register(ModItems.claw, Models.GENERATED)
    }
}