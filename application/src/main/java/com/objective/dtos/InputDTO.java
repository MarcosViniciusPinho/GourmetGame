package com.objective.dtos;

import com.objective.domains.Node;

import javax.swing.*;

public class InputDTO {

    private final String menu;
    private final String dish;

    public InputDTO(Node node) {
        this.dish = JOptionPane.showInputDialog(null, "Qual prato você pensou?");
        this.menu = JOptionPane.showInputDialog(null, String.format("%s é  ______ mas %s não.", this.dish,
                node.getNext() != null ? node.getNext().getKey() : node.getKey()));
    }

    public String getMenu() {
        return menu;
    }

    public String getDish() {
        return dish;
    }
}