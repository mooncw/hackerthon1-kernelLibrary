package kernel.hackerthon.library.controller;

import kernel.hackerthon.library.dto.JoinRequest;
import kernel.hackerthon.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @GetMapping("/join")
    public String showJoinForm(JoinRequest joinRequest) { return "joinForm"; }

    @PostMapping("/join")
    public String join(JoinRequest joinRequest) {
        userService.join(joinRequest);
        return "redirect:/books";
    }

}
