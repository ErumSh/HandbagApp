module de.iav.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires java.net.http;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires org.apache.logging.log4j;


    exports de.iav.frontend;



    opens de.iav.frontend.model to com.fasterxml.jackson.databind, com.fasterxml.jackson.datatype.jsr310;
    opens de.iav.frontend.service to com.fasterxml.jackson.databind, com.fasterxml.jackson.datatype.jsr310;
    opens de.iav.frontend.controller to com.fasterxml.jackson.databind, com.fasterxml.jackson.datatype.jsr310;
    exports de.iav.frontend.controller;
    exports de.iav.frontend.service;
    exports de.iav.frontend.model;
    exports de.iav.frontend.security;
    opens de.iav.frontend to com.fasterxml.jackson.databind, com.fasterxml.jackson.datatype.jsr310, javafx.fxml;
    opens de.iav.frontend.security to com.fasterxml.jackson.databind, com.fasterxml.jackson.datatype.jsr310, javafx.fxml;
}