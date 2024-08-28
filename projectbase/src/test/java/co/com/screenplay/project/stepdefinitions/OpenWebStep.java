package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.questions.ValidateElementsTextBtn;
import co.com.screenplay.project.tasks.ChooseSubElementsRandomTask;
import co.com.screenplay.project.tasks.FuntionsElementsTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.screenplay.project.utils.Constants.ACTOR;
import static co.com.screenplay.project.utils.Constants.REMEMBER_TEXT_BTN_SUB_ELEMENTS;
import static co.com.screenplay.project.utils.DataFaker.fakerNumberOneAndNine;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
//1

@Slf4j
public class OpenWebStep {

    @Before // Esta anotación indica que el método siguiente se ejecutará antes de cada escenario de prueba
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }       // Prepara el escenario con un Cast en línea". Configura el navegador a usar.

    @When("ingresa al navegador chrome")
    public void enterChromeBrowser() {
    }       // Este método está vacío, probablemente la lógica para abrir Chrome se implementará aquí

    @Then("visualizara el titulo de la pagina {string}")        // Espera un parámetro de tipo String
    public void willDisplayThePageTitle(String textValidation) {
    }       // Este método también está vacío, aquí se implementará la lógica para verificar el título de la página

    @And("desea validar la funcion de la carta de elementos")
    public void wantValidateTheFunctionOfTheElementChart() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                FuntionsElementsTask.choose()
        );
    }    // Este método hace que un actor intente realizar la tarea FuntionsElementsTask

    @When("selecciona aleatoriamente alguna de las subfunciones")
    public void randomlySelectsSomeOfTheSubfunctions() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                ChooseSubElementsRandomTask.witchParams(fakerNumberOneAndNine())
        );      // Este método hace que el actor intente realizar la tarea ChooseSubElementsRandomTask con un número
    }           // aleatorio entre 1 y 9


    @Then("visualizara en la cabecera el nombre de la opción elegida")
    public void willDisplayInTheHeaderTheNameOfTheChosenOption() {
        String validateText = OnStage.theActor(ACTOR).recall(REMEMBER_TEXT_BTN_SUB_ELEMENTS);
        // Recupera un texto guardado previamente
        if (validateText != null) {
            log.info(validateText);
        }       // Si el texto no es nulo, lo registra en el log
        theActorInTheSpotlight().should(seeThat(
                ValidateElementsTextBtn.witchParams(validateText))
        );
    }     // Este método verifica que el actor pueda ver el texto validado en algún elemento de la página
}