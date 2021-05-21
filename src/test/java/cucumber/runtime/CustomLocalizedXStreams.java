package cucumber.runtime;

import com.zinio.zenith.util.EntityConverter;
import cucumber.runtime.xstream.LocalizedXStreams;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by ducnguyen on 9/18/16.
 */
public class CustomLocalizedXStreams extends LocalizedXStreams {
    private final Map<Locale, LocalizedXStream> xStreamsByLocale = new HashMap<Locale, LocalizedXStream>();

    public CustomLocalizedXStreams(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override
    public LocalizedXStream get(Locale locale) {
        LocalizedXStream localizedXStream = super.get(locale);
        if (!xStreamsByLocale.containsKey(locale)) {
            xStreamsByLocale.put(locale, localizedXStream);
            localizedXStream.registerConverter(
                    new EntityConverter(localizedXStream.getMapper())
            );
        }
        return localizedXStream;
//        return super.get(locale);
    }
}
