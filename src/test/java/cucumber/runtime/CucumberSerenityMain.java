package cucumber.runtime;

import cucumber.runtime.ClassFinder;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import net.serenitybdd.cucumber.SerenityReporter;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.webdriver.Configuration;

import java.io.IOException;
import java.util.ArrayList;

import static java.util.Arrays.asList;

/**
 * Created by ducnguyen on 9/9/16.
 */
public class CucumberSerenityMain {
    private static final String ENV_VARIABLE = "env";
    private static final String DEFAULT_ENV = "local";

    public static void main(String[] argv) throws Throwable {
        String env = System.getenv(ENV_VARIABLE);
        if (null == env) {
            env = System.getProperty(ENV_VARIABLE, DEFAULT_ENV);
        }
        System.setProperty(ENV_VARIABLE, env);
        byte exitstatus = run(argv, Thread.currentThread().getContextClassLoader());
        System.exit(exitstatus);
    }

    /**
     * Launches the Cucumber-JVM command line.
     *
     * @param argv        runtime options. See details in the {@code cucumber.api.cli.Usage.txt} resource.
     * @param classLoader classloader used to load the runtime
     * @return 0 if execution was successful, 1 if it was not (test failures)
     * @throws IOException if resources couldn't be loaded during the run.
     */
    public static byte run(String[] argv, ClassLoader classLoader) throws IOException {
        RuntimeOptions runtimeOptions = new RuntimeOptions(new ArrayList<String>(asList(argv)));

        ResourceLoader resourceLoader = new MultiLoader(classLoader);
        ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);

        Configuration systemConfiguration = Injectors.getInjector().getInstance(Configuration.class);
        SerenityReporter reporter = new SerenityReporter(systemConfiguration);
        runtimeOptions.addPlugin(reporter);

        CustomRuntime runtime = new CustomRuntime(resourceLoader, classFinder, classLoader, runtimeOptions);
        runtime.run();
        return runtime.exitStatus();
    }
}
