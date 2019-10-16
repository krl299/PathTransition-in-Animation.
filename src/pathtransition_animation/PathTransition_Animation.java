/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathtransition_animation;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Carlos
 */
public class PathTransition_Animation extends Application {
    
   @Override
    public void start(Stage primaryStage) {
        Circle circulo=new Circle(50);
        circulo.setCenterX(150);
        circulo.setCenterY(125);
        Rectangle rectangulo=new Rectangle(25,50);
        PathTransition pt=new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(circulo);
        pt.setNode(rectangulo);
        
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(false);
        //Comienza la animacion
        pt.play();
        circulo.setOnMousePressed(e -> pt.pause());
        circulo.setOnMouseReleased(e -> pt.play());
        
        Pane root = new Pane();
        circulo.setStroke(Color.BLACK);
        circulo.setFill(Color.WHITE);
        rectangulo.setStroke(Color.BLACK);
        rectangulo.setFill(Color.ORANGE);
        root.getChildren().add(circulo);
        root.getChildren().add(rectangulo);

        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Path Transition in Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
