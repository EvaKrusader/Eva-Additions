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

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
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
				}
			});
			context.setPacketHandled(true);
		}
	}
}
