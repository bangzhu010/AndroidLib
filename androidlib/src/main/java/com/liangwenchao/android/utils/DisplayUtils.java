package com.liangwenchao.android.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by LiangWenchao on 2016/7/19.
 */
public class DisplayUtils {
    private static DisplayUtils displayUtils;
    private static Context mContext;
    private DisplayUtils(Context context){
        this.mContext = context;
    }
    public synchronized static DisplayUtils newInstance(Context context){
        if(displayUtils ==null){
            displayUtils = new DisplayUtils(context);
        }
        return  displayUtils;
    }
    public static int px2dip(Context context,int px){
        final float scale= context.getResources().getDisplayMetrics().density;
        return (int) (px/scale+0.5f);
    }
    public static int dip2px(Context context,int dip){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dip*scale+0.5f);
    }
    public static int px2sp(Context context,int px){
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (px/scale+0.5f);
    }
    public static int sp2px(Context context,int sp){
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp*scale +0.5f);
    }
    public static int dip2px(int dip){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dip,mContext.getResources().getDisplayMetrics());
    }
    public static int sp2px(int sp){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                sp,
                mContext.getResources().getDisplayMetrics());
    }
}
