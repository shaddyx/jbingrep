package ua.org.shaddy.bingrep.cmdline;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;

public class CmdLineEntity {
	@Parameter(description = "List of rules")
	private List<String> rules = new ArrayList<>();

	@Parameter(names = { "-C" }, description = "Context bytes", required = false)
	private int context = 0;

	public String getRules() {
		return String.join(" ", rules);
	}

	public void setRules(List<String> rules) {
		this.rules = rules;
	}

	public int getContext() {
		return context;
	}

	public void setContext(int context) {
		this.context = context;
	}

	@Override
	public String toString() {
		return "CmdLineEntity [rules=" + rules + ", context=" + context + "]";
	}

}
