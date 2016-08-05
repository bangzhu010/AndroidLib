package com.liangwenchao.android.utils.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * Created by LiangWenchao on 2016/8/5.
 */
public class BitmapUtils {
    /**
     *  压缩图片并保存
     * @param bitmap 原图片
     * @param format 压缩格式
     * @param quality 压缩质量
     * @param destFile 压缩后的文件
     * @return 压缩后的路径
     */
    public static String save(Bitmap bitmap, Bitmap.CompressFormat format, int quality, File destFile){
        try {
            FileOutputStream out = new FileOutputStream(destFile);
            if(bitmap.compress(format,quality,out)){
                out.flush();
                out.close();
            }
            if(bitmap!=null &&!bitmap.isRecycled()){
                bitmap.recycle();
            }
            return destFile.getAbsolutePath();
        } catch (Exception e){
            e.printStackTrace();
        }
        return  null;

    }

    /**
     *  压缩图片并保存
     * @param bitmap 原图片
     * @param format 压缩格式
     * @param quailty 压缩质量
     * @param context 上下文
     * @return 压缩后的路径
     */
    public static String save(Bitmap bitmap, Bitmap.CompressFormat format, int quailty, Context context){
        if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Toast.makeText(context,"请插入SD卡",Toast.LENGTH_SHORT).show();
            return null;
        }
        File destDir = new File(Environment.getExternalStorageDirectory() + "/" + context.getPackageName() + "/image/");
        if(!destDir.exists()){
            destDir.mkdirs();
        }
        File destFile = new File(destDir, UUID.randomUUID().toString());
        return  save(bitmap,format,quailty,destFile);
    }

}
