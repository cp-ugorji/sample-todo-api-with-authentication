/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologyz.stealth.jwt.models;

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
public class JwtTokenRequest {
    //private static final long serialVersionUID = -5616176897013108345L;

    private String username;
    private String password;
}
