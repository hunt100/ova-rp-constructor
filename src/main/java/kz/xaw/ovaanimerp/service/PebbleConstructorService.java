package kz.xaw.ovaanimerp.service;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.StringLoader;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

@Component
public class PebbleConstructorService {

    private final PebbleEngine engine = new PebbleEngine.Builder().loader(new StringLoader()).strictVariables(false).build();
    private static final Logger log = LoggerFactory.getLogger(PebbleConstructorService.class);

    private StringBuilder source;

    public PebbleEngine getEngine() {
        return engine;
    }

    public StringBuilder getSource() {
        return source;
    }

    public void setSource(StringBuilder source) {
        this.source = source;
    }

    public String createCompleteMessage(Map<String, Object> params, String unformattedText) {
        try {
            source = new StringBuilder(unformattedText);
            PebbleTemplate template = engine.getTemplate(source.toString());
            Writer writer = new StringWriter();
            template.evaluate(writer, params);
            return writer.toString();
        } catch (IOException e) {
            log.error("createCompleteMessage() -> IOException: {}", e);
            return null;
        }
    }
}
