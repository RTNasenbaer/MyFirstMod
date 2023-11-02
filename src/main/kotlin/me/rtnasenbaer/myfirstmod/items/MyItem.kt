package me.rtnasenbaer.myfirstmod.items

import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.StackReference
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ItemUsageContext
import net.minecraft.screen.slot.Slot
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.*
import net.minecraft.world.World

class MyItem(settings: Settings) : Item(settings) {

    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {

        user.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, 1.0F, 1.0F)

        return TypedActionResult.success(user.getStackInHand(hand))
    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        tooltip?.add(Text.translatable("item.myfirstmod.my_item.tooltip").formatted(Formatting.GOLD))
    }
    
}