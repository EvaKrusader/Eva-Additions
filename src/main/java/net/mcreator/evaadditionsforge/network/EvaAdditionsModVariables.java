package net.mcreator.evaadditionsforge.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.evaadditionsforge.EvaAdditionsMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EvaAdditionsModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		EvaAdditionsMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.EnderlinkAssistant = original.EnderlinkAssistant;
			clone.SpiderKilled = original.SpiderKilled;
			clone.advName = original.advName;
			clone.BugHints = original.BugHints;
			clone.knowledgeLVL = original.knowledgeLVL;
			clone.hasAptitude = original.hasAptitude;
			clone.aptitudeChance = original.aptitudeChance;
			clone.aptitudePower = original.aptitudePower;
			clone.aptitudeItem = original.aptitudeItem;
			clone.playerCycle = original.playerCycle;
			clone.dev_rarity = original.dev_rarity;
			clone.dev_name = original.dev_name;
			clone.ItemColorReset = original.ItemColorReset;
			clone.justPowered = original.justPowered;
			clone.HasAptitudeUpped = original.HasAptitudeUpped;
			clone.realAptitude = original.realAptitude;
			clone.obsidianTimer = original.obsidianTimer;
			clone.currentDate = original.currentDate;
			clone.nextDate = original.nextDate;
			clone.currentVersion = original.currentVersion;
			clone.nextVersion = original.nextVersion;
			clone.showNewOutMessage = original.showNewOutMessage;
			clone.currentDateNum = original.currentDateNum;
			clone.nextDateNum = original.nextDateNum;
			clone.ver1 = original.ver1;
			clone.ver2 = original.ver2;
			clone.ver3 = original.ver3;
			if (!event.isWasDeath()) {
				clone.ShowLiveleak = original.ShowLiveleak;
				clone.WillFixNextIllness = original.WillFixNextIllness;
				clone.weaknessNum = original.weaknessNum;
				clone.poisonNum = original.poisonNum;
				clone.witherNum = original.witherNum;
				clone.blindnessNum = original.blindnessNum;
				clone.nauseaNum = original.nauseaNum;
				clone.AntibodyLevel = original.AntibodyLevel;
				clone.doDamageAntibody = original.doDamageAntibody;
				clone.AntibodyMedsLVL = original.AntibodyMedsLVL;
				clone.hasMeds = original.hasMeds;
				clone.VoidWingsSlow = original.VoidWingsSlow;
				clone.gogglesDamage = original.gogglesDamage;
				clone.wingersss = original.wingersss;
				clone.lastWalked5seconds = original.lastWalked5seconds;
				clone.extraWingDamage = original.extraWingDamage;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("eva_additions", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public String EnderlinkAssistant = "null";
		public double SpiderKilled = 0;
		public String advName = "\"\"";
		public double BugHints = 0;
		public boolean ShowLiveleak = false;
		public boolean WillFixNextIllness = false;
		public double weaknessNum = 0;
		public double poisonNum = 0;
		public double witherNum = 0;
		public double blindnessNum = 0;
		public double nauseaNum = 0;
		public double AntibodyLevel = 0;
		public boolean doDamageAntibody = false;
		public double AntibodyMedsLVL = 0;
		public boolean hasMeds = false;
		public double knowledgeLVL = -1.0;
		public boolean hasAptitude = false;
		public double aptitudeChance = 0;
		public double aptitudePower = 0;
		public ItemStack aptitudeItem = ItemStack.EMPTY;
		public boolean playerCycle = false;
		public boolean VoidWingsSlow = false;
		public String dev_rarity = "\"\"";
		public String dev_name = "\"\"";
		public double gogglesDamage = 0;
		public String ItemColorReset = "\u00A7r\u00A7f";
		public boolean justPowered = false;
		public double HasAptitudeUpped = 0;
		public ItemStack realAptitude = ItemStack.EMPTY;
		public double obsidianTimer = 0;
		public ItemStack wingersss = ItemStack.EMPTY;
		public BlockState lastWalked5seconds = Blocks.AIR.defaultBlockState();
		public double extraWingDamage = 0;
		public String currentDate = "\"\"";
		public String nextDate = "\"\"";
		public String currentVersion = "\"\"";
		public String nextVersion = "\"\"";
		public boolean showNewOutMessage = false;
		public double currentDateNum = 0;
		public double nextDateNum = 0;
		public double ver1 = 0.0;
		public double ver2 = 1.0;
		public double ver3 = 1.0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				EvaAdditionsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("EnderlinkAssistant", EnderlinkAssistant);
			nbt.putDouble("SpiderKilled", SpiderKilled);
			nbt.putString("advName", advName);
			nbt.putDouble("BugHints", BugHints);
			nbt.putBoolean("ShowLiveleak", ShowLiveleak);
			nbt.putBoolean("WillFixNextIllness", WillFixNextIllness);
			nbt.putDouble("weaknessNum", weaknessNum);
			nbt.putDouble("poisonNum", poisonNum);
			nbt.putDouble("witherNum", witherNum);
			nbt.putDouble("blindnessNum", blindnessNum);
			nbt.putDouble("nauseaNum", nauseaNum);
			nbt.putDouble("AntibodyLevel", AntibodyLevel);
			nbt.putBoolean("doDamageAntibody", doDamageAntibody);
			nbt.putDouble("AntibodyMedsLVL", AntibodyMedsLVL);
			nbt.putBoolean("hasMeds", hasMeds);
			nbt.putDouble("knowledgeLVL", knowledgeLVL);
			nbt.putBoolean("hasAptitude", hasAptitude);
			nbt.putDouble("aptitudeChance", aptitudeChance);
			nbt.putDouble("aptitudePower", aptitudePower);
			nbt.put("aptitudeItem", aptitudeItem.save(new CompoundTag()));
			nbt.putBoolean("playerCycle", playerCycle);
			nbt.putBoolean("VoidWingsSlow", VoidWingsSlow);
			nbt.putString("dev_rarity", dev_rarity);
			nbt.putString("dev_name", dev_name);
			nbt.putDouble("gogglesDamage", gogglesDamage);
			nbt.putString("ItemColorReset", ItemColorReset);
			nbt.putBoolean("justPowered", justPowered);
			nbt.putDouble("HasAptitudeUpped", HasAptitudeUpped);
			nbt.put("realAptitude", realAptitude.save(new CompoundTag()));
			nbt.putDouble("obsidianTimer", obsidianTimer);
			nbt.put("wingersss", wingersss.save(new CompoundTag()));
			nbt.put("lastWalked5seconds", NbtUtils.writeBlockState(lastWalked5seconds));
			nbt.putDouble("extraWingDamage", extraWingDamage);
			nbt.putString("currentDate", currentDate);
			nbt.putString("nextDate", nextDate);
			nbt.putString("currentVersion", currentVersion);
			nbt.putString("nextVersion", nextVersion);
			nbt.putBoolean("showNewOutMessage", showNewOutMessage);
			nbt.putDouble("currentDateNum", currentDateNum);
			nbt.putDouble("nextDateNum", nextDateNum);
			nbt.putDouble("ver1", ver1);
			nbt.putDouble("ver2", ver2);
			nbt.putDouble("ver3", ver3);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			EnderlinkAssistant = nbt.getString("EnderlinkAssistant");
			SpiderKilled = nbt.getDouble("SpiderKilled");
			advName = nbt.getString("advName");
			BugHints = nbt.getDouble("BugHints");
			ShowLiveleak = nbt.getBoolean("ShowLiveleak");
			WillFixNextIllness = nbt.getBoolean("WillFixNextIllness");
			weaknessNum = nbt.getDouble("weaknessNum");
			poisonNum = nbt.getDouble("poisonNum");
			witherNum = nbt.getDouble("witherNum");
			blindnessNum = nbt.getDouble("blindnessNum");
			nauseaNum = nbt.getDouble("nauseaNum");
			AntibodyLevel = nbt.getDouble("AntibodyLevel");
			doDamageAntibody = nbt.getBoolean("doDamageAntibody");
			AntibodyMedsLVL = nbt.getDouble("AntibodyMedsLVL");
			hasMeds = nbt.getBoolean("hasMeds");
			knowledgeLVL = nbt.getDouble("knowledgeLVL");
			hasAptitude = nbt.getBoolean("hasAptitude");
			aptitudeChance = nbt.getDouble("aptitudeChance");
			aptitudePower = nbt.getDouble("aptitudePower");
			aptitudeItem = ItemStack.of(nbt.getCompound("aptitudeItem"));
			playerCycle = nbt.getBoolean("playerCycle");
			VoidWingsSlow = nbt.getBoolean("VoidWingsSlow");
			dev_rarity = nbt.getString("dev_rarity");
			dev_name = nbt.getString("dev_name");
			gogglesDamage = nbt.getDouble("gogglesDamage");
			ItemColorReset = nbt.getString("ItemColorReset");
			justPowered = nbt.getBoolean("justPowered");
			HasAptitudeUpped = nbt.getDouble("HasAptitudeUpped");
			realAptitude = ItemStack.of(nbt.getCompound("realAptitude"));
			obsidianTimer = nbt.getDouble("obsidianTimer");
			wingersss = ItemStack.of(nbt.getCompound("wingersss"));
			lastWalked5seconds = NbtUtils.readBlockState(BuiltInRegistries.BLOCK.asLookup(), nbt.getCompound("lastWalked5seconds"));
			extraWingDamage = nbt.getDouble("extraWingDamage");
			currentDate = nbt.getString("currentDate");
			nextDate = nbt.getString("nextDate");
			currentVersion = nbt.getString("currentVersion");
			nextVersion = nbt.getString("nextVersion");
			showNewOutMessage = nbt.getBoolean("showNewOutMessage");
			currentDateNum = nbt.getDouble("currentDateNum");
			nextDateNum = nbt.getDouble("nextDateNum");
			ver1 = nbt.getDouble("ver1");
			ver2 = nbt.getDouble("ver2");
			ver3 = nbt.getDouble("ver3");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.EnderlinkAssistant = message.data.EnderlinkAssistant;
					variables.SpiderKilled = message.data.SpiderKilled;
					variables.advName = message.data.advName;
					variables.BugHints = message.data.BugHints;
					variables.ShowLiveleak = message.data.ShowLiveleak;
					variables.WillFixNextIllness = message.data.WillFixNextIllness;
					variables.weaknessNum = message.data.weaknessNum;
					variables.poisonNum = message.data.poisonNum;
					variables.witherNum = message.data.witherNum;
					variables.blindnessNum = message.data.blindnessNum;
					variables.nauseaNum = message.data.nauseaNum;
					variables.AntibodyLevel = message.data.AntibodyLevel;
					variables.doDamageAntibody = message.data.doDamageAntibody;
					variables.AntibodyMedsLVL = message.data.AntibodyMedsLVL;
					variables.hasMeds = message.data.hasMeds;
					variables.knowledgeLVL = message.data.knowledgeLVL;
					variables.hasAptitude = message.data.hasAptitude;
					variables.aptitudeChance = message.data.aptitudeChance;
					variables.aptitudePower = message.data.aptitudePower;
					variables.aptitudeItem = message.data.aptitudeItem;
					variables.playerCycle = message.data.playerCycle;
					variables.VoidWingsSlow = message.data.VoidWingsSlow;
					variables.dev_rarity = message.data.dev_rarity;
					variables.dev_name = message.data.dev_name;
					variables.gogglesDamage = message.data.gogglesDamage;
					variables.ItemColorReset = message.data.ItemColorReset;
					variables.justPowered = message.data.justPowered;
					variables.HasAptitudeUpped = message.data.HasAptitudeUpped;
					variables.realAptitude = message.data.realAptitude;
					variables.obsidianTimer = message.data.obsidianTimer;
					variables.wingersss = message.data.wingersss;
					variables.lastWalked5seconds = message.data.lastWalked5seconds;
					variables.extraWingDamage = message.data.extraWingDamage;
					variables.currentDate = message.data.currentDate;
					variables.nextDate = message.data.nextDate;
					variables.currentVersion = message.data.currentVersion;
					variables.nextVersion = message.data.nextVersion;
					variables.showNewOutMessage = message.data.showNewOutMessage;
					variables.currentDateNum = message.data.currentDateNum;
					variables.nextDateNum = message.data.nextDateNum;
					variables.ver1 = message.data.ver1;
					variables.ver2 = message.data.ver2;
					variables.ver3 = message.data.ver3;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
