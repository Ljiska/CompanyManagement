package beans;

public class CompanyTeam {

    private int id;
    private int idCompany;
    private int idTeam;

    public CompanyTeam() {
    }

    public CompanyTeam(int id, int idCompany, int idTeam) {
        this.id = id;
        this.idCompany = idCompany;
        this.idTeam = idTeam;
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

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

}
