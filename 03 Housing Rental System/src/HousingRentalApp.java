/*
New system launcher with GUI
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;

public class HousingRentalApp extends Application {

    private SystemService systemService = new SystemService(5);
    private ListView<String> listView = new ListView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Layout for the main window
        BorderPane root = new BorderPane();

        // ListView to show housing listings
        listView.setPrefHeight(200);
        listView.setItems(FXCollections.observableArrayList());

        // Buttons for various actions
        Button btnAdd = new Button("Add Listing");
        Button btnSearch = new Button("Search Listing");
        Button btnDelete = new Button("Delete Listing");
        Button btnUpdate = new Button("Update Listing");
        Button btnExit = new Button("Exit");

        // Event handlers for buttons
        btnAdd.setOnAction(e -> openAddWindow());
        btnSearch.setOnAction(e -> openSearchWindow());
        btnDelete.setOnAction(e -> openDeleteWindow());
        btnUpdate.setOnAction(e -> openUpdateWindow());
        btnExit.setOnAction(e -> primaryStage.close());

        // Layout for buttons
        VBox buttonsLayout = new VBox(10, btnAdd, btnSearch, btnDelete, btnUpdate, btnExit);
        root.setLeft(buttonsLayout);
        root.setCenter(listView);

        // Set the scene
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Housing Rental System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openAddWindow() {
        // Create and display a window for adding listings
        Stage addStage = new Stage();
        VBox addLayout = new VBox(10);

        TextField nameField = new TextField();
        nameField.setPromptText("Enter house name");

        TextField cityField = new TextField();
        cityField.setPromptText("Enter city");

        TextField rentField = new TextField();
        rentField.setPromptText("Enter rent amount");

        TextField statusField = new TextField();
        statusField.setPromptText("Enter status");

        Button addButton = new Button("Add Listing");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String city = cityField.getText();
            int rent = Integer.parseInt(rentField.getText());
            String status = statusField.getText();

            HousingDomain newHouse = new HousingDomain(0, name, city, rent, status);
            if (systemService.add(newHouse)) {
                listView.getItems().add(newHouse.toString());
            }
            addStage.close();
        });

        addLayout.getChildren().addAll(nameField, cityField, rentField, statusField, addButton);
        Scene addScene = new Scene(addLayout, 300, 200);
        addStage.setTitle("Add House Listing");
        addStage.setScene(addScene);
        addStage.show();
    }

    private void openSearchWindow() {
        // Create and display a window for searching listings
        Stage searchStage = new Stage();
        VBox searchLayout = new VBox(10);

        TextField idField = new TextField();
        idField.setPromptText("Enter listing ID to search");

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            int id = Integer.parseInt(idField.getText());
            HousingDomain house = systemService.houseInfo(id);
            if (house != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("House Information");
                alert.setHeaderText("Found House Listing");
                alert.setContentText(house.toString());
                alert.show();
            }
        });

        searchLayout.getChildren().addAll(idField, searchButton);
        Scene searchScene = new Scene(searchLayout, 300, 150);
        searchStage.setTitle("Search House Listing");
        searchStage.setScene(searchScene);
        searchStage.show();
    }

    private void openDeleteWindow() {
        // Create and display a window for deleting listings
        Stage deleteStage = new Stage();
        VBox deleteLayout = new VBox(10);

        TextField idField = new TextField();
        idField.setPromptText("Enter listing ID to delete");

        Button deleteButton = new Button("Delete Listing");
        deleteButton.setOnAction(e -> {
            int id = Integer.parseInt(idField.getText());
            if (systemService.del(id)) {
                listView.getItems().removeIf(item -> item.contains(String.valueOf(id)));
            }
            deleteStage.close();
        });

        deleteLayout.getChildren().addAll(idField, deleteButton);
        Scene deleteScene = new Scene(deleteLayout, 300, 150);
        deleteStage.setTitle("Delete House Listing");
        deleteStage.setScene(deleteScene);
        deleteStage.show();
    }

    private void openUpdateWindow() {
        // Create and display a window for updating listings
        Stage updateStage = new Stage();
        VBox updateLayout = new VBox(10);

        TextField idField = new TextField();
        idField.setPromptText("Enter listing ID to update");

        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            int id = Integer.parseInt(idField.getText());
            HousingDomain house = systemService.update(id);
            if (house != null) {
                // Set fields with existing data for the user to modify
                TextField nameField = new TextField(house.getName());
                TextField cityField = new TextField(house.getCity());
                TextField rentField = new TextField(String.valueOf(house.getRent()));
                TextField statusField = new TextField(house.getStatus());

                Button updateButton = new Button("Update Listing");
                updateButton.setOnAction(event -> {
                    house.setName(nameField.getText());
                    house.setCity(cityField.getText());
                    house.setRent(Integer.parseInt(rentField.getText()));
                    house.setStatus(statusField.getText());

                    listView.getItems().set(listView.getItems().indexOf(house.toString()), house.toString());
                    updateStage.close();
                });

                updateLayout.getChildren().addAll(nameField, cityField, rentField, statusField, updateButton);
                Scene updateScene = new Scene(updateLayout, 300, 200);
                updateStage.setTitle("Update House Listing");
                updateStage.setScene(updateScene);
                updateStage.show();
            }
        });

        updateLayout.getChildren().addAll(idField, searchButton);
        Scene updateScene = new Scene(updateLayout, 300, 150);
        updateStage.setTitle("Update House Listing");
        updateStage.setScene(updateScene);
        updateStage.show();
    }
}
