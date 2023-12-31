package me.rtnasenbaer.myfirstmod.datagen

import me.rtnasenbaer.myfirstmod.block.ModBlocks
import me.rtnasenbaer.myfirstmod.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.BlockStateModelGenerator
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.Models
import net.minecraft.item.ArmorItem

class ModModelProvider(output: FabricDataOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANCIENT_SCALE_BLOCK)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCALE_BLOCK)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENCLOSED_FOSSILS)
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ENCLOSED_FOSSILS)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {
        itemModelGenerator.register(ModItems.ANCIENT_SCALE, Models.GENERATED)
        itemModelGenerator.register(ModItems.SCALE, Models.GENERATED)
        itemModelGenerator.register(ModItems.CLAW, Models.GENERATED)

        itemModelGenerator.register(ModItems.FOSSIL_SWORD, Models.HANDHELD)
        itemModelGenerator.register(ModItems.FOSSIL_SHOVEL, Models.HANDHELD)
        itemModelGenerator.register(ModItems.FOSSIL_PICKAXE, Models.HANDHELD)
        itemModelGenerator.register(ModItems.FOSSIL_AXE, Models.HANDHELD)
        itemModelGenerator.register(ModItems.FOSSIL_HOE, Models.HANDHELD)

        itemModelGenerator.registerArmor(ModItems.FOSSIL_HELMET as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.FOSSIL_CHESTPLATE as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.FOSSIL_LEGGINGS as ArmorItem)
        itemModelGenerator.registerArmor(ModItems.FOSSIL_BOOTS as ArmorItem)
    }
}