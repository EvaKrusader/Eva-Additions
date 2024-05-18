package net.mcreator.evaadditionsforge.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TeleportRightClickProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double tpX = 0;
		double tpY = 0;
		double toZ = 0;
		double cooler = 0;
		if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			tpX = entity.level()
					.clip(new ClipContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((10 * (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get())))),
							ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
					.getBlockPos().getX();
			tpY = entity.level()
					.clip(new ClipContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((10 * (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get())))),
							ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
					.getBlockPos().getY();
			toZ = entity.level()
					.clip(new ClipContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((10 * (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get())))),
							ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
					.getBlockPos().getZ();
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get()) == 1) {
				cooler = 140;
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get()) == 2) {
				cooler = 100;
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get()) == 3) {
				cooler = 60;
			}
			if ((world.getBlockState(BlockPos.containing(tpX, tpY, toZ))).getBlock() == Blocks.AIR) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You are not close enough to teleport."), true);
			} else {
				if (entity.isShiftKeyDown()) {
					world.addParticle(ParticleTypes.FIREWORK, (tpX + 0.5), (tpY + 1), (toZ + 0.5), 0, 1, 0);
				} else {
					{
						Entity _ent = entity;
						_ent.teleportTo((tpX + 0.5), (tpY + 1), (toZ + 0.5));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((tpX + 0.5), (tpY + 1), (toZ + 0.5), _ent.getYRot(), _ent.getXRot());
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), (int) cooler);
					{
						ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			}
		}
	}
}
