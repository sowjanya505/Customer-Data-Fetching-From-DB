package new_project;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
 
import new_project.CustomerDao;
import new_project.Customer;
 
@SuppressWarnings("unused")
@Repository
public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao{
    
    @Autowired 
    DataSource dataSource;
    
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
    
    
 
    @Override
    public Customer getCustomerById(String cusId) {
        String sql = "SELECT * FROM bank_acc WHERE user_id = ?";
        return (Customer)getJdbcTemplate().queryForObject(sql, new Object[]{cusId}, new RowMapper<Customer>(){
            @Override
            public Customer mapRow(ResultSet rs, int rwNumber) throws SQLException {
                Customer cus = new Customer();
                cus.setCusId(rs.getString("user_id"));
                cus.setCusName(rs.getString("acc_name"));
                cus.setCus_accnum(rs.getString("acc_num"));
                cus.setCus_accbal(rs.getString("acc_bal"));
                cus.setCus_balcur(rs.getString("acc_currency"));
                
                
                return cus;
            }
        });
    }
}

