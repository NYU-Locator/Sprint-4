/*package com.example.mylocator;

import java.util.ArrayList;






import com.example.mylocator.*;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.WindowManager;

public class MainActivity extends Activity {
	public static MainActivity instance = null;
	private ViewPager mTabPager;	
	private ImageView mTabImg;// pic of animation
	private ImageView mTab1,mTab2,mTab3,mTab4,mTab5;
	private int currIndex = 0;// current page
	private int zero = 0;// single pic offset
	private int one;//
	private int two;
	private int three;
	private int four;
	private Button but1;
	private LinearLayout mClose;
    private LinearLayout mCloseBtn;
    private View layout;	
	private boolean menu_display = false;
	private PopupWindow menuWindow;
	private LayoutInflater inflater;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_locator);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		instance=this;
        mTabPager = (ViewPager)findViewById(R.id.tabpager);
        mTabPager.setOnPageChangeListener(new MyOnPageChangeListener());
        mTab1 = (ImageView) findViewById(R.id.img_category);
        mTab2 = (ImageView) findViewById(R.id.img_search);
        mTab3 = (ImageView) findViewById(R.id.img_home);
        mTab4 = (ImageView) findViewById(R.id.img_schedule);
        mTab5 = (ImageView) findViewById(R.id.img_more);
        mTabImg = (ImageView) findViewById(R.id.img_tab_now);
        mTab1.setOnClickListener(new MyOnClickListener(0));
        mTab2.setOnClickListener(new MyOnClickListener(1));
        mTab3.setOnClickListener(new MyOnClickListener(2));
        mTab4.setOnClickListener(new MyOnClickListener(3));
        mTab5.setOnClickListener(new MyOnClickListener(4));
        Display currDisplay = getWindowManager().getDefaultDisplay();//get the size of window
        int displayWidth = currDisplay.getWidth();
        int displayHeight = currDisplay.getHeight();
        one = displayWidth/5; //set the size of translating
        two = one*2;
        three = one*3;
        four = one*4;
        LayoutInflater mLi = LayoutInflater.from(this);
        View view1 = mLi.inflate(R.layout.category, null);
        View view2 = mLi.inflate(R.layout.search, null);
        View view3 = mLi.inflate(R.layout.home, null);
        View view4 = mLi.inflate(R.layout.schedule, null);
        View view5 = mLi.inflate(R.layout.more, null);
        final ArrayList<View> views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        views.add(view5);
        but1 =(Button) view1.findViewById(R.id.Button01);
        but1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
            	intent.setClass(MainActivity.this,home.class);
            	startActivity(intent);
			}
		});
        
PagerAdapter mPagerAdapter = new PagerAdapter() {
			
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}
			
			@Override
			public int getCount() {
				return views.size();
			}

			@Override
			public void destroyItem(View container, int position, Object object) {
				((ViewPager)container).removeView(views.get(position));
			}
			@Override
			public Object instantiateItem(View container, int position) {
				((ViewPager)container).addView(views.get(position));
				return views.get(position);
			}
	};
	mTabPager.setAdapter(mPagerAdapter);
	}
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}
		@Override
		public void onClick(View v) {
			mTabPager.setCurrentItem(index);
		}
	};
	public class MyOnPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageSelected(int arg0) {
			Animation animation = null;
			switch (arg0) {
			case 0:
				mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_category_whilepressing));
				if (currIndex == 1) {
					animation = new TranslateAnimation(one, 0, 0, 0);
					mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_search_whilenormal));
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(two, 0, 0, 0);
					mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_home_whilenormal));
				}
				else if (currIndex == 3) {
					animation = new TranslateAnimation(three, 0, 0, 0);
					mTab4.setImageDrawable(getResources().getDrawable(R.drawable.tab_schedule_whilenormal));
				}
				else if (currIndex==4){
					animation = new TranslateAnimation(four, 0, 0, 0);
					mTab5.setImageDrawable(getResources().getDrawable(R.drawable.tab_more_whilenormal));
				
				}
				
				break;
			case 1:
				mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_search_whilepressing));
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, one, 0, 0);
					mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_category_whilenormal));
				} else if (currIndex == 2) {
					animation = new TranslateAnimation(two, one, 0, 0);
					mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_home_whilenormal));
				}
				else if (currIndex == 3) {
					animation = new TranslateAnimation(three, one, 0, 0);
					mTab4.setImageDrawable(getResources().getDrawable(R.drawable.tab_schedule_whilenormal));
				}
				else if (currIndex==4){
					animation = new TranslateAnimation(four, one, 0, 0);
					mTab5.setImageDrawable(getResources().getDrawable(R.drawable.tab_more_whilenormal));
				
				}
				
				break;
			case 2:
				mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_home_whilepressing));
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, two, 0, 0);
					mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_category_whilenormal));
				} else if (currIndex == 1) {
					animation = new TranslateAnimation(one, two, 0, 0);
					mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_search_whilenormal));
				}
				else if (currIndex == 3) {
					animation = new TranslateAnimation(three, two, 0, 0);
					mTab4.setImageDrawable(getResources().getDrawable(R.drawable.tab_schedule_whilenormal));
				}
				else if (currIndex==4)
				{
					animation = new TranslateAnimation(four, two, 0, 0);
					mTab5.setImageDrawable(getResources().getDrawable(R.drawable.tab_more_whilenormal));
				
				}
				break;
			case 3:
				mTab4.setImageDrawable(getResources().getDrawable(R.drawable.tab_schedule_whilepressing));
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, three, 0, 0);
					mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_category_whilenormal));
				} else if (currIndex == 1) {
					animation = new TranslateAnimation(one, three, 0, 0);
					mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_search_whilenormal));
				}
				else if (currIndex == 2) {
					animation = new TranslateAnimation(two, three, 0, 0);
					mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_home_whilenormal));
				}
				else if (currIndex==4){
					animation = new TranslateAnimation(four, three, 0, 0);
					mTab5.setImageDrawable(getResources().getDrawable(R.drawable.tab_more_whilenormal));
				
				}
				break;
			case 4:
				mTab5.setImageDrawable(getResources().getDrawable(R.drawable.tab_more_whilepressing));
				if (currIndex == 0) {
					animation = new TranslateAnimation(zero, four, 0, 0);
					mTab1.setImageDrawable(getResources().getDrawable(R.drawable.tab_category_whilenormal));
				} else if (currIndex == 1) {
					animation = new TranslateAnimation(one, four, 0, 0);
					mTab2.setImageDrawable(getResources().getDrawable(R.drawable.tab_search_whilenormal));
				}
				else if (currIndex == 2) {
					animation = new TranslateAnimation(two, four, 0, 0);
					mTab3.setImageDrawable(getResources().getDrawable(R.drawable.tab_home_whilenormal));
				}
				else if (currIndex==3){
					animation = new TranslateAnimation(three, four, 0, 0);
					mTab4.setImageDrawable(getResources().getDrawable(R.drawable.tab_schedule_whilenormal));
				
				}
				break;
			}
			currIndex = arg0;
			animation.setFillAfter(true);// True: the pic stopped after the animation
			animation.setDuration(150);
			
			mTabImg.startAnimation(animation);
		}
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
		public boolean onKeyDown(int keyCode, KeyEvent event) {
	    	if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {  //get back key
	    		
	        	if(menu_display){         //if  Menu opened £¬close the Menu first
	        		menuWindow.dismiss();
	        		menu_display = false;
	        		}
	        /*	else {
	        		Intent intent = new Intent();
	            	intent.setClass(mylocator.this,Exit.class);
	            	startActivity(intent);
	        	}*/


