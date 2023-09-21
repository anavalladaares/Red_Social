package es.imatia.redsocial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PostsTest {

    Users user1;
    Users user2;
    Users user3;
    Posts post1;
    Posts post2;
    Pictures pictureLeon;
    Posts post3;
    Videos videoBosque;
    Posts post4;
    Comments comment1;
    Comments comment2;

    @BeforeEach
    void init() {
        this.user1 = new Users("Isaura", "Docampo", "isauradocampo", new ArrayList<Users>(),
                new ArrayList<Posts>());
        this.user2 = new Users("Anton", "Piñeiro", "antonpiñeiro", new ArrayList<Users>(),
                new ArrayList<Posts>());
        this.user3 = new Users("Adrian", "Sánchez-Puerta", "adriansanchezpuerta",
                new ArrayList<Users>(), new ArrayList<Posts>());

        this.post1 = new Posts(new ArrayList<Comments>(), "Y siempre es así?");
        this.post2 = new Posts(new ArrayList<Comments>(), "Vinicius es mas malo que Casemiro");
        this.pictureLeon = new Pictures("León come gamba", 780, 490);
        this.post3 = new Posts(new ArrayList<Comments>(), pictureLeon);
        this.videoBosque = new Videos("Bosque encantado", "4k", 55);
        this.post4 = new Posts(new ArrayList<Comments>(), videoBosque);

        this.comment1 = new Comments(user2, "Buena reflexión del día");
        this.comment2 = new Comments(user3, "No tienes ni idea, Casemiro es Top!");
    }

    @Test
    void textPostTest() { //Test del constructor de texto
        Assertions.assertNotNull(this.post1);
        Assertions.assertNotNull(this.post1.getText());
        Assertions.assertNotNull(this.post1.getCommentsList());
        Assertions.assertEquals(0, this.post1.getCommentsList().size());
    }

    @Test
    void picturePostTest() { //Test del constructor de fotos
        Assertions.assertNotNull(this.post3);
        Assertions.assertNotNull(this.post3.getPictures());
        Assertions.assertNotNull(this.post3.getCommentsList());
        Assertions.assertEquals(0, this.post3.getCommentsList().size());
    }

    @Test
    void videosPostTest() { //Test del constructor de vídeos
        Assertions.assertNotNull(this.post4);
        Assertions.assertNotNull(this.post4.getVideos());
        Assertions.assertNotNull(this.post4.getCommentsList());
        Assertions.assertEquals(0, this.post4.getCommentsList().size());
    }

    @Test
    void addCommentTest() { //Añadir comentarios
        Assertions.assertEquals(0, this.post1.getCommentsList().size());
        this.post1.addComment(comment1);
        Assertions.assertEquals(1, this.post1.getCommentsList().size());
    }

    @Test
    void deleteCommentTest() { //Eliminar comentarios
        this.post1.addComment(comment1);
        Assertions.assertEquals(1, this.post1.getCommentsList().size());
        this.post1.deleteComment(comment1);
        Assertions.assertEquals(0, this.post1.getCommentsList().size());
    }

    @Test
    void showPostDetailsWithNullTextTest() { //comprobar el setText para los post que no tienen este campo
        this.post3.showPostsDetails();
        Assertions.assertEquals("", this.post3.getText());
    }

    @Test
    void showPostDetailsTextTest() { //test de mostrar post de tipo texto
        this.post1.showPostsDetails();
    }

    @Test
    void showPostDetailsPicturesTest() { //test de mostrar post de tipo imagen
        this.post3.showPostsDetails();
    }

    @Test
    void showPostDetailsVideosTest() { //test de mostrar post de tipo video
        this.post4.showPostsDetails();
    }

    @Test
    void countCommentsWithSize0Test() { //contar comentarios habiendo 0
        this.post1.countComments();
        Assertions.assertEquals(0, this.post1.getCommentsList().size());
    }

    @Test
    void countCommentsTest() { //contar comentarios existiendo algunos
        this.post2.addComment(comment2);
        this.post2.countComments();
        Assertions.assertEquals(1, this.post2.getCommentsList().size());
    }
}

