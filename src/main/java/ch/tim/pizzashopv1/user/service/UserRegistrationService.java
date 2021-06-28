package ch.tim.pizzashopv1.user.service;

import ch.tim.pizzashopv1.common.dto.SearchPaginationResult;
import ch.tim.pizzashopv1.user.to.UserDTO;

public interface UserRegistrationService {
    UserDTO registerUser(UserDTO userDTO) ;

    SearchPaginationResult<UserDTO> getUsers();
    SearchPaginationResult<UserDTO> getUserByCode(String userCode);
}
