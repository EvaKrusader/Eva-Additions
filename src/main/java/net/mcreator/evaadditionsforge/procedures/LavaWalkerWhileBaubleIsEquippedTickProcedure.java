package net.mcreator.evaadditionsforge.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModBlocks;
import net.mcreator.evaadditionsforge.EvaAdditionsMod;

public class LavaWalkerWhileBaubleIsEquippedTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.LAVA) {
			if (itemstack.getOrCreateTag().getDouble("baublePower") == 1) {
				{
					double _setval = Mth.nextInt(RandomSource.create(), 5, 15);
					entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.obsidianTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:lava_walker_adv"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
				world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.STONE.defaultBlockState(), 3);
				EvaAdditionsMod.queueServerWork(5, () -> {
					if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.FIRE_WALKER.get(), itemstack) != 0) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:lava_walker_enchant"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
						world.setBlock(BlockPos.containing(x, y - 0, z), Blocks.FIRE.defaultBlockState(), 3);
					}
				});
				EvaAdditionsMod.queueServerWork((int) (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).obsidianTimer, () -> {
					world.destroyBlock(BlockPos.containing(x, y - 1, z), false);
					world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.LAVA.defaultBlockState(), 3);
				});
			} else if (itemstack.getOrCreateTag().getDouble("baublePower") == 5) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:lava_walker_adv"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
				world.setBlock(BlockPos.containing(x, y - 1, z), EvaAdditionsModBlocks.COLD_OBSIDIAN.get().defaultBlockState(), 3);
			} else {
				{
					double _setval = Mth.nextInt(RandomSource.create(), 20, 30);
					entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.obsidianTimer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				world.setBlock(BlockPos.containing(x, y - 1, z), EvaAdditionsModBlocks.COLD_OBSIDIAN.get().defaultBlockState(), 3);
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:lava_walker_adv"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
				EvaAdditionsMod.queueServerWork(
						(int) ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).obsidianTimer * (itemstack.getOrCreateTag().getDouble("baublePower") - 1)),
						() -> {
							world.destroyBlock(BlockPos.containing(x, y - 1, z), false);
							world.setBlock(BlockPos.containing(x, y - 1, z), EvaAdditionsModBlocks.CRACKING_OBSIDIAN.get().defaultBlockState(), 3);
							if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.FIRE_WALKER.get(), itemstack) != 0) {
								if (entity instanceof ServerPlayer _player) {
									Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("eva_additions:lava_walker_enchant"));
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
								world.setBlock(BlockPos.containing(x, y - 0, z), Blocks.SOUL_FIRE.defaultBlockState(), 3);
							}
							EvaAdditionsMod.queueServerWork((int) ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).obsidianTimer
									* (itemstack.getOrCreateTag().getDouble("baublePower") - 1)), () -> {
										world.destroyBlock(BlockPos.containing(x, y - 1, z), false);
										world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.LAVA.defaultBlockState(), 3);
									});
						});
			}
		}
	}
}
