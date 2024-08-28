package co.com.screenplay.project.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Step;

import static co.com.screenplay.project.ui.HomeUI.BTN_ELEMENTS;
import static co.com.screenplay.project.ui.HomeUI.BTN_LIST_ELEMENTS;
import static co.com.screenplay.project.utils.Constants.REMEMBER_TEXT_BTN_SUB_ELEMENTS;
//9

@AllArgsConstructor   //Genera automáticamente un constructor con todos los campos de la clase como parámetros.
public class ChooseSubElementsRandomTask implements Task {  // Seleciona de forma aleatoria un elemento

    private String numberRamdonBtn;     // almacenará el número del botón aleatorio a seleccionar.

    @Override       // Este método está sobrescribiendo un método de la interfaz Task.
    @Step("{0} selecciona aleatoria-mente la posición #numberRamdonBtn de la sub función de elementos")
    public <T extends Actor> void performAs(T actor) {      //Toma un Actor como parámetro quw realizará las acciones.
        String number = numberRamdonBtn;        //Asigna el valor de numberRamdonBtn a una variable local number.
        actor.attemptsTo(Scroll.to(BTN_ELEMENTS),      //Se Desplaza hasta el elemento BTN_ELEMENTS
                Click.on(BTN_LIST_ELEMENTS.of(      //Hace clic en el elemento
                        number))
        );

        String textBtn = BTN_LIST_ELEMENTS.of(          //Obtiene el texto del botón seleccionado.
                number).resolveFor(actor).getText();
        actor.remember(REMEMBER_TEXT_BTN_SUB_ELEMENTS, textBtn);    //El actor (guarda) el texto del botón para su uso posterior,
    }

    public static ChooseSubElementsRandomTask witchParams(String numberRamdonBtn) {
        return Tasks.instrumented(ChooseSubElementsRandomTask.class, numberRamdonBtn);
    }  // Crea una instancia de ChooseSubElementsRandomTask
}