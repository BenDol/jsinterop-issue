/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.workingflows.js.jscore.client.api.core;

import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 *
 * @author Cristian Rinaldi
 */
@JsType(isNative = true)
public class DOMError {

    @JsProperty
    public native String getName();

}
