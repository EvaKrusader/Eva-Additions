
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.evaadditionsforge.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.evaadditionsforge.enchantment.WingGelEnchantment;
import net.mcreator.evaadditionsforge.enchantment.WaterProofEnchantment;
import net.mcreator.evaadditionsforge.enchantment.TeleportEnchantment;
import net.mcreator.evaadditionsforge.enchantment.PlumeShieldEnchantment;
import net.mcreator.evaadditionsforge.enchantment.PillarScraperEnchantment;
import net.mcreator.evaadditionsforge.enchantment.MedsEnchantment;
import net.mcreator.evaadditionsforge.enchantment.IncorrodibleEnchantment;
import net.mcreator.evaadditionsforge.enchantment.FragilityEnchantment;
import net.mcreator.evaadditionsforge.enchantment.FireWalkerEnchantment;
import net.mcreator.evaadditionsforge.enchantment.BlessingEnchantment;
import net.mcreator.evaadditionsforge.EvaAdditionsMod;

public class EvaAdditionsModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, EvaAdditionsMod.MODID);
	public static final RegistryObject<Enchantment> BLESSING = REGISTRY.register("blessing", () -> new BlessingEnchantment());
	public static final RegistryObject<Enchantment> SELF_REGULATION = REGISTRY.register("self_regulation", () -> new MedsEnchantment());
	public static final RegistryObject<Enchantment> PLUME_SHIELD = REGISTRY.register("plume_shield", () -> new PlumeShieldEnchantment());
	public static final RegistryObject<Enchantment> FIRE_WALKER = REGISTRY.register("fire_walker", () -> new FireWalkerEnchantment());
	public static final RegistryObject<Enchantment> INCORRODIBLE = REGISTRY.register("incorrodible", () -> new IncorrodibleEnchantment());
	public static final RegistryObject<Enchantment> WATER_PROOF = REGISTRY.register("water_proof", () -> new WaterProofEnchantment());
	public static final RegistryObject<Enchantment> WING_GEL = REGISTRY.register("wing_gel", () -> new WingGelEnchantment());
	public static final RegistryObject<Enchantment> PILLAR_SCRAPER = REGISTRY.register("pillar_scraper", () -> new PillarScraperEnchantment());
	public static final RegistryObject<Enchantment> FRAGILITY = REGISTRY.register("fragility", () -> new FragilityEnchantment());
	public static final RegistryObject<Enchantment> TELEPORT = REGISTRY.register("teleport", () -> new TeleportEnchantment());
}
