package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.screenplay.project.ui.HomeUI.ID_CARD_ELEMENTS;
import static co.com.screenplay.project.utils.Constants.TIME_SHORT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
//8

public class FuntionsElementsTask implements Task {
    @Override
    @Step("{0} selección la ID card ELEMENTS")
    public <T extends Actor> void performAs(T actor) {

        // Principio  SOLID Responsabilidad Única

        actor.attemptsTo(Scroll.to(ID_CARD_ELEMENTS));                  //El actor hace scroll hasta el elemento.
        actor.attemptsTo(WaitUntil.the(ID_CARD_ELEMENTS, isEnabled())   //Realiza espera del elemento si esta disponible
                        .forNoMoreThan(TIME_SHORT).seconds(),      //Si esta disponible espera el tiempo de la constante
                Click.on(ID_CARD_ELEMENTS));            //Da clic en el elemento
    }

    public static FuntionsElementsTask choose() {
        return Tasks.instrumented(FuntionsElementsTask.class);
    }
}