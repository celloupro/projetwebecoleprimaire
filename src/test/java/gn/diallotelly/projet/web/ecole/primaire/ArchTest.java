package gn.diallotelly.projet.web.ecole.primaire;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("gn.diallotelly.projet.web.ecole.primaire");

        noClasses()
            .that()
            .resideInAnyPackage("gn.diallotelly.projet.web.ecole.primaire.service..")
            .or()
            .resideInAnyPackage("gn.diallotelly.projet.web.ecole.primaire.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..gn.diallotelly.projet.web.ecole.primaire.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
