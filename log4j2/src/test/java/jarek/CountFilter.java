package jarek;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginBuilderAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginBuilderFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;

@Plugin(name = "CountFilter", category = Node.CATEGORY, elementType = Filter.ELEMENT_TYPE, printObject = true)
public class CountFilter extends AbstractFilter {
    private long count;
    private long currentCount;

    private CountFilter(final long count, final Filter.Result onMatch,
                        final Filter.Result onMismatch) {
        super(onMatch, onMismatch);
        this.count = count;
    }

    @PluginBuilderFactory
    public static CountFilter.Builder newBuilder() {
        return new CountFilter.Builder();
    }

    @Override
    public Result filter(LogEvent event) {
        currentCount++;
        if (currentCount % count == 0)
            return Result.NEUTRAL;
        else
            return Result.DENY;
    }

    public static class Builder extends AbstractFilter.AbstractFilterBuilder<CountFilter.Builder> 
    implements org.apache.logging.log4j.core.util.Builder<CountFilter> {
        @PluginBuilderAttribute
        private long count;

        public CountFilter.Builder setMaxCount(final long maxCount) {
            this.count = maxCount;
            return this;
        }

        @Override
        public CountFilter build() {
            if (this.count <= 0) {
                this.count = 1;
            }
            return new CountFilter(this.count, this.getOnMatch(), this.getOnMismatch());
        }
    }
}
