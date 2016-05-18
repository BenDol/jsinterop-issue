package com.jsinterop.issue.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import static com.workingflows.js.jquery.client.api.JQuery.*;

public class JsInteropIssueEntry implements EntryPoint {

    @Override
    public void onModuleLoad() {
        Button button = new Button("Click Me");
        button.getElement().setId("btn1");
        RootPanel.get().add(button);

        $(button).on("click", (e, o) -> {
            Element gwtElement = $(e.getCurrentTarget()).asElement();
            Window.alert(gwtElement.getId());
            return true;
        });
    }
}
