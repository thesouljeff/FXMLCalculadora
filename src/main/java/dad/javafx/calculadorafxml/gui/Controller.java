package dad.javafx.calculadorafxml.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Controller implements Initializable {
	
	// model
	private Calculadora calc = new Calculadora();
	
	// view
	@FXML
	private BorderPane view;
	
	@FXML
	private TextField tfPantalla;
	
	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tfPantalla.textProperty().bind(calc.pantallaProperty());
	}
	
	@FXML
	public void onActionInsertar(ActionEvent e) {
		char num = ((Button)e.getSource()).getText().charAt(0);
		calc.insertar(num);
	}
	
	@FXML
	public void onActionBorrarTodo(ActionEvent e) {
		calc.borrarTodo();
	}
	
	@FXML
	public void onActionBorrar(ActionEvent e) {
		calc.borrar();
	}
	
	@FXML
	public void onActionInsertarComa(ActionEvent e) {
		calc.insertarComa();
	}
	
	@FXML
	public void onActionOperar(ActionEvent e) {
		char operando = ((Button)e.getSource()).getText().charAt(0);
		calc.operar(operando);
	}

	public BorderPane getView() {
		return view;
	}

	public Calculadora getModel() {
		return calc;
	}

}
