package beans;

public class UserPosition {

    private int id;
    private int idUser;
    private int idPosition;

    public UserPosition() {
    }

    public UserPosition(int id, int idUser, int idPosition) {
        this.id = id;
        this.idUser = idUser;
        this.idPosition = idPosition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

}
