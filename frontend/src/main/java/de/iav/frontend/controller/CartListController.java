package de.iav.frontend.controller;

import de.iav.frontend.model.Bag;
import de.iav.frontend.model.User;
import de.iav.frontend.service.BagService;
import de.iav.frontend.service.UserService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartListController {
 

    public Button Buy;
    public ListView listBags;
    public Label TotalLabel;
    public Label NameLabel;
    public Button removeButton;
    public String email;
    private final UserService userService = new UserService();
    private final BagService bagService = new BagService();
    public void BuyButtonPressed(ActionEvent actionEvent) {
        User oldUser = userService.getUserByEmail(email);
        List<Bag> listOfBags = oldUser.listOfBags();

        listOfBags.clear();
        List<Bag> listOfBagsUpdated = listOfBags;
        User newUser = new User(oldUser.id(), oldUser.userName(), oldUser.email(), oldUser.password(),oldUser.role(), listOfBagsUpdated);
        System.out.println(newUser);
        userService.updateUser(newUser);
        listBags.getItems().clear();

    }

    public void RemoveButtonPressed(ActionEvent actionEvent) {
        // Get the selected item from the list view
        final int selectedIdx = listBags.getSelectionModel().getSelectedIndex();
        if (selectedIdx != -1) {
            Object itemToRemove = listBags.getSelectionModel().getSelectedItem();

            final int newSelectedIdx =
                    (selectedIdx == listBags.getItems().size() - 1)
                            ? selectedIdx - 1
                            : selectedIdx;

            listBags.getItems().remove(selectedIdx);

            listBags.getSelectionModel().select(newSelectedIdx);
        }
    }


    public void TotalButtonPressed(ActionEvent actionEvent) {
        ObservableList items = listBags.getItems();
        int totalPrice = 0;
        for (Object item : items) {
            String itemString = item.toString(); // Assuming the output of item's toString method is as mentioned
            Pattern pattern = Pattern.compile("price=(\\d+)");
            Matcher matcher = pattern.matcher(itemString);
            if (matcher.find()) {
                int price = Integer.parseInt(matcher.group(1));
                totalPrice += price;
            }
        }
        TotalLabel.setText(String.valueOf(totalPrice));
    }
}