/*
	    	}
	    	
	    	return false;
		
			}
	    	
	    }
		
		
		
		
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

}
*/
package com.example.mylocator;

import java.util.ArrayList;

//import com.example.mylocator.MainActivity;
import com.example.mylocator.home.MyOnPageChangeListener;
import com.example.mylocator.home.txListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



public class MainActivity extends FragmentActivity{
	
	private ViewPager mPager;
	private ArrayList<Fragment> fragmentList;
	private ImageView image;
	private ImageView view1, view2, view3, view4, view5;
	private int currIndex;// current index
	private int bmpW;// width
	private int offset;//
	
	
	//DB
	String DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/com.example.mylocator/databases" ;  
	String DB_NAME = "LocatorTest.db";
	//DB
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_locator);

		Button btn = (Button) findViewById(R.id.button1);
		
		
		InitTextView();
		InitImage();
		InitViewPager();
		
		btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            	 getSqliteContent();
            }
		});
	}
	
	public void InitTextView() {
		view1 = (ImageView) findViewById(R.id.img_category);
		view2 = (ImageView) findViewById(R.id.img_search);
		view3 = (ImageView) findViewById(R.id.img_home);
		view4 = (ImageView) findViewById(R.id.img_schedule);
		view5= (ImageView) findViewById(R.id.img_more);
		view1.setOnClickListener(new txListener(0));
		view2.setOnClickListener(new txListener(1));
		view3.setOnClickListener(new txListener(2));
		view4.setOnClickListener(new txListener(3));
		view5.setOnClickListener(new txListener(4));
	}
	public class txListener implements View.OnClickListener {
		private int index = 0;

		public txListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mPager.setCurrentItem(index);
		}
	}
	/*
	 * InitImage
	 */
	public void InitImage() {
		image = (ImageView) findViewById(R.id.img_tab_now);
		bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.tab_bg)
				.getWidth();
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;
		offset = (screenW / 5 - bmpW) / 2;

		// imgageview set 1 offset
		Matrix matrix = new Matrix();
		matrix.postTranslate(offset, 0);
		image.setImageMatrix(matrix);
	}
	/*
	 * 初始化ViewPager
	 */
	public void InitViewPager() {
		mPager = (ViewPager) findViewById(R.id.tabpager);
		fragmentList = new ArrayList<Fragment>();
		Fragment category = new CategoryFragment();
		Fragment search = new SearchFragment();
		Fragment home= new HomeFragment();
		Fragment schedule = new ScheduleFragment();
		Fragment more = new MoreFragment();
		
		
		fragmentList.add(category);
		fragmentList.add(search);
		fragmentList.add(home);
		fragmentList.add(schedule);
		fragmentList.add(more);

		// ViewPager adapter
		mPager.setAdapter(new MyFragmentPagerAdapter(
				getSupportFragmentManager(), fragmentList));
		mPager.setCurrentItem(0);// the first page
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());//
	}
	
	public class MyOnPageChangeListener implements OnPageChangeListener {
		private int one = offset * 2 + bmpW;// offset

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}
		
		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			Animation animation = new TranslateAnimation(currIndex * one, arg0
					* one, 0, 0);//
			currIndex = arg0;
			animation.setFillAfter(true);//
			animation.setDuration(200);//
			image.startAnimation(animation);//
			int i = currIndex + 1;
			Toast.makeText(MainActivity.this, "you choose " + i + "page",
					Toast.LENGTH_SHORT).show();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	//DB
public void getSqliteContent(){

		
		File f = new File(DB_PATH + DB_NAME);
		if (!f.exists()) {
			prepareDB();
		}
		 Toast.makeText(MainActivity.this, "GET DATABASE INFO", Toast.LENGTH_SHORT).show();
		SQLiteDatabase db = openOrCreateDatabase(DB_PATH+DB_NAME, Context.MODE_PRIVATE, null);
        
		Cursor c = db.rawQuery("SELECT * FROM Events", new String[]{});  
        
		int row_num = c.getCount();
		
		if(row_num !=0){
        	c.moveToFirst();
        	for(int i = 0; i < row_num; i++){
        		int year = c.getInt(0);
        		int mon = c.getInt(1); 
        		int date = c.getInt(2);
        		String m = c.getString(3);
        		int hour = c.getInt(4);
        		int min = c.getInt(5);
        		String name = c.getString(6);
        		int cate = c.getInt(7);
        		String addr = c.getString(8);
        		double gpsLO = c.getDouble(9);
        		double gpsLA = c.getDouble(10);
        		String descrip = c.getString(11);
        		
        		Toast.makeText(MainActivity.this, 
        				"Time: " + year + "." + mon + "." + date + "< " + 
        				hour + ":" + min + " >" + "\n" + "Catagory: " + cate +  
        				"\n" + "EVENT NAME: " + name,
        				Toast.LENGTH_LONG).show();
        		
        		
        		c.moveToNext();
        		
        	}
        }        
	}


public void prepareDB() {
	if ((new File(DB_PATH+DB_NAME)).exists() == false) {
		
		Toast.makeText(MainActivity.this, "NO DATABASE, PREPARING~~", Toast.LENGTH_SHORT).show();
		
		File f = new File(DB_PATH);
		
		if (!f.exists()) {
			f.mkdir();
		}

		try {
			
			InputStream is = getAssets().open(DB_NAME);
			
			OutputStream os = new FileOutputStream(DB_PATH + DB_NAME);

			
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}

			
			os.flush();
			os.close();
			is.close();
			Toast.makeText(MainActivity.this, "DATABASE PREPARED!!!", Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} else {
		Toast.makeText(MainActivity.this, "DATABASE EXITS~ >.^", Toast.LENGTH_SHORT).show();
	}
}
	
}



