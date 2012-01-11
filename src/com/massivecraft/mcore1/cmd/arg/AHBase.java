package com.massivecraft.mcore1.cmd.arg;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.command.CommandSender;

import com.massivecraft.mcore1.MPlugin;

public abstract class AHBase<T> implements IArgHandler<T>
{
	protected Collection<String> error = new ArrayList<String>();
	
	@Override
	public abstract T parse(String str, String style, CommandSender sender, MPlugin p);

	@Override
	public Collection<String> getErrors()
	{
		return this.error;
	}
}
