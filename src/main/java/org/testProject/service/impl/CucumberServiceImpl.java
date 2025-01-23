package org.testProject.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import org.testProject.model.Cucumber;
import org.testProject.service.CucumberService;

import java.util.List;
import java.util.stream.Stream;

@ApplicationScoped
public class CucumberServiceImpl implements CucumberService {
    @Override
    public List<Cucumber> getCucumbers(int quantity) {
        return Stream.generate(Cucumber::new).limit(quantity).toList();
    }
}
