package com.zsoft.cra.cucumber.stepdefs;

import com.zsoft.cra.CraApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = CraApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
