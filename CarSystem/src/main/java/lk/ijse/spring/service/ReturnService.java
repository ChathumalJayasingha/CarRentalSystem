package lk.ijse.spring.service;

import lk.ijse.spring.dto.ReturnDTO;

import java.util.List;

public interface ReturnService {
    void addReturn(ReturnDTO dto);
    void updateReturn(ReturnDTO dto);
    void deleteReturn(String id);
    List<ReturnDTO> getAllReturns();
    ReturnDTO searchReturn(String id);
}
