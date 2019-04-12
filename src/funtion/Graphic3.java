/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funtion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

/**
 *
 * @author sebas
 */
public class Graphic3 extends Application {

    private final int WIDTH = 830;
    private final int HEIGHT = 1000;
    private Scene scene;
    private Pane pane;
    private Canvas canvas;
    private Image image;
    private ImageView imageView; //modifica una imagen
    private SnapshotParameters snapshot; //le da atributos a la hora de modificar una imagen
    private PixelReader pixel; //se encarga de leer pixel por pixel
    private WritableImage writable; //convierte pixeles en una imagen

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("Gráfico 3");

        initComponents(primaryStage);
        primaryStage.show();

        primaryStage.setMaxHeight(1000);

        primaryStage.setMaxWidth(1000);
        primaryStage.setScene(scene);
        primaryStage.show();
        initComponents(primaryStage);

    }

    private void initComponents(Stage primaryStage) {
        primaryStage.setResizable(false);
        this.pane = new Pane();
        this.scene = new Scene(this.pane, WIDTH, HEIGHT);
        this.canvas = new Canvas(WIDTH, HEIGHT);
        this.imageView = new ImageView(this.image); //recibe por parametro la imagen a modificar

        this.pane.getChildren().add(this.canvas);
        GraphicsContext gc = this.canvas.getGraphicsContext2D();

        draw(gc);

        primaryStage.setScene(this.scene);

    }

    private void draw(GraphicsContext gc) {
        //Pintar
        try {

            this.image = new Image(new FileInputStream("nubes.png"));
            gc.drawImage(this.image, 250, 100);

            this.image = new Image(new FileInputStream("arboll.png"));
            gc.drawImage(this.image, 8, 450);

            this.image = new Image(new FileInputStream("arbol1.0.png"));
            gc.drawImage(this.image, 500, 450);

            gc.setFill(Color.GREEN);
            gc.fillOval(-200, 700, 700, 500);

            gc.setFill(Color.GREEN);
            gc.fillOval(200, 700, 700, 500);

            gc.strokeArc(200, 700, 300, 700, 40, 100, ArcType.CHORD);

            gc.setFill(Color.BROWN);

            gc.fillArc(200, 700, 300, 700, 40, 100, ArcType.CHORD);

            gc.setFill(Color.BLACK);

            gc.fillArc(340, 750, 50, 170, 40, 100, ArcType.CHORD);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Graphic3.class.getName()).log(Level.SEVERE, null, ex);
        }

        imageView.setPreserveRatio(false); //evita que la imagen se distorcione
        this.imageView.setFitHeight(200); //Nuevo tamaño en alto
        this.imageView.setFitWidth(200); //Nuevo tamaño en ancho
        this.image = imageView.snapshot(snapshot, null); //obtienen la imagen modificada y la sobreescribe con la original
        gc.drawImage(this.image, 25, 25);
    }

}
