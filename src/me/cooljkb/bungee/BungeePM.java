package me.cooljkb.bungee;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeePM
	extends Plugin
{
	public void onEnable()
	{
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new MSGCommand());
	}
}