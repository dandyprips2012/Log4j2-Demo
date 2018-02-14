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
@ConverterKeys(value = { "ct" })
public class CustomPatternConverter extends LogEventPatternConverter{

	protected CustomPatternConverter(String name, String style) {
		super(name, style);
	}

	public static CustomPatternConverter newInstance(String [] options) {
		return new CustomPatternConverter("ct","ct");

	}
	
	@Override
	public void format(LogEvent le, StringBuilder sb) {
		sb.append(parseMessage(le.getMessage().toString().subSequence(22, le.getMessage().toString().length()-1).toString()));
	}

	private String parseMessage(String s) {
		Map<String, String> patternMap = new HashMap<String, String>(10);
		String pattern = "(\\S+):\\s(\\S*)(?:\\b(?!:)|$)";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s);
		
		while(m.find()) {
			patternMap.put(m.group(1), m.group(2));
		}
		return patternMap.get("Content-Type");
	}

}
