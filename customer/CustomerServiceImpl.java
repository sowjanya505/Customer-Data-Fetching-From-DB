package new_project;
 
import java.util.List;
import new_project.CustomerDao;
import new_project.Customer;
import new_project.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

@Service
public class CustomerServiceImpl implements CustomerService {
 
    @Autowired
    CustomerDao customerDao;    
    @Override
    public Customer getCustomerById(String cusId) {
        Customer customer = customerDao.getCustomerById(cusId);
        return customer;
    }
 
}




