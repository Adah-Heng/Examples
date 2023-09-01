import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


/**
 * @author Adahm
 * The calculator has buttons that calculate numbers and display the memory.
 * It has the numbers zero through nine. The buttons also include all clear,
 * multiplication, division, addition, subtraction, square root, power, 
 * a back button, and a decimal. The memory buttons are memory clear, 
 * memory recall, memory plus, and memory minus.
 */
public class JavaFXCalculator extends Application {

	/**
	 * The memory display for the calculator.
	 */
	private TextField tfDisplay;    // display textfield

	/**
	 * The array for the amount of buttons used.
	 */
	private Button[] btns;          // 24 buttons

	/**
	 * The program can grab the memory for displaying.
	 */
	private Text memoryText;

	/**
	 * Keeps track of what the number in the memory is.
	 */
	private double memory = 0.0;

	/**
	 * The labels for the buttons.
	 */
	private String[] btnLabels = {  // Labels of 24 buttons 
			//buttons plus a text control to display the calculator's current memory value
			"7", "8", "9", "+",
			"4", "5", "6", "-",
			"1", "2", "3", "x",
			".", "0", "=", "/", 
			"C","←", "^", "√",
			"MC", "MR", "M+", "M-" 
	};

	/**
	 * The result keeps track of the result from the calculations.
	 */
	private double result = 0;      // Result of computation and for computation.

	/**
	 * The string that is the input number.
	 */
	private String inStr = "0";  // Input number as String

	/**
	 * The last operator refers to the ' '(nothing), '+', '-', '*', '/', '='.
	 * Last operator helps figure out which one of the compute switch to use.
	 */
	private char lastOperator = ' '; // Previous operator: ' '(nothing), '+', '-', '*', '/', '='

	/**
	 * When a button is pushed the event handle will take the inputs, 
	 * and compute them if needed and displays that number. 
	 * Otherwise, it displays the input for the number or the decimal point
	 * depending on which was pushed. The only one that does not use 
	 * compute to compute the result is the square root.
	 */
	EventHandler<ActionEvent> handler = evt -> { // Event handler for all the 24 Buttons
		String currentBtnLabel = ((Button)evt.getSource()).getText();
		switch (currentBtnLabel) {
		// Number buttons
		case "0": case "1": case "2": case "3": case "4":
		case "5": case "6": case "7": case "8": case "9":
		case ".":
			if (inStr.equals("0")) {
				inStr = currentBtnLabel;  // no leading zero
			} else {
				inStr += currentBtnLabel; // append input digit
			}
			tfDisplay.setText(inStr);
			// Clear buffer if last operator is '='
			if (lastOperator == '=') {
				result = 0;
				lastOperator = ' ';
			}
			break;

			// Operator buttons: '+', '-', 'x', '/', '=','CE','π', 'Mem','.','EXP' 
		case "+":
			compute();
			lastOperator = '+';
			break;
		case "-":
			compute();
			lastOperator = '-';
			break;
		case "x":
			compute();
			lastOperator = '*';
			break;
		case "/":
			compute();
			lastOperator = '/';
			break;
		case "=":
			compute();
			lastOperator = '=';
			break;
		case "√":
			lastOperator = '√';
			if (this.lastOperator != '=' ) {
				this.result = Double.parseDouble(this.inStr);
			}
			this.result = Math.sqrt(this.result);
			this.inStr = this.result + "";
			this.tfDisplay.setText(this.inStr);
			lastOperator = '=';
			break;
		case "^":
			compute();
			lastOperator = '^';
			break;
		case "M+":
			if (this.lastOperator != '=' ) {
				double value = Double.parseDouble(this.inStr);
				this.memory += value;
			}else {
				this.memory += this.result;
			}
			this.memoryText.setText("Memory = " + this.memory);
			break;
		case "M-":
			if (!(this.lastOperator == '=' )) {
				double value = Double.parseDouble(this.inStr);
				this.memory -= value;
			}else {
				this.memory -= this.result;
			}
			this.memoryText.setText("Memory = " + this.memory);
			break;
		case "MR":
			this.inStr = String.valueOf(this.memory);
			this.tfDisplay.setText(memory + " ");
			break;
		case "MC":
			this.memory = 0.0;
			this.memoryText.setText("Memory = " + this.memory);
			break;
		case "←":
			if (this.inStr.length() == 1) {
				this.inStr = "0";
			} else {
				inStr = inStr.substring(0, inStr.length() - 1);
			}
			this.tfDisplay.setText(this.inStr);
			break;
		case "C":
			result = 0.0;
			inStr = "0";
			lastOperator = ' ';
			tfDisplay.setText("0");
			break;
		}
	};

