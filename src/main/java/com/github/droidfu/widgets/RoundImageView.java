package com.github.droidfu.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class RoundImageView extends ImageView{

    private static Paint paint = new Paint();

    public RoundImageView(Context context) {
        super(context);

        this.setAdjustViewBounds(true);

        //Generally the size returned from the twitter service
        this.setMaxHeight(73);
        this.setMaxWidth(73);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        Drawable drawable = getDrawable();

        Bitmap b =  ((BitmapDrawable)drawable).getBitmap();
        Bitmap bitmap = null;

        bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

        Bitmap roundBitmap = getRoundedCornerBitmap(bitmap, 15);
        canvas.drawBitmap(roundBitmap, 0, 0 , null);
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
                .getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;

        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        if(paint != null) {
            paint.reset();
        } else {
            paint = new Paint();
        }

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }
}
