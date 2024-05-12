package net.mcreator.evaadditionsforge.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.evaadditionsforge.init.EvaAdditionsModItems;

public class GelPackagingPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double randChance = 0;
		randChance = Math.random();
		if (randChance > 0.66) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(EvaAdditionsModItems.WING_GEL_ITEM.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (randChance > 0.33) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(EvaAdditionsModItems.WING_GEL_ITEM.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(EvaAdditionsModItems.WING_GEL_ITEM.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands()
							.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
									_ent.getDisplayName(), _ent.level().getServer(), _ent),
									("give @s firework_rocket{Tags:['test']}" + ForgeRegistries.ITEMS.getKey(EvaAdditionsModItems.WING_GEL_ITEM.get()).toString() + "give @s {Tags:['gelPower']}"));
				}
			}
		}
	}
}
