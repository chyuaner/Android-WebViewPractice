package org.twbbs.yuan817.webviewpractice;

import android.content.Context;
import android.widget.Toast;


public class JavaScriptCallFunc {
	Context context;
	JavaScriptCallFunc(Context context) {
		this.context = context;
	}
	public void displayAbout(){
		HelpUtils.showAboutDialog(context);
		Toast.makeText(context, "TEST", Toast.LENGTH_SHORT).show();
	}
}
