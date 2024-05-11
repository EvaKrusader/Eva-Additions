
package net.mcreator.evaadditionsforge.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.procedures.EndWingsWhileBaubleIsEquippedTickProcedure;
import net.mcreator.evaadditionsforge.procedures.EndWingsBaubleIsEquippedProcedure;

import java.util.List;

public class EndWingsItem extends Item implements ICurioItem {
	public EndWingsItem() {
		super(new Item.Properties().durability(25).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		EndWingsWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity(), stack);
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		EndWingsBaubleIsEquippedProcedure.execute(stack);
	}
}
