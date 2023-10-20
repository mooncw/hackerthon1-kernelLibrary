package kernel.hackerthon.library.controller;

import jakarta.servlet.http.HttpSession;
import kernel.hackerthon.library.dto.JoinRequest;
import kernel.hackerthon.library.dto.LoginRequest;
import kernel.hackerthon.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final HttpSession httpSession;
    @GetMapping("/join")
    public String showJoinForm(JoinRequest joinRequest) { return "joinForm"; }

    @PostMapping("/join")
    public String join(JoinRequest joinRequest) {
        userService.join(joinRequest);
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping("/loginProcess")
    public String login( LoginRequest loginRequest) {
        userService.saveSession(loginRequest, httpSession);
        return "redirect:/books";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout(httpSession);
        return "redirect:/user/login";
    }

    @GetMapping("/noPermission")
    public String showNoPermission() {
        return "noPermission";
    }
}
