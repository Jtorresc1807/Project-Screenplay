package co.com.screenplay.project.hook;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static co.com.screenplay.project.utils.Constants.WEB_URL;
import static net.serenitybdd.screenplay.Tasks.instrumented;
//3
public class OpenWeb implements Task {   // interfaz que define tareas que los actores pueden realizar.

    private EnvironmentVariables environmentVariables;      // Permite que OpenWeb acceda a las variables de entorno en serenity.conf

    public OpenWeb(String webUrl) {     // Constructor que inicializa objetos
        this.webUrl = webUrl;
    }

    private String webUrl;   //Almacenará la URL del sitio web.

    @Override           // Está sobrescribiendo un método de la interfaz Task
    @Step("{0} abre el navegador web")
    public <T extends Actor> void performAs(T actor) {  // Puede trabajar con cualquier tipo de Actor
        String pathWebUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(WEB_URL);
        //Obtiene la URL del sitio web en la clase Constants.java
        actor.attemptsTo(Open.url(pathWebUrl));   // El actor intenta abrir la URL obtenida de las variables de entorno.
    }

    public static Performable browserURL(String webUrl) {  //Crear una nueva instancia de OpenWeb
        return instrumented(OpenWeb.class, webUrl);
    }
}