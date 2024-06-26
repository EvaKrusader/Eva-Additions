
package net.mcreator.evaadditionsforge.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.procedures.NightVisionWhileBaubleIsEquippedTickProcedure;
import net.mcreator.evaadditionsforge.procedures.NightVisionBaubleIsEquippedProcedure;
import net.mcreator.evaadditionsforge.procedures.CurioRemoveGlowProcedure;

import java.util.List;

public class NightVisionItem extends Item implements ICurioItem {
	public NightVisionItem() {
		super(new Item.Properties().durability(250).rarity(Rarity.COMMON));
	}

	@Override
	public boolean isEnderMask(SlotContext slotContext, EnderMan enderMan, ItemStack stack) {
		return true;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return CurioRemoveGlowProcedure.execute(itemstack);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		NightVisionWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity().level(), slotContext.entity().getX(), slotContext.entity().getY(), slotContext.entity().getZ(), slotContext.entity(), stack);
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		NightVisionBaubleIsEquippedProcedure.execute(stack);
	}
}
