
package net.mcreator.evaadditionsforge.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.procedures.AntibodyWhileBaubleIsEquippedTickProcedure;
import net.mcreator.evaadditionsforge.procedures.AntibodyBaubleIsEquippedProcedure;

import java.util.List;

public class AntibodyItem extends Item implements ICurioItem {
	public AntibodyItem() {
		super(new Item.Properties().durability(50).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		AntibodyWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity(), stack);
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		AntibodyBaubleIsEquippedProcedure.execute(slotContext.entity().level(), slotContext.entity().getX(), slotContext.entity().getY(), slotContext.entity().getZ(), slotContext.entity(), stack);
	}
}
