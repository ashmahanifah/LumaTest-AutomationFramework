package com.ashma;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.ashma",
        features = "src/test/resources",
        plugin = {"pretty", "html:laporan/hasil.html", "json:laporan/hasil.json"}
)
public class CucumberTest {
}
