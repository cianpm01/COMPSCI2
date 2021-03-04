package com.example.cshw2;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import androidx.annotation.RequiresApi;

import java.util.Random;


public class FaceControl implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener {

    //Instance variables

    private Face view;
    Random rand = new Random();
// Seekbars to be used in a setter method
    SeekBar seekOne;
    SeekBar seekTwo;
    SeekBar seekThree;


    //ints representing red, green and blue to be used when adjusting the color

    int red;
    int green;
    int blue;


//Constructor
    public FaceControl(Face fav)
    {
        view = fav;

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override

    //onClick method
    public void onClick(View v) {
        switch (v.getId()) {
            //If the random button is clicked, all elements of the face are randomized
            case R.id.button:
                // do your code
                view.hairStyle = rand.nextInt(3);
                view.skinColor = rand.nextInt(1 + 167772) -167772;
                view.eyeColor = rand.nextInt(1 + 167772) -167772;
                view.hairColor = rand.nextInt(1 + 167772) -167772;







                view.invalidate();
                break;
            //If the "hair" radio button is selected, the sliders reflect the hair color's rgb values
            case R.id.Hairbutton:

                 red = Color.red((view.hairColor));
                 blue = Color.blue(view.hairColor);
                 green = Color.green(view.hairColor);

            //Progress is set to rgb values
                 seekOne.setProgress(red);
                 seekTwo.setProgress(blue);
                 seekThree.setProgress(green);

                 view.invalidate();












                break;
//If the "skin" radio button is selected, the sliders reflect the skin color's rgb values
            case R.id.skinButton:

                red = Color.red((view.skinColor));
                blue = Color.blue(view.skinColor);
                green = Color.green(view.skinColor);


                seekOne.setProgress(red);
                seekTwo.setProgress(blue);
                seekThree.setProgress(green);

                view.invalidate();

                break;
//If the "eye" radio button is selected, the sliders reflect the hair color's rgb values
            case R.id.eyeButton:

                red = Color.red((view.eyeColor));
                blue = Color.blue(view.eyeColor);
                green = Color.green(view.eyeColor);


                seekOne.setProgress(red);
                seekTwo.setProgress(blue);
                seekThree.setProgress(green);
                view.invalidate();

                break;



            default:
                break;




    }

}
    //Method for nothing selected for the spinner. If no items are selected, the spinner will default to Style one
    public void onNothingSelected(AdapterView<?> parent) {
        view.hairStyle = 0;
        view.invalidate();


    }
    //This method sets the variable hairStyle in hte face class according to the item on the spinner the user selects

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        //Switch statement to manage each different case pf positions
        switch(position)
        {
            case 0:
                view.hairStyle = 0;
                break;
            case 1:
                view.hairStyle = 1;
                break;
            case 2:
                view.hairStyle = 2;
                break;
            default:
                break;


        }
        view.invalidate();


    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    //Setter method for the seekbars
    public void setSeekBars(SeekBar r, SeekBar g, SeekBar y)
    {
        seekOne = r;
        seekTwo = g;
        seekThree = y;

    }
}
