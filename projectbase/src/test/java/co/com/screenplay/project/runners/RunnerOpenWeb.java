package co.com.screenplay.project.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
//2
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/openweb.feature",
        glue = "co.com.screenplay.project.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@successful2"
)


public class RunnerOpenWeb {
}
