package cucumber.runtime;

import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.cucumber.SerenityReporter;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.webdriver.Configuration;
import org.junit.runners.model.InitializationError;

import java.io.IOException;

/**
 * Created by ducnguyen on 9/18/16.
 */
public class CustomCucumberWithSerenity extends CucumberWithSerenity {
    public CustomCucumberWithSerenity(Class clazz) throws InitializationError, IOException {
        super(clazz);
    }

    /**
     * Create the Runtime. Sets the Serenity runtime.
     */
    protected cucumber.runtime.Runtime createRuntime(ResourceLoader resourceLoader, ClassLoader classLoader,
                                                     RuntimeOptions runtimeOptions) throws InitializationError, IOException {
        return createSerenityEnabledRuntime(resourceLoader, classLoader, runtimeOptions);
    }

    private Runtime createSerenityEnabledRuntime(ResourceLoader resourceLoader, ClassLoader classLoader, RuntimeOptions runtimeOptions) {
        Configuration systemConfiguration = Injectors.getInjector().getInstance(Configuration.class);
        return createSerenityEnabledRuntime(resourceLoader, classLoader, runtimeOptions, systemConfiguration);
    }

    public static Runtime createSerenityEnabledRuntime(ResourceLoader resourceLoader, ClassLoader classLoader, RuntimeOptions runtimeOptions, Configuration systemConfiguration) {
        ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
        SerenityReporter reporter = new SerenityReporter(systemConfiguration);
        runtimeOptions.addPlugin(reporter);
        return new CustomRuntime(resourceLoader, classFinder, classLoader, runtimeOptions);
    }
}
