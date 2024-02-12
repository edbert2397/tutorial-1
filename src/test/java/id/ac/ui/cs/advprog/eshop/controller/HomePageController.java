package id.ac.ui.cs.advprog.eshop.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MockitoExtension.class)
class HomepageControllerTest{

    @BeforeEach
    void setUp(){

    }

    @InjectMocks
    HomepageController homepageController;

    @Test
    void homePageReturnString(){
        String result = homepageController.homepage();
        assertEquals("Homepage",result);
    }
}

