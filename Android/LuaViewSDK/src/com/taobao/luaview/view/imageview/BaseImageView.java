package com.taobao.luaview.view.imageview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Base ImageView
 *
 * @author song
 * @date 16/3/9
 */
public abstract class BaseImageView extends ImageView {
    protected boolean mAttachedWindow = false;
    protected boolean isNetworkMode = false;

    public void setIsNetworkMode(boolean isNetworkMode) {
        this.isNetworkMode = isNetworkMode;
    }

    /**
     * 图片加载回调
     */
    public interface LoadCallback {
        //drawable = null 表示失败，drawable != null表示成功
        void onLoadResult(Drawable drawable);
    }

    public BaseImageView(Context context) {
        super(context);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mAttachedWindow = true;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mAttachedWindow = false;
    }

    public abstract void loadUrl(final String url, final LoadCallback callback);

    public abstract String getUrl();

}
