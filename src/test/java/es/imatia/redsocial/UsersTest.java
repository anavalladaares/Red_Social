package es.imatia.redsocial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class UsersTest {

    Users user1;
    Users user2;
    Users user3;
    Posts post1;
    Posts post2;
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

        this.comment1 = new Comments(user2, "Buena reflexión del día");
        this.comment2 = new Comments(user3, "No tienes ni idea, Casemiro es Top!");
    }

    @Test
    void usersTest() { //Test del constructor
        Assertions.assertNotNull(this.user1);
        Assertions.assertNotNull(user1.getName());
        Assertions.assertNotNull(user1.getSurname());
        Assertions.assertNotNull(user1.getUserName());
        Assertions.assertNotNull(this.user1.getUserList());
        Assertions.assertNotNull(this.user1.getPostList());
        Assertions.assertEquals(0, this.user1.getUserList().size());
        Assertions.assertEquals(0, this.user1.getPostList().size());
    }

    @Test
    void followWithSize0Test() { //Si todavía no sigo a nadie
        Assertions.assertEquals(0, this.user1.getUserList().size());
        this.user1.follow(user2);
        Assertions.assertEquals(1, this.user1.getUserList().size());
    }

    @Test
    void followAlreadyFollowingTest() { //Si ya sigo a esa persona en concreto
        this.user1.follow(user2);
        this.user1.follow(user2);
        Assertions.assertEquals(1, this.user1.getUserList().size());
    }

    @Test
    void followWithSize1Test() { //Si ya sigo a alguien pero no a esa persona
        this.user1.follow(user2);
        this.user1.follow(user3);
        Assertions.assertEquals(2, this.user1.getUserList().size());
    }

    @Test
    void unfollowAlreadyFollowingTest() { //Si seguía a esa persona en concreto
        Assertions.assertEquals(0, this.user1.getUserList().size());
        this.user1.follow(user2);
        Assertions.assertEquals(1, this.user1.getUserList().size());
        this.user1.unfollow(user2);
        Assertions.assertEquals(0, this.user1.getUserList().size());
    }

    @Test
    void unfollowWithoutFollowingTest() { //No seguía a esa persona en concreto
        Assertions.assertEquals(0, this.user1.getUserList().size());
        this.user1.follow(user2);
        Assertions.assertEquals(1, this.user1.getUserList().size());
        this.user1.unfollow(user3);
        Assertions.assertEquals(1, this.user1.getUserList().size());
    }

    @Test
    void unfollowWithSize0Test() { //No sigo a nadie
        Assertions.assertEquals(0, this.user1.getUserList().size());
        this.user1.unfollow(user2);
        Assertions.assertEquals(0, this.user1.getUserList().size());
    }

    @Test
    void unfollowWithSize2Test() { //Si sigo a más de 1 persona y quiero dejar de seguir a 1
        Assertions.assertEquals(0, this.user1.getUserList().size());
        this.user1.follow(user2);
        this.user1.follow(user3);
        Assertions.assertEquals(2, this.user1.getUserList().size());
        this.user1.unfollow(user2);
        Assertions.assertEquals(1, this.user1.getUserList().size());
    }

    @Test
    void addPostTest() { //Si quiero añadir un nuevo post
        Assertions.assertNotNull(this.user1.getPostList());
        Assertions.assertEquals(0, this.user1.getPostList().size());
        this.user1.addPost(post1);
        Assertions.assertEquals(1, this.user1.getPostList().size());
    }

   @Test
    void deletePublishedPostTest() { //Si quiero borrar un post mío
       Assertions.assertEquals(0, this.user3.getPostList().size());
       this.user3.addPost(post1);
       Assertions.assertEquals(1, this.user3.getPostList().size());
       this.user3.deletePost(post1);
       Assertions.assertEquals(0, this.user3.getPostList().size());
   }

   @Test
    void deleteNotPublishedPostTest() { //Si quiero borrar un post que no es mío
       this.user3.addPost(post1);
       Assertions.assertEquals(1, this.user3.getPostList().size());
       this.user3.deletePost(post2);
       Assertions.assertEquals(1, this.user3.getPostList().size());
   }

   @Test
    void listPostWithSize2Test() { //Si tengo 2 posts
       this.user2.addPost(post1);
       this.user2.addPost(post2);
       this.user2.listPosts();
   }

   @Test
    void listPostWithSize0Test() { //Si no tengo ningún post
        this.user1.listPosts();
   }

   @Test
    void list1CommentTest() { //Si mi post tiene comentarios
       this.user1.addPost(post1);
       this.post1.addComment(comment1);
       this.user1.listComments();
   }

   @Test
    void list0CommentTest() { //Si mi post no tiene comentarios
       this.user3.listComments();
   }

}
