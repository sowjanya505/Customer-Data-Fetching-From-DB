package new_project;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
 
@SuppressWarnings("unused")
@Controller
public class CustomerController {
 
    @Autowired
    CustomerService customerService;
 
    @RequestMapping("/welcome")
    public ModelAndView firstPage() {
        return new ModelAndView("welcome");
    }
 
    @RequestMapping(value = "/getCustomer",method = RequestMethod.GET)
    public @ResponseBody Customer getCustomer(@RequestParam String customerId,
            @RequestParam String password) {
        Customer customer = customerService.getCustomerById(customerId);
        return customer;
    }

 
}