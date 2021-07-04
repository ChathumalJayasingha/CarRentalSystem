package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Override
    public void addUser(UserDTO dto) {
        if (!userRepo.existsById(dto.getUserId())) {
            userRepo.save(modelMapper.map(dto, User.class));
        } else {
            throw new ValidateException(dto.getUserId()+" user is already Exist in this Database");
        }
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (userRepo.existsById(dto.getUserId())) {
            userRepo.save(modelMapper.map(dto, User.class));
        } else {
            throw new ValidateException(dto.getUserId()+" <- This user Not Found for update in this database");
        }
    }

    @Override
    public void deleteUser(String id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new ValidateException(id+" <- This user cant delete in this database");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return modelMapper.map(userRepo.findAll(), new TypeToken<List<UserDTO>>(){}.getType());

    }

    @Override
    public UserDTO searchUser(String id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDTO.class);
        } else {
            throw new ValidateException(id+" <- This user Not Found in this database");
        }
    }
}
