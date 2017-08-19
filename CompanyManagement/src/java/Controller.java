
import beans.*;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import db.*;

@SessionScoped
@ManagedBean
public class Controller implements Serializable {

    private String username;
    private String password;
    
    public String msg = "";

    private User user = new User();
    private User newUser = new User();
    private ArrayList<User> users = new ArrayList<User>();
    private City city = new City();
    private City newCity = new City();
    private ArrayList<City> cities = new ArrayList<City>();
    private Company company = new Company();
    private Company newCompany = new Company();
    private ArrayList<Company> companies = new ArrayList<Company>();
    private Position position = new Position();
    private Position newPosition = new Position();
    private ArrayList<Position> positions = new ArrayList<Position>();
    private Team team = new Team();
    private Team newTeam = new Team();
    private ArrayList<Team> teams = new ArrayList<Team>();
    private CompanyCity companyCity = new CompanyCity();
    private CompanyCity newCompanyCity = new CompanyCity();
    private ArrayList<CompanyCity> companyCities = new ArrayList<CompanyCity>();
    private CompanyTeam companyTeam = new CompanyTeam();
    private CompanyTeam newCompanyTeam = new CompanyTeam();
    private ArrayList<CompanyTeam> companyTeams = new ArrayList<CompanyTeam>();
    private UserCompany userCompany = new UserCompany();
    private UserCompany newUserCompany = new UserCompany();
    private ArrayList<UserCompany> userCompanies = new ArrayList<UserCompany>();
    private UserPosition userPosition = new UserPosition();
    private UserPosition newUserPosition = new UserPosition();
    private ArrayList<UserPosition> userPositions = new ArrayList<UserPosition>();
    private UserSalary userSalary = new UserSalary();
    private UserSalary newUserSalary = new UserSalary();
    private ArrayList<UserSalary> userSalaries = new ArrayList<UserSalary>();
    private UserTeam userTeam = new UserTeam();
    private UserTeam newUserTeam = new UserTeam();
    private ArrayList<UserTeam> userTeams = new ArrayList<UserTeam>();
    private OpenPosition openPosition = new OpenPosition();
    private OpenPosition newOpenPosition = new OpenPosition();
    private ArrayList<OpenPosition> openPositions = new ArrayList<OpenPosition>();
    private CompanyOpenPosition companyOpenPosition = new CompanyOpenPosition();
    private CompanyOpenPosition newCompanyOpenPosition = new CompanyOpenPosition();
    private ArrayList<CompanyOpenPosition> companyOpenPositions = new ArrayList<CompanyOpenPosition>();
    
    public Controller() {
        initUsers();
        initCities();
        initCompanies();
        initPositions();
        initTeams();
        initCompanyCities();
        initCompanyTeams();
        initUserCompanies();
        initUserPositions();
        initUserSalaries();
        initUserTeams();
        initOpenPositions();
        initCompanyOpenPositions();
    }

    private void initUsers() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DB.getInstance().getConnection();
            stmt = con.createStatement();
            String querry = "SELECT * FROM user;";
            rs = stmt.executeQuery(querry);
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String address = rs.getString("address");
                Date dateOfBirth = rs.getDate("dateOfBirth");
                String email = rs.getString("email");
                String type = rs.getString("type");

                user = new User(id, username, password, name, surname, address, dateOfBirth, email, type);

