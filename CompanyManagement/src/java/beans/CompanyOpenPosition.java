package beans;

public class CompanyOpenPosition {

    private int id;
    private int idCompany;
    private int idOpenPosition;

    public CompanyOpenPosition() {
    }

    public CompanyOpenPosition(int id, int idCompany, int idOpenPosition) {
        this.id = id;
        this.idCompany = idCompany;
        this.idOpenPosition = idOpenPosition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public int getIdOpenPosition() {
        return idOpenPosition;
    }

    public void setIdOpenPosition(int idOpenPosition) {
        this.idOpenPosition = idOpenPosition;
    }

}
