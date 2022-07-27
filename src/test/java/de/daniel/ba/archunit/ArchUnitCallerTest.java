package de.daniel.ba.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses
public class ArchUnitCallerTest {

    @ArchTest
    public static final ArchRule no_classes_should_call_XXX_method_from_XXXXX_class = noClasses().should().callMethod(INotAllowedCall.class, "notAllowed");


}
