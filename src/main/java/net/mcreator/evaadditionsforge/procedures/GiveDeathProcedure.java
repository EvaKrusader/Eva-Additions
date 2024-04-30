package net.mcreator.evaadditionsforge.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.evaadditionsforge.init.EvaAdditionsModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GiveDeathProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getDirectEntity());
		}
	}

	public static void execute(Entity entity, Entity immediatesourceentity) {
		execute(null, entity, immediatesourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (immediatesourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("eva_additions:can_give_death")))) {
			if (Mth.nextInt(RandomSource.create(), 1, (int) Math.sqrt((entity.getDisplayName().getString()).length())) == (entity.getDisplayName().getString()).length()) {
				if (entity instanceof ServerPlayer _plr4 && _plr4.level() instanceof ServerLevel && _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:nether/root"))).isDone()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(EvaAdditionsModMobEffects.PREMATURE_DEATH.get(), (int) (Mth.nextInt(RandomSource.create(), (int) (entity.getDisplayName().getString()).length(), 60) * 20), 0));
				}
			}
		}
	}
}
