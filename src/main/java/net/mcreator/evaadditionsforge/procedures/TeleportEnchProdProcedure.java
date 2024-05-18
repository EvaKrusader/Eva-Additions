package net.mcreator.evaadditionsforge.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.mcreator.evaadditionsforge.init.EvaAdditionsModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TeleportEnchProdProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double xTP = 0;
		double zTP = 0;
		double yMod = 0;
		double tpNum = 0;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get()) == 1) {
			tpNum = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get()) + Mth.nextInt(RandomSource.create(), 0, 2);
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get()) == 2) {
			tpNum = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get()) + Mth.nextInt(RandomSource.create(), -1, 1);
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get()) == 3) {
			tpNum = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get()) + Mth.nextInt(RandomSource.create(), -2, 1);
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			xTP = Mth.nextInt(RandomSource.create(), (int) (tpNum * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get()) * (-1)),
					(int) (tpNum * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get())));
			zTP = Mth.nextInt(RandomSource.create(), (int) (tpNum * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get()) * (-1)),
					(int) (tpNum * (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(EvaAdditionsModEnchantments.TELEPORT.get())));
			if (!((world.getBlockState(BlockPos.containing(entity.getX() + xTP, y, entity.getZ() + zTP))).getBlock() == Blocks.CAVE_AIR)) {
				{
					Entity _ent = entity;
					_ent.teleportTo((x + xTP), (y + yMod), (z + zTP));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((x + xTP), (y + yMod), (z + zTP), _ent.getYRot(), _ent.getXRot());
				}
			}
		}
	}
}
