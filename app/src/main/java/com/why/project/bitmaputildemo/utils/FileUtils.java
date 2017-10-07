package com.why.project.bitmaputildemo.utils;

import android.text.TextUtils;

import java.io.File;

/**
 * Created by HaiyuKing
 * Used 配合APPDir的文件工具类
 */

public class FileUtils {

	//创建目录
	public static boolean makeDirs(String filePath) {
		if (TextUtils.isEmpty(filePath)) {
			return false;
		}

		File folder = new File(filePath);
		return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
	}

	//获取目录名
	public static String getFolderName(String filePath) {

		if (TextUtils.isEmpty(filePath)) {
			return filePath;
		}

		int filePosi = filePath.lastIndexOf(File.separator);
		return (filePosi == -1) ? "" : filePath.substring(0, filePosi);
	}

	/**删除所有文件*/
	public static void deleteAllFile(String filePath)
	{
		if(!TextUtils.isEmpty(filePath)) {
			deleteAllFiles(new File(filePath));
		}
	}

	/**删除所有文件*/
	public static void deleteAllFiles(File root)
	{
		File[] arrayOfFile = root.listFiles();
		if (arrayOfFile != null)
		{
			for(int j = 0;j < arrayOfFile.length;j++){
				File file = arrayOfFile[j];
				if (file.isDirectory())
				{
					deleteAllFiles(file);
					file.delete();
				}else if(file.exists()){
					deleteAllFiles(file);
					file.delete();
				}
			}
		}
	}

	/**获取第一个文件的完整路径*/
	public static String firstFile(String parentPath){
		File[] arrayOfFile = new File(parentPath).listFiles();
		String firstFilePath = "";
		if (arrayOfFile != null)
		{
			File file0 = arrayOfFile[0];
			firstFilePath = file0.getPath();
		}
		return firstFilePath;
	}
}
