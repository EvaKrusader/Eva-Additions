
package net.mcreator.evaadditionsforge.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import java.util.List;

public class DiscBumblebeeItem extends RecordItem {
	public DiscBumblebeeItem() {
		super(4, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("eva_additions:record_bumblebee")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 5140);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}
}
