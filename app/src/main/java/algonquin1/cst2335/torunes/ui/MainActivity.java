package algonquin1.cst2335.torunes.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import algonquin1.cst2335.torunes.R;
import algonquin1.cst2335.torunes.data.MainViewModel;
import algonquin1.cst2335.torunes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainViewModel model;
    private ActivityMainBinding variableBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainViewModel.class);


        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());


        Button btn = findViewById(R.id.button1);
        EditText myedit = findViewById(R.id.myEditText );

        variableBinding.button.setOnClickListener(click ->
        {
            model.editString.postValue(variableBinding.myEditText.getText().toString());
            model.editString.observe(this,s -> {
                variableBinding.textview.setText( "Your edit text has: " + s);
            });


        });

            model.isSelected.observe(this,selected -> {
                variableBinding.checkbox.setChecked(selected);
                variableBinding.radio.setChecked(selected);
                variableBinding.switch1.setChecked(selected);
            });

        variableBinding.checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });

        variableBinding.radio.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });

        variableBinding.switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.isSelected.postValue(isChecked);
        });

        variableBinding.myImageButton.setOnClickListener(v -> {
            int width = variableBinding.myImageButton.getWidth();
            int height = variableBinding.myImageButton.getHeight();

            // Show a Toast with width and height information
            Toast.makeText(this, "The width = " + width + " and height = " + height, Toast.LENGTH_SHORT).show();
        });

    }
}