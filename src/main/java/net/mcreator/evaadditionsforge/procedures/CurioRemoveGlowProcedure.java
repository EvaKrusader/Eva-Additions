package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class CurioRemoveGlowProcedure {
	public static boolean execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(new ResourceLocation("minecraft:remove_glow"))) == true) {
			return false;
		}
		return true;
	}
}
