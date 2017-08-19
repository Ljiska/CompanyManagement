package beans;

public class UserSalary {

    private int id;
    private int amount;
    private int idUser;

    public UserSalary() {
    }

    public UserSalary(int id, int amount, int idUser) {
        this.id = id;
        this.amount = amount;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

}
