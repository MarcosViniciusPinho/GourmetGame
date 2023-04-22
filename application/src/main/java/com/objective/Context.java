package com.objective;

import com.objective.domains.Node;
import com.objective.domains.Nodes;
import com.objective.dtos.InputDTO;

import javax.swing.*;

public class Context {

    private final Nodes nodes;
    private final static String CHOCOLATE_CAKE = "Bolo de Chocolate";

    public Context() {
        this.nodes = new Nodes();
    }

    private int getBuildConfirmDialog(String message) {
        return JOptionPane.showConfirmDialog(
                null,
                message,
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );
    }

    private void applyContextLasagna() {
        var result = this.getBuildConfirmDialog(
                "O prato que você pensou é Lasanha?"
        );
        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Acertei de novo!");
        } else if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Você clicou em Não. - Lasanha");
        }
    }

    private void applyContext(Node node) {
        var result = this.getBuildConfirmDialog(
                String.format("O prato que você pensou é %s?", node.getKey())
        );
        if (result == JOptionPane.YES_OPTION) {
            var element = node.getNext();
            if(element != null) {
                this.applyContext(element);
            } else {
                JOptionPane.showMessageDialog(null, "Acertei de novo!");
            }
        } else if (result == JOptionPane.NO_OPTION) {
            var input = new InputDTO(node);
            nodes.add(new Node(input.getMenu(), input.getDish()));
        }
    }

    public void init() {
        var result = this.getBuildConfirmDialog(
                "O prato que você pensou é massa?"
        );
        if (result == JOptionPane.YES_OPTION) {
            this.applyContextLasagna();
        } else if (result == JOptionPane.NO_OPTION) {
            var node = this.nodes.get();
            if(node.isPresent()) {
                this.applyContext(node.get());
            } else {
                this.applyContext(new Node(CHOCOLATE_CAKE));
            }
        }
    }

}