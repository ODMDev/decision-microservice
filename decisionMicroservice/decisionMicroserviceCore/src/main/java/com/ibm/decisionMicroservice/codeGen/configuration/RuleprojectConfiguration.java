package com.ibm.decisionMicroservice.codeGen.configuration;

import com.ibm.decisionMicroservice.codeGen.GeneratorOptions;
import com.ibm.decisionMicroservice.codeGen.processor.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RuleprojectConfiguration implements Configuration {
    @Override
    public boolean isCorrect(GeneratorOptions options) {
        return options.getXomJarPath() != null
                && options.getRuleAppProjectPath() != null
                && options.getRuleAppDeploymentName() != null
                && options.getRuleSetPath() != null;
    }

    @Override
    public List<Processor> getProcessors() {
        return new ArrayList<>(Arrays.asList(
                new RuleProjectProcessor(),
                new RulesetExtractionProcessor(),
                new RuleappBuilderProcessor()
        ));
    }

    @Override
    public String name() {
        return "Rule project configuration";
    }
}
