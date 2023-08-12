package com.hepsiBurada.runners;


import io.cucumber.junit.*;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"rerun:target/rerun.txt",
                "html:target/cucumberReport.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json",
                "pretty",
        },
        features = "src/test/resources/features",
        glue = "com/hepsiBurada/step_definitions",
        tags = "",
        stepNotifications = true,
        dryRun = false,
        publish = false
)
public class HB_Runner {
}
