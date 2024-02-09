package org.project.View;

import org.project.Model.Edition.Edition;

public interface FactoryEdition {
    Edition create(ConsoleUI consoleUI);
    String description();
}
