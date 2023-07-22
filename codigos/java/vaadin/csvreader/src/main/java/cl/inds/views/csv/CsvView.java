package cl.inds.views.csv;

import cl.inds.views.MainLayout;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.shared.util.SharedUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@PageTitle("CSV")
@Route(value="csv", layout = MainLayout.class)
@RouteAlias(value="", layout = MainLayout.class)
public class CsvView extends VerticalLayout {
    Grid<String[]> grid = new Grid<String[]>();

    public CsvView() {

        var boton = new Button("Coloca tu CSV aquí");

        boton.addClickListener(e->leerElArchivoDelClasshPath());

        // Boton de lanzar un csv
        var buffer = new MemoryBuffer();
        var upload = new Upload(buffer);

        upload.addSucceededListener(e->{
           despliegaElCsv(buffer.getInputStream());
        });

        add(grid,
                new HorizontalLayout(
                boton,upload));
    }

    /**
     * Lee el archivo que tenemos en el classpath para referencia.
     */
    public void leerElArchivoDelClasshPath() {
        despliegaElCsv(getClass().getClassLoader().getResourceAsStream("a.csv"));
    }

    private void despliegaElCsv(InputStream resourceAsStream) {
        var parser = new CSVParserBuilder().withSeparator(',').build();
        var lector  = new CSVReaderBuilder(new InputStreamReader(resourceAsStream)).withCSVParser(parser).build();

        try {
            var entradasDelCsv = lector.readAll();

            var cabeceras = entradasDelCsv.get(0);

            for(int i=0;i<cabeceras.length;i++) {
                int indice = i;
                grid.addColumn(row->row[indice]).setHeader(SharedUtil.camelCaseToHumanFriendly(cabeceras[indice]));
            }

            grid.setItems(entradasDelCsv.subList(1,entradasDelCsv.size()));

        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
