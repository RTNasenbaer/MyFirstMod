package me.rtnasenbaer.myfirstmod.world.gen

import me.rtnasenbaer.myfirstmod.world.ModPlacedFeatures
import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.minecraft.world.gen.GenerationStep

object ModOreGeneration {

    fun generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ENCLOSED_FOSSILS_PLACED_KEY)
    }
}