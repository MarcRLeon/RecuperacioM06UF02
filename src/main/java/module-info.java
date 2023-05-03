module dam2.recuperaciom06uf2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;
    
    opens dam2.recuperaciom06uf2 to javafx.fxml;
    
    exports dam2.recuperaciom06uf2;
    
}