	/**
	 * When the user pushes one of the operator buttons the code performs
	 * the computation based on the previous result and the current input.
	 * It uses the last operator to do the computation.
	 */
	private void compute() {
		double inNum = Double.parseDouble(inStr);// User pushes '+', '-', '*', '/' or '=' button. 
		inStr = "0";
		if (lastOperator == ' ') {
			result = inNum;
		} else if (lastOperator == '+') {
			result += inNum;
		} else if (lastOperator == '-') {
			result -= inNum;
		} else if (lastOperator == '*') {
			result *= inNum;
		} else if (lastOperator == '/') {
			result /= inNum;
		} else if (lastOperator == '=') {

		} else if (lastOperator == '^')	{
			result =  Math.pow(inNum, this.result);
		}

		// Keep the result for the next operation
		tfDisplay.setText(result + "");
	};

	/**
	 * Start the padding for the buttons, the columns of buttons, 
	 * the constraints for the buttons including color of buttons, 
	 * and creates buttons. Creates the padding between the top, sides, and bottom 
	 * in the root display. The top root is where the inStr is displayed in set top. 
	 * The pane is where all the buttons will be placed in set center. 
	 * The memory is on the set bottom. Otherwise, it sets the scene size,
	 * the title, and show. 
	 */
	@Override
	public void start(Stage primaryStage) { // Setup the UI
		memoryText = new Text("Memory = 0.0");
		// Setup the Display TextField
		tfDisplay = new TextField("0");
		tfDisplay.setEditable(false);
		tfDisplay.setAlignment(Pos.CENTER_RIGHT);

		// Setup a GridPane for 4x4 Buttons
		int numCols = 4;
		GridPane paneButton = new GridPane();
		paneButton.setPadding(new Insets(9, 0, 9, 0));  // top, right, bottom, left
		paneButton.setVgap(5);  // Vertical gap between nodes
		paneButton.setHgap(5);  // Horizontal gap between nodes
		// Setup 4 columns of equal width, fill parent
		ColumnConstraints[] columns = new ColumnConstraints[numCols];
		for (int i = 0; i < numCols; ++i) {
			columns[i] = new ColumnConstraints();
			columns[i].setHgrow(Priority.ALWAYS) ;  // Allow column to grow
			columns[i].setFillWidth(true);  // Ask nodes to fill space for column
			paneButton.getColumnConstraints().add(columns[i]);
			switch() {
			case "M+, M-, MR, MC": 
				btns[i].setStyle("-fx-color: blue");
				break;
			case "←, AC":
				btns[i].setStyle("-fx-color: orange");
				break;
			case "7, 8, 9, +, 4, 5, 6, -, 1, 2, 3, x, ., =, /, ^, √" 
			btns[i].setStyle("-fx-color: purple");
			break;
			}
		}

		// Setup 16 Buttons and add to GridPane; and event handler
		btns = new Button[24];
		for (int i = 0; i < btns.length; ++i) {
			btns[i] = new Button(btnLabels[i]);
			btns[i].setOnAction(handler);  // Register event handler
			btns[i].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);  // full-width
			paneButton.add(btns[i], i % numCols, i / numCols);  // control, col, row
		}

		// Setup up the scene graph rooted at a BorderPane (of 5 zones)
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(15, 15, 15, 15));  // top, right, bottom, left
		root.setTop(tfDisplay);     // Top zone contains the TextField
		root.setCenter(paneButton); // Center zone contains the GridPane of Buttons
		root.setBottom(this.memoryText);

		// Set up scene and stage
		primaryStage.setScene(new Scene(root, 300, 300));
		primaryStage.setTitle("JavaFX Calculator");
		primaryStage.show();
	}

	/**
	 * @param The launch for the calculator.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

