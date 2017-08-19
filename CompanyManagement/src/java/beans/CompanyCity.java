package beans;

public class CompanyCity {

    private int id;
    private int idCompany;
    private int idCity;

    public CompanyCity() {
    }

    public CompanyCity(int id, int idCompany, int idCity) {
        this.id = id;
        this.idCompany = idCompany;
        this.idCity = idCity;
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

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

}
