package de.daniel.ba.archunit;

import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.daniel.ba.archunit.services.DTO;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

public class MusterspracheTest {

    @ArchTest
    public static final ArchRule all_Services_should_be_called_Service =
            classes().that()
                    .areAnnotatedWith(Service.class).should()
                    .haveSimpleNameContaining("Service");

    @ArchTest
    public static ArchRule all_API_methods_in_Service_layer_should_return_DTO =
            methods().that().areDeclaredInClassesThat().resideInAPackage("..services..")
                    .and().arePublic().should().haveRawReturnType(DTO.class)
                    .because("We use DT0s for decoupling the Service-Layer.");


}
