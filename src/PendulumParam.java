import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PendulumParam {

    private double t0;
    private double tend;
    private double theta0;
    private double omega0;
    private double h;
    private double c;
    private double f;
    private double a;

    public PendulumParam(){
        t0 = 0;
        tend = 100;
        theta0 = 0.87;
        omega0 = 0;
        h = 0.01;
        c = 0.5;
        a = 0.5;
        f = 0.66;
    }

    public PendulumParam(double t0, double tend, double theta0, double omega0, double h, double c, double f, double a) {
        this.t0 = t0;
        this.tend = tend;
        this.theta0 = theta0;
        this.omega0 = omega0;
        this.h = h;
        this.c = c;
        this.f = f;
        this.a = a;
    }

    public double getC() {
        return c;
    }

    public double getF() {
        return f;
    }

    public double getA() {
        return a;
    }

    public double getT0() {
        return t0;
    }

    public double getTend() {
        return tend;
    }

    public double getTheta0() {
        return theta0;
    }

    public double getOmega0() {
        return omega0;
    }

    public double getH() {
        return h;
    }



    public void display() {
        Stage window = new Stage();
        window.setTitle("Parametres");
        window.initModality(Modality.APPLICATION_MODAL);

        Label lblT0 = new Label("t0: ");
        Slider sliderT0 = new Slider(0, 100, t0);
        sliderT0.setShowTickLabels(true);
        sliderT0.setShowTickMarks(true);
        sliderT0.setMajorTickUnit(10);
        sliderT0.setMinorTickCount(9);
        sliderT0.setSnapToTicks(true);
        sliderT0.setPrefWidth(500);
        TextField txtT0 = new TextField(Double.toString(h));
        sliderT0.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                txtT0.setText(Double.toString(newValue.doubleValue()));
            }
        });

        Label lblTEnd = new Label("t end: ");
        Slider sliderTEnd = new Slider(0, 1000, tend);
        sliderTEnd.setShowTickLabels(true);
        sliderTEnd.setShowTickMarks(true);
        sliderTEnd.setSnapToTicks(true);
        sliderTEnd.setMajorTickUnit(100);
        sliderTEnd.setMinorTickCount(99);
        sliderTEnd.setPrefWidth(500);
        TextField txtTEnd = new TextField(Double.toString(tend));
        sliderTEnd.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                txtTEnd.setText(Double.toString(newValue.doubleValue()));
            }
        });

        Label lblTheta0 = new Label("Theta0: ");
        Slider sliderTheta0 = new Slider(0, 3.14, theta0);
        sliderTheta0.setShowTickLabels(true);
        sliderTheta0.setShowTickMarks(true);
        sliderTheta0.setMajorTickUnit(1);
        sliderTheta0.setMinorTickCount(99);
        sliderTheta0.setSnapToTicks(true);
        sliderTheta0.setPrefWidth(500);
        TextField txtTheta0 = new TextField(Double.toString(theta0));
        sliderTheta0.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                txtTheta0.setText(Double.toString(newValue.doubleValue()));
            }
        });

        Label lblOmega0 = new Label("Omega0: ");
        Slider sliderOmega0 = new Slider(0, 10, omega0);
        sliderOmega0.setShowTickLabels(true);
        sliderOmega0.setShowTickMarks(true);
        sliderOmega0.setMajorTickUnit(2);
        sliderOmega0.setMinorTickCount(19);
        sliderOmega0.setSnapToTicks(true);
        sliderOmega0.setPrefWidth(500);
        TextField txtOmega0 = new TextField(Double.toString(omega0));
        sliderOmega0.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                txtOmega0.setText(Double.toString(newValue.doubleValue()));
            }
        });

        Label lblH = new Label("h: ");
        Slider sliderH = new Slider(0, 0.1, h);
        sliderH.setShowTickLabels(true);
        sliderH.setShowTickMarks(true);
        sliderH.setMajorTickUnit(0.05);
        sliderH.setMinorTickCount(49);
        sliderH.setSnapToTicks(true);
        sliderH.setPrefWidth(500);
        TextField txtH = new TextField(Double.toString(h));
        sliderH.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                txtH.setText(Double.toString(newValue.doubleValue()));
            }
        });

        Label lblC = new Label("c: ");
        Slider sliderC = new Slider(0, 2, c);
        sliderC.setShowTickLabels(true);
        sliderC.setShowTickMarks(true);
        sliderC.setMajorTickUnit(0.5);
        sliderC.setMinorTickCount(49);
        sliderC.setSnapToTicks(true);
        sliderC.setPrefWidth(500);
        TextField txtC = new TextField(Double.toString(c));
        sliderC.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                txtC.setText(Double.toString(newValue.doubleValue()));
            }
        });

        Label lblF = new Label("f: ");
        Slider sliderF = new Slider(0, 5, f);
        sliderF.setShowTickLabels(true);
        sliderF.setShowTickMarks(true);
        sliderF.setMajorTickUnit(1);
        sliderF.setMinorTickCount(19);
        sliderF.setSnapToTicks(true);
        sliderF.setPrefWidth(500);
        TextField txtF = new TextField(Double.toString(f));
        sliderF.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                txtF.setText(Double.toString(newValue.doubleValue()));
            }
        });

        Label lblA = new Label("a: ");
        Slider sliderA = new Slider(0, 2, a);
        sliderA.setShowTickLabels(true);
        sliderA.setShowTickMarks(true);
        sliderA.setMajorTickUnit(0.1);
        sliderA.setMinorTickCount(9);
        sliderA.setSnapToTicks(true);
        sliderA.setPrefWidth(500);
        TextField txtA = new TextField(Double.toString(a));
        sliderA.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                txtA.setText(Double.toString(newValue.doubleValue()));
            }
        });


        Button btnSet = new Button("Set");
        btnSet.setPrefWidth(100);
        HBox hBoxSet = new HBox(20, btnSet);
        hBoxSet.setAlignment(Pos.CENTER);
        btnSet.setOnAction(event -> {

            t0 = Double.parseDouble(txtT0.getText());
            tend = Double.parseDouble(txtTEnd.getText());
            theta0 = Double.parseDouble(txtTheta0.getText());
            omega0 = Double.parseDouble(txtOmega0.getText());
            h = Double.parseDouble(txtH.getText());
            c = Double.parseDouble(txtC.getText());
            f = Double.parseDouble(txtF.getText());
            a = Double.parseDouble(txtA.getText());

            window.close();

        });

        HBox hBoxT0 = new HBox(20, lblT0, sliderT0, txtT0);
        hBoxT0.setAlignment(Pos.CENTER_RIGHT);

        HBox hBoxTEnd = new HBox(20, lblTEnd, sliderTEnd, txtTEnd);
        hBoxTEnd.setAlignment(Pos.CENTER_RIGHT);

        HBox hBoxTheta0 = new HBox(20, lblTheta0, sliderTheta0, txtTheta0);
        hBoxTheta0.setAlignment(Pos.CENTER_RIGHT);

        HBox hBoxOmega0 = new HBox(20, lblOmega0, sliderOmega0, txtOmega0);
        hBoxOmega0.setAlignment(Pos.CENTER_RIGHT);

        HBox hBoxH = new HBox(20, lblH, sliderH, txtH);
        hBoxH.setAlignment(Pos.CENTER_RIGHT);

        HBox hBoxC = new HBox(20, lblC, sliderC, txtC);
        hBoxC.setAlignment(Pos.CENTER_RIGHT);

        HBox hBoxF = new HBox(20, lblF, sliderF, txtF);
        hBoxF.setAlignment(Pos.CENTER_RIGHT);

        HBox hBoxA = new HBox(20, lblA, sliderA, txtA);
        hBoxA.setAlignment(Pos.CENTER_RIGHT);

        VBox vBox = new VBox(20, hBoxT0, hBoxTEnd, hBoxTheta0, hBoxOmega0, hBoxH, hBoxC, hBoxA, hBoxF, hBoxSet);
        vBox.setPadding(new Insets(20, 20, 20, 20));

        Scene scene = new Scene(vBox, 850, 600);
        window.setScene(scene);

        window.showAndWait();
    }


}
