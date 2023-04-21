package com.objective;

import javax.swing.*;

public class Start {

    private void init() {
        JOptionPane.showMessageDialog(
                null,
                "Pense em um prato que gosta",
                "Jogo Gourmet",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private int getSelectedResultPasta() {
        return JOptionPane.showConfirmDialog(
                null,
                "O prato que você pensou é massa?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );
    }

    private int getSelectedResultLasagna() {
        return JOptionPane.showConfirmDialog(
                null,
                "O prato que você pensou é Lasanha?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );
    }

    private void applyContextLasagna() {
        var result = this.getSelectedResultLasagna();
        if (result == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Acertei de novo!");
            this.applyContext();
        } else if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Você clicou em Não. - Lasanha");
        }
    }

    public void applyContext() {
        this.init();
        var result = this.getSelectedResultPasta();
        if (result == JOptionPane.YES_OPTION) {
            this.applyContextLasagna();
        } else if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Você clicou em Não. - Massa");
        }
    }

    public static void main(String[] args) {
        new Start().applyContext();
    }
}
