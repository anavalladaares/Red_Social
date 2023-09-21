package es.imatia.redsocial;
import java.util.List;

public class Users {

    private String username;
    private String name;
    private String surname;
    private List<Users> userList;
    private List<Posts> postList;

    //Constructor
    public Users(String name, String surname, String username, List<Users> userList, List<Posts> postList) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.userList = userList;
        this.postList = postList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return this.username;
    }
    public void setUserName(String username) {
        this.username = username;
    }

    public List<Users> getUserList() {
        return userList;
    }
    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

    public List<Posts> getPostList() {
        return postList;
    }
    public void setPostList(List<Posts> postList) {
        this.postList = postList;
    }

    //Comenzar a seguir un usuario
    public void follow(Users users) {
        if (this.getUserList().size() != 0) {
            for(Users u: this.getUserList()) {
                if(u.getUserName().equals(users.getUserName())){
                    System.out.println("You already follow this user");
                } else {
                    this.getUserList().add(users);
                    System.out.println(this.getUserName() + " is now following " + users.getUserName());
                    break;
                }
            }
        } else {
            userList.add(users);
            System.out.println(this.username + " is now following " + users.getUserName());
        }
    }

    //Dejar de seguir a un usuario
    public void unfollow(Users users) {
        if(this.getUserList().size() != 0) {
            for(Users u: this.getUserList()) {
                if(u.getUserName().equals(users.getUserName())){
                    this.getUserList().remove(users);
                    System.out.println(this.username + " no longer follows " + users.getUserName()); //lo deja de seguir
                    break;
                } else {
                    System.out.println(this.username + " does not follow " + users.getUserName()); //no lo seguía"
                }
            }
        } else {
            System.out.println(this.username + " does not follow " + users.getUserName()); //no lo seguía"
        }
    }

    //Añadir un post
    public void addPost(Posts posts){
        postList.add(posts);
    }

    //Eliminar un post
    public void deletePost(Posts deletePost){
        postList.remove(deletePost);
    }

    //Listar todos los posts de un usuario
    public void listPosts() {
        System.out.println(this.username + " has posted the following posts: ");
        for(Posts p: getPostList()) {
            p.showPostsDetails();
        }
    }

    /*Queremos que liste los comentarios de cada post de un usuario concreto.
     * El método accederá a la lista de los post de un usuario y para cada post, imprimirá los comentarios que tenga*/
    public void listComments() {
        System.out.println("Posts published by " + this.username + ":");
        for (Posts p: this.getPostList()) {
            for (Comments c: p.getCommentsList()) {
                System.out.println("The author of the comment is: " + c.getUsername() + ".");
                System.out.println("Comment: " + c.getText() + ".");
            }
        }
    }
}