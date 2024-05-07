
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.evaadditionsforge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.evaadditionsforge.enchantment.PlumeShieldEnchantment;
import net.mcreator.evaadditionsforge.enchantment.MedsEnchantment;
import net.mcreator.evaadditionsforge.enchantment.BlessingEnchantment;
import net.mcreator.evaadditionsforge.EvaAdditionsMod;

public class EvaAdditionsModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, EvaAdditionsMod.MODID);
	public static final RegistryObject<Enchantment> BLESSING = REGISTRY.register("blessing", () -> new BlessingEnchantment());
	public static final RegistryObject<Enchantment> MEDS = REGISTRY.register("meds", () -> new MedsEnchantment());
	public static final RegistryObject<Enchantment> PLUME_SHIELD = REGISTRY.register("plume_shield", () -> new PlumeShieldEnchantment());
}
