package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.dto.ReturnDTO;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.entity.Returns;
import lk.ijse.spring.repo.OrdersRepo;
import lk.ijse.spring.repo.ReturnsRepo;
import lk.ijse.spring.service.ReturnService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnsRepo returnsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrdersRepo ordersRepo;

    @Override
    public void addReturn(ReturnDTO dto) {
        if (!returnsRepo.existsById(dto.getOrderReturnId())) {
            Optional<Orders> byId = ordersRepo.findById(dto.getOrdersDTO().getOrderId());
            dto.setOrdersDTO(modelMapper.map(byId.get(), OrdersDTO.class));
            returnsRepo.save(modelMapper.map(dto, Returns.class));
        }
    }

    @Override
    public void updateReturn(ReturnDTO dto) {

    }

    @Override
    public void deleteReturn(String id) {

    }

    @Override
    public List<ReturnDTO> getAllReturns() {
        return modelMapper.map(returnsRepo.findAll(), new TypeToken<List<ReturnDTO>>(){}.getType());
    }

    @Override
    public ReturnDTO searchReturn(String id) {
        return null;
    }
}
