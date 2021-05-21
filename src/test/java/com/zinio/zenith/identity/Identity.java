package com.zinio.zenith.identity;

import cucumber.api.CucumberOptions;
import cucumber.runtime.CustomCucumberWithSerenity;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.Ignore;
import org.junit.runner.RunWith;

@RunWith(CustomCucumberWithSerenity.class)
@CucumberOptions(
		// For all test
//        	features="src/test/resources/features",
		
		// For WebSmoke test
//		features="src/test/resources/features/web-smoketest/WebSmokeTest.feature:5",
		
		// For Android To WWW test
		features="src/test/resources/features/Android-WWW/AndroidToWWW.feature",
        glue = {"com.zinio.zenith.identity.steps"}
)

public class Identity {}
