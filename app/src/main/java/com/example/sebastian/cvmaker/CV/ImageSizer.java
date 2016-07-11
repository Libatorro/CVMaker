package com.example.sebastian.cvmaker.CV;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Sebastian on 2016-07-06.
 */
public class ImageSizer {

    public static Bitmap decodeSampledBitmapFromFile(String path, int reqWidth, int reqHeight) {
        {
            final BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);


            final int height = options.outHeight;
            final int width = options.outWidth;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            int inSampleSize = 1;

            if (height > reqHeight) {
                inSampleSize = Math.round((float) height / (float) reqHeight);
            }

            int expectedWidth = width / inSampleSize;

            if (expectedWidth > reqWidth) {
                //if(Math.round((float)width / (float)reqWidth) > inSampleSize) // If bigger SampSize..
                inSampleSize = Math.round((float) width / (float) reqWidth);
            }


            options.inSampleSize = inSampleSize;

            // Decode bitmap with inSampleSize set
            options.inJustDecodeBounds = false;

            return BitmapFactory.decodeFile(path, options);
        }
    }
}
