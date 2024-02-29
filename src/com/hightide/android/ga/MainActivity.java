package com.hightide.android.ga;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private TextView textView;
    private RelativeLayout relativeLayout;  // Declare relativeLayout here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a RelativeLayout as the root layout
        relativeLayout = new RelativeLayout(this);  // Initialize relativeLayout here
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        // Create a TextView
        textView = new TextView(this);
        textView.setText("Welcome to the HTGA");
        textView.setTextSize(14);

        // Set the TextView to be centered horizontally
        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        textParams.addRule(RelativeLayout.LEFT_OF);

        // Add the TextView to the RelativeLayout
        relativeLayout.addView(textView, textParams);

        // Automatically display text on the next line
        addTextToNextLine("");
        addTextToNextLine("About the HTGA");
        addTextToNextLine("The HTGA is a really cool application that houses most of all HighTide's projects or links to his projects making it really easy to find your way around HighTide's online environment.");
        addTextToNextLine("");
        
        // About the HighTide Coolpage
        addTextToNextLine("The HighTide Coolpage");
        addTextToNextLine("A perfect example of the links mentioned in the last text, at the top of this app you should see a button with the text \"Coolpage\" on it. If you tap or click that button, a new internet tab will open on your device and you will be sent to the HighTide Coolpage (more info below).");
        addTextToNextLine("");
        addTextToNextLine("The HighTide Coolpage is a website that like this app, has all of HighTides major projects listed in a way that makes it very human readable. The coolpage usually updaye every day or so and adds little to a lot of features at once. When the coolpage updates, its usually to upload entire projects at one time (web apps, games, ect.). The coolpage can always take suggestions so feel free to suggest one by clicking the \"Contact Us!\" button on the coolpage's homepage./n/nThe coolpage usually works with a couple languages. These languages being:\n- HTML (main language)\n- PHP\n- CSS\n- And finally JavaScript\nThis app uses Java but I would prefer not to use Java for coding as I know very little about it.");

        // Add a button to open a web page
        addUrlButton("Coolpage", "https://hightide.coolpage.biz");

        // Set the RelativeLayout as the content of the activity
        setContentView(relativeLayout, layoutParams);
    }

    private void addTextToNextLine(String text) {
        String currentText = textView.getText().toString();
        textView.setText(currentText + "\n" + text);
    }

    private void addUrlButton(String buttonText, final String url) {
        Button button = new Button(this);
        button.setText(buttonText);

        // Set the button to be centered horizontally
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.BELOW, textView.getId());  // Position below the TextView

        // Set an onClickListener to open the web page
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebPage(url);
            }
        });

        // Add the button to the RelativeLayout
        relativeLayout.addView(button, buttonParams);
    }

    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
