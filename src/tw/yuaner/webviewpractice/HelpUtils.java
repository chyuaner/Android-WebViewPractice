/**
 * 數字抽籤
 * FileName:	HelpUtils.java
 *
 * 日期: 		2012.9.25
 * 作者: 		元兒～
 * Version: 	v1.0
 * 更新資訊:
 * └─ v1.0 -2012.9.25
 *    ├─ 將原本在MainActivity.java裡的showAboutDialog()內容抽出成這個class
 *    └─ 解決在Android 2.x手機上因佈景主題而呈現暗底黑字的問題（改成白字）
 * 
 * Description: 所有有關"支援"資訊
 */
package tw.yuaner.webviewpractice;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import tw.yuaner.webviewpractice.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.method.ScrollingMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class HelpUtils {
	//顯示"關於"資訊的對話框	
	public static void showAboutDialog(Context context){
		//建立對話方塊AlertDialog
		AlertDialog about_AlertDialog = new AlertDialog.Builder(context).create();
		about_AlertDialog.setTitle(R.string.about);	//設定AlertDialog標題
		
		try {
			/*PackageManager package_manager = this.getPackageManager();
			PackageInfo package_info = package_manager.getPackageInfo(this.getPackageName(), 0);*/
			//建立Layout面板
			ScrollView about_AlertDialog_scrollView = new ScrollView(context); 
			LinearLayout about_AlertDialog_content = new LinearLayout(context);
			about_AlertDialog_content.setOrientation(LinearLayout.VERTICAL);	//設定為直向的layout
			//宣告"取得套件資訊"的物件
			//PackageInfo package_info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			
			//前面的關於字串
			TextView content_textView = new TextView(context);
			content_textView.setTextAppearance(context, android.R.style.TextAppearance_Medium);	//指定文字樣式為中等大小
			content_textView.setAutoLinkMask(Linkify.ALL);	//設定成會自動加上連結
			if(VERSION.SDK_INT <11) content_textView.setTextColor(context.getResources().getColor(android.R.color.background_light));
			/*content_textView.setText(
					context.getString(R.string.app_name) + "\n\n"
					+ package_info.packageName + "\n"
					+ package_info.versionName + "\n"
					+ "\n");*/
			content_textView.setText("TEST");
			about_AlertDialog_content.addView(content_textView);
			
			//指定這個面板到這個對話框
			about_AlertDialog_scrollView.addView(about_AlertDialog_content);
			about_AlertDialog.setView(about_AlertDialog_scrollView);
			
			/*about_AlertDialog.setMessage(
					getString(R.string.app_name) + "\n"
					+ getString(R.string.package_name) + package_info.packageName + "\n"
					+ getString(R.string.version) + package_info.versionName + "\n"
					+ getString(R.string.author) + getString(R.string.author_content) + "\n"
					+ getString(R.string.author_website) + getString(R.string.author_website_content)
			);*/
		} /*catch (NameNotFoundException ex) {
			about_AlertDialog.setMessage("ERROR");
			//e.printStackTrace();
		}*/ catch(Exception ex){
			Toast.makeText(context,"ERROR", Toast.LENGTH_LONG).show();
		}
		about_AlertDialog.setButton(context.getString(android.R.string.ok), new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		about_AlertDialog.show();
	}
}
