/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technologyz.stealth.interfaces;

import com.technologyz.stealth.entities.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Chukwudi Ugorji
 */
public interface TodoRepository extends JpaRepository<Todo, Long>{
    List<Todo> findByUsername(String username);
}
