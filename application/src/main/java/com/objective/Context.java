package com.objective;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Context {

    private final Map<String, String> map = new HashMap<>();
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
            JOptionPane.showMessageDialog(null, "Acertei de novo!");
        } else if (result == JOptionPane.NO_OPTION && CHOCOLATE_CAKE.equals(name)) {
            String key = JOptionPane.showInputDialog(null, "Qual prato você pensou?");
            String value = JOptionPane.showInputDialog(null, String.format("%s é  ______ mas %s não.", key, name));
            map.put(key, value);
        }
    }

    public void init() {
        var result = this.getBuildConfirmDialog(
                "O prato que você pensou é massa?"
        );
        if (result == JOptionPane.YES_OPTION) {
            this.applyContextLasagna();
        } else if (result == JOptionPane.NO_OPTION) {
            if(!this.map.isEmpty()) {
                this.map.forEach((key, value) -> this.applyContext(value));
            }
            this.applyContext(CHOCOLATE_CAKE);
        }
    }

}