package es.imatia.redsocial;

import java.time.LocalDate;

public class Comments {

    private String text;
    private LocalDate date;
    private String username;

    public Comments(Users user, String text){
        this.username = user.getUserName();
        this.date = LocalDate.now();
        this.text = text;
    }

    public String getUsername() {
        return username;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

}
