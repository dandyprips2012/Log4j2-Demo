package org.practice.log4j2.cpl;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

@Plugin(category = "Converter", name = "TestPatternConverter")
@ConverterKeys(value = { "ct" , "ua"})
public class CustomPatternConverter extends LogEventPatternConverter{

	private static Map<String, String> patternMap = new HashMap<String, String>(10);
	private static int beginIndex = 0;

	protected CustomPatternConverter(String [] options) {
		super("name", "style");
	}

	public static CustomPatternConverter newInstance(String [] options) {
		return new CustomPatternConverter(options);

	}

	@Override
	public void format(LogEvent le, StringBuilder sb) {
		if(patternMap.isEmpty())
			this.createMap(le.getMessage().getFormattedMessage());
		if(Pattern.compile("content-type").matcher(sb.substring(beginIndex)).find()) {
			sb.append(patternMap.get("Content-Type"));
			beginIndex = sb.indexOf(patternMap.get("Content-Type"));
		} else if (Pattern.compile("User-Agent").matcher(sb).find()) {
			sb.append(patternMap.get("User-Agent"));
			beginIndex = sb.indexOf(patternMap.get("User-Agent"));
		}
	}

	private void createMap(String formatMessage) {
		String pattern = "(\\S+):\\s(\\S*)(?:\\b(?!:)|$)";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(formatMessage);

		while(m.find()) {
			patternMap.put(m.group(1), m.group(2));
		}
	}

}
