package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableLayout {
    public static void display(String title){
        Stage window=new Stage();
        window.setTitle(title);

        TableColumn<Product,String> nameColumn=new TableColumn("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product,String> priceColumn=new TableColumn("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product,String> quantityColumn=new TableColumn("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableView<Product> tableView;

        tableView=new TableView<>();
        tableView.setItems(getObservableList());
        tableView.getColumns().addAll(nameColumn,priceColumn,quantityColumn);

        VBox vBox=new VBox();
        vBox.getChildren().addAll(tableView);

        Scene scene=new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public static ObservableList<Product> getObservableList(){

        ObservableList<Product> products= FXCollections.observableArrayList();

        products.add(new Product("A",1,2));
        products.add(new Product("B",3,4));
        products.add(new Product("C",5,6));

        return products;
    }
}
