
package net.mcreator.evaadditionsforge.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.procedures.EntomologistEpiphanyItemInInventoryTickProcedure;
import net.mcreator.evaadditionsforge.procedures.EntomologistEpiphanyItemInHandTickProcedure;

import java.util.List;

public class EntomologistEpiphanyItem extends Item {
	public EntomologistEpiphanyItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			EntomologistEpiphanyItemInHandTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		EntomologistEpiphanyItemInInventoryTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
