package net.mcreator.evaadditionsforge.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

import java.net.URL;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class UpdateVersionRightclickedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject json = new com.google.gson.JsonObject();
		double ver3 = 0;
		double ver2 = 0;
		double ver1 = 0;
		double nextVersion = 0;
		double currentVersion = 0;
		double modif = 0;
		String url = "";
		String color = "";
		String whatVer = "";
		file = new File(System.getProperty("java.io.tmpdir"), File.separator + "modver.json");
		url = "https://raw.githubusercontent.com/EvaKrusader/Eva-Additions/master/src/main/modver.json";
		try {
			org.apache.commons.io.FileUtils.copyURLToFile(new URL(url), file, 1000, 1000);
		} catch (IOException e) {
			e.printStackTrace();
		}
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				json = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ver3 == Math.round(json.get("ver3").getAsDouble()) - 1) {
					{
						double _setval = Math.round(json.get("ver3").getAsDouble());
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ver3 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					modif = 0;
					color = "\u00A7b";
					whatVer = (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " (Right Version)";
				} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ver3 == Math.round(json.get("ver3").getAsDouble())) {
					{
						double _setval = Math.round(json.get("ver3").getAsDouble()) + 1;
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ver3 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					modif = 1;
					color = "\u00A7e";
					whatVer = (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " (Non-existant Version)";
				} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ver3 == Math.round(json.get("ver3").getAsDouble()) + 1) {
					{
						double _setval = Math.round(json.get("ver3").getAsDouble()) - 1;
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ver3 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					modif = -1;
					color = "\u00A7c";
					whatVer = (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + " (Obsolete Version)";
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(
							Component.literal(("Local Version switched to " + ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).currentVersion).substring(0, 4)
									+ color + new java.text.DecimalFormat("#").format(new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).currentVersion).substring(4)) + modif) + whatVer)),
							true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
