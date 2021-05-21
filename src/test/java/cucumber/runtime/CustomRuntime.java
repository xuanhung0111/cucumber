package cucumber.runtime;

import cucumber.runtime.io.ResourceLoader;
import org.joor.Reflect;

import java.util.Collection;

/**
 * Created by ducnguyen on 9/18/16.
 */
public class CustomRuntime extends Runtime {
    public CustomRuntime(ResourceLoader resourceLoader, ClassFinder classFinder, ClassLoader classLoader, RuntimeOptions runtimeOptions) {
        this(resourceLoader,
                classLoader,
                Reflect.on(Runtime.class).call("loadBackends", resourceLoader, classFinder).get(),
                runtimeOptions);
//        this.syncTracker();
    }

    public CustomRuntime(ResourceLoader resourceLoader, ClassLoader classLoader, Collection<? extends Backend> backends, RuntimeOptions runtimeOptions) {
        this(resourceLoader, classLoader, backends, runtimeOptions, StopWatch.SYSTEM, null);
//        this.syncTracker();
    }

    public CustomRuntime(ResourceLoader resourceLoader, ClassLoader classLoader, Collection<? extends Backend> backends, RuntimeOptions runtimeOptions, RuntimeGlue optionalGlue) {
        this(resourceLoader, classLoader, backends, runtimeOptions, StopWatch.SYSTEM, optionalGlue);
//        this.syncTracker();
    }

    public CustomRuntime(ResourceLoader resourceLoader, ClassLoader classLoader, Collection<? extends Backend> backends, RuntimeOptions runtimeOptions, StopWatch stopWatch, RuntimeGlue optionalGlue) {
        super(resourceLoader, classLoader, backends, runtimeOptions, stopWatch, new RuntimeGlue(new UndefinedStepsTracker(), new CustomLocalizedXStreams(classLoader)));
        this.syncTracker();
    }

    private void syncTracker() {
        RuntimeGlue runtimeGlue = (RuntimeGlue) this.getGlue();
        UndefinedStepsTracker trackerInGlue = Reflect.on(runtimeGlue).get("tracker");
        Reflect.on(this).set("undefinedStepsTracker", trackerInGlue);
    }
}
