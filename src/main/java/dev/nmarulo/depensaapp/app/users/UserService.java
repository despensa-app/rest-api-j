package dev.nmarulo.depensaapp.app.users;

import dev.nmarulo.depensaapp.app.users.dtos.FindByIdUserRes;
import dev.nmarulo.depensaapp.commons.exception.NotFoundException;
import dev.nmarulo.depensaapp.commons.service.BasicServiceImp;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Getter
public class UserService extends BasicServiceImp {
    
    private final UserRepository userRepository;
    
    public FindByIdUserRes findById(Long id, User userToken) {
        var userId = id;
        
        if (!Objects.equals(userToken.getId(), id)) {
            userId = userToken.getId();
        }
        
        var findById = this.userRepository.findById(userId);
        
        if (findById.isEmpty()) {
            throw new NotFoundException(getLocalMessage().getMessage("error.record-not-exist"));
        }
        
        return UserMapper.toFindByIdUserRes(findById.get());
    }
    
}
