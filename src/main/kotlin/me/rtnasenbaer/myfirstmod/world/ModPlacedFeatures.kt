package me.rtnasenbaer.myfirstmod.world

import me.rtnasenbaer.myfirstmod.MyFirstMod
import net.minecraft.registry.Registerable
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.util.Identifier
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.PlacedFeature
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier
import net.minecraft.world.gen.placementmodifier.PlacementModifier

object ModPlacedFeatures {

    val ENCLOSED_FOSSILS_PLACED_KEY : RegistryKey<PlacedFeature> = registerKey("enclosed_fossils_placed")

    fun bootstrap(context: Registerable<PlacedFeature>) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE)

        register(context, ENCLOSED_FOSSILS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(
            ModConfiguredFeatures.ENCLOSED_FOSSILS_KEY),
            ModOrePlacement.modifiersWithCount(12,
                HeightRangePlacementModifier.uniform(
                    YOffset.fixed(-48),
                    YOffset.fixed(48)
                )
            )
        )
    }

    fun registerKey(name: String): RegistryKey<PlacedFeature> {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier(MyFirstMod.MOD_ID, name))
    }

    private fun register(
        context: Registerable<PlacedFeature>,
        key: RegistryKey<PlacedFeature>,
        configuration: RegistryEntry<ConfiguredFeature<*, *>>,
        modifier: List<PlacementModifier>
    ) {
        context.register(key, PlacedFeature(configuration, modifier.toList()))
    }

}