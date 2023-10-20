package kernel.hackerthon.library.controller;

import kernel.hackerthon.library.dto.LoginRequest;
import kernel.hackerthon.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginRestController {
    private final UserService userService;

    @PostMapping("/user/loginCheck")
    public ResponseEntity<Long> loginCheck(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.loginCheck(loginRequest));
    }
}
