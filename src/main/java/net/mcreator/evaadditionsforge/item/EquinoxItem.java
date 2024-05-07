
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.procedures.SmartassBaubleIsUnequippedProcedure;
import net.mcreator.evaadditionsforge.procedures.EquinoxWhileBaubleIsEquippedTickProcedure;
import net.mcreator.evaadditionsforge.procedures.EquinoxItemInInventoryTickProcedure;
import net.mcreator.evaadditionsforge.procedures.EquinoxBaubleEquippedProcedure;
import net.mcreator.evaadditionsforge.procedures.AptitudesRemoveGlowProcedure;

import java.util.List;

public class EquinoxItem extends Item implements ICurioItem {
	public EquinoxItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return AptitudesRemoveGlowProcedure.execute(itemstack);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		EquinoxItemInInventoryTickProcedure.execute();
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
		SmartassBaubleIsUnequippedProcedure.execute(itemstack);
		return true;
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		EquinoxWhileBaubleIsEquippedTickProcedure.execute(slotContext.entity().level(), slotContext.entity(), stack);
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		EquinoxBaubleEquippedProcedure.execute(slotContext.entity().level(), slotContext.entity().getX(), slotContext.entity().getY(), slotContext.entity().getZ(), slotContext.entity(), stack);
	}
}
