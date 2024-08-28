package co.com.screenplay.project.questions;

import io.cucumber.java.ro.Si;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.screenplay.project.ui.HomeUI.TXT_RANDOM_NAME_BTN;
//11

@AllArgsConstructor
@Slf4j  //
public class ValidateElementsTextBtn implements Question<Boolean> {     //Devolverá un valor booleano.

    private String validTextSubElementBtn;

    @Override
    @Subject("{0} se realiza validación del elemento capturado en header con dicho parametro #validTextSubElementBtn")
    public Boolean answeredBy(Actor actor) {        //Toma un Actor como parámetro y devuelve un Boolean.
        boolean result;         //variable result para almacenar el resultado de la validación.
        String validTextBtnHeader = TXT_RANDOM_NAME_BTN.resolveFor(actor).getText();        //Obtiene el texto del botón del encabezado usando TXT_RANDOM_NAME_BTN
        if (validTextBtnHeader != null && validTextSubElementBtn.equals(validTextBtnHeader)) {
            log.info(validTextBtnHeader); //Compara el texto obtenido del encabezado con el texto del subelemento del botón.
            result = true; //Si coinciden y el texto del encabezado no es nulo, registra el texto y establece result como true.
        } else {
            result = false;     // En caso contrario, establece result como false.
        }
        return result;   //Devuelve el resultado de la validación.
    }

    public static ValidateElementsTextBtn witchParams(String validTextSubElementBtn) {
        return new ValidateElementsTextBtn(validTextSubElementBtn);
    }  //  crea una instancia de ValidateElementsTextBtn.
}
