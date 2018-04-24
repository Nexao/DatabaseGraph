
import com.mycompany.connectiontest.Person;
import java.util.List;

public interface IDataAccessor {

    public List<Person> getAllPersonsDepthOne(String name);

    public List<Person> getAllPersonsDepthTwo(String name);

    public List<Person> getAllPersonsDepthThree(String name);

    public List<Person> getAllPersonsDepthFour(String name);

    public List<Person> getAllPersonsDepthFive(String name);
}