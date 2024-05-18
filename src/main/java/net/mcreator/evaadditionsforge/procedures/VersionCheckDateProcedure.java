package net.mcreator.evaadditionsforge.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.evaadditionsforge.network.EvaAdditionsModVariables;

import java.util.Calendar;

import java.net.URL;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class VersionCheckDateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject json = new com.google.gson.JsonObject();
		boolean SendDownload = false;
		String url = "";
		String p1 = "";
		String p2 = "";
		String tdP1 = "";
		String tdP2 = "";
		String ACurrentDate = "";
		String ANextDate = "";
		double day = 0;
		double month = 0;
		double year = 0;
		double len1 = 0;
		double len2 = 0;
		double len3 = 0;
		double tdLen1 = 0;
		double tdLen2 = 0;
		day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		month = Calendar.getInstance().get(Calendar.MONTH);
		year = Calendar.getInstance().get(Calendar.YEAR);
		file = new File(System.getProperty("java.io.tmpdir"), File.separator + "modver.json");
		url = "https://raw.githubusercontent.com/EvaKrusader/" + "Eva-Additions" + "/master/src/main/modver.json";
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
				if (entity instanceof Player) {
					len1 = (new java.text.DecimalFormat("##").format(Math.round(json.get("day").getAsDouble()))).length();
					len2 = (new java.text.DecimalFormat("##").format(Math.round(json.get("month").getAsDouble()))).length();
					len3 = (new java.text.DecimalFormat("##").format(Math.round(json.get("year").getAsDouble()))).length();
					tdLen1 = (new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.DAY_OF_MONTH))).length();
					tdLen2 = (new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.MONTH))).length();
					if (len1 == 1) {
						p1 = "00" + new java.text.DecimalFormat("##").format(Math.round(json.get("day").getAsDouble()));
					} else if (len1 == 2) {
						p1 = "0" + new java.text.DecimalFormat("##").format(Math.round(json.get("day").getAsDouble()));
					}
					if (len2 == 1) {
						p2 = "00" + new java.text.DecimalFormat("##").format(Math.round(json.get("month").getAsDouble()));
					} else if (len2 == 2) {
						p2 = "0" + new java.text.DecimalFormat("##").format(Math.round(json.get("month").getAsDouble()));
					}
					if (tdLen1 == 1) {
						tdP1 = "00" + new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
					} else if (tdLen1 == 2) {
						tdP1 = "0" + new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
					}
					if (tdLen2 == 1) {
						tdP2 = "00" + new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.MONTH) + 1);
					} else if (tdLen2 == 2) {
						tdP2 = "0" + new java.text.DecimalFormat("##").format(Calendar.getInstance().get(Calendar.MONTH) + 1);
					}
					{
						double _setval = new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(new java.text.DecimalFormat("####").format(Math.round(Calendar.getInstance().get(Calendar.YEAR))) + ""
								+ (tdP1 + "/" + tdP2 + "/" + new java.text.DecimalFormat("##").format(Math.round(Calendar.getInstance().get(Calendar.YEAR)))).substring(5, 7)
								+ (tdP1 + "/" + tdP2 + "/" + new java.text.DecimalFormat("##").format(Math.round(Calendar.getInstance().get(Calendar.YEAR)))).substring(1, 3));
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.currentDateNum = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(new java.text.DecimalFormat("##").format(Math.round(json.get("year").getAsDouble())) + "" + (p1 + "/" + p2 + "/" + new java.text.DecimalFormat("##").format(Math.round(json.get("year").getAsDouble()))).substring(5, 7)
								+ (p1 + "/" + p2 + "/" + new java.text.DecimalFormat("##").format(Math.round(json.get("year").getAsDouble()))).substring(1, 3));
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.nextDateNum = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = (tdP1 + "/" + tdP2 + "/" + new java.text.DecimalFormat("##").format(Math.round(Calendar.getInstance().get(Calendar.YEAR)))).substring(1, 3) + "/"
								+ (tdP1 + "/" + tdP2 + "/" + new java.text.DecimalFormat("##").format(Math.round(Calendar.getInstance().get(Calendar.YEAR)))).substring(5, 7) + "/"
								+ new java.text.DecimalFormat("##").format(Math.round(Calendar.getInstance().get(Calendar.YEAR)));
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.currentDate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = (p1 + "/" + p2 + "/" + new java.text.DecimalFormat("##").format(Math.round(json.get("year").getAsDouble()))).substring(1, 3) + "/"
								+ (p1 + "/" + p2 + "/" + new java.text.DecimalFormat("##").format(Math.round(json.get("year").getAsDouble()))).substring(5, 7) + "/"
								+ new java.text.DecimalFormat("####").format(Math.round(json.get("year").getAsDouble()));
						entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.nextDate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					ACurrentDate = (tdP1 + "/" + tdP2 + "/" + new java.text.DecimalFormat("##").format(Math.round(Calendar.getInstance().get(Calendar.YEAR)))).substring(1, 3) + "/"
							+ (tdP1 + "/" + tdP2 + "/" + new java.text.DecimalFormat("##").format(Math.round(Calendar.getInstance().get(Calendar.YEAR)))).substring(5, 7) + "/"
							+ new java.text.DecimalFormat("##").format(Math.round(Calendar.getInstance().get(Calendar.YEAR)));
					ANextDate = (p1 + "/" + p2 + "/" + new java.text.DecimalFormat("##").format(Math.round(json.get("year").getAsDouble()))).substring(1, 3) + "/"
							+ (p1 + "/" + p2 + "/" + new java.text.DecimalFormat("##").format(Math.round(json.get("year").getAsDouble()))).substring(5, 7) + "/" + new java.text.DecimalFormat("####").format(Math.round(json.get("year").getAsDouble()));
				}
				if (json.get("send").getAsDouble() >= 1 || (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).sendOutMessage == true) {
					if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).nextDateNum > (entity
							.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).currentDateNum
							&& (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).SendDOwnloadLink == false) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((("The next update of Eva Additions will release on " + "\u00A7a" + ANextDate
									+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + "!") + ""
									+ (" (" + "\u00A7a" + (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).nextVersion
											+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + ")"))),
									false);
					} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).nextDateNum == (entity
							.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).currentDateNum) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("" + ("The latest update of Eva Additions released on " + "\u00A7b" + ANextDate + " (today)"
									+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + "!"))), false);
						{
							boolean _setval = true;
							entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SendDOwnloadLink = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).currentDateNum > (entity
							.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).nextDateNum) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("" + ("The latest update of Eva Additions released on " + "\u00A7c" + ANextDate
									+ (entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).ItemColorReset + "!"))), false);
						{
							boolean _setval = true;
							entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SendDOwnloadLink = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (json.get("send").getAsDouble() == 2) {
						{
							boolean _setval = true;
							entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SendDOwnloadLink = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EvaAdditionsModVariables.PlayerVariables())).SendDOwnloadLink == true) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										("tellraw @a {\"text\":\"Click here to download the new version!\",\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"" + "" + json.get("update").getAsString()
												+ "\"}}"));
							}
						}
					}
				}
				{
					boolean _setval = false;
					entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SendDOwnloadLink = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = false;
					entity.getCapability(EvaAdditionsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sendOutMessage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ExportItemsProcedure.execute(entity);
	}
}
