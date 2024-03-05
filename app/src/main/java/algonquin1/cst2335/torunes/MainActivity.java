package algonquin1.cst2335.torunes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Hoang Anh Nguyen
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    /** this holds the text at the center of the screen */
    private TextView tv = null;

    /** this holds the text field at the center of the screen */
    private EditText et = null;

    /** this holds the button at the center of the screen */
    private Button btn = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tv = findViewById(R.id.passwordTextView);
         et = findViewById(R.id.passwordEditText);
        btn = findViewById(R.id.loginButton);

        btn.setOnClickListener( clk ->{
            String password = et.getText().toString();

            checkPasswordComplexity( password);
            if (!checkPasswordComplexity(password)) {
                // Password complexity requirements are not met
                tv.setText("You shall not pass!");
            }else {
                tv.setText("Your password is complex enough");
            }
        });
    }

    /**
     * This Function checks the complexity of a password.
     *
     * @param pw The String object that we are checking
     * @return Returns true if the password meets the complexity criteria
     */
    boolean checkPasswordComplexity(String pw) {
        boolean foundUpperCase = false, foundLowerCase = false, foundNumber = false, foundSpecial = false;

        for (char c : pw.toCharArray()) {
            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }
        }

        if (!foundUpperCase) {
            // Say that they are missing an upper case letter;
            showToast("Password must contain at least one uppercase letter.");
            return false;
        } else if (!foundLowerCase) {
            // Say that they are missing a lower case letter;
            showToast("Password must contain at least one lowercase letter.");
            return false;
        } else if (!foundNumber) {
            // Say that they are missing a number;
            showToast("Password must contain at least one digit.");
            return false;
        } else if (!foundSpecial) {
            // Say that they are missing a special character;
            showToast("Password must contain at least one special character.");
            return false;
        } else {

            return true;
        }
    }

    /**
     * Checks if a character is a special character.
     *
     * @param c The character to check
     * @return Returns true if the character is one of: #$%^&*!@?
     */
    boolean isSpecialCharacter(char c) {
        String specialCharacters = "#$%^&*!@?";
        return specialCharacters.contains(String.valueOf(c));
    }

    /**
     * Shows a toast message.
     *
     * @param message The message to display in the toast
     */
    void showToast(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}