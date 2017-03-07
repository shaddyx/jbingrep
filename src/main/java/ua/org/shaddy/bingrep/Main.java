package ua.org.shaddy.bingrep;

import java.io.IOException;

import com.beust.jcommander.JCommander;

import ua.org.shaddy.bingrep.cmdline.CmdLineEntity;
import ua.org.shaddy.bingrep.cmdline.RulesUtil;
import ua.org.shaddy.bingrep.rules.RuleChecker;
import ua.org.shaddy.bingrep.streams.SimpleBufferedInputStream;
import ua.org.shaddy.bingrep.streams.SimpleBufferedOutputStream;

public class Main {
	
	public static void main(String[] args) throws IOException {
		CmdLineEntity params = new CmdLineEntity();
		JCommander paramsParser = new JCommander(params, args);
		
		SimpleBufferedInputStream in = new SimpleBufferedInputStream(System.in);
		SimpleBufferedOutputStream out = new SimpleBufferedOutputStream(System.out);
		
		
		RuleChecker ruleChecker = new RuleChecker(RulesUtil.createRules(params.getRules()));
		while (true){
			int b = in.read();
			ruleChecker.check(b);
			if (b == -1){
				break;
			}
			out.write(b);
		}
		in.close();
		out.close();
	}
}
