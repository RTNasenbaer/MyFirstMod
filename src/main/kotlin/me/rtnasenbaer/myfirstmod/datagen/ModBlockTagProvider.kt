package me.rtnasenbaer.myfirstmod.datagen

import me.rtnasenbaer.myfirstmod.block.ModBlocks
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.tag.BlockTags
import net.minecraft.registry.tag.TagKey
import net.minecraft.util.Identifier
import java.util.concurrent.CompletableFuture

class ModBlockTagProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>) : FabricTagProvider.BlockTagProvider(output, registriesFuture) {
    override fun configure(arg: RegistryWrapper.WrapperLookup?) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(ModBlocks.enclosedFossils)

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier("fabric", "needs_tool_level_-1")))
            .add(ModBlocks.scaleBlock, ModBlocks.ancientScaleBlock)

    }
}