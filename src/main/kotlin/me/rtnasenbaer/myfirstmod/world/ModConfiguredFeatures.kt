package me.rtnasenbaer.myfirstmod.world

import me.rtnasenbaer.myfirstmod.MyFirstMod
import me.rtnasenbaer.myfirstmod.block.ModBlocks
import net.minecraft.registry.Registerable
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.BlockTags
import net.minecraft.structure.rule.RuleTest
import net.minecraft.structure.rule.TagMatchRuleTest
import net.minecraft.util.Identifier
import net.minecraft.world.gen.feature.ConfiguredFeature
import net.minecraft.world.gen.feature.Feature
import net.minecraft.world.gen.feature.FeatureConfig
import net.minecraft.world.gen.feature.OreFeatureConfig

object ModConfiguredFeatures {

    val ENCLOSED_FOSSILS_KEY : RegistryKey<ConfiguredFeature<*, *>> = registerKey("enclosed_fossils")

    fun bootstrap(context : Registerable<ConfiguredFeature<*, *>>) {
        val stoneReplaceables : RuleTest = TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES)
        val deepslateReplaceables : RuleTest = TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES)

        val overworldEnclosedFossils : List<OreFeatureConfig.Target> = listOf(
            OreFeatureConfig.createTarget(
                stoneReplaceables,
                ModBlocks.ENCLOSED_FOSSILS.defaultState
            ),
            OreFeatureConfig.createTarget(
                deepslateReplaceables,
                ModBlocks.DEEPSLATE_ENCLOSED_FOSSILS.defaultState
            )
        )

        register(context, ENCLOSED_FOSSILS_KEY, Feature.ORE, OreFeatureConfig(overworldEnclosedFossils, 12))
    }

    fun registerKey(name: String): RegistryKey<ConfiguredFeature<*, *>> {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier(MyFirstMod.MOD_ID, name))
    }

    private fun <FC : FeatureConfig, F : Feature<FC>> register(
        context: Registerable<ConfiguredFeature<*, *>>,
        key: RegistryKey<ConfiguredFeature<*, *>>,
        feature: F,
        configuration: FC
    ) {
        context.register(key, ConfiguredFeature(feature, configuration))
    }


}