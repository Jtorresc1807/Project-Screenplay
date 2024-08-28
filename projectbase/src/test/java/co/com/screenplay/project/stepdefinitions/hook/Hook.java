package co.com.screenplay.project.stepdefinitions.hook;

import co.com.screenplay.project.hook.OpenWeb;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;

import static co.com.screenplay.project.utils.Constants.TIME_SHORT;
import static co.com.screenplay.project.utils.Constants.TITLE;
import static co.com.screenplay.project.utils.Constants.WEB_URL;
import static co.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
//5
public class Hook {         //Precondiciones

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }           // Prepara el escenario con un Cast en línea". Configura el navegador a usar.

    @Given("{string} abre el sitio web de pruebas")
    public void openTheTestWebsite(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(           // En el escenario se llama al actor Alejandro
                OpenWeb.browserURL(WEB_URL));               // para que intente abrir la pagina

        waiting(TIME_SHORT);            //Constante de espera que se usa en Time.java
        theActorInTheSpotlight().should(        //El actor es el centro de atencion y deberia ver el titulo de la pagina
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE)  //Verifica que el título contenga la cadena de la constante (TITLE).
                )
        );
    }
}
