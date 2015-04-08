/* Commented and Edited by Collin Mullis
 * Code Originally coded up by Brian Capouch
 * CMP112 Practicum, #2
 */

//package name so that if this app was to go on the app store,
// It would not have a problem with deleting someone else's app
// with the same name
package edu.saintjoe.cs.brianc.examtwo;

// Imports components that this app uses
import com.google.devtools.simple.runtime.components.Component;
import com.google.devtools.simple.runtime.components.HandlesEventDispatching;
import com.google.devtools.simple.runtime.components.android.Form;

import com.google.devtools.simple.runtime.components.android.Button;
import com.google.devtools.simple.runtime.components.android.Label;
import com.google.devtools.simple.runtime.components.android.HorizontalArrangement;
import com.google.devtools.simple.runtime.components.android.TextBox;

import com.google.devtools.simple.runtime.events.EventDispatcher;
// Establish class, which is the Application itself
public class ExamActivity extends Form implements HandlesEventDispatching {
// Defines Components
	private HorizontalArrangement line1, line2, line3;
	private Button incButton;
	private Label resultLabel;
	private Label promptLabel;
	private TextBox inputBox;
	private Label outputLabel;
	int temp;
	
// This line is where the app runs, takes the place of main()
 void $define() {
// Sets backgorund color to "White" 	
     this.BackgroundColor(COLOR_WHITE);
// This gives each HorizontalArragement a name.    
     line1 = new HorizontalArrangement(this);
     line2 = new HorizontalArrangement(this);
     line3 = new HorizontalArrangement(this);

// Sets prompt label to be in line1, and to have the text of "Enter a number:"     
     promptLabel = new Label(line1, "Enter a number:");
// Sets inputBox on line1
     inputBox = new TextBox(line1);
// Makes the inputBox only accept numeric values.
     inputBox.NumbersOnly(true);
     
     
// Sets incButton on line2 and sets its text to "Double It"
     incButton = new Button(line2,"Double It"); 
// Sets resultLabel on line 3 and sets it's text to blank     
     resultLabel = new Label(line3,"");
     
// Tells the app to look for whenever any button is pressed. 
     EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click");
    
 } 
 @Override
 // Method for the class, which is also an event handler.
 public boolean dispatchEvent(Component component, String id, String eventName,
         Object[] args) {
 	// If incButton is clicked, turn the number into a string, multiply it by 2, then turn it back to a string
	// then return true, and set result label to the end value.
	    if (component.equals(incButton) && eventName.equals("Click")){
	    	temp = Integer.parseInt(inputBox.Text());
	    	temp = temp * 2;
	    	resultLabel.Text(String.valueOf(temp));
	        return true;
	     } 
    return true;
	} 
} 
