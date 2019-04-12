/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funtion;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 *
 * @author Rita
 */
public class Graphic2 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Grafico 2");
        Group root = new Group();
        Canvas canvas = new Canvas(650, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        draw2DShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    private void draw2DShapes(GraphicsContext gc) {
        double width = gc.getCanvas().getWidth();
        double height = gc.getCanvas().getHeight();

        Random random = new Random();
        

        gc.translate(width / 2, height / 2);

        for (int i = 0; i < 60; i++) {

            gc.setFill(Color.rgb(random.nextInt(200), random.nextInt(200),
                    random.nextInt(200), 0.9));
            gc.rotate(06.0);

            gc.strokeOval(200, 60, 100, 100);
            gc.setFill(Color.rgb(random.nextInt(200), random.nextInt(200),
                    random.nextInt(200), 0.9));
            
            gc.fillPolygon(
                    
         
         new double[] { 10, 17, 19, 13, 13, 15, 77, 87,51, 93 },
         new double[] { 10, 16, 16, 24, 26, 22, 26,24, 16, 16 }, 10);

            gc.fillRoundRect(110, 110, 30, 30, 20, 20);

            gc.fillArc(200, 200, 200, 200, 200, 200, ArcType.CHORD);

        }
    }

}
