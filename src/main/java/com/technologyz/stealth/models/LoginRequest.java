/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologyz.stealth.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
/**
 *
 * @author Chukwudi Ugorji
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class LoginRequest {
    private String username;
    private String password;
}
