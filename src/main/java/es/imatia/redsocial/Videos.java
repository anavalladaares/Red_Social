package es.imatia.redsocial;

public class Videos {

    private String videoTitle;
    private String quality;
    private int duration;

    public Videos(String videoTitle, String quality, int duration) {
        this.videoTitle = videoTitle;
        this.quality = quality;
        this.duration = duration;
    }

    public String getVideoTitle() {
        return videoTitle;
    }
    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getQuality() {
        return quality;
    }
    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

}
