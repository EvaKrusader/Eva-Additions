package net.mcreator.evaadditionsforge.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModItems;
import net.mcreator.evaadditionsforge.EvaAdditionsMod;

public class PowerUpperRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "\u00A7r\u00A7f";
			entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ItemColorReset = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower == 5) {
			{
				double _setval = 1;
				entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.aptitudePower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:reset_aptitude_adv"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
			if (((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudeItem).getItem() == EvaAdditionsModItems.COGNITION.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(EvaAdditionsModItems.SMARTASS_TREASURE.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudeItem).getItem() == EvaAdditionsModItems.PERCEPTION.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(EvaAdditionsModItems.SENSES_TREASURE.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudeItem).getItem() == EvaAdditionsModItems.REQUIEM.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(EvaAdditionsModItems.REQUIEM_TREASURE.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			} else if (((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudeItem).getItem() == EvaAdditionsModItems.EQUINOX.get()) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(EvaAdditionsModItems.EQUINOX_TREASURE.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
			EvaAdditionsMod.queueServerWork(10, () -> {
				{
					ItemStack _setval = ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudeItem);
					entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.realAptitude = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = true;
					entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.justPowered = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				EvaAdditionsMod.queueServerWork(10, () -> {
					{
						ItemStack _setval = new ItemStack(Blocks.AIR);
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.aptitudeItem = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						ItemStack _setval = ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).realAptitude);
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.aptitudeItem = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
			});
		} else {
			{
				double _setval = (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudePower + 1;
				entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.aptitudePower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			EvaAdditionsMod.queueServerWork(10, () -> {
				{
					ItemStack _setval = ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).aptitudeItem);
					entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.realAptitude = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = true;
					entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.justPowered = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				EvaAdditionsMod.queueServerWork(10, () -> {
					{
						ItemStack _setval = new ItemStack(Blocks.AIR);
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.aptitudeItem = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						ItemStack _setval = ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).realAptitude);
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.aptitudeItem = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
			});
		}
		ChooseAptitudeProcedure.execute(entity);
	}
}
