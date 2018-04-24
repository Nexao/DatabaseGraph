
import com.mycompany.connectiontest.DBConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emil
 */
public class Runner {
    
    
    public static void main(String[] args) throws Exception {
        DBConnection con = new DBConnection();
        ConnectionTest word = new ConnectionTest(con);
        word.getAll();
//        word.getAllPersonsDepthOne("");
//        word.getAllPersonsDepthTwo("");
//        word.getAllPersonsDepthThree("");
//        word.getAllPersonsDepthFour("");
//        word.getAllPersonsDepthFive("");
    }
}
