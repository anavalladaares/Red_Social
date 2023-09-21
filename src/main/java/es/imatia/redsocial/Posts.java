package es.imatia.redsocial;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Posts {

    private LocalDate date;
    private String text;
    private List<Comments> commentsList;
    private Pictures pictures;
    private Videos videos;

    //Constructor del TEXTO
    public Posts(List<Comments> commentsList, String text){
        this.commentsList = commentsList;
        this.text = text;
        this.date = LocalDate.now();
    }

    //Constructor de las IMÁGENES
    public Posts(List<Comments> commentsList, Pictures pictures) {
        this.commentsList = commentsList;
        this.pictures = pictures;
        this.date = LocalDate.now();
    }

    //Constructor de los VÍDEOS
    public Posts(List<Comments> commentsList, Videos videos) {
        this.commentsList = commentsList;
        this.videos = videos;
        this.date = LocalDate.now();
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }
    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    public Pictures getPictures() {
        return pictures;
    }

    public Videos getVideos() {
        return videos;
    }

    //Añadir un comentario
    public void addComment(Comments addComments) {
        commentsList.add(addComments);
    }

    //Eliminar un comentario
    public void deleteComment(Comments deleteComments){
        commentsList.remove(deleteComments);
    }

    //Detalles de los posts
    public void showPostsDetails() {
        if(Objects.isNull(this.getText())) {
            this.setText("");
        }
        if(!getText().isEmpty()) {
            System.out.println("The post says: " + getText());
        } else if(getPictures() != null && !getPictures().getPicturetitle().isEmpty()) {
            System.out.println("The image post is: " + getPictures().getPicturetitle() + ", with dimensions "
                    + getPictures().getPictureHeight() + "x" + getPictures().getPictureWidght());
        } else if(getVideos() != null) {
            System.out.println("The video post is: " + getVideos().getVideoTitle() + ", with quality "
                    + getVideos().getQuality() + " and duration " + getVideos().getDuration() + " seconds.");
        }
    }

    //Mostrar la cantidad de comentarios de un post
    public void countComments() {
        if(getCommentsList().size() == 0) {
            System.out.println("There are no comments");
        } else {
            System.out.println("There's a total of " + getCommentsList().size() + " comments.");
        }
    }
}
