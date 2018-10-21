package com.wtf.utils;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@CucumberOptions(dryRun=true,
                 features="",
                 glue="",
                 monochrome=true,
                 plugin="{}",
                 tags="{}")
@RunWith(Cucumber.class)
public class TestRunner {

}
