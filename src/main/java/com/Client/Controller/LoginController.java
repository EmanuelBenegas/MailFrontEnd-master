package com.Client.Controller;

import com.Client.Response.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Usuario on 19/02/2018.
 */
@Controller
@SessionAttributes("user")
@RequestMapping(value = "/login")
public class LoginController {
    static String uri = "http://localhost:8090/api-mail/login";
    static String uriRegister = "http://localhost:8090/api-mail/register";

    @ModelAttribute("user")
    @RequestMapping(value = "")
    public ModelAndView login(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return new ModelAndView("/login", "user-entity", user);
    }

    @RequestMapping(value = "/iniciar", method = RequestMethod.POST)
    public String iniciar(@ModelAttribute User user,  Model model) throws IOException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("nombreUsuario", user.getNombreUsuario())
                .queryParam("password", user.getPassword());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.POST,
                null,
                String.class);

        if(response.getStatusCode() == HttpStatus.OK){
            ObjectMapper mapper = new ObjectMapper();
            user = mapper.readValue(response.getBody(), User.class);

            model.addAttribute("user", user);
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }

}
