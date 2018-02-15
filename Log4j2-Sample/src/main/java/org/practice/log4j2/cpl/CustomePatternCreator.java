package org.practice.log4j2.cpl;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;

@Plugin(category = "Converter", name = "TestPatternConverter")
@ConverterKeys(value = { "payload" })
public class CustomePatternCreator extends LogEventPatternConverter{

	protected CustomePatternCreator(String name, String style) {
		super(name, style);
	}

	public static CustomePatternCreator newInstance(String [] options) {
		return new CustomePatternCreator("payload","payload");

	}
	
	@Override
	public void format(LogEvent le, StringBuilder sb) {
		sb.append("appended");
	}

}
