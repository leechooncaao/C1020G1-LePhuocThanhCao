package com.show_image.controller;

import com.show_image.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PhotoController {
    @Autowired
    private PhotoService photoService;


}
