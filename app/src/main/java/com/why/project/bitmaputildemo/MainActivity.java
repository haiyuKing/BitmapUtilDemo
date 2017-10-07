package com.why.project.bitmaputildemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.why.project.bitmaputildemo.utils.AppDir;
import com.why.project.bitmaputildemo.utils.BitmapUtil;
import com.why.project.bitmaputildemo.utils.FileUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity {

	private ImageView img_source;
	private ImageView img_scale1;
	private ImageView img_scale2;

	private Button btn_save;
	private Button btn_show;
	private ImageView img_show;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initDatas();
		initEvents();
	}

	private void initViews() {
		img_source = (ImageView) findViewById(R.id.img_source);
		img_scale1 = (ImageView) findViewById(R.id.img_scale1);
		img_scale2 = (ImageView) findViewById(R.id.img_scale2);

		btn_save = (Button) findViewById(R.id.btn_save);
		btn_show = (Button) findViewById(R.id.btn_show);
		img_show = (ImageView) findViewById(R.id.img_show);
	}

	private void initDatas() {
		img_source.setImageResource(R.mipmap.ic_launcher);

		Bitmap sourceBitmap = BitmapUtil.drawableToBitmap(getResources().getDrawable(R.mipmap.ic_launcher));
		Bitmap sacleBitmap1 = BitmapUtil.bitmapZoomByHeight(sourceBitmap,200);
		img_scale1.setImageBitmap(sacleBitmap1);

		Bitmap sacleBitmap2 = BitmapUtil.bitmapZoomByScale(sourceBitmap,2,1);
		img_scale2.setImageBitmap(sacleBitmap2);
	}

	private void initEvents() {
		btn_save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String pngFilePath = AppDir.getInstance(MainActivity.this).IMAGE + File.separator + System.currentTimeMillis() + ".png";
				Bitmap sourceBitmap = BitmapUtil.drawableToBitmap(getResources().getDrawable(R.mipmap.ic_launcher));
				BitmapUtil.saveBitmapToSDCard(sourceBitmap,pngFilePath);
			}
		});

		btn_show.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String pngPath = FileUtils.firstFile(AppDir.getInstance(MainActivity.this).IMAGE);
				Bitmap pngBitmap = BitmapUtil.getBitmapFromSDCard(pngPath);
				img_show.setImageBitmap(pngBitmap);
			}
		});
	}
}
