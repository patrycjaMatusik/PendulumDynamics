import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;

public class WahadloZSila extends Application {

    LineChart<Number, Number> figure1;
    TextField txtT0;
    TextField txtTEnd;
    TextField txtTheta0;
    TextField txtOmega0;
    TextField txth;
    TextField txtC;
    TextField txtA;
    TextField txtF;
    Label lblT0;
    Label lblTEnd;
    Label lblTheta0;
    Label lblOmega0;
    Label lblh;
    Label lblC;
    Label lblA;
    Label lblF;
    Button btnSetParam;
    Button btnPlot;
    Button btnAnimation;
    Scene sceneMain;
    PendulumParam param;


    @Override
    public void start(Stage primaryStage) throws Exception {

        param = new PendulumParam();

        VBox layoutMain = new VBox(10, displayParam(), displayButtons(primaryStage)); // spacing - odstep pomiedzy kolejnymi komponentami
        layoutMain.setPadding(new Insets(20, 20, 20, 20));
        sceneMain = new Scene(layoutMain, 1200, 170);
        primaryStage.setScene(sceneMain);
        primaryStage.show();
        primaryStage.setTitle("Change scene demo");

    }

    public static void main(String[] args) {
        launch(args);
    }

    private VBox displayParam() {
        lblT0 = new Label("t0: ");
        lblTEnd = new Label("t end: ");
        lblTheta0 = new Label("theta 0: ");
        lblOmega0 = new Label("omega 0: ");
        lblh = new Label("Step: ");
        lblC = new Label("c: ");
        lblA = new Label("A: ");
        lblF = new Label("f: ");

        txtT0 = new TextField();
        txtT0.setEditable(false);
        txtT0.setText("0");
        txtTEnd = new TextField();
        txtTEnd.setEditable(false);
        txtTEnd.setText("100");
        txtTheta0 = new TextField();
        txtTheta0.setEditable(false);
        txtTheta0.setText("0.087");
        txtOmega0 = new TextField();
        txtOmega0.setEditable(false);
        txtOmega0.setText("0");
        txth = new TextField();
        txth.setEditable(false);
        txth.setText("0.01");
        txtC = new TextField();
        txtC.setEditable(false);
        txtC.setText("0.5");
        txtA = new TextField();
        txtA.setEditable(false);
        txtA.setText("0.5");
        txtF = new TextField();
        txtF.setEditable(false);
        txtF.setText("0.66");

        updateParam();

        HBox layout2 = new HBox(20, lblT0, txtT0, lblTEnd, txtTEnd, lblTheta0, txtTheta0, lblOmega0, txtOmega0);
        HBox layout3 = new HBox(20, lblh, txth, lblC, txtC, lblA, txtA, lblF, txtF);
        layout2.setAlignment(Pos.CENTER);
        layout3.setAlignment(Pos.CENTER);
        VBox layouts23 = new VBox(20, layout2, layout3);

        return layouts23;
    }


    private void updateParam() {

        txtT0.setText(String.valueOf(param.getT0()));
        txtTEnd.setText(String.valueOf(param.getTend()));
        txtTheta0.setText(String.valueOf(param.getTheta0()));
        txtOmega0.setText(String.valueOf(param.getOmega0()));
        txth.setText(String.valueOf(param.getH()));
        txtC.setText(String.valueOf(param.getC()));
        txtF.setText(String.valueOf(param.getF()));
        txtA.setText(String.valueOf(param.getA()));

    }

    private HBox displayButtons(Stage stage) {
        btnSetParam = new Button("Set Param");
        btnSetParam.setPrefWidth(150);
        btnSetParam.setOnAction(e -> {
            param.display();
            updateParam();
        });

        btnPlot = new Button("Plot");
        btnPlot.setPrefWidth(150);
        btnPlot.setOnAction(e -> {
            ArrayList<String> calc = calculate();
            plot(stage, calc);
        });

        btnAnimation = new Button("Animation");
        btnAnimation.setPrefWidth(150);
        btnAnimation.setOnAction(e -> {
            ArrayList<String> calc = calculate();
            animation(calc);
        });

        HBox hBox = new HBox(20, btnSetParam, btnPlot, btnAnimation);
        hBox.setAlignment(Pos.CENTER);

        return hBox;
    }

