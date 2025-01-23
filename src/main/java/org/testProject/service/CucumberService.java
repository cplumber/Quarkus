package org.testProject.service;

import org.testProject.model.Cucumber;

import java.util.List;

public interface CucumberService {
    List<Cucumber> getCucumbers(int quantity);
}
