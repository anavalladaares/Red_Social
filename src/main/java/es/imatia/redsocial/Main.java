package es.imatia.redsocial;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Añadir usuarios

        Users ana = new Users("Ana", "Valladares", "anavalladares", new ArrayList<Users>(), new ArrayList<Posts>());
        Users adrian = new Users("Adrian", "Sánchez-Puerta", "adriansanchezpuerta", new ArrayList<Users>(), new ArrayList<Posts>());
        Users anton = new Users("Anton", "Piñeiro", "antonpiñeiro", new ArrayList<Users>(), new ArrayList<Posts>());
        Users isaura = new Users("Isaura", "Docampo", "isauradocampo", new ArrayList<Users>(), new ArrayList<Posts>());
        Users nuria = new Users("Nuria", "Oujo", "nuriaoujo", new ArrayList<Users>(), new ArrayList<Posts>());

        ana.follow(adrian);
        ana.follow(anton);
        ana.follow(isaura);
        ana.follow(nuria);
        anton.follow(adrian);
        anton.follow(nuria);
        adrian.follow(isaura);
        adrian.follow(ana);
        adrian.follow(nuria);
        isaura.follow(anton);
        isaura.follow(adrian);
        nuria.follow(isaura);
        nuria.follow(anton);
        nuria.follow(ana);

        //Añadir posts

            Pictures pictureLeon = new Pictures("León come gamba", 780, 490);
        Posts postLeon = new Posts(new ArrayList<Comments>(), pictureLeon);
            Pictures picturePenedo = new Pictures("Penedo sobre lienzo", 250, 1200);
        Posts postPenedo = new Posts(new ArrayList<Comments>(), picturePenedo);
            Pictures pictureDora = new Pictures("Dora en el jardín", 770, 1440);
        Posts postDora = new Posts(new ArrayList<Comments>(), pictureDora);

            Videos videoBarco = new Videos("Barco navegando", "1080p", 30);
        Posts postBarco = new Posts(new ArrayList<Comments>(), videoBarco);
            Videos videoBosque = new Videos("Bosque encantado", "4k", 55);
        Posts postBosque = new Posts(new ArrayList<Comments>(), videoBosque);
            Videos videoCama = new Videos("Como hacer una cama", "720p", 49);
        Posts postCama = new Posts(new ArrayList<Comments>(), videoCama);
            Videos baptisterioRomano = new Videos("Baptisterio Romano", "1080p", 4);
        Posts postBaptisterio = new Posts(new ArrayList<Comments>(), baptisterioRomano);

        Posts descartes = new Posts(new ArrayList<Comments>(), "Pienso, luego existo");
        Posts dudaExistencial = new Posts(new ArrayList<Comments>(), "Y siempre es así?");
        Posts deportes = new Posts(new ArrayList<Comments>(), "Vinicius es mas malo que Casemiro");

        //Añadir posts y comentarios

        ana.getPostList().add(postLeon);
        ana.getPostList().get(0).addComment(new Comments(nuria,"Gran obra maestra"));
        ana.getPostList().add(descartes);
        ana.getPostList().get(1).addComment(new Comments(nuria, "Buena reflexión del día"));
        adrian.getPostList().add(postPenedo);
        adrian.getPostList().get(0).addComment(new Comments(ana, "El mejor cuadro que vi en mi vida"));
        adrian.getPostList().add(postBarco);
        adrian.getPostList().get(1).addComment(new Comments(ana, "¡Que mareo!"));
        anton.getPostList().add(postBosque);
        anton.getPostList().get(0).addComment(new Comments(adrian,"Bosque encantado? eso no se lo cree nadie"));
        anton.getPostList().add(dudaExistencial);
        anton.getPostList().get(1).addComment(new Comments(adrian, "No, por que si es así, no sera así, por lo que al no ser así quiere decir que sera así"));
        isaura.getPostList().add(postDora);
        isaura.getPostList().get(0).addComment(new Comments(anton,"Es preciosa!!"));
        isaura.getPostList().add(deportes);
        isaura.getPostList().get(1).addComment(new Comments(anton,"No tienes ni idea, Casemiro es Top!"));
        nuria.getPostList().add(postCama);
        nuria.getPostList().get(0).addComment(new Comments(isaura ,"Wow increíble, me encanta tu contenido!"));
        nuria.getPostList().get(0).addComment(new Comments(anton ,"Alucinante!"));
        nuria.getPostList().add(postBaptisterio);
        //nuria.getPostList().get(1).addComment(new Comments(isaura, "Estoy fascinada con tanta belleza <3"));

        //Dejar de seguir a un usuario

        nuria.unfollow(ana); //la seguía
        anton.unfollow(isaura); //no la seguía

        //Comenzar a seguir un usuario

        ana.follow(adrian); //ya lo sigue
        nuria.follow(adrian); //no lo seguía

        //Eliminar un usuario

        anton.unfollow(nuria); //la seguía
        isaura.unfollow(ana); //no la seguía

        //Eliminar un post

        isaura.deletePost(deportes);

        //Eliminar un comentario

        postBaptisterio.deleteComment(new Comments(isaura, "Estoy fascinada con tanta belleza <3"));

        //Listar todos los posts de un usuario

        nuria.listPosts();

        //Listar los comentarios de un usuario entrando en la lista de post del user, entrando en la lista de
        //comentarios de cada post (con 2 'for')

        ana.listComments();

        //Mostrar el número de comentarios que tiene un post

        postCama.countComments();
        postBaptisterio.countComments();

        /*
        postLeon.addComment(comentarioLeon);
        descartes.addComment(comentarioDescartes);
        postPenedo.addComment(comentarioPenedo);
        postBarco.addComment(comentarioBarco);
        postBosque.addComment(comentarioBosque);
        dudaExistencial.addComment(comentarioDudaExistencial);
        postDora.addComment(comentarioDora);
        deportes.addComment(comentarioDeportes);
        postCama.addComment(comentarioCama);
        postBaptisterio.addComment(comentarioBaptisterio);

        Comments comentarioLeon = new Comments(nuria,"Gran obra maestra");
        Comments comentarioDescartes = new Comments(nuria, "Buena reflexión del día");
        Comments comentarioPenedo = new Comments(ana, "El mejor cuadro que vi en mi vida");
        Comments comentarioBarco = new Comments(ana, "¡Que mareo!");
        Comments comentarioBosque = new Comments(adrian,"Bosque encantado? eso no se lo cree nadie");
        Comments comentarioDudaExistencial = new Comments(adrian, "No, por que si es así, no sera así, por lo que al no ser así quiere decir que sera así");
        Comments comentarioDora = new Comments(anton,"Es preciosa!!");
        Comments comentarioDeportes = new Comments(anton,"No tienes ni idea, Casemiro es Top!");
        Comments comentarioCama = new Comments( isaura ,"Wow increíble, me encanta tu contenido!");
        Comments comentarioBaptisterio = new Comments(isaura, "Estoy fascinada con tanta belleza <3");

        ana.addPost(postLeon);
        ana.addPost(descartes);
        adrian.addPost(postPenedo);
        adrian.addPost(postBarco);
        anton.addPost(postBosque);
        anton.addPost(dudaExistencial);
        isaura.addPost(postDora);
        isaura.addPost(deportes);
        nuria.addPost(postCama);
        nuria.addPost(postBaptisterio);
        */

    }

}
