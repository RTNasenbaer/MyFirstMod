package me.rtnasenbaer.myfirstmod.world

import net.minecraft.world.gen.placementmodifier.*

object ModOrePlacement {

    fun modifiers(countModifier: PlacementModifier, heightModifier: PlacementModifier): List<PlacementModifier> {
        return listOf(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of())
    }

    fun modifiersWithCount(count: Int, heightModifier: PlacementModifier): List<PlacementModifier> {
        return modifiers(CountPlacementModifier.of(count), heightModifier)
    }

    fun modifiersWithRarity(chance: Int, heightModifier: PlacementModifier): List<PlacementModifier> {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier)
    }


}