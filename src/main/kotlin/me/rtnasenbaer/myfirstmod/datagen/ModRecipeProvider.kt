package me.rtnasenbaer.myfirstmod.datagen

import me.rtnasenbaer.myfirstmod.block.ModBlocks
import me.rtnasenbaer.myfirstmod.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeExporter
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.item.Items
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.util.Identifier

class ModRecipeProvider(output: FabricDataOutput) : FabricRecipeProvider(output) {

    val ancient_smeltable = listOf(ModBlocks.ENCLOSED_FOSSILS)
    override fun generate(exporter: RecipeExporter) {
        offerSmelting(exporter, ancient_smeltable, RecipeCategory.MISC, ModItems.ANCIENT_SCALE, 0.7F, 200, "ancient_scale")
        offerBlasting(exporter, ancient_smeltable, RecipeCategory.MISC, ModItems.ANCIENT_SCALE, 0.7F, 100, "ancient_scale")


        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ANCIENT_SCALE, RecipeCategory.DECORATIONS, ModBlocks.ANCIENT_SCALE_BLOCK)
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SCALE, RecipeCategory.DECORATIONS, ModBlocks.SCALE_BLOCK)


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FOSSIL_SWORD, 1)
            .pattern(" C ")
            .pattern(" S ")
            .pattern(" T ")
            .input('C', ModItems.CLAW)
            .input('S', ModItems.ANCIENT_SCALE)
            .input('T', Items.STICK)
            .criterion(hasItem(ModItems.CLAW), conditionsFromItem(ModItems.CLAW))
            .criterion(hasItem(ModItems.ANCIENT_SCALE), conditionsFromItem(ModItems.ANCIENT_SCALE))
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.FOSSIL_SWORD)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FOSSIL_SHOVEL, 1)
            .pattern(" S ")
            .pattern(" T ")
            .pattern(" T ")
            .input('S', ModItems.ANCIENT_SCALE)
            .input('T', Items.STICK)
            .criterion(hasItem(ModItems.ANCIENT_SCALE), conditionsFromItem(ModItems.ANCIENT_SCALE))
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.FOSSIL_SHOVEL)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FOSSIL_PICKAXE, 1)
            .pattern("CSC")
            .pattern(" T ")
            .pattern(" T ")
            .input('C', ModItems.CLAW)
            .input('S', ModItems.ANCIENT_SCALE)
            .input('T', Items.STICK)
            .criterion(hasItem(ModItems.CLAW), conditionsFromItem(ModItems.CLAW))
            .criterion(hasItem(ModItems.ANCIENT_SCALE), conditionsFromItem(ModItems.ANCIENT_SCALE))
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.FOSSIL_PICKAXE)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FOSSIL_AXE, 1)
            .pattern("SS ")
            .pattern("CT ")
            .pattern(" T ")
            .input('C', ModItems.CLAW)
            .input('S', ModItems.ANCIENT_SCALE)
            .input('T', Items.STICK)
            .criterion(hasItem(ModItems.CLAW), conditionsFromItem(ModItems.CLAW))
            .criterion(hasItem(ModItems.ANCIENT_SCALE), conditionsFromItem(ModItems.ANCIENT_SCALE))
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.FOSSIL_AXE)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.FOSSIL_HOE, 1)
            .pattern("CS ")
            .pattern(" T ")
            .pattern(" T ")
            .input('C', ModItems.CLAW)
            .input('S', ModItems.ANCIENT_SCALE)
            .input('T', Items.STICK)
            .criterion(hasItem(ModItems.CLAW), conditionsFromItem(ModItems.CLAW))
            .criterion(hasItem(ModItems.ANCIENT_SCALE), conditionsFromItem(ModItems.ANCIENT_SCALE))
            .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.FOSSIL_HOE)))


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FOSSIL_HELMET, 1)
            .pattern("SSS")
            .pattern("C C")
            .pattern("   ")
            .input('C', ModItems.CLAW)
            .input('S', ModItems.ANCIENT_SCALE)
            .criterion(hasItem(ModItems.CLAW), conditionsFromItem(ModItems.CLAW))
            .criterion(hasItem(ModItems.ANCIENT_SCALE), conditionsFromItem(ModItems.ANCIENT_SCALE))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.FOSSIL_HELMET)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FOSSIL_CHESTPLATE, 1)
            .pattern("C C")
            .pattern("SSS")
            .pattern("SSS")
            .input('C', ModItems.CLAW)
            .input('S', ModItems.ANCIENT_SCALE)
            .criterion(hasItem(ModItems.CLAW), conditionsFromItem(ModItems.CLAW))
            .criterion(hasItem(ModItems.ANCIENT_SCALE), conditionsFromItem(ModItems.ANCIENT_SCALE))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.FOSSIL_CHESTPLATE)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FOSSIL_LEGGINGS, 1)
            .pattern("SSS")
            .pattern("S S")
            .pattern("C C")
            .input('C', ModItems.CLAW)
            .input('S', ModItems.ANCIENT_SCALE)
            .criterion(hasItem(ModItems.CLAW), conditionsFromItem(ModItems.CLAW))
            .criterion(hasItem(ModItems.ANCIENT_SCALE), conditionsFromItem(ModItems.ANCIENT_SCALE))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.FOSSIL_LEGGINGS)))

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.FOSSIL_BOOTS, 1)
            .pattern("   ")
            .pattern("S S")
            .pattern("C C")
            .input('C', ModItems.CLAW)
            .input('S', ModItems.ANCIENT_SCALE)
            .criterion(hasItem(ModItems.CLAW), conditionsFromItem(ModItems.CLAW))
            .criterion(hasItem(ModItems.ANCIENT_SCALE), conditionsFromItem(ModItems.ANCIENT_SCALE))
            .offerTo(exporter, Identifier(getRecipeName(ModItems.FOSSIL_BOOTS)))

    }
}