package jarek;

import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rewrite.RewritePolicy;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.core.impl.MutableLogEvent;
import org.apache.logging.log4j.message.SimpleMessage;

@Plugin(name = "JarekRewritePolicy", category = Core.CATEGORY_NAME, elementType = "rewritePolicy")
public class JarekRewritePolicy implements RewritePolicy {
    @Override
    public LogEvent rewrite(LogEvent source) {
        if (!(source instanceof MutableLogEvent))
            return source;
        MutableLogEvent event = (MutableLogEvent) source;
        event.setMessage(new SimpleMessage("."));
        return event;
    }

    @PluginFactory
    public static JarekRewritePolicy create() {
        return new JarekRewritePolicy();
    }
}
