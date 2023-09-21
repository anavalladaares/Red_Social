package es.imatia.redsocial;

public class Pictures {

    private String picturetitle;
    private int pictureHeight;
    private int pictureWidght;

    public Pictures(String picturetitle, int pictureHeight, int pictureWidght){
        this.picturetitle = picturetitle;
        this.pictureHeight = pictureHeight;
        this.pictureWidght = pictureWidght;
    }

    public String getPicturetitle() {
        return picturetitle;
    }
    public void setPicturetitle(String picturetitle) {
        this.picturetitle = picturetitle;
    }

    public int getPictureHeight() {
        return pictureHeight;
    }
    public void setPictureHeight(int pictureHeight) {
        this.pictureHeight = pictureHeight;
    }

    public int getPictureWidght() {
        return pictureWidght;
    }
    public void setPictureWidght(int pictureWidght) {
        this.pictureWidght = pictureWidght;
    }

}
