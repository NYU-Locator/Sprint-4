package com.example.mylocator;

import android.os.Bundle;  
import android.support.v4.app.Fragment;  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.Spinner;
import android.widget.Button;  
import android.widget.TextView;
import android.widget.Toast; 
import android.widget.CheckBox;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.view.KeyEvent;



  
public class SearchFragment extends Fragment{  
	private Spinner spinner_month, spinner_date, spinner_hour, spinner_min, spinner_category;
	private CheckBox chk_manhattan, chk_brooklyn, chk_queens, chk_bronx;
	private EditText editText_search_name;
	private Button btnsearch;
	private View rootView;
	
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        rootView = (View) inflater.inflate(R.layout.search, container, false);//get the layout file  
    	addListenerOnButton();
    	return rootView;
          
    }  

    public void addListenerOnButton() {
    	editText_search_name = (EditText) rootView.findViewById(R.id.editText_search_name);  
    	spinner_month = (Spinner) rootView.findViewById(R.id.spinner_month);
    	spinner_date = (Spinner) rootView.findViewById(R.id.spinner_date);
    	spinner_hour = (Spinner) rootView.findViewById(R.id.spinner_hour);
    	spinner_min = (Spinner) rootView.findViewById(R.id.spinner_min);
    	spinner_category = (Spinner) rootView.findViewById(R.id.spinner_category);
    	chk_manhattan = (CheckBox) rootView.findViewById(R.id.chk_manhattan);
    	chk_brooklyn = (CheckBox) rootView.findViewById(R.id.chk_brooklyn);
    	chk_queens = (CheckBox) rootView.findViewById(R.id.chk_queens);
    	chk_bronx = (CheckBox) rootView.findViewById(R.id.chk_bronx);
    	btnsearch = (Button) rootView.findViewById(R.id.button_search);
     
    	btnsearch.setOnClickListener(new OnClickListener() {
     
    	  @Override
    	  public void onClick(View v) {
    		String choicemessage = "Search : " + 
    				"\nName : "+ String.valueOf(editText_search_name.getText()) +
                    "\nMonth : "+ String.valueOf(spinner_month.getSelectedItem()) +
                    "\nDate : "+ String.valueOf(spinner_date.getSelectedItem()) +
                    "\nHour : "+ String.valueOf(spinner_hour.getSelectedItem()) +
                    "\nMinute : "+ String.valueOf(spinner_min.getSelectedItem()) +
                    "\nCategory : "+ String.valueOf(spinner_category.getSelectedItem()) +
                    "\nManhanttan : "+ String.valueOf(chk_manhattan.isChecked()) +
    				"\nBrooklyn : "+ String.valueOf(chk_brooklyn.isChecked()) +
    				"\nQueens : "+ String.valueOf(chk_queens.isChecked()) +
    				"\nBronx : "+ String.valueOf(chk_bronx.isChecked());

    		Toast.makeText(getActivity(), choicemessage,Toast.LENGTH_SHORT).show();
    	  }
     
    	});
    }
}  
