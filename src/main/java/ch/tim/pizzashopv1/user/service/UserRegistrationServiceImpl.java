package ch.tim.pizzashopv1.user.service;

import ch.tim.pizzashopv1.common.dto.SearchPaginationResult;
import ch.tim.pizzashopv1.user.dao.UserRepository;
import ch.tim.pizzashopv1.user.dao.UserRolesRepository;
import ch.tim.pizzashopv1.user.domain.User;
import ch.tim.pizzashopv1.user.domain.UserRoles;
import ch.tim.pizzashopv1.user.to.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public UserRegistrationServiceImpl(UserRepository userRepository,UserRolesRepository userRolesRepository,ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional()
    public UserDTO registerUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);

        //user.setUserRolesByCode(List.of(userRoles));
        userRepository.save(user);
        UserRoles userRoles = new UserRoles(user.getCode(),"USER");
        userRolesRepository.save(userRoles);
        return userDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public SearchPaginationResult<UserDTO> getUserByCode(String userCode) {
        Optional<User> userOptional = userRepository.findById(userCode);
        User user;
        SearchPaginationResult<UserDTO> result = null;
        if(userOptional.isPresent()){
            user = userOptional.get();
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            result = new SearchPaginationResult<>(1, List.of(userDTO));
        }

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public SearchPaginationResult<UserDTO> getUsers(){
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = userList.stream().map(this::mapToDTO).collect(Collectors.toList());
         return new SearchPaginationResult<>(userList.size(), userDTOList);

    }

    private UserDTO mapToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
