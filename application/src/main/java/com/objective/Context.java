package com.objective;

import com.objective.domains.Node;

import javax.swing.*;

public class Context {

//    private final Map<String, String> map = new HashMap<>();
    private final Node node = new Node();
    private final static String CHOCOLATE_CAKE = "Bolo de Chocolate";

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

    private void applyContext(String name) {
        var result = this.getBuildConfirmDialog(
                String.format("O prato que você pensou é %s?", name)
        );
        if (result == JOptionPane.YES_OPTION) {
            var element = node.getAttribute(name);
            if(element != null) {
                this.applyContext((String) node.getAttribute(name));
            } else {
                JOptionPane.showMessageDialog(null, "Acertei de novo!");
            }
        } else if (result == JOptionPane.NO_OPTION) {
            String value = JOptionPane.showInputDialog(null, "Qual prato você pensou?");
            String key = JOptionPane.showInputDialog(null, String.format("%s é  ______ mas %s não.", value, name));
//            map.put(key, value);
            node.setAttribute(key, value);
        }
//        else if(result == JOptionPane.YES_OPTION) {
//            this.applyContext((String) node.getAttribute(name));
//        }
    }

    public void init() {
        var result = this.getBuildConfirmDialog(
                "O prato que você pensou é massa?"
        );
        if (result == JOptionPane.YES_OPTION) {
            this.applyContextLasagna();
        } else if (result == JOptionPane.NO_OPTION) {
//            node.setAttribute(CHOCOLATE_CAKE, CHOCOLATE_CAKE);
            var list = this.node.getAttributeKeys();
            if(!list.isEmpty()) {
                list.forEach(this::applyContext);
            } else {
                this.applyContext(CHOCOLATE_CAKE);
            }
        }
    }

}