/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologyz.stealth.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Chukwudi Ugorji
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class LoginResponse {
    private String token;
    private String message;
}
