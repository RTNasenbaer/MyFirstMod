package me.rtnasenbaer.myfirstmod.datagen

import me.rtnasenbaer.myfirstmod.block.ModBlocks
import me.rtnasenbaer.myfirstmod.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.block.Block
import net.minecraft.enchantment.Enchantments
import net.minecraft.item.Item
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.condition.LootCondition
import net.minecraft.loot.condition.MatchToolLootCondition
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.loot.entry.LeafEntry
import net.minecraft.loot.entry.LootPoolEntry
import net.minecraft.loot.function.ApplyBonusLootFunction
import net.minecraft.loot.provider.number.ConstantLootNumberProvider
import net.minecraft.predicate.NumberRange
import net.minecraft.predicate.item.EnchantmentPredicate
import net.minecraft.predicate.item.ItemPredicate

class ModLootTableProvider(dataOutput: FabricDataOutput) : FabricBlockLootTableProvider(dataOutput) {

    val WITH_SILK_TOUCH = MatchToolLootCondition.builder(
        ItemPredicate.Builder.create()
            .enchantment(EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1)))
    )

    override fun generate() {
        addDrop(ModBlocks.ANCIENT_SCALE_BLOCK)
        addDrop(ModBlocks.SCALE_BLOCK)
        addDrop(ModBlocks.ENCLOSED_FOSSILS, this.oreDrops(ModBlocks.ENCLOSED_FOSSILS, 66, 33, ModItems.ANCIENT_SCALE, ModItems.CLAW))
        addDrop(ModBlocks.DEEPSLATE_ENCLOSED_FOSSILS, this.oreDrops(ModBlocks.DEEPSLATE_ENCLOSED_FOSSILS, 66, 33, ModItems.ANCIENT_SCALE, ModItems.CLAW))

    }

    fun oreDrops(dropWithSilkTouch: Block, weight: Int, weight2: Int, drop: Item, drop2: Item): LootTable.Builder {
        return this.dropsWithSilkTouch(
            dropWithSilkTouch,
            applyExplosionDecay(
                dropWithSilkTouch,
                ItemEntry.builder(drop).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)).weight(weight)
            ) as LootPoolEntry.Builder<*>,
            applyExplosionDecay(
                dropWithSilkTouch,
                ItemEntry.builder(drop2).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)).weight(weight2)
            ) as LootPoolEntry.Builder<*>
        )
    }

    private fun dropsWithSilkTouch(
        drop: Block,
        child: LootPoolEntry.Builder<*>,
        child2: LootPoolEntry.Builder<*>,
    ): LootTable.Builder {
        return this.drops(drop, WITH_SILK_TOUCH, child, child2)
    }

    private fun drops(
        drop: Block,
        conditionBuilder: LootCondition.Builder,
        child: LootPoolEntry.Builder<*>,
        child2: LootPoolEntry.Builder<*>,
    ): LootTable.Builder {
        return LootTable.builder().pool(
            LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f)).with(
                (ItemEntry.builder(drop).conditionally(conditionBuilder) as LeafEntry.Builder<*>).alternatively(child)
            ).with(
                (ItemEntry.builder(drop).conditionally(conditionBuilder) as LeafEntry.Builder<*>).alternatively(child2)
            )
        )
    }

}