
package net.mcreator.evaadditionsforge.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.evaadditionsforge.procedures.PrematureDeathEffectStartedappliedProcedure;
import net.mcreator.evaadditionsforge.procedures.PrematureDeathEffectExpiresProcedure;

public class PrematureDeathMobEffect extends MobEffect {
	public PrematureDeathMobEffect() {
		super(MobEffectCategory.HARMFUL, -7077887);
	}

	@Override
	public String getDescriptionId() {
		return "effect.eva_additions.premature_death";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		PrematureDeathEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		PrematureDeathEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