                users.add(user);
            }
            user = new User();
            con.close();
        } catch (SQLException ex) {
        } finally {
            DB.getInstance().putConnection(con);
        }
    }

    private void initCities() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DB.getInstance().getConnection();
            stmt = con.createStatement();
            String querry = "SELECT * FROM city;";
            rs = stmt.executeQuery(querry);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                city = new City(id, name);

                cities.add(city);
            }
            city = new City();
        } catch (SQLException ex) {
        } finally {
            DB.getInstance().putConnection(con);
        }
    }

    private void initCompanies() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DB.getInstance().getConnection();
            stmt = con.createStatement();
            String querry = "SELECT * FROM company;";
            rs = stmt.executeQuery(querry);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                company = new Company(id, name);

                companies.add(company);
            }
            company = new Company();
        } catch (SQLException ex) {
        } finally {
            DB.getInstance().putConnection(con);
        }
    }

    private void initPositions() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DB.getInstance().getConnection();
            stmt = con.createStatement();
            String querry = "SELECT * FROM position;";
            rs = stmt.executeQuery(querry);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                position = new Position(id, name);

                positions.add(position);
            }
            position = new Position();
        } catch (SQLException ex) {
        } finally {
            DB.getInstance().putConnection(con);
        }
    }

    private void initTeams() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DB.getInstance().getConnection();
            stmt = con.createStatement();
            String querry = "SELECT * FROM team;";
            rs = stmt.executeQuery(querry);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                team = new Team(id, name);

                teams.add(team);
            }
            team = new Team();
        } catch (SQLException ex) {
        } finally {
            DB.getInstance().putConnection(con);
        }
    }

    private void initCompanyCities() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DB.getInstance().getConnection();
            stmt = con.createStatement();
            String querry = "SELECT * FROM companycity;";
            rs = stmt.executeQuery(querry);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idCompany = rs.getInt("idCompany");
                int idCity = rs.getInt("idCity");

                companyCity = new CompanyCity(id, idCompany, idCity);

                companyCities.add(companyCity);
            }
            companyCity = new CompanyCity();
        } catch (SQLException ex) {
        } finally {
            DB.getInstance().putConnection(con);
        }
    }

    private void initCompanyTeams() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DB.getInstance().getConnection();
            stmt = con.createStatement();
            String querry = "SELECT * FROM companyteam;";
            rs = stmt.executeQuery(querry);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idCompany = rs.getInt("idCompany");
                int idTeam = rs.getInt("idTeam");

                companyTeam = new CompanyTeam(id, idCompany, idTeam);

                companyTeams.add(companyTeam);
            }
            companyTeam = new CompanyTeam();
        } catch (SQLException ex) {
        } finally {
            DB.getInstance().putConnection(con);
        }
    }

    private void initUserCompanies() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DB.getInstance().getConnection();
            stmt = con.createStatement();
            String querry = "SELECT * FROM usercompany;";
            rs = stmt.executeQuery(querry);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idUser = rs.getInt("idUser");
                int idCompany = rs.getInt("idCompany");

                userCompany = new UserCompany(id, idUser, idCompany);

                userCompanies.add(userCompany);
            }
            userCompany = new UserCompany();
        } catch (SQLException ex) {
        } finally {
            DB.getInstance().putConnection(con);
        }
    }

    private void initUserPositions() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DB.getInstance().getConnection();
            stmt = con.createStatement();
            String querry = "SELECT * FROM userposition;";
            rs = stmt.executeQuery(querry);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idUser = rs.getInt("idUser");
                int idPosition = rs.getInt("idPosition");

                userPosition = new UserPosition(id, idUser, idPosition);

                userPositions.add(userPosition);
            }
            userPosition = new UserPosition();
        } catch (SQLException ex) {
        } finally {
            DB.getInstance().putConnection(con);
        }
    }

    private void initUserSalaries() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DB.getInstance().getConnection();
            stmt = con.createStatement();
            String querry = "SELECT * FROM usersalary;";
            rs = stmt.executeQuery(querry);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idUser = rs.getInt("idUser");
                int idSalary = rs.getInt("idSalary");

                userSalary = new UserSalary(id, idUser, idSalary);

                userSalaries.add(userSalary);
            }
            userSalary = new UserSalary();
        } catch (SQLException ex) {
        } finally {
            DB.getInstance().putConnection(con);
        }
    }

    private void initUserTeams() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DB.getInstance().getConnection();
            stmt = con.createStatement();
            String querry = "SELECT * FROM userteams;";
            rs = stmt.executeQuery(querry);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idUser = rs.getInt("idUser");
                int idTeam = rs.getInt("idTeam");

                userTeam = new UserTeam(id, idUser, idTeam);

                userTeams.add(userTeam);
            }
            userTeam = new UserTeam();
        } catch (SQLException ex) {
        } finally {
            DB.getInstance().putConnection(con);
        }
    }

    private void initOpenPositions() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DB.getInstance().getConnection();
            stmt = con.createStatement();
            String querry = "SELECT * FROM openposition;";
            rs = stmt.executeQuery(querry);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");

                openPosition = new OpenPosition(id, name, description);

                openPositions.add(openPosition);
            }
            openPosition = new OpenPosition();
        } catch (SQLException ex) {
        } finally {
            DB.getInstance().putConnection(con);
        }
    }

    private void initCompanyOpenPositions() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = DB.getInstance().getConnection();
            stmt = con.createStatement();
            String querry = "SELECT * FROM companyopenposition;";
            rs = stmt.executeQuery(querry);
            while (rs.next()) {
                int id = rs.getInt("id");
                int idCompany = rs.getInt("idCompany");
                int idOpenPosition = rs.getInt("idOpenPosition");

                companyOpenPosition = new CompanyOpenPosition(id, idCompany, idOpenPosition);

                companyOpenPositions.add(companyOpenPosition);
            }
            companyOpenPosition = new CompanyOpenPosition();
        } catch (SQLException ex) {
        } finally {
            DB.getInstance().putConnection(con);
        }
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getNewCity() {
        return newCity;
    }

    public void setNewCity(City newCity) {
        this.newCity = newCity;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getNewCompany() {
        return newCompany;
    }

    public void setNewCompany(Company newCompany) {
        this.newCompany = newCompany;
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(ArrayList<Company> companies) {
        this.companies = companies;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getNewPosition() {
        return newPosition;
    }

    public void setNewPosition(Position newPosition) {
        this.newPosition = newPosition;
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public void setPositions(ArrayList<Position> positions) {
        this.positions = positions;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getNewTeam() {
        return newTeam;
    }

    public void setNewTeam(Team newTeam) {
        this.newTeam = newTeam;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public CompanyCity getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(CompanyCity companyCity) {
        this.companyCity = companyCity;
    }

    public CompanyCity getNewCompanyCity() {
        return newCompanyCity;
    }

    public void setNewCompanyCity(CompanyCity newCompanyCity) {
        this.newCompanyCity = newCompanyCity;
    }

    public ArrayList<CompanyCity> getCompanyCities() {
        return companyCities;
    }

    public void setCompanyCities(ArrayList<CompanyCity> companyCities) {
        this.companyCities = companyCities;
    }

    public CompanyTeam getCompanyTeam() {
        return companyTeam;
    }

    public void setCompanyTeam(CompanyTeam companyTeam) {
        this.companyTeam = companyTeam;
    }

    public CompanyTeam getNewCompanyTeam() {
        return newCompanyTeam;
    }

    public void setNewCompanyTeam(CompanyTeam newCompanyTeam) {
        this.newCompanyTeam = newCompanyTeam;
    }

    public ArrayList<CompanyTeam> getCompanyTeams() {
        return companyTeams;
    }

    public void setCompanyTeams(ArrayList<CompanyTeam> companyTeams) {
        this.companyTeams = companyTeams;
    }

    public UserCompany getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(UserCompany userCompany) {
        this.userCompany = userCompany;
    }

    public UserCompany getNewUserCompany() {
        return newUserCompany;
    }

    public void setNewUserCompany(UserCompany newUserCompany) {
        this.newUserCompany = newUserCompany;
    }

    public ArrayList<UserCompany> getUserCompanies() {
        return userCompanies;
    }

    public void setUserCompanies(ArrayList<UserCompany> userCompanies) {
        this.userCompanies = userCompanies;
    }

    public UserPosition getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(UserPosition userPosition) {
        this.userPosition = userPosition;
    }

    public UserPosition getNewUserPosition() {
        return newUserPosition;
    }

    public void setNewUserPosition(UserPosition newUserPosition) {
        this.newUserPosition = newUserPosition;
    }

    public ArrayList<UserPosition> getUserPositions() {
        return userPositions;
    }

    public void setUserPositions(ArrayList<UserPosition> userPositions) {
        this.userPositions = userPositions;
    }

    public UserSalary getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(UserSalary userSalary) {
        this.userSalary = userSalary;
    }

    public UserSalary getNewUserSalary() {
        return newUserSalary;
    }

    public void setNewUserSalary(UserSalary newUserSalary) {
        this.newUserSalary = newUserSalary;
    }

    public ArrayList<UserSalary> getUserSalaries() {
        return userSalaries;
    }

    public void setUserSalaries(ArrayList<UserSalary> userSalaries) {
        this.userSalaries = userSalaries;
    }

    public UserTeam getUserTeam() {
        return userTeam;
    }

    public void setUserTeam(UserTeam userTeam) {
        this.userTeam = userTeam;
    }

    public UserTeam getNewUserTeam() {
        return newUserTeam;
    }

    public void setNewUserTeam(UserTeam newUserTeam) {
        this.newUserTeam = newUserTeam;
    }

    public ArrayList<UserTeam> getUserTeams() {
        return userTeams;
    }

    public void setUserTeams(ArrayList<UserTeam> userTeams) {
        this.userTeams = userTeams;
    }

    public OpenPosition getOpenPosition() {
        return openPosition;
    }

    public void setOpenPosition(OpenPosition openPosition) {
        this.openPosition = openPosition;
    }

    public OpenPosition getNewOpenPosition() {
        return newOpenPosition;
    }

    public void setNewOpenPosition(OpenPosition newOpenPosition) {
        this.newOpenPosition = newOpenPosition;
    }

    public ArrayList<OpenPosition> getOpenPositions() {
        return openPositions;
    }

    public void setOpenPositions(ArrayList<OpenPosition> openPositions) {
        this.openPositions = openPositions;
    }

    public CompanyOpenPosition getCompanyOpenPosition() {
        return companyOpenPosition;
    }

    public void setCompanyOpenPosition(CompanyOpenPosition companyOpenPosition) {
        this.companyOpenPosition = companyOpenPosition;
    }

    public CompanyOpenPosition getNewCompanyOpenPosition() {
        return newCompanyOpenPosition;
    }

    public void setNewCompanyOpenPosition(CompanyOpenPosition newCompanyOpenPosition) {
        this.newCompanyOpenPosition = newCompanyOpenPosition;
    }

    public ArrayList<CompanyOpenPosition> getCompanyOpenPositions() {
        return companyOpenPositions;
    }

    public void setCompanyOpenPositions(ArrayList<CompanyOpenPosition> companyOpenPositions) {
        this.companyOpenPositions = companyOpenPositions;
    }

    
}
