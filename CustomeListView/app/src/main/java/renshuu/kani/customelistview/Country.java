package renshuu.kani.customelistview;

import android.graphics.drawable.Drawable;

/**
 * Created by hungnm on 16/07/05.
 */
public class Country {



    String nameTA;

    public String getNameTA() {
        return nameTA;
    }

    public void setNameTA(String nameTA) {
        this.nameTA = nameTA;
    }


    public String getNameTV() {
        return nameTV;
    }

    public void setNameTV(String nameTV) {
        this.nameTV = nameTV;
    }

    String nameTV;

    public Drawable getImgFlag() {
        return imgFlag;
    }

    public void setImgFlag(Drawable imgFlag) {
        this.imgFlag = imgFlag;
    }

    Drawable imgFlag;

}
