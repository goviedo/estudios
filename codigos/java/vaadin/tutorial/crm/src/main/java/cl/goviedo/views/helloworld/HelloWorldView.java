package cl.goviedo.views.helloworld;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Hello World")
@Route(value = "hello")
@RouteAlias(value = "")
public class HelloWorldView extends VerticalLayout {

    public HelloWorldView() {
     Button btn = new Button("Presioname!");
     Text texto = new Text("Hola como vas");

     HorizontalLayout hl = new HorizontalLayout(texto, btn);
     hl.setDefaultVerticalComponentAlignment(Alignment.BASELINE);

        add(hl);
    }

}
