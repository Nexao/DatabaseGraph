

import com.mycompany.connectiontest.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mycompany.connectiontest.Person;
import java.util.List;

public class ConnectionTest implements IDataAccessor{
    private DBConnection dbCon;

    
    public ConnectionTest(DBConnection dbCon) {
        this.dbCon = dbCon;
    }

    public List<Person> getAll() {
        List<Person> list = new ArrayList();

        try {
            Connection connection = this.dbCon.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM database.person LIMIT 10;";
            ResultSet res = stmt.executeQuery(query);
            list = this.getResults(res);
        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthOne" + e.toString());
        }
        return list;
    }


    @Override
    public List<Person> getAllPersonsDepthOne(String name) {
        List<Person> list = new ArrayList();

        try {
            Connection connection = this.dbCon.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM database.person a JOIN  (select * FROM database.endorsement e JOIN database.person p ON e.source_node_id = p.id WHERE p.name='" + name + "') b ON a.id=b.target_node_id LIMIT 5;";
            ResultSet res = stmt.executeQuery(query);
            list = this.getResults(res);
        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthOne" + e.toString());
        }
        return list;
    }

    @Override
    public List<Person> getAllPersonsDepthTwo(String name) {
        List<Person> list = new ArrayList();
        try {
            Connection connection = this.dbCon.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM database.person WHERE id IN (SELECT target_node_id FROM database.endorsement WHERE source_node_id IN (SELECT target_node_id FROM database.endorsement e JOIN database.person p ON e.source_node_id = p.id WHERE p.name = '" + name + "')) LIMIT 5;";
            ResultSet res = stmt.executeQuery(query);
            list = this.getResults(res);
        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthTwo" + e.toString());
        }
        return list;
    }

    @Override
    public List<Person> getAllPersonsDepthThree(String name) {
        List<Person> list = new ArrayList();
        try {
            Connection connection = this.dbCon.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM database.person WHERE id IN (SELECT target_node_id FROM database.endorsement WHERE source_node_id IN (SELECT target_node_id FROM database.endorsement WHERE source_node_id IN (SELECT target_node_id FROM database.endorsement e JOIN database.person p ON e.source_node_id = p.id WHERE p.name = '"+name+"'))) LIMIT 5;";
            ResultSet res = stmt.executeQuery(query);
            list = this.getResults(res);
        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthThree" + e.toString());
        }
        return list;
    }

    @Override
    public List<Person> getAllPersonsDepthFour(String name) {
        List<Person> list = new ArrayList();
        try {
            Connection connection = this.dbCon.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM database.person WHERE id IN (SELECT target_node_id FROM database.endorsement WHERE source_node_id IN (SELECT target_node_id FROM database.endorsement WHERE source_node_id IN (SELECT target_node_id FROM database.endorsement WHERE source_node_id IN (SELECT target_node_id FROM database.endorsement e JOIN database.person p ON e.source_node_id = p.id WHERE p.name = '"+name+"')))) LIMIT 5;";
            ResultSet res = stmt.executeQuery(query);

            list = this.getResults(res);

        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthFour" + e.toString());
        }
        return list;
    }

    @Override
    public List<Person> getAllPersonsDepthFive(String name) {
        List<Person> list = new ArrayList();
        try {
            Connection connection = this.dbCon.getConnection();
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM database.person WHERE id IN (SELECT target_node_id FROM database.endorsement WHERE source_node_id IN (SELECT target_node_id FROM database.endorsement WHERE source_node_id IN (SELECT target_node_id FROM database.endorsement WHERE source_node_id IN (SELECT target_node_id FROM database.endorsement WHERE source_node_id IN (SELECT target_node_id FROM database.endorsement e JOIN database.person p ON e.source_node_id = p.id WHERE p.name = '"+name+"'))))) LIMIT 5;";
            ResultSet res = stmt.executeQuery(query);

            list = this.getResults(res);

        } catch (Exception e) {
            System.out.println("ERROR FOUND IN getAllPersonsDepthFive" + e.toString());
        }
        return list;
    }
    
    
    private List<Person> getResults(ResultSet res) throws SQLException {
        List<Person> list = new ArrayList();
        while (res.next()) {
                String id = res.getString("id");
                String name = res.getString("name");
                String job = res.getString("job");
                String bday = res.getString("birthday");
                Person p = new Person(id, name, job, bday);
                list.add(p);
            }
        return list;
    }

}