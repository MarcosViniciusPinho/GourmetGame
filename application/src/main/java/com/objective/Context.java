package com.objective;

import com.objective.config.Inject;
import com.objective.domains.Node;
import com.objective.dtos.InputDTO;
import com.objective.ports.inbound.NodeServicePort;

import javax.swing.*;

public class Context {

    private final NodeServicePort port;
    private final static String CHOCOLATE_CAKE = "Bolo de Chocolate";
    private final static String LASAGNA = "Lasagna";

    public Context() {
        this.port = Inject.getInstance(NodeServicePort.class);
    }

    private int getBuildConfirmDialog(String message) {
        return JOptionPane.showConfirmDialog(
                null,
                message,
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );
    }

    private void apply(Node node) {
        var result = this.getBuildConfirmDialog(
                String.format("O prato que você pensou é %s?", node.getKey())
        );
        if (result == JOptionPane.YES_OPTION) {
            var element = node.getNext();
            if(element != null) {
                this.apply(element);
            } else {
                JOptionPane.showMessageDialog(null, "Acertei de novo!");
            }
        } else if (result == JOptionPane.NO_OPTION) {
            var input = new InputDTO(node);
            this.port.add(new Node(input.getMenu(), input.getDish()));
        }
    }

    public void init() {
        var result = this.getBuildConfirmDialog(
                "O prato que você pensou é massa?"
        );
        if(result == JOptionPane.YES_OPTION
                || result == JOptionPane.NO_OPTION) {
            var node = this.port.get();
            if(node.isPresent()) {
                this.apply(node.get());
            } else {
                var defaultElement = result == JOptionPane.YES_OPTION ? LASAGNA : CHOCOLATE_CAKE;
                this.apply(new Node(defaultElement));
            }
        }
    }

}