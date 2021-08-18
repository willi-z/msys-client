package msys.client.stages;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import msys.client.App;
import msys.client.stages.tools.management.ProjectTaskBar;

import java.util.Objects;


public class Project extends Stage {
    private Scene scene;
    private ProjectTaskBar project_manager = new ProjectTaskBar(0);
    //private ToolManager tool_manager = new ToolManager(0);
    //private PropertyManager property_manager = new PropertyManager(0);
    //private ModuleManager module_manager = new ModuleManager(0);

    public Project(){

        BorderPane pane = new BorderPane();
        pane.setTop(project_manager.getVisual());
        //pane.setLeft(tool_manager.getVisual());
        //pane.setRight(property_manager.getVisual());
        //pane.setCenter(module_manager.getVisual());
        scene = new Scene(pane, 400, 300);

        var style = getClass().getResource(App.config.getString("design.css"));
        scene.getStylesheets().add(Objects.requireNonNull(style).toExternalForm());

        var host = App.config.getString("server.url");
        project_manager.setHost(host);
        setTitle("Project");
        setMaximized(true);
        setScene(scene);
    }
}
