package com.example.etudiants_api;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(
        key = "cucumber.glue",
        value = "com.example.etudiants_api.steps"
)
@ConfigurationParameter(
        key = "cucumber.plugin",
        value = "pretty, html:target/cucumber-reports/report.html"
)
public class CucumberRunnerTest {
    // Vide — JUnit Platform Suite lance Cucumber automatiquement
}