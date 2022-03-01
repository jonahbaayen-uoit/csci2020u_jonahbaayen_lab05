package com.github.jonahbaayen.lab05.components;

import javafx.scene.control.TextField;

public class TextFieldWithPrompt extends TextField {
    public TextFieldWithPrompt(String promptText) {
        this.setPromptText(promptText);
    }
}
