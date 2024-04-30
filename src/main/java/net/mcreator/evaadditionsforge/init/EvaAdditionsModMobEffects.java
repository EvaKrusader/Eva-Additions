
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.evaadditionsforge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.evaadditionsforge.potion.PrematureDeathMobEffect;
import net.mcreator.evaadditionsforge.EvaAdditionsMod;

public class EvaAdditionsModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, EvaAdditionsMod.MODID);
	public static final RegistryObject<MobEffect> PREMATURE_DEATH = REGISTRY.register("premature_death", () -> new PrematureDeathMobEffect());
}
