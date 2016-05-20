package com.jsinterop.issue.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.workingflows.js.jquery.client.api.Functions.EventFunc1;
import com.workingflows.js.jquery.client.api.JQueryElement;
import com.workingflows.js.jquery.client.api.MouseEvent;

import static com.workingflows.js.jquery.client.api.JQuery.*;

public class JsInteropIssueEntry implements EntryPoint {

    void addContextMenuHandler(EventFunc1<MouseEvent> handler, JQueryElement element) {
        element.on("context-menu", handler);
    }

    @Override
    public void onModuleLoad() {
        Button button = new Button("Right Click Me");
        RootPanel.get().add(button);

        final JQueryElement $button = $(button);

        // Bind context-menu event
        addContextMenuHandler((e, mouseEvent) -> {
            Window.alert("Button right clicked! x: " + mouseEvent.getPageX() + ", y:" + mouseEvent.getPageY());
            return true;
        }, $button);

        // Trigger context-menu event
        $button.contextmenu(mouseEvent -> {
            $button.trigger("context-menu", new Object[]{mouseEvent});
            return false;
        });
    }
}