    public ArrayList<String> calculate() {

        ArrayList<String> data = new ArrayList<>();

        double c = Double.parseDouble(txtC.getText());
        double a = Double.parseDouble(txtA.getText());
        double f = Double.parseDouble(txtF.getText());
        double time = Double.parseDouble(txtT0.getText());
        double h = Double.parseDouble(txth.getText());
        int n = (int) ((Double.parseDouble(txtTEnd.getText()) - time) / h);
        double theta = Double.parseDouble(txtTheta0.getText());
        double omega = Double.parseDouble(txtOmega0.getText());
        double thetaOld;
        double thetahalf;
        double omegahlaf;
        double thalf;

        for (int i = 0; i < n; i++) {
            thetaOld = theta;
            thetahalf = theta + (h / 2) * omega;
            omegahlaf = omega + (h / 2) * (-Math.sin(thetaOld) - c * omega + a * Math.sin(f * time));
            theta = theta + h * omegahlaf;
            thalf = time + h / 2;
            omega = omega + h * (-Math.sin(thetahalf) - c * omegahlaf + a * Math.sin(f * thalf));
            data.add(time + "," + theta + "," + omega);
            time = time + h;
        }
        return data;
    }

    private void plot(Stage stage, ArrayList data) {

        NumberAxis x1 = new NumberAxis();
        x1.setLabel("Time");
        NumberAxis y1 = new NumberAxis();
        y1.setLabel("Value");
        figure1 = new LineChart<Number, Number>(x1, y1);

        XYChart.Series values1 = new XYChart.Series();
        XYChart.Series values2 = new XYChart.Series();

        for (int i = 0; i < data.size(); i+=5) {
                String[] line = data.get(i).toString().split(",");
                values1.getData().add(new XYChart.Data(Double.parseDouble(line[0]), Double.parseDouble(line[1])));
                values2.getData().add(new XYChart.Data(Double.parseDouble(line[0]), Double.parseDouble(line[2])));
        }


        figure1.setCreateSymbols(false);
        figure1.getData().clear();
        figure1.setLegendVisible(true);
        values1.setName("Theta");
        values2.setName("Omega");
        figure1.getData().add(values1);
        figure1.getData().add(values2);

        VBox vBox = new VBox(20, displayParam(), displayButtons(stage));
        vBox.getChildren().add(figure1);
        vBox.setPadding(new Insets(20, 20, 20, 20));
        Scene scene = new Scene(vBox, 1200, 600);
        stage.setScene(scene);
        stage.show();
    }


    int i;

    public void animation(ArrayList<String> data) {

        ArrayList<Double> thetaArray = new ArrayList<>();

        for (int l = 0; l < data.size(); l++) {
            String[] line = data.get(l).split(",");
            thetaArray.add(Double.parseDouble(line[1]));
        }

        double xc = 300f;
        double yc = 250f;
        double r = 200f;

        Circle circle = new Circle();
        circle.setCenterX(xc + r * Math.cos(thetaArray.get(0)));
        circle.setCenterY(yc + r * Math.sin(thetaArray.get(0)));
        circle.setRadius(15.0);
        circle.setFill(Color.PINK);
        circle.setStrokeWidth(20);

        Line line = new Line(xc, yc, xc + r * Math.cos(thetaArray.get(0)), yc + r * Math.sin(thetaArray.get(0)));

        i = 1;
        KeyFrame keyFrame = new KeyFrame(Duration.millis(5), e -> {
                double x = xc + r * Math.sin(thetaArray.get(i));
                double y = yc + r * Math.cos(thetaArray.get(i));
                circle.setCenterY(y);
                circle.setCenterX(x);
                line.setEndX(x);
                line.setEndY(y);
                i++;
        });

        Timeline timeline = new Timeline();
        timeline.setCycleCount(thetaArray.size()-1);
        timeline.setAutoReverse(false);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        Group root = new Group(circle, line);
        Scene scene = new Scene(root, 600, 500);
        Stage stage1 = new Stage();
        stage1.setTitle("Path transition example");
        stage1.initModality(Modality.APPLICATION_MODAL);
        stage1.setScene(scene);
        stage1.show();
    }


}
