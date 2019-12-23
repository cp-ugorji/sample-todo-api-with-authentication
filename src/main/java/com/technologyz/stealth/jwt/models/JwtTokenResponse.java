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
@EqualsAndHashCode
@AllArgsConstructor
public class JwtTokenResponse {
    //private static final long serialVersionUID = 8317676219297719109L;
    private final String token;
}
