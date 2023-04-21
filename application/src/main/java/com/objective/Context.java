package com.objective;

import javax.swing.*;

public class Context {

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

    private void applyContextChocolateCake() {
        var result = this.getBuildConfirmDialog(
                "O prato que você pensou é Bolo de Chocolate?"
        );
        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Acertei de novo!");
        } else if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Você clicou em Não. - Chocolate Cake");
        }
    }

    public void init() {
        var result = this.getBuildConfirmDialog(
                "O prato que você pensou é massa?"
        );
        if (result == JOptionPane.YES_OPTION) {
            this.applyContextLasagna();
        } else if (result == JOptionPane.NO_OPTION) {
            this.applyContextChocolateCake();
        }
    }

}