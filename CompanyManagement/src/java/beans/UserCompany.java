package beans;

public class UserCompany {

    private int id;
    private int idUser;
    private int idCompany;

    public UserCompany() {
    }

    public UserCompany(int id, int idUser, int idCompany) {
        this.id = id;
        this.idUser = idUser;
        this.idCompany = idCompany;
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

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

}
