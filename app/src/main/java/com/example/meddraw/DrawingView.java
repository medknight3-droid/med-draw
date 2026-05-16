package com.example.meddraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawingView extends View {
    private Paint paint = new Paint();
    private Path path = new Path();

    public DrawingView(Context c, AttributeSet a) {
        super(c, a);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(8f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();

        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            path.moveTo(x, y);
        } else if (e.getAction() == MotionEvent.ACTION_MOVE) {
            path.lineTo(x, y);
        }

        invalidate();
        return true;
    }
}
