package net.mcreator.evaadditionsforge.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;
import net.mcreator.evaadditionsforge.init.EvaAdditionsModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WhenHurtAntibodyProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double cureChance = 0;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(EvaAdditionsModItems.METABOLISM.get(), lv).isPresent() : false == true) {
			cureChance = Math.random();
			if (cureChance < (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).AntibodyLevel / 4) {
				if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.WEAKNESS)) {
					if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).hasMeds == true) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getDuration() : 0,
									(int) (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).AntibodyMedsLVL, false, false));
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.WEAKNESS);
						DoHurtAntibodyProcedure.execute(world, x, y, z, entity);
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.WEAKNESS);
						DoHurtAntibodyProcedure.execute(world, x, y, z, entity);
					}
				}
				if (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.POISON)) {
					if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).hasMeds == true) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.POISON) ? _livEnt.getEffect(MobEffects.POISON).getDuration() : 0,
									(int) (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).AntibodyLevel, false, false));
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.POISON);
						DoHurtAntibodyProcedure.execute(world, x, y, z, entity);
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.POISON);
						DoHurtAntibodyProcedure.execute(world, x, y, z, entity);
					}
				}
				if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MobEffects.WITHER)) {
					if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).hasMeds == true) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WITHER) ? _livEnt.getEffect(MobEffects.WITHER).getDuration() : 0,
									(int) (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).AntibodyLevel, false, false));
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.WITHER);
						DoHurtAntibodyProcedure.execute(world, x, y, z, entity);
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.WITHER);
						DoHurtAntibodyProcedure.execute(world, x, y, z, entity);
					}
				}
				if (entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MobEffects.BLINDNESS)) {
					if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).hasMeds == true) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.BLINDNESS) ? _livEnt.getEffect(MobEffects.BLINDNESS).getDuration() : 0,
									(int) (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).AntibodyLevel, false, false));
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.BLINDNESS);
						DoHurtAntibodyProcedure.execute(world, x, y, z, entity);
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.BLINDNESS);
						DoHurtAntibodyProcedure.execute(world, x, y, z, entity);
					}
				}
				if (entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(MobEffects.CONFUSION)) {
					if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).hasMeds == true) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.CONFUSION) ? _livEnt.getEffect(MobEffects.CONFUSION).getDuration() : 0,
									(int) (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).AntibodyLevel, false, false));
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.CONFUSION);
						DoHurtAntibodyProcedure.execute(world, x, y, z, entity);
					} else {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.CONFUSION);
						DoHurtAntibodyProcedure.execute(world, x, y, z, entity);
					}
				}
			}
		}
	}
}
