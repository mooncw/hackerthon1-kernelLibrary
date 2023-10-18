package kernel.hackerthon.library.service;

import jakarta.servlet.http.HttpSession;
import kernel.hackerthon.library.domain.User;
import kernel.hackerthon.library.dto.JoinRequest;
import kernel.hackerthon.library.dto.LoginRequest;
import kernel.hackerthon.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public void join(JoinRequest joinRequest) { userRepository.save(joinRequest.toEntity()); }

    public void saveSession(LoginRequest loginRequest, HttpSession session) {
        User findUser = findByUser(loginRequest);
        session.setAttribute("loginUser", findUser.getId());
    }

    public Long loginCheck(LoginRequest loginRequest) {
        User findUser = findByUser(loginRequest);
        return findUser.getId();
    }

    private User findByUser(LoginRequest loginRequest) {
        return userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword())
                .orElseThrow(() -> new IllegalArgumentException("존재하는 회원이 없음"));
    }

    public void logout(HttpSession session) {
        session.invalidate(); // session 초기화
    }
}
