package me.cooljkb.bungee;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class MSGCommand
  extends Command
{
  public MSGCommand()
  {
    super("msg", "bungeepm.use", new String[] { "msg" });
  }
  
  public void execute(CommandSender sender, String[] args)
  {
    if (args.length < 2)
    {
      sender.sendMessage(new TextComponent(ChatColor.RED + "/msg <player> <message>"));
      return;
    }
    ProxiedPlayer p = ProxyServer.getInstance().getPlayer(args[0]);
    if (p == null)
    {
      sender.sendMessage(new TextComponent(ChatColor.RED + "Could not find player " + args[0] + "."));
      return;
    }
    StringBuilder msgBuilder = new StringBuilder();
    for (int i = 1; i < args.length; i++) {
      msgBuilder.append(args[i]).append(" ");
    }
    String msg = ChatColor.translateAlternateColorCodes('&', msgBuilder.toString().trim());
    
    p.sendMessage(new TextComponent(ChatColor.WHITE + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "MSG" + ChatColor.WHITE + "]" + ChatColor.GOLD + sender.getName() + ": " + ChatColor.WHITE + msg));
    sender.sendMessage(new TextComponent(ChatColor.WHITE + "[" + ChatColor.DARK_RED + ChatColor.BOLD + "MSG" + ChatColor.WHITE + "]" + ChatColor.GOLD + sender.getName() + ": " + ChatColor.WHITE + msg));
  }
}
