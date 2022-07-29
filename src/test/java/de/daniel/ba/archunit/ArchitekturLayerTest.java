package de.daniel.ba.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses
public class ArchitekturLayerTest {

    @ArchTest
    public static final ArchRule layeredArchitectureCheck = layeredArchitecture()
            .consideringAllDependencies()
            .layer("controller").definedBy("..controller..")
            .layer("services").definedBy("..services..")
            .layer("persistence").definedBy("..persistence..")
            .whereLayer("controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("services").mayOnlyBeAccessedByLayers("controller")
            .whereLayer("persistence").mayOnlyBeAccessedByLayers("services");
}

