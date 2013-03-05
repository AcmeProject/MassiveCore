package com.massivecraft.mcore;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.permissions.Permissible;

import com.massivecraft.mcore.cmd.CmdMcore;
import com.massivecraft.mcore.usys.cmd.CmdUsys;
import com.massivecraft.mcore.util.MUtil;

public class Conf extends SimpleConfig
{
	// -------------------------------------------- //
	// CONTENT
	// -------------------------------------------- //
	
	public static String dburi = "gson://./mstore";
	public static String serverid = UUID.randomUUID().toString();
	public static Map<String, List<String>> cmdaliases = MUtil.map(
		CmdUsys.USYS, MUtil.list(CmdUsys.USYS),
		CmdMcore.MCORE, MUtil.list(CmdMcore.MCORE)
	);
	public static int tpdelay = 10;
	
	public static List<String> getCmdAliases(String name)
	{
		List<String> ret = cmdaliases.get(name);
		if (ret == null)
		{
			ret = MUtil.list(name);
			cmdaliases.put(name, ret);
			i.save();
		}
		return ret;
	}
	
	public static int getTpdelay(Permissible permissible)
	{
		if (Permission.NOTPDELAY.has(permissible, false)) return 0;
		return Math.max(tpdelay, 0); 
	}
	
	// -------------------------------------------- //
	// META
	// -------------------------------------------- //
	public static transient Conf i = new Conf();
	private Conf()
	{
		super(MCore.p, new File("plugins/mcore/conf.json"));
	}
}
