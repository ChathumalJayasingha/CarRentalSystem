package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addCustomer(CustomerDTO dto) {
        if (!customerRepo.existsById(dto.getCustomerNIC())) {
            customerRepo.save(modelMapper.map(dto, Customer.class));
        } else {
            throw new ValidateException(dto.getCustomerNIC()+" Customer is already Exist in this Database");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCustomerNIC())) {
            customerRepo.save(modelMapper.map(dto, Customer.class));
        } else {
            throw new ValidateException(dto.getCustomerNIC()+" <- This customer Not Found for update in this database");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        } else {
            throw new ValidateException(id+" <- This customer cant delete in this database");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return modelMapper.map(customerRepo.findAll(), new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            return modelMapper.map(customer.get(), CustomerDTO.class);
        } else {
            throw new ValidateException(id+" <- This customer Not Found in this database");
        }
    }
}
