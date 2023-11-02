package me.rtnasenbaer.myfirstmod.datagen

import me.rtnasenbaer.myfirstmod.block.ModBlocks
import me.rtnasenbaer.myfirstmod.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.RecipeProvider
import net.minecraft.recipe.book.RecipeCategory

class ModRecipeProvider(output: FabricDataOutput) : FabricRecipeProvider(output) {

    val ancient_smeltable = listOf(ModBlocks.enclosedFossils)
    override fun generate(exporter: RecipeExporter) {
        offerSmelting(exporter, ancient_smeltable, RecipeCategory.MISC, ModItems.ancientScale, 0.7F, 200, "ancient_scale")
        offerBlasting(exporter, ancient_smeltable, RecipeCategory.MISC, ModItems.ancientScale, 0.7F, 100, "ancient_scale")

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ancientScale, RecipeCategory.DECORATIONS, ModBlocks.ancientScaleBlock)
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.scale, RecipeCategory.DECORATIONS, ModBlocks.scaleBlock)
    }
}