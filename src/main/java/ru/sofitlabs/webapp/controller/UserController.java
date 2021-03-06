package ru.sofitlabs.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.sofitlabs.webapp.data.animebase.AnimeEntityService;
import ru.sofitlabs.webapp.data.animebase.CommentsEntity;
import ru.sofitlabs.webapp.data.animebase.CommentsEntityService;
import ru.sofitlabs.webapp.data.user.UserEntity;
import ru.sofitlabs.webapp.data.user.UserEntityService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@SessionAttributes(value = "user")
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserEntityService userEntityService;

    @Autowired
    CommentsEntityService commentsEntityService;

    @Autowired
    AnimeEntityService animeEntityService;

    @RequestMapping(value = "/comments", method = GET)
    @ResponseBody
    public List<CommentsEntity> getUserComments(HttpServletRequest request) {
        return commentsEntityService.getAllByUser((UserEntity) request.getSession().getAttribute("user"));
    }

}
